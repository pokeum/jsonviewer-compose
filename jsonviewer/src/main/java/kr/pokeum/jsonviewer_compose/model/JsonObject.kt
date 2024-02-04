package kr.pokeum.jsonviewer_compose.model

import androidx.compose.runtime.mutableStateOf

class JsonObject(
    override val key: String,
    val elements: MutableList<JsonElement>
) : JsonElement {

    internal val expanded = mutableStateOf(false)
}