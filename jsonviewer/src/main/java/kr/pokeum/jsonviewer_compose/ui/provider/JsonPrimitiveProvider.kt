package kr.pokeum.jsonviewer_compose.ui.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kr.pokeum.jsonviewer_compose.model.JsonPrimitive

internal class JsonPrimitiveProvider : PreviewParameterProvider<JsonPrimitive> {
    override val values: Sequence<JsonPrimitive>
        get() = listOf(
            JsonPrimitive(key = "key", value = "ABCDEF"),
            JsonPrimitive(key = "key", value = 123.456),
            JsonPrimitive(key = "key", value = true)
        ).asSequence()
}