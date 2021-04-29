package com.sebasorozcob.www.gpstrackermvvm.services

import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.sebasorozcob.www.gpstrackermvvm.util.Constants.ACTION_PAUSE_SERVICE
import com.sebasorozcob.www.gpstrackermvvm.util.Constants.ACTION_START_OR_RESUME_SERVICE
import com.sebasorozcob.www.gpstrackermvvm.util.Constants.ACTION_STOP_SERVICE
import timber.log.Timber

class TrackingService : LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("Started or resumed Service")
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused Service")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stoped Service")
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

}