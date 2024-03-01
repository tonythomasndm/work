package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG="QuizViewModel"

class ButtonViewModel: ViewModel() {
    init{
        Log.d(TAG,"ViewModel instance Created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.d(TAG,"ViewModel instance is about to be destroyed")
    }
}