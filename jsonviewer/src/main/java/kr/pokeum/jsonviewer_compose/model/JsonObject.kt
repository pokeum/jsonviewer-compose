package kr.pokeum.jsonviewer_compose.model

import androidx.compose.runtime.mutableStateOf
import java.lang.StringBuilder

class JsonObject(
    override val key: String,
    val elements: MutableList<JsonElement>
) : JsonElement {

    internal val expanded = mutableStateOf(false)

    override fun toString(): String {
        val jsonString = StringBuilder()
        elements.joinTo(jsonString, prefix = CURLY_BRACKET_BEGIN, postfix = CURLY_BRACKET_END) { element ->
            "\"${element.key}\": $element"
        }
        return jsonString.toString()
    }

    companion object {
        private const val CURLY_BRACKET_BEGIN = "{"
        private const val CURLY_BRACKET_END = "}"
    }
}