package com.example.animalapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

@Composable
fun AnimalScreen(animal: String) {
    val context = LocalContext.current
    val imageRes = if (animal == "Dog") R.drawable.dog else R.drawable.cat
    val soundRes = if (animal == "Dog") R.raw.dogg else R.raw.catt
    val videoRes = if (animal == "Dog") R.raw.dog else R.raw.cat

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$animal Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val mediaPlayer = MediaPlayer.create(context, soundRes)
            mediaPlayer?.start()
            mediaPlayer?.setOnCompletionListener { mediaPlayer.release() }
        }) {
            Text("Reproduzir Som")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra("videoRes", videoRes)
            context.startActivity(intent)
        }) {
            Text("Reproduzir Vídeo")
        }
    }
}
