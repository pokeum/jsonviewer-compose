package kr.pokeum.jsonviewer_compose.ui.values

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class JsonViewerColor(
    private val color: Color,
    private val darkModeColor: Color? = null
) {
    @Composable
    internal fun getColor() =
        if (isSystemInDarkTheme()) { darkModeColor ?: color } else { color }

    companion object {

        private val Black           = Color(0xFF000000)
        private val Gray            = Color(0xFF888888)
        private val Red             = Color(0xFFF44336)
        private val Blue            = Color(0xFF2196F3)
        private val Green           = Color(0xFF4CAF50)

        internal var Key             = JsonViewerColor(Black)
        internal var Value           = JsonViewerColor(Gray)
        internal var Splitter        = JsonViewerColor(Black)
        internal var Type            = JsonViewerColor(Blue)
        internal var Arrow           = JsonViewerColor(Red)
        internal var Bracket         = JsonViewerColor(Green)
        internal var Divider         = JsonViewerColor(Color(0x1E000000))
    }
}