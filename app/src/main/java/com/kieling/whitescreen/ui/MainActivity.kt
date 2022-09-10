package com.kieling.whitescreen.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kieling.whitescreen.ui.theme.WhiteScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel: MainViewModel by viewModels()
        setContent {
            AddMainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AddMainScreen() {
    HideSystemUI()
    Scaffold(modifier = Modifier.fillMaxSize()) { paddings ->
        WhiteScreenTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier
                    .padding(paddings)
                    .fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {}
        }
    }
}

@Composable
fun HideSystemUI() {
    // https://developer.android.com/training/system-ui/immersive
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isNavigationBarVisible = false // Navigation bar
}
