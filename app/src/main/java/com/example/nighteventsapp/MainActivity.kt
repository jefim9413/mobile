package com.example.nighteventsapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.example.nighteventsapp.components.BottomNavigationBar
import com.example.nighteventsapp.components.DrawerContent
import com.example.nighteventsapp.components.TopBar
import com.example.nighteventsapp.navigation.AppNavigation
import com.example.nighteventsapp.ui.theme.NightEventsAppTheme
import com.example.nighteventsapp.utils.createNotificationChannel
import com.example.nighteventsapp.utils.sendNotification
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Solicitar permissão para notificações (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    1 // Código de solicitação
                )
            }
        }

        // Criar o canal de notificações
        createNotificationChannel(this)

        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val isDarkTheme = remember { mutableStateOf(false) }

            NightEventsAppTheme(darkTheme = isDarkTheme.value) {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = true,
                    drawerContent = {
                        DrawerContent(navController) { scope.launch { drawerState.close() } }
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopBar(
                                onThemeToggle = { isDarkTheme.value = !isDarkTheme.value },
                                onOpenDrawer = { scope.launch { drawerState.open() } }
                            )
                        },
                        bottomBar = { BottomNavigationBar(navController) }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            // Passa o contexto para a navegação
                            AppNavigation(navController = navController, context = this@MainActivity)

                            // Teste: Envia uma notificação ao abrir a MainActivity
                            LaunchedEffect(Unit) {
                                sendNotification(
                                    context = this@MainActivity,
                                    title = "Bem-vindo ao EventsApp",
                                    message = "Acompanhe seus eventos favoritos!"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
