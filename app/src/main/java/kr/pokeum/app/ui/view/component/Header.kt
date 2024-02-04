package kr.pokeum.app.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pokeum.app.ui.theme.Black
import kr.pokeum.app.ui.theme.DarkThemeAdaptableColor
import kr.pokeum.app.ui.theme.Divider

@Composable
fun HeaderTitle(
    name: String,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold,
                color = DarkThemeAdaptableColor(Black)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = DarkThemeAdaptableColor(Divider))
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun SubHeaderTitle(
    name: String,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = DarkThemeAdaptableColor(Black)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = DarkThemeAdaptableColor(Divider))
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Preview
@Composable
fun PreviewHeader() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(16.dp, 12.dp)) {
            HeaderTitle(name = "Preview Header")
            SubHeaderTitle(name = "Preview Sub-Header")
        }
    }
}