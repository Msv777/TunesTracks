package com.example.constraintlayout_navigation.lxr

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.constraintlayout_navigation.*
import kotlinx.android.synthetic.main.activity_music.*
import kotlinx.android.synthetic.main.fragment_music_bottom.*
import showToast

class MusicActivity : AppCompatActivity() {
    private var animator: ObjectAnimator? = null
    private val name: String? = null
    private val intent1: Intent? = null
    private var intent2: Intent? = null
    val mediaPlayer = MyApplication.mymediaPlayer
    //    private MyServiceConn conn;
    private val isUnbind = false
    private fun initProgress():SeekBar{
        var progress = findViewById<SeekBar>(R.id.sb)
        //progress就是seekbar的实例
        progress.max = mediaPlayer.duration
        progress.setOnSeekBarChangeListener( object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                // 滑动中
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // 开始滑动
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // 滑动结束
                MyApplication.mymediaPlayer.seekTo(sb.progress)
                Log.d("mediaplayerlxr","seekto success")
                "跳转进度".showToast()
            }

        })
        return progress
    }
    private fun init() {
        //        conn=new MyServiceConn();
//        bindService(intent2,conn,BIND_AUTO_CREATE);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initProgress()
        val progressThread_p = progressThread(mediaPlayer,initProgress())
        progressThread_p.start()
        btn_play.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start() // 开始播放
            }
        }
        btn_pause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause() // 开始播放

            }
        }
        btn_continue_play.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start() // 开始播放
            }
        }
        btn_exit.setOnClickListener {
//            mediaPlayer.reset() // 停止播放
//            mymediaPlayer.initMediaPlayer()
//            mediaPlayer.start()
            finish()
        }
        supportActionBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private var sb: SeekBar? = null
        private var tv_progress: TextView? = null
        private var tv_total: TextView? = null
        private var name_song: TextView? = null
        @JvmField
        @SuppressLint("HandlerLeak")
        var handler: Handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                val bundle = msg.data
                val duration = bundle.getInt("duration")
                val currentPosition = bundle.getInt("currentPosition")
                sb!!.max = duration
                sb!!.progress = currentPosition
                var minute = duration / 1000 / 60
                var second = duration / 1000 % 60
                var strMinute: String? = null
                var strSecond: String? = null
                strMinute = if (minute < 10) {
                    "0$minute"
                } else {
                    minute.toString() + ""
                }
                strSecond = if (second < 10) {
                    "0$second"
                } else {
                    second.toString() + ""
                }
                tv_total!!.text = "$strMinute:$strSecond"
                minute = currentPosition / 1000 / 60
                second = currentPosition / 1000 % 60
                strMinute = if (minute < 10) {
                    "0$minute"
                } else {
                    "$minute "
                }
                strSecond = if (second < 10) {
                    "0$second"
                } else {
                    "$second "
                }
                tv_progress!!.text = "$strMinute:$strSecond"
            }
        }
    }
}