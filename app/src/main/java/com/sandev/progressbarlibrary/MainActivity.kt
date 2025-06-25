package com.sandev.progressbarlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sandev.circular_progressbar.CircularProgressbar
import com.sandev.progressbarlibrary.ui.theme.ProgressbarLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgressbarLibraryTheme {



                    CircularProgressbar(Modifier.size(200.dp),
                        completedPercentage = 75.0,
                        title = "hello",
                        titleVisibility = true,
                        cpbarThickness = 8.dp)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProgressbarLibraryTheme {
        Greeting("Android")
    }
}