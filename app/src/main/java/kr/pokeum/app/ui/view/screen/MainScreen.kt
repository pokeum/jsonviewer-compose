package kr.pokeum.app.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pokeum.app.JsonGenerator
import kr.pokeum.app.R
import kr.pokeum.app.api.performNetworkRequest
import kr.pokeum.app.ui.theme.DarkThemeAdaptableColor
import kr.pokeum.app.ui.view.Screen
import kr.pokeum.app.ui.view.component.HeaderTitle
import kr.pokeum.app.ui.view.component.IconTextButtonItem
import kr.pokeum.app.ui.view.component.IconTextButtons

@Composable
fun MainScreen(
    onNavigationButtonClicked: (String) -> Unit
) {
    val textField = remember { mutableStateOf("") }

    val jsonGenerator = JsonGenerator(LocalContext.current)

    val iconTextButtonItems = listOf(
        IconTextButtonItem(
            iconResId = R.drawable.ic_content_paste_white_24dp,
            text = stringResource(id = R.string.load_from_text),
            onClick = {
                if (jsonGenerator.saveToCache { fromString(textField.value) }) {
                    onNavigationButtonClicked(Screen.JsonViewer.name)
                    textField.value = ""    // reset
                }
            }
        ),
        IconTextButtonItem(
            iconResId = R.drawable.ic_web_white_24dp,
            text = stringResource(id = R.string.load_from_url),
            onClick = {
                performNetworkRequest(textField.value) { response ->
                    if (jsonGenerator.saveToCache { fromString(response) }) {
                        onNavigationButtonClicked(Screen.JsonViewer.name)
                        textField.value = ""    // reset
                    }
                }
            }
        ),
    )

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkThemeAdaptableColor(MaterialTheme.colors.background)
    ) {
        Column(modifier = Modifier.padding(12.dp, 12.dp)) {
            HeaderTitle(name = Screen.Main.title)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TextField(
                    value = textField.value,
                    onValueChange = {
                        textField.value = it
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 12.dp)
                        .background(Color.LightGray)
                )
                IconTextButtons(iconTextButtonItems = iconTextButtonItems)
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        onNavigationButtonClicked = { }
    )
}