package com.kieling.whitescreen.ui

import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat.getInsetsController
import androidx.core.view.WindowInsetsCompat.Type.systemBars
import com.kieling.whitescreen.ui.theme.WhiteScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set fullscreen
        enableEdgeToEdge()
        val windowInsetsController = getInsetsController(window, window.decorView)
        windowInsetsController.hide(systemBars())

        // Avoid screen lock
        window.addFlags(FLAG_KEEP_SCREEN_ON)

        setContent { AddMainScreen() }
    }
}

@Preview(showBackground = true)
@Composable
private fun AddMainScreen() {
    WhiteScreenTheme {}
}
