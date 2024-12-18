package com.example.nighteventsapp.utils

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager // Para criar canais de notificação
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat // Para enviar notificações
import com.example.nighteventsapp.R
import com.example.nighteventsapp.utils.NotificationManager as LocalNotificationManager // Gerenciador de notificações locais

/**
 * Envia uma notificação para o usuário.
 * @param context Contexto da aplicação para acessar o sistema de notificações.
 * @param title Título da notificação.
 * @param message Mensagem a ser exibida na notificação.
 */
fun sendNotification(context: Context, title: String, message: String) {
    val channelId = "EVENT_CHANNEL"
    val notificationId = (System.currentTimeMillis() % 10000).toInt()

    // Adiciona a mensagem à lista local de notificações
    LocalNotificationManager.addNotification("$title: $message")

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_notification) // Substitua pelo ícone existente no projeto
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(notificationId, builder.build())
    }
}

/**
 * Cria o canal de notificações. Necessário para Android Oreo (API 26+) ou superior.
 * @param context Contexto da aplicação para registrar o canal.
 */
fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "EVENT_CHANNEL"
        val channelName = "Notificações de Eventos"
        val channelDescription = "Notificações relacionadas aos eventos favoritados ou inscritos"
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val channel = NotificationChannel(channelId, channelName, importance).apply {
            description = channelDescription
        }

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
