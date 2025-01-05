package kr.pokeum.jsonviewer_compose.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import kr.pokeum.jsonviewer_compose.ui.values.JsonViewerColor

@Composable
internal fun keyValueSpannableGenerator(
    key: String,
    value: String,
    splitter: String
) = buildAnnotatedString {
    withStyle(
        SpanStyle(color = JsonViewerColor.Key.getColor())
    ) { append(key) }
    withStyle(
        SpanStyle(color = JsonViewerColor.Splitter.getColor())
    ) { append(splitter) }
    withStyle(
        SpanStyle(color = JsonViewerColor.Value.getColor())
    ) { append(value) }
}