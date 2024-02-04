package kr.pokeum.jsonviewer_compose.ui.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import kr.pokeum.jsonviewer_compose.ui.values.Colors

internal fun keyValueSpannableGenerator(
    key: String,
    value: String,
    splitter: String,
    keyColor: Color? = null,
    valueColor: Color? = null,
    splitterColor: Color? = null,
): AnnotatedString {

    return buildAnnotatedString {
        withStyle(
            SpanStyle(color = keyColor ?: Colors.Black)
        ) { append(key) }
        withStyle(
            SpanStyle(color = splitterColor ?: Colors.Black)
        ) { append(splitter) }
        withStyle(
            SpanStyle(color = valueColor ?: Colors.Gray)
        ) { append(value) }
    }
}
