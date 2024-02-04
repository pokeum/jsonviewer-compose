package kr.pokeum.jsonviewer_compose.ui.viewholder

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kr.pokeum.jsonviewer_compose.model.JsonNull
import kr.pokeum.jsonviewer_compose.ui.provider.JsonNullProvider
import kr.pokeum.jsonviewer_compose.ui.util.keyValueSpannableGenerator
import kr.pokeum.jsonviewer_compose.ui.values.Colors
import kr.pokeum.jsonviewer_compose.ui.values.Dimens
import kr.pokeum.jsonviewer_compose.ui.values.Strings

@Preview(showSystemUi = true)
@Composable
internal fun JsonNullViewHolder(
    @PreviewParameter(JsonNullProvider::class)
    target: JsonNull
) {
    var key by remember { mutableStateOf(target.key) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = Dimens.JSON_HEADER_LAYOUT_HEIGHT)
        ) {
            val (keyDescriptionLayout, keyLayout) = createRefs()

            /** Key Description Layout */
            Box(
                modifier = Modifier
                    .width(Dimens.JSON_KEY_DESCRIPTION_LAYOUT_WIDTH)
                    .constrainAs(keyDescriptionLayout) {
                        start.linkTo(parent.start, margin = Dimens.JSON_KEY_MARGIN_START)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = Strings.JSON_NULL_KEY_DESCRIPTION_LABEL,
                    fontSize = Dimens.JSON_KEY_DESCRIPTION_LABEL_SIZE,
                    fontWeight = FontWeight.Bold,
                    color = Colors.Blue500
                )
            }

            /** Key Layout */
            Row(
                modifier = Modifier
                    .constrainAs(keyLayout) {
                        start.linkTo(keyDescriptionLayout.end, margin = Dimens.JSON_KEY_MARGIN_START)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = keyValueSpannableGenerator(
                        key = "\"$key\"",
                        value = Strings.JSON_NULL,
                        splitter = Strings.JSON_SPLITTER
                    ),
                    fontSize = Dimens.JSON_KEY_LABEL_SIZE,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}