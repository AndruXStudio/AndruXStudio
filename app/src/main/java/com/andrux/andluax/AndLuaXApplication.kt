package com.andrux.andluax

import android.app.Application
import io.github.rosemoe.sora.langs.textmate.registry.FileProviderRegistry
import io.github.rosemoe.sora.langs.textmate.registry.GrammarRegistry
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.langs.textmate.registry.provider.AssetsFileResolver
import io.github.rosemoe.sora.langs.textmate.registry.model.IThemeSource
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel

/**
 * 全局初始化 TextMate（只需要执行一次）。
 *
 * 参考：
 * - Getting Started: https://project-sora.github.io/sora-editor-docs/guide/getting-started
 * - Using Language (TextMate): https://project-sora.github.io/sora-editor-docs/guide/using-language
 */
class AndLuaXApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTextMateOnce()
    }

    private fun initTextMateOnce() {
        // 让 TextMate 能从 assets 读取语法/主题文件
        FileProviderRegistry.getInstance().addFileProvider(AssetsFileResolver(assets))

        // 加载主题
        val themeName = "andluax-light"
        val themeAssetsPath = "textmate/$themeName.json"
        val model = ThemeModel(
            IThemeSource.fromInputStream(
                FileProviderRegistry.getInstance().tryGetInputStream(themeAssetsPath),
                themeAssetsPath,
                null,
            ),
            themeName,
        )
        ThemeRegistry.getInstance().loadTheme(model)
        ThemeRegistry.getInstance().setTheme(themeName)

        // 加载语法注册表（Lua）
        GrammarRegistry.getInstance().loadGrammars("textmate/languages.json")
    }
}

