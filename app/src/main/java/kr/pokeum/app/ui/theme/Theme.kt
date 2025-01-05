package kr.pokeum.app.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kr.pokeum.app.ui.util.complementary

@SuppressLint("ComposableNaming")
@Composable
fun DarkThemeAdaptableColor(
    lightColor: Color,
    darkColor: Color? = null
) : Color = if (isSystemInDarkTheme()) {
    darkColor ?: lightColor.complementary()
} else { lightColor }