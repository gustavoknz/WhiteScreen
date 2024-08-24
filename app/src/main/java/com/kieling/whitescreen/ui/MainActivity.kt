package com.kieling.whitescreen.ui

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kieling.whitescreen.ui.theme.WhiteScreenTheme

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
    WhiteScreenTheme { HomeScreen() }
}
