package com.sandev.circular_progressbar

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressbar(
    modifier: Modifier = Modifier.size(200.dp),
    cpbarThickness:Dp=20.dp,
    completedPercentage: Double = 30.0,
    backgroundColor: Color = Color.Transparent,
    progressbarGradientColors: List<Color> = listOf(Color(0, 0, 255), Color(0, 255, 0), Color(0, 0, 255)),
    percentageVisibility: Boolean = true,
    title: String,
    titleVisibility: Boolean = false
) {
    var targetAngle by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        targetAngle = (completedPercentage * 3.6).toFloat()
    }

    val animatedSweepAngle by animateFloatAsState(
        targetValue = targetAngle,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "ArcAnimation"
    )

    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor)
                .padding(cpbarThickness/2),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.matchParentSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val arcSize = Size(canvasWidth, canvasHeight)

                drawArc(
                    brush = Brush.sweepGradient(
                        colors = progressbarGradientColors,
                        center = Offset(canvasWidth / 2, canvasHeight / 2)
                    ),
                    startAngle = -90F,
                    sweepAngle = animatedSweepAngle,
                    useCenter = false,
                    topLeft = Offset(0f, 0f),
                    size = arcSize,
                    style = Stroke(width = cpbarThickness.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
                )
            }
            if (percentageVisibility) {
                Text(
                    text = "${completedPercentage.toInt()}%",
                    fontSize = 36.sp
                )
            }
        }

        if (titleVisibility) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}
