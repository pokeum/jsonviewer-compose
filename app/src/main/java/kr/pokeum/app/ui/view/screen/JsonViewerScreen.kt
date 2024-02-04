package kr.pokeum.app.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pokeum.app.ui.view.Screen
import kr.pokeum.app.ui.view.component.HeaderTitle
import kr.pokeum.app.util.generateJsonElement
import kr.pokeum.jsonviewer_compose.ui.adapter.JsonViewerAdapter
import kotlin.random.Random

@Preview
@Composable
fun JsonViewerScreen() {

    val context = LocalContext.current

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(12.dp, 12.dp)) {
            HeaderTitle(name = Screen.JsonViewer.title)
            JsonViewerAdapter(
                jsonElement = context.generateJsonElement(getRandomJsonFileName())
            )
        }
    }
}

private val fileNames = listOf(
    "comments",
    "glossary",
    "photos",
    "posts",
    "web-app",
    "widget"
)

private fun getRandomJsonFileName(): String {
    val randomInt = Random.nextInt(0, fileNames.size)
    return "${fileNames[randomInt]}.json"
}