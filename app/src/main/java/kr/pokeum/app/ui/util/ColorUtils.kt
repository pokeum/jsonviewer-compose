package kr.pokeum.app.ui.util

import androidx.compose.ui.graphics.Color

fun Color.complementary() = Color(
    red = 1F - red,
    green = 1F - green,
    blue = 1F - blue
)