package com.example.constraintlayout_navigation

import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.constraintlayout_navigation.Database.MyDatabaseHelper
import kotlinx.android.synthetic.main.fragment_music_bottom.*

class MyApplication : Application() {
    companion object {
        lateinit var context: Context
        lateinit var activity: AppCompatActivity
        lateinit var mymediaPlayer:MediaPlayer
        lateinit var dbHelper:MyDatabaseHelper
        var homerePosition :Int = 0
        var gametitleImageViewRid = R.drawable.cyber2077_pic
    }

    override fun onCreate() {super.onCreate()
        context = applicationContext
        mymediaPlayer= MediaPlayer()
        dbHelper= MyDatabaseHelper(this, "MusicList.db", 1)
    }

}
//全局获取应用上下文



