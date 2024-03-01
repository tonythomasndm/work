package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                MessageCard(Message("God","World is beautiful"))
                MessageCard(Message("Android","I m going to learn Jetpack Compose with the help of God"))
            }

        }
    }
}
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message){
    Column{
        Text("Hello ${msg.author}")
        Text("- ${msg.body}")
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewMessageCard(){
    MessageCard(Message("Preview","Is it working?"))
}