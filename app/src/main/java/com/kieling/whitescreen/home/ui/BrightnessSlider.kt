package com.kieling.whitescreen.home.ui

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kieling.whitescreen.ui.theme.SliderProgressBarActive
import com.kieling.whitescreen.ui.theme.SliderProgressBarInactive
import com.kieling.whitescreen.ui.theme.SliderThumb

@Composable
fun BrightnessSlider(modifier: Modifier = Modifier, valueSetter: (Float) -> Unit) {
    var value by remember { mutableFloatStateOf(.1F) }
    Slider(
        value = value,
        onValueChange = { value = it },
        modifier = modifier,
        onValueChangeFinished = { valueSetter(value) },
        colors = SliderDefaults.colors().copy(
            thumbColor = SliderThumb,
            activeTrackColor = SliderProgressBarActive,
            inactiveTrackColor = SliderProgressBarInactive
        )
    )
}
