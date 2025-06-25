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
import androidx.compose.runtime.mutableFloatStateOf
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
fun CircularProgressbar(modifier: Modifier,
    completedPercentage:Double=30.0,
    backgroundColor: Color= Color(0,0,0,0),
    progressbarGradientColors:List<Color> = listOf(Color(0,0,255), Color(0,255,0),Color(0,0,255)),
    textVisibility: Boolean=true
){

    var targetAngle by remember { mutableFloatStateOf(0f) }
    val isTextVisible  by remember { mutableStateOf(textVisibility) }

    LaunchedEffect(Unit) {
        targetAngle = (completedPercentage*3.6).toFloat()
    }

    val animatedSweepAngle by animateFloatAsState(
        targetValue = targetAngle,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "ArcAnimation"
    )

    Box(
        modifier = modifier
            .size(200.dp)
            .background(backgroundColor)
            .padding(16.dp)
    ) {
    Canvas(modifier = Modifier.fillMaxSize()){
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
            topLeft = Offset(0f,0f),
            size = arcSize,
            style = Stroke(width = 20f, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )

    }
        if(isTextVisible){
            Text(modifier = Modifier.align(Alignment.Center), text = "$completedPercentage%", fontSize = 50.sp)
        }
    }
}