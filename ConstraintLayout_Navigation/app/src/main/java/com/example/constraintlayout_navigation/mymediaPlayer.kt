package com.example.constraintlayout_navigation


import android.content.Context
import android.content.res.AssetManager
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

 class mymediaPlayer{
    companion object {
        val assetManager = MyApplication.context.assets
        var fd = assetManager.openFd("Send It.mp3")
        fun initMediaPlayer() {
            MyApplication.mymediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
            MyApplication.mymediaPlayer.prepare()
        }

    }
}