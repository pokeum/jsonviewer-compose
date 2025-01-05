package kr.pokeum.jsonviewer_compose.model

import androidx.compose.runtime.mutableStateOf
import java.lang.StringBuilder

class JsonArray(
    override val key: String,
    val elements: MutableList<JsonElement>
) : JsonElement {

    internal val expanded = mutableStateOf(false)

    override fun toString(): String {
        val jsonString = StringBuilder()
        elements.joinTo(jsonString, prefix = SQUARE_BRACKET_BEGIN, postfix = SQUARE_BRACKET_END)
        return jsonString.toString()
    }

    companion object {
        private const val SQUARE_BRACKET_BEGIN = "["
        private const val SQUARE_BRACKET_END = "]"
    }
}