package com.example.alarmapp

import android.app.TimePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import java.util.*

@Composable
fun TimePickerDialogHandler(
    show: Boolean,
    onTimeSelected: (Int, Int) -> Unit,
    onDismiss: () -> Unit
) {
    if (show) {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // ✅ Correção: Usar LaunchedEffect para rodar código fora do Composable
        LaunchedEffect(Unit) {
            TimePickerDialog(
                context,
                { _, selectedHour, selectedMinute ->
                    onTimeSelected(selectedHour, selectedMinute)
                },
                hour, minute, true
            ).apply {
                setOnDismissListener { onDismiss() }
                show()
            }
        }
    }
}
