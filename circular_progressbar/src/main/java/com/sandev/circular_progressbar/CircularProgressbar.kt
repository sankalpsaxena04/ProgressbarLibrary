package com.sandev.circular_progressbar

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressbar(
    completedPercentage:Int=30,

){
    val maxSweepAngle = 357f

    var targetAngle by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        targetAngle = maxSweepAngle
    }

    val animatedSweepAngle by animateFloatAsState(
        targetValue = targetAngle,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "ArcAnimation"
    )

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color(21f,21f,21f))
            .padding(16.dp)
    ) {
    Canvas(modifier = Modifier.fillMaxSize().background(Color.White)){
        val canvasWidth = size.width
        val canvasHeight = size.height
        val arcSize = Size(canvasWidth, canvasHeight)

        drawArc(
            brush = Brush.sweepGradient(
                colors = listOf(Color.Blue, Color.Green, Color.Blue),
                center = Offset(canvasWidth / 2, canvasHeight / 2)
            ),
            startAngle = -90F,
            sweepAngle = animatedSweepAngle,
            useCenter = false,
            topLeft = Offset(0f,0f),
            size = arcSize,
            style = Stroke(width = 20f, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )

    }
        Text(modifier = Modifier.align(Alignment.Center), text = "$completedPercentage%", fontSize = 50.sp)
    }
}