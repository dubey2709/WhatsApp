package com.example.whatsapp_clone

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

private const val SPACING = 100
@Composable
fun Watermark(
    content: @Composable BoxScope.() -> Unit,
) {
    Box {
        content()

        Layout(
            content = {

                repeat(6) {

                    Text(
                        text = "IIIT Bhopal",
                        style = TextStyle(fontSize  = 10.sp),
                        color = Color(0xFF6E6C6A)

                    )
                }
            }
        ) { measurables, constraints ->
            val placeables: List<Placeable> = measurables
                .map { measurable -> measurable.measure(constraints) }

            layout(constraints.maxWidth, constraints.maxHeight) {
                val maxWidth: Double = placeables.maxOf { it.width }.toDouble()

                val tileSize: Int = (constraints.maxWidth / Math.atan(maxWidth)).toInt()

                placeables
                    .chunked(2)  // Placing 2 columns
                    .forEachIndexed { index, (first, second) ->
                        val indexedTileSize: Int = index * tileSize
                        first.placeRelativeWithLayer(-SPACING, indexedTileSize + SPACING) { rotationZ = -45f }
                        second.placeRelativeWithLayer(tileSize, indexedTileSize) { rotationZ = -45f }
                    }
            }
        }
    }
}