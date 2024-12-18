package com.example.nighteventsapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nighteventsapp.screens.*
import com.example.nighteventsapp.utils.NotificationManager

@Composable
fun AppNavigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController, context = context) }
        composable("favorites") { FavoritesScreen(navController) }
        composable("events") { SubscribedEventsScreen(navController) }
        composable("notifications") {
            NotificationScreen(notifications = NotificationManager.getNotifications())
        }
        composable("eventDetails/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")
            EventDetailsScreen(eventId = eventId)
        }
    }
}
