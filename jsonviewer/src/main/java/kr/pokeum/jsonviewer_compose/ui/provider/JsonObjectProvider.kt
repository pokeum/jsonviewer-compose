package kr.pokeum.jsonviewer_compose.ui.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kr.pokeum.jsonviewer_compose.model.JsonArray
import kr.pokeum.jsonviewer_compose.model.JsonNull
import kr.pokeum.jsonviewer_compose.model.JsonObject
import kr.pokeum.jsonviewer_compose.model.JsonPrimitive

internal class JsonObjectProvider : PreviewParameterProvider<JsonObject> {
    override val values: Sequence<JsonObject>
        get() = listOf(
            JsonObject(
                key = "out",
                elements = mutableListOf(
                    JsonArray(
                        key = "array",
                        elements = mutableListOf(
                            JsonPrimitive(key = "0", value = "ABCDEF"),
                            JsonPrimitive(key = "1", value = 123.456),
                            JsonPrimitive(key = "2", value = true)
                        )
                    ),
                    JsonObject(
                        key = "in",
                        elements = mutableListOf(
                            JsonPrimitive(key = "key", value = "ABCDEF"),
                            JsonPrimitive(key = "key", value = 123.456),
                            JsonPrimitive(key = "key", value = true),
                            JsonNull(key = "key")
                        )
                    )
                )
            )
        ).asSequence()
}