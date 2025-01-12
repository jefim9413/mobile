package com.example.alarmapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.alarmapp.R
import com.example.alarmapp.setAlarm

@Composable
fun AlarmScreen() {
    var hour by remember { mutableStateOf(0) }
    var minute by remember { mutableStateOf(0) }
    var showTimePicker by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Definir Alarme", fontSize = 32.sp, fontWeight = FontWeight.Bold)

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Alarm Icon",
            modifier = Modifier.size(120.dp).padding(16.dp)
        )

        Button(onClick = { showTimePicker = true }) {
            Text("Selecionar Hora", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = String.format("Hora selecionada: %02d:%02d", hour, minute),
            fontSize = 16.sp,
            color = MaterialTheme.colors.primary
        )

        if (showTimePicker) {
            TimePickerDialogHandler(
                show = showTimePicker,
                onTimeSelected = { selectedHour, selectedMinute ->
                    hour = selectedHour
                    minute = selectedMinute
                    showTimePicker = false
                },
                onDismiss = { showTimePicker = false }
            )
        }

        Button(
            onClick = {
                setAlarm(context, hour, minute)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        ) {
            Text("Configurar Alarme", fontSize = 18.sp, color = Color.White)
        }
    }
}
