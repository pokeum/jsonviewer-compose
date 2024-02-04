package kr.pokeum.jsonviewer_compose.ui.values

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal class Dimens {

    companion object {
        val JSON_HEADER_LAYOUT_HEIGHT by lazy { 56.dp }
        val JSON_ARROW_ICON_LAYOUT_WIDTH by lazy { 21.dp }
        val JSON_ARROW_ICON_LAYOUT_HEIGHT by lazy { 18.dp }
        val JSON_KEY_DESCRIPTION_LAYOUT_WIDTH by lazy { 36.dp }
        val JSON_PRIMITIVE_KEY_DESCRIPTION_LABEL_SIZE by lazy { 10.sp }
        val JSON_KEY_DESCRIPTION_LABEL_SIZE by lazy { 14.sp }
        val JSON_KEY_LABEL_SIZE by lazy { 14.sp }
        val JSON_KEY_MARGIN_START by lazy { 8.dp }
        val JSON_DIVIDER_MARGIN_START by lazy { 16.dp }
        val JSON_DIVIDER_LAYOUT_WIDTH by lazy { 1.dp }
        val JSON_ELEMENTS_MARGIN_START by lazy { 24.dp }
    }
}