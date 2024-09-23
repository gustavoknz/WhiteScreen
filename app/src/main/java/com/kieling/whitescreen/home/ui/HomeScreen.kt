package com.kieling.whitescreen.home.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS
import android.provider.Settings.System
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kieling.whitescreen.home.HomeViewModel
import com.kieling.whitescreen.ui.theme.Black
import com.kieling.whitescreen.ui.theme.Orange
import com.kieling.whitescreen.ui.theme.Red
import com.kieling.whitescreen.ui.theme.White

@Composable
fun AddHomeScreen(homeViewModel: HomeViewModel = viewModel(), finishApp: () -> Unit) {
    HomeScreen(finishApp)
}

@Composable
private fun HomeScreen(finishApp: () -> Unit) {
    val colorInput = remember { mutableStateOf(Red) }
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
            ColoredBox(colorInput, White)
            ColoredBox(colorInput, Orange)
            ColoredBox(colorInput, Red)
        }
        val context = LocalContext.current
        BrightnessSlider(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
                .alpha(.15F)
        ) {
            println("New value: $it")
            val settingsCanWrite = hasWriteSettingsPermission(context)
            if (!settingsCanWrite) {
                showPermissionsDialog(context, finishApp)
            } else {
                setBrightness(context, brightness = it)
            }
        }
    }
}

private fun hasWriteSettingsPermission(context: Context) = System.canWrite(context)

private fun showPermissionsDialog(context: Context, finishApp: () -> Unit) {
    AlertDialog.Builder(context)
        .setTitle("Permission required")
        .setNegativeButton("Exit") { _, _ -> finishApp() }
        .setPositiveButton("Go to settings") { _, _ -> changeWriteSettingsPermission(context) }
        .setMessage("The app must have the permission to set the system brightness.")
        .create()
        .show()
}

private fun changeWriteSettingsPermission(context: Context) {
    context.startActivity(Intent(ACTION_MANAGE_WRITE_SETTINGS))
}

private fun setBrightness(context: Context, brightness: Float) {
    val activity = context as? Activity ?: return
    val layoutParams: WindowManager.LayoutParams = activity.window.attributes
    layoutParams.screenBrightness = brightness
    activity.window.attributes = layoutParams
}

// BK method
//private fun changeScreenBrightness(context: Context, screenBrightnessValue: Int) {
//    System.putInt(
//        context.contentResolver,
//        System.SCREEN_BRIGHTNESS_MODE,
//        System.SCREEN_BRIGHTNESS_MODE_MANUAL
//    )
//    // Apply the screen brightness value to the system, this will change the value in Settings ->
//    // Display ---> Brightness level. It will also change the screen brightness for the device.
//    System.putInt(context.contentResolver, System.SCREEN_BRIGHTNESS, screenBrightnessValue)
//}

@Composable
private fun ColoredBox(colorInput: MutableState<Color>, boxColor: Color) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .border(width = 0.1.dp, color = Black)
            .background(boxColor)
            .clickable { colorInput.value = boxColor }
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen {}
}

@Preview
@Composable
private fun ColorBoxPreview() {
    ColoredBox(colorInput = remember { mutableStateOf(Red) }, boxColor = Red)
}
