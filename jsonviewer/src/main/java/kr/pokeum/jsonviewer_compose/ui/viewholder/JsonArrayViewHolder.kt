package kr.pokeum.jsonviewer_compose.ui.viewholder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kr.pokeum.jsonviewer_compose.R
import kr.pokeum.jsonviewer_compose.model.JsonArray
import kr.pokeum.jsonviewer_compose.ui.adapter.JsonViewerAdapter
import kr.pokeum.jsonviewer_compose.ui.provider.JsonArrayProvider
import kr.pokeum.jsonviewer_compose.ui.values.Colors
import kr.pokeum.jsonviewer_compose.ui.values.Dimens
import kr.pokeum.jsonviewer_compose.ui.values.Strings

@Preview(showSystemUi = true)
@Composable
internal fun JsonArrayViewHolder(
    @PreviewParameter(JsonArrayProvider::class)
    target: JsonArray
) {
    val key by remember { mutableStateOf(target.key) }
    val elements by remember { mutableStateOf(target.elements) }
    var expanded by rememberSaveable { target.expanded }

    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (headerLayout, expandableLayout) = createRefs()

        /** Header Layout */
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = Dimens.JSON_HEADER_LAYOUT_HEIGHT)
                .constrainAs(headerLayout) { top.linkTo(parent.top) }
                .clickable { expanded = !expanded }
        ) {
            val (arrowImage, keyDescriptionLayout, keyLabel) = createRefs()

            /** Arrow Image */
            Image(
                modifier = Modifier
                    .width(Dimens.JSON_ARROW_ICON_LAYOUT_WIDTH)
                    .height(Dimens.JSON_ARROW_ICON_LAYOUT_HEIGHT)
                    .rotate(degrees = if (expanded) 90f else 0f)
                    .constrainAs(arrowImage) {
                        start.linkTo(parent.start, margin = Dimens.JSON_KEY_MARGIN_START)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                painter = painterResource(id = R.drawable.ic_arrow_white_24dp),
                contentDescription = Strings.JSON_ARROW_ICON_DESCRIPTION,
                colorFilter = ColorFilter.tint(Colors.Red500),
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center
            )

            /** Key Description Layout */
            Box(
                modifier = Modifier
                    .width(Dimens.JSON_KEY_DESCRIPTION_LAYOUT_WIDTH)
                    .constrainAs(keyDescriptionLayout) {
                        start.linkTo(arrowImage.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = Strings.JSON_ARRAY_KEY_DESCRIPTION_LABEL,
                    fontSize = Dimens.JSON_KEY_DESCRIPTION_LABEL_SIZE,
                    fontWeight = FontWeight.Bold,
                    color = Colors.Green500
                )
            }

            /** Key Label */
            Text(
                modifier = Modifier
                    .constrainAs(keyLabel) {
                        start.linkTo(keyDescriptionLayout.end, margin = Dimens.JSON_KEY_MARGIN_START)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                text = "\"$key\"",
                fontSize = Dimens.JSON_KEY_LABEL_SIZE,
                fontWeight = FontWeight.Bold,
                color = Colors.DarkerGray
            )
        }

        /** Expandable Layout */
        if (expanded) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(expandableLayout) { top.linkTo(headerLayout.bottom) }
            ) {
                val (divider, childAdapter) = createRefs()

                /** Divider */
                Box(
                    modifier = Modifier
                        .width(Dimens.JSON_DIVIDER_LAYOUT_WIDTH)
                        .background(Colors.DividerColor)
                        .constrainAs(divider) {
                            start.linkTo(parent.start, margin = Dimens.JSON_DIVIDER_MARGIN_START)
                            top.linkTo(parent.top)
                            bottom.linkTo(childAdapter.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                /** Child Adapter */
                JsonViewerAdapter(
                    modifier = Modifier
                        .wrapContentHeight()
                        .constrainAs(childAdapter) {
                            start.linkTo(parent.start, margin = Dimens.JSON_ELEMENTS_MARGIN_START)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        },
                    elements = elements
                )
            }
        }
    }
}