package com.example.postapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postapp.ui.screens.PostItem
import com.example.postapp.ui.screens.PostScreen
import com.example.postapp.ui.screens.UserScreen
import com.example.postapp.ui.theme.PostAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostAppTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    val navController = rememberNavController()
    rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Post App") })
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "user_screen",
            modifier = Modifier.padding(padding)
        ) {
            composable("user_screen") {
                UserScreen()
            }
            composable("post_screen") {
                PostScreen()
            }
        }
    }
}