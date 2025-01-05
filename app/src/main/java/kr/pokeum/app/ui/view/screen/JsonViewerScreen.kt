package kr.pokeum.app.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pokeum.app.ui.view.Screen
import kr.pokeum.app.ui.view.component.HeaderTitle
import kr.pokeum.app.JsonGenerator
import kr.pokeum.app.ui.theme.DarkThemeAdaptableColor
import kr.pokeum.jsonviewer_compose.ui.adapter.JsonViewerAdapter
import kr.pokeum.jsonviewer_compose.ui.values.JsonViewerColor

@Preview
@Composable
fun JsonViewerScreen(
) {
    val jsonGenerator = JsonGenerator(LocalContext.current)

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkThemeAdaptableColor(MaterialTheme.colors.background)
    ) {
        Column(modifier = Modifier.padding(12.dp, 12.dp)) {
            HeaderTitle(name = Screen.JsonViewer.title)

            JsonViewerAdapter(
                jsonElement = jsonGenerator.getCacheData(),
                keyColor = JsonViewerColor(
                    color = Color.Black,
                    darkModeColor = Color.White
                ),
                splitterColor = JsonViewerColor(
                    color = Color.Black,
                    darkModeColor = Color.White
                ),
            )
        }
    }
}