package com.bignerdranch.android.coroutinespratice

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.android.coroutinespratice.ui.theme.CoroutinesPraticeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext

private const val TAG="MainActivity"
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesPraticeTheme {

                //GlobalScope.launch(Dispatchers.Main) {
                //                    Log
                //GlobalScope.launch(newSingleThreadContext("My Thread"))
                GlobalScope.launch(Dispatchers.IO) {
                    val answer=doNetworkCall()
                    withContext(Dispatchers.Main){
                        Log.d(TAG,"THREAD M context = ${Thread.currentThread().name}")
                        tvDummy.text = answer
                    }


//                    Log.d(TAG,doNetworkCall())
//                    Log.d(TAG,doNetworkCall2())
//                    delay(10000L)//will block the current coroutine - not the whole thread
//                   Log.d(TAG,"THREAD = ${Thread.currentThread().name}")
                }
                Log.d(TAG,"THREAD M = ${Thread.currentThread().name}")
            }
        }
    }
    //first delay call also influences the second call bcoz they are executed in the same routune
    suspend fun doNetworkCall(): String{
        delay(3000L)
        return "This is the answer"
    }
    suspend fun doNetworkCall2(): String{
        delay(3000L)
        return "This is the 2 answer"
    }
}

suspend fun doNetworkCall(): String{
    delay(3000L)
    return "This is the answer"
}
//main finished - all other cancelled
//suspend fn inside of rotine or another suspend fn
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesPraticeTheme {
        Greeting("Android")
    }
}