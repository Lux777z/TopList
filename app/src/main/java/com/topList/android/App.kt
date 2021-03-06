package com.topList.android

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.topList.android.utils.RxBus
import com.topList.theme.ThemeManager
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * @author yyf
 * @since 08-12-2019
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ThemeManager.init(this) {
            RxBus.instance.post(it)
        }
        Fresco.initialize(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}
