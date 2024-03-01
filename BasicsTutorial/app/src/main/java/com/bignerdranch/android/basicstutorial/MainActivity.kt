package com.bignerdranch.android.basicstutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.SavedStateHandle
import com.bignerdranch.android.basicstutorial.ui.theme.BasicsTutorialTheme

private const val TAG ="MainActivity"
class MainActivity : ComponentActivity() {
    private val buttonViewModel: ButtonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        Log.d(TAG,"Got a View Model : $buttonViewModel")
        setContent {
            BasicsTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(buttonViewModel)
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onRestart() {
        super.onRestart()
        println("OnRestart()")
    }
}

@Composable
fun MyApp(viewModel: ButtonViewModel = ButtonViewModel(savedStateHandle = SavedStateHandle())) {

    Column {
        // Display the counter value
        Text(text = "Counter: ${viewModel.counter}")

        // Button to increment the counter
        Button(onClick = { viewModel.incrementCounter() }) {
            Text(text = "Increment")
        }

        // Button to decrement the counter
        Button(onClick = { viewModel.decrementCounter() }) {
            Text(text = "Decrement")
        }
    }
}

@Preview
@Composable
fun PreviewMyApp() {
    MyApp()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.Blue,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicsTutorialTheme {
        Greeting("Android")
    }
}