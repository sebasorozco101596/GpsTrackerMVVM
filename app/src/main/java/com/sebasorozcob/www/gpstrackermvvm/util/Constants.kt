package com.sebasorozcob.www.gpstrackermvvm.util

object Constants {

    // Room Database
    const val RUNNING_DATABASE_NAME = "running_db"

    // Permissions of the location
    const val REQUEST_CODE_LOCATION_PERMISSION = 0

    // Start or Resume the service
    const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE"
    const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
    const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"
    const val ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT"

    // Notifications
    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Tracking"
    const val NOTIFICATION_ID = 1 // If i put 0 as ID I gonna receive a error

}