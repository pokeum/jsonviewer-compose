package kr.pokeum.jsonviewer_compose.ui.adapter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.pokeum.jsonviewer_compose.model.*
import kr.pokeum.jsonviewer_compose.ui.viewholder.JsonArrayViewHolder
import kr.pokeum.jsonviewer_compose.ui.viewholder.JsonNullViewHolder
import kr.pokeum.jsonviewer_compose.ui.viewholder.JsonObjectViewHolder
import kr.pokeum.jsonviewer_compose.ui.viewholder.JsonPrimitiveViewHolder

@Composable
fun JsonViewerAdapter(
    jsonElement: JsonElement? = null
) {
    val elements: MutableList<JsonElement> = when (jsonElement) {
        is JsonObject -> { jsonElement.elements }
        is JsonArray -> { jsonElement.elements }
        is JsonPrimitive -> { mutableListOf(jsonElement) }
        is JsonNull -> { mutableListOf(jsonElement) }
        else -> { mutableListOf() }
    }

    // Use LazyColumn because list of items is unknown and could potentially be long
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(elements) { element ->
            when (element) {
                is JsonObject -> JsonObjectViewHolder(target = element)
                is JsonArray -> JsonArrayViewHolder(target = element)
                is JsonPrimitive -> JsonPrimitiveViewHolder(target = element)
                is JsonNull -> JsonNullViewHolder(target = element)
            }
        }
    }
}

@Composable
internal fun JsonViewerAdapter(
    modifier: Modifier,
    elements: MutableList<JsonElement>
) {
    Column(modifier = modifier) {
        elements.forEach { element ->
            when (element) {
                is JsonObject -> JsonObjectViewHolder(target = element)
                is JsonArray -> JsonArrayViewHolder(target = element)
                is JsonPrimitive -> JsonPrimitiveViewHolder(target = element)
                is JsonNull -> JsonNullViewHolder(target = element)
            }
        }
    }
}