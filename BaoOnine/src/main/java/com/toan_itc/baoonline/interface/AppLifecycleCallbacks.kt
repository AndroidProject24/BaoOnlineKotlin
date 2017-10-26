package com.toan_itc.baoonline.`interface`

import android.app.Application

interface AppLifecycleCallbacks {

  fun onCreate(application: Application)

  fun onTerminate(application: Application)
}