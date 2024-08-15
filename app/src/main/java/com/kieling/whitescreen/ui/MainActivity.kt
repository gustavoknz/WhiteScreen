package com.kieling.whitescreen.ui

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kieling.whitescreen.ui.theme.LightRed
import com.kieling.whitescreen.ui.theme.MediumRed
import com.kieling.whitescreen.ui.theme.Red
import com.kieling.whitescreen.ui.theme.White
import com.kieling.whitescreen.ui.theme.WhiteScreenTheme
import com.kieling.whitescreen.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set fullscreen
        enableEdgeToEdge()
        hideSystemBars(window)

        // Avoid screen lock
        window.addFlags(FLAG_KEEP_SCREEN_ON)

        setContent { AddMainScreen() }
    }
}

private fun hideSystemBars(window: Window) {
    // val windowInsetsController = getInsetsController(window, window.decorView)
    // windowInsetsController.hide(statusBars())
    // windowInsetsController.hide(systemBars())
    window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
}

@Preview
@Composable
private fun AddMainScreen() {
    WhiteScreenTheme {
        val colorInput = remember { mutableStateOf(LightRed) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorInput.value)
                .padding(40.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ColorOption(colorInput, White)
                ColorOption(colorInput, Yellow)
                ColorOption(colorInput, LightRed)
                ColorOption(colorInput, MediumRed)
                ColorOption(colorInput, Red)
            }
        }
    }
}

@Composable
private fun ColorOption(colorInput: MutableState<Color>, color: Color) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(color)
            .clickable { colorInput.value = color }
    ) {
        Text(
            modifier = Modifier.align(Center),
            text = "-",
            color = Color.Gray
        )
    }
}
