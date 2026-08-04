package com.andrux.andluax

import android.graphics.Typeface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.langs.textmate.scheme.TextMateColorScheme
import io.github.rosemoe.sora.widget.CodeEditor

@Composable
fun SoraLuaEditor(
    modifier: Modifier = Modifier,
    initialText: String,
) {
    val editorHolder = remember { mutableStateOf<CodeEditor?>(null) }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            CodeEditor(context).also { editor ->
                editorHolder.value = editor

                editor.setText(initialText)
                editor.typefaceText = Typeface.MONOSPACE

                // 一些常用显示选项（可按需调整）
                editor.nonPrintablePaintingFlags =
                    CodeEditor.FLAG_DRAW_WHITESPACE_LEADING or
                        CodeEditor.FLAG_DRAW_LINE_SEPARATOR or
                        CodeEditor.FLAG_DRAW_WHITESPACE_IN_SELECTION

                // TextMate 颜色方案与 Lua 语言
                editor.colorScheme = TextMateColorScheme.create(ThemeRegistry.getInstance())
                editor.setEditorLanguage(
                    TextMateLanguage.create(
                        "source.lua",
                        true, // 启用 TextMate 补全（若语法/配置支持）
                    ),
                )
            }
        },
        update = { editor ->
            // 外部状态变更时可以在这里同步，比如切换主题、加载文件等
        },
    )

    // 释放资源（sora-editor 官方要求必须调用）
    DisposableEffect(Unit) {
        onDispose {
            editorHolder.value?.release()
            editorHolder.value = null
        }
    }
}

