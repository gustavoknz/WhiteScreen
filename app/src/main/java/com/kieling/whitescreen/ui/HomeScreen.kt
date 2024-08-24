package com.kieling.whitescreen.ui

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kieling.whitescreen.ui.theme.Black
import com.kieling.whitescreen.ui.theme.MediumRed
import com.kieling.whitescreen.ui.theme.Red
import com.kieling.whitescreen.ui.theme.White
import com.kieling.whitescreen.ui.theme.Yellow

@Composable
fun HomeScreen() {
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
            ColoredBox(colorInput, Yellow)
            ColoredBox(colorInput, MediumRed)
            ColoredBox(colorInput, Red)
        }
    }
}

@Composable
fun ColoredBox(colorInput: MutableState<Color>, boxColor: Color) {
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
private fun ColorBoxPreview() {
    ColoredBox(colorInput = remember { mutableStateOf(Red) }, boxColor = Red)
}
