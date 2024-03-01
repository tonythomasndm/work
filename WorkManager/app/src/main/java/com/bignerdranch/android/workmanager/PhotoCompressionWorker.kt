package com.bignerdranch.android.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class PhotoCompressionWorker(
    private val appContext: Context,
    private val params: WorkerParameters
    ): CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        val stringUri = params.inputData.getString()
    }

    companion object{
        const val KEY_CONTENT_URI ="KEY_CONTENT_URI"
        const val KEY_COMPRESSION_THRESHOLD ="KEY_COMPRESSION_THRERSHOLD"
        const val KEY_CONTENT_URI ="KEY_CONTENT_URI"
    }
}