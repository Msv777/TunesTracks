package com.example.constraintlayout_navigation

import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_music_bottom.*

class MyApplication : Application() {
    companion object {
        lateinit var context: Context
        lateinit var activity: AppCompatActivity
        lateinit var mymediaPlayer:MediaPlayer
    }

    override fun onCreate() {super.onCreate()
        context = applicationContext
        mymediaPlayer= MediaPlayer()
    }

}
//全局获取应用上下文



