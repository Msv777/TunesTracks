package com.example.constraintlayout_navigation

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.constraintlayout_navigation.lxr.frag1
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_music_bottom.*
import showToast


class MainActivity : AppCompatActivity() {
    val mediaPlayer = MyApplication.mymediaPlayer
    //定义函数区域
    //seekbar控制
    private fun initProgress():SeekBar{
        var progress = findViewById<SeekBar>(R.id.seekBar)
        //progress就是seekbar的实例
        progress.max = mediaPlayer.duration
    return progress
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
//        listView.adapter=adapter

        //设定navicontrol,配置跳转,
        // 导航图：读取这个切换目标及路径
        //NavHost：包含A、B、C的容器，用于显示Fragment。
        //NavController：在得知切换目标时，控制NavHost去显示B这个Fragment。
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        pause.setVisibility(View.INVISIBLE)
        mymediaPlayer.initMediaPlayer()
        initProgress()
        val progressThread_p =progressThread(mediaPlayer,initProgress())
        progressThread_p.start()
        progressThread_p.flag=true
        var progress = findViewById<SeekBar>(R.id.seekBar)
        //progress就是seekbar的实例
        progress.setOnSeekBarChangeListener( object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                // 滑动中
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // 开始滑动
                progressThread_p.flag=false
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // 滑动结束
                mediaPlayer.seekTo(seekBar.progress)
                Log.d("mediaplayer", progressThread_p.flag.toString())
                "跳转进度".showToast()
                progressThread_p.flag=true
                Log.d("mediaplayerAfter", progressThread_p.flag.toString())
            }

        })
        //设置mainactivity按键区域
        play.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start() // 开始播放
                play.setVisibility(View.INVISIBLE)
                pause.setVisibility(View.VISIBLE)
            }
        }
        pause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause() // 开始播放
                Log.d("resumeError",(mediaPlayer.isPlaying).toString())
                Log.d("duGetError",(mediaPlayer.getCurrentPosition()).toString())
                Log.d("duError",(mediaPlayer.duration).toString())
                play.setVisibility(View.VISIBLE)
                pause.setVisibility(View.INVISIBLE)
            }

        }
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.start()
        }
        supportActionBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }

}
