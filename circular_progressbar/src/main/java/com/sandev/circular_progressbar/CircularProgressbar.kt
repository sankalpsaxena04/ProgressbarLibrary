package com.sandev.circular_progressbar

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import  androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CircularProgressbar(){
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.White)
            .padding(16.dp)
    ) {
    Canvas(modifier = Modifier.fillMaxSize().background(Color.White)){
        val canvasWidth = size.width
        val canvasHeight = size.height
        val arcSize = Size(canvasWidth, canvasHeight)

        drawArc(
            brush = Brush.sweepGradient(
                colors = listOf(Color.White, Color.Green,Color.White),
                center = Offset(canvasWidth / 2, canvasHeight / 2)
            ),
            startAngle = 0F,
            sweepAngle = 270F,
            useCenter = false,
            topLeft = Offset(0f,0f),
            size = arcSize,
            style = Stroke(width = 20f, cap = StrokeCap.Round)
            )

    }
        Text(modifier = Modifier.align(Alignment.Center), text = "20%", fontSize = 50.sp)
    }
}