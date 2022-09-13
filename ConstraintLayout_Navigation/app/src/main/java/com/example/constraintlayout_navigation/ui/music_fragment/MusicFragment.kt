package com.example.constraintlayout_navigation.ui.music_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.constraintlayout_navigation.MyApplication
import com.example.constraintlayout_navigation.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import showToast

class MusicFragment : Fragment() {
    companion object {
        const val TAG = "FragmentLMUSIC"
    }
    //viewmodel是用来存储activity间数据的;如text的value;可以在屏幕旋转之间保留;
    //LayoutInflater inflater：作用类似于findViewById（），findViewById（）用来寻找xml布局下的具体的控件（Button、TextView等），LayoutInflater inflater（）用来找res/layout/下的xml布局文件
    //ViewGroup container：表示容器，View放在里面
    //Bundle savedInstanceState：保存当前的状态，在活动的生命周期中，只要离开了可见阶段，活动很可能就会被进程终止，这种机制能保存当时的状态
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG,"onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG,"onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        Log.d(TAG,"importantsit")
        return inflater.inflate(R.layout.fragment_music_bottom, container, false)
    }

    override fun onStart() {
        super.onStart()
//        button.setOnClickListener { Toast.makeText(MyApplication.context,"id button ",Toast.LENGTH_LONG).show()}
        //赋值逻辑写在这,不能写上面

        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

}