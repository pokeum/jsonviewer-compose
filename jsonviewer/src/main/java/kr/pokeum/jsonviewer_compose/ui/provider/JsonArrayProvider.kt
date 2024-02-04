package kr.pokeum.jsonviewer_compose.ui.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kr.pokeum.jsonviewer_compose.model.JsonArray
import kr.pokeum.jsonviewer_compose.model.JsonNull
import kr.pokeum.jsonviewer_compose.model.JsonPrimitive

internal class JsonArrayProvider : PreviewParameterProvider<JsonArray> {
    override val values: Sequence<JsonArray>
        get() = listOf(
            JsonArray(
                key = "key",
                elements = mutableListOf(
                    JsonArray(
                        key = "0",
                        elements = mutableListOf(
                            JsonPrimitive(key = "0", value = "ABCDEF"),
                            JsonPrimitive(key = "1", value = 123.456),
                            JsonPrimitive(key = "2", value = true)
                        )
                    ),
                    JsonNull(key = "1")
                )
            )
        ).asSequence()
}