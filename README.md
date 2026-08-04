# AndLuaX（AndLua+ 二次开发骨架）

这是一个面向 **AndLua+** 二次开发/重构的 Android 项目骨架，目标是：

- 全面使用 **AndroidX**
- UI 全面采用 **Jetpack Compose + Material3**
- 代码输入区使用 **sora-editor（Sora Code Editor）**，并通过 **TextMate** 语法实现 **Lua** 高亮

> 二次开发创作者：**AndruX**

## 功能现状

- 已集成 `CodeEditor`（sora-editor）并在 Compose 中通过 `AndroidView` 嵌入
- 已集成 TextMate 语言模块，并提供内置的 Lua TextMate Grammar（精简版）与主题
- 提供一个示例编辑器页面（顶部 Material3 AppBar + 编辑器主体）

## 你接下来要做什么

- 将 AndLua+ 的 Lua 运行/打包/项目管理等能力迁移到 `app` 模块中（此仓库当前只提供 UI + 编辑器 + 高亮骨架）
- 如果你需要更完整的 Lua 语法高亮（比如 EmmyLua/复杂规则），可以替换 `app/src/main/assets/textmate/lua/syntaxes/lua.tmLanguage.json`

## 构建要求

根据 sora-editor 官方文档，建议：

- **Gradle 运行在 JDK 17 或以上**
- `language-textmate` 在 Android 13（API 33）以下运行时建议开启 **Core Library Desugaring**

参考：sora-editor 文档站点 [$TRAE_REF](https://project-sora.github.io/sora-editor-docs/guide/getting-started) [$TRAE_REF](https://project-sora.github.io/sora-editor-docs/guide/using-language)

## 许可证提示（重要）

- sora-editor 为 LGPL-2.1-or-later，引用它意味着你的分发方式需要遵循其许可证条款（例如动态链接与替换、提供许可证文本等）。
- AndLua+ 的具体许可证与第三方依赖许可证，请你在真正合并/迁移 AndLua+ 源码时一并处理。

