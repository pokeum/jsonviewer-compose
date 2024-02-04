package kr.pokeum.app.ui.view.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kr.pokeum.app.R
import kr.pokeum.app.ui.theme.Black
import kr.pokeum.app.ui.theme.White
import kr.pokeum.app.ui.view.Screen

data class IconTextButtonItem(
    @DrawableRes val iconResId: Int,
    val text: String,
    val onClick: (() -> Unit)? = null
)

@Composable
fun IconTextButton(
    @DrawableRes iconResId: Int,
    text: String,
    onClick: (() -> Unit)? = null
) {
    Button(
        onClick = onClick ?: {},
        colors = ButtonDefaults.buttonColors(backgroundColor = White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        shape = RoundedCornerShape(20)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (iconImage, nameText) = createRefs()
            Image(
                painter = painterResource(iconResId),
                contentDescription = "Dashboard icon",
                colorFilter = ColorFilter.tint(Black),
                modifier = Modifier.constrainAs(iconImage) {
                    start.linkTo(parent.start, margin = 8.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )
            Text(
                text = text,
                color = Black,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
                    .constrainAs(nameText) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

@Preview
@Composable
fun PreviewIconTextButton() {
    IconTextButton(
        iconResId = R.drawable.ic_json_black_24dp,
        text = Screen.JsonViewer.title,
        onClick = { }
    )
}

@Composable
fun IconTextButtons(iconTextButtonItems: Collection<IconTextButtonItem>) {
    for (iconTextButtonItem in iconTextButtonItems) {
        IconTextButton(
            iconResId = iconTextButtonItem.iconResId,
            text = iconTextButtonItem.text,
            onClick = iconTextButtonItem.onClick
        )
    }
}

