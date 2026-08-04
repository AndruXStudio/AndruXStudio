package com.andrux.andluax

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                EditorScaffold(
                    onRun = {
                        Toast.makeText(this, "TODO: 这里接入 Lua 运行/调试逻辑", Toast.LENGTH_SHORT).show()
                    },
                    onSave = {
                        Toast.makeText(this, "TODO: 这里接入保存/文件系统逻辑", Toast.LENGTH_SHORT).show()
                    },
                )
            }
        }
    }
}

@Composable
private fun EditorScaffold(
    onRun: () -> Unit,
    onSave: () -> Unit,
) {
    val initialCode = remember {
        """
        -- AndLuaX / Lua 示例
        local function hello(name)
          print("Hello, " .. name)
        end

        hello("AndruX")
        """.trimIndent()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AndLuaX") },
                actions = {
                    IconButton(onClick = onRun) {
                        Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "运行")
                    }
                    IconButton(onClick = onSave) {
                        Icon(imageVector = Icons.Filled.Save, contentDescription = "保存")
                    }
                },
            )
        },
    ) { innerPadding ->
        SoraLuaEditor(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            initialText = initialCode,
        )
    }
}

