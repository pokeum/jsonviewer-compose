package kr.pokeum.jsonviewer_compose.model

import androidx.compose.runtime.mutableStateOf

class JsonArray(
    override val key: String,
    val elements: MutableList<JsonElement>
) : JsonElement {

    internal val expanded = mutableStateOf(false)
}