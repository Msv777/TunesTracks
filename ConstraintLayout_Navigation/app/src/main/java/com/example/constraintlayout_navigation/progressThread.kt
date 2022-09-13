package com.example.constraintlayout_navigation

import android.media.MediaPlayer
import android.util.Log
import android.widget.SeekBar
import com.example.constraintlayout_navigation.ui.home.HomeFragment

class progressThread (var player: MediaPlayer,var progress:SeekBar): Thread(){
    var flag:Boolean = true
    override fun run() {
        super.run()
        while(flag){
            if(player.isPlaying()) {
                progress.setProgress(player.getCurrentPosition()); //实时获取播放音乐的位置并且设置进度条的位置
            }
//            if(progress.getProgress()==player.duration)
//            {
//                Log.d("ThreadSeekBar","resetsucess")
//                player.reset()
//            }
        }
    }
}