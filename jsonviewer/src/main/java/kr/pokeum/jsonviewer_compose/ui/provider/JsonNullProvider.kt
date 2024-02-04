package kr.pokeum.jsonviewer_compose.ui.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kr.pokeum.jsonviewer_compose.model.JsonNull

internal class JsonNullProvider : PreviewParameterProvider<JsonNull> {
    override val values: Sequence<JsonNull>
        get() = listOf(JsonNull(key = "key")).asSequence()
}