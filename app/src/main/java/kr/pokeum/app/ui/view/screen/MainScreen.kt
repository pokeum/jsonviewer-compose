package kr.pokeum.app.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pokeum.app.R
import kr.pokeum.app.ui.view.Screen
import kr.pokeum.app.ui.view.component.HeaderTitle
import kr.pokeum.app.ui.view.component.IconTextButtonItem
import kr.pokeum.app.ui.view.component.IconTextButtons

@Composable
fun MainScreen(
    onNavigationButtonClicked: (String) -> Unit
) {
    val iconTextButtonItems = listOf(
        IconTextButtonItem(
            iconResId = R.drawable.ic_json_white_24dp,
            text = Screen.JsonViewer.title,
            onClick = {
                onNavigationButtonClicked(Screen.JsonViewer.name)
            }
        ),
    )

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(12.dp, 12.dp)) {
            HeaderTitle(name = Screen.Main.title)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
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