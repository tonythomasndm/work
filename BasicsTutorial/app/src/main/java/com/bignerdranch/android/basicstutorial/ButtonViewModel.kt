package com.bignerdranch.android.basicstutorial

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG="ButtonViewModel"
const val COUNTER_KEY="COUNTER_KEY"
class ButtonViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    init{
        Log.d(TAG,"ViewModel instance Created")

    }
    //val counter = mutableStateOf(0)
    var counter:Int
        get() = savedStateHandle.get(COUNTER_KEY) ?: 0
        set(value) = savedStateHandle.set(COUNTER_KEY,value)
    // Function to increment the counter
    fun incrementCounter() {
        counter++
    }

    // Function to decrement the counter
    fun decrementCounter() {
        counter --
    }


    override fun onCleared(){
        super.onCleared()
        Log.d(TAG,"ViewModel instance is about to be destroyed")
    }

}

@Composable
fun Show(){
    Text(text = "Work")
}