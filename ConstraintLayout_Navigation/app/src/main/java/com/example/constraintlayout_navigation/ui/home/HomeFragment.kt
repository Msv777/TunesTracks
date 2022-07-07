package com.example.constraintlayout_navigation.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constraintlayout_navigation.Bean.TestBean
import com.example.constraintlayout_navigation.MyApplication
import com.example.constraintlayout_navigation.R
import com.example.constraintlayout_navigation.adapter.MultiItemAdapter
import com.example.constraintlayout_navigation.adapter.SingleItemAdapter
import com.example.constraintlayout_navigation.nest_adapter
import com.example.constraintlayout_navigation.ui.dashboard.DashboardFragment
import com.example.constraintlayout_navigation.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_right.*
import showToast

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    companion object {
        const val TAG = "HOMEtagLIFE"
    }

    //viewmodel是用来存储activity间数据的;如text的value;可以在屏幕旋转之间保留;
    private lateinit var dashboardViewModel: DashboardViewModel//lateinit是后赋值,这样可以省去判空语句
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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }


    override fun onStart() {
        super.onStart()
//        button.setOnClickListener { Toast.makeText(MyApplication.context,"id button ",Toast.LENGTH_LONG).show()}
//        写在这里
        val datas = listOf<TestBean>(
            TestBean("one", "现在就听",R.drawable.pineapple_pic),
            TestBean("three", "three",R.drawable.apple_pic),
            TestBean("two", "Legend of Zelda Bow",R.drawable.glist_zelda,"KASS`Theme","メインテーマ","2;10","3:10"),
            TestBean("two", "Nier Autometa",R.drawable.glist_nierautometa,"Weight of the World","遺サレタ場所/斜光","2;10","3:10"),
            TestBean("two", "Heartstone 背景音乐原声",R.drawable.glist_heartstone,"Pull up a Chair","One Last Chance","2;10","3:10"),
            TestBean("two", "APEX英雄 游戏原声",R.drawable.glist_apexlegends,"Neo Tokyo","Main Theme","2;10","3:10"),
            TestBean("two", "原神 璃月OST",R.drawable.glist_genshinliyue,"杯中明月","峭岩作歌","2;10","3:10"),
            TestBean("two", "HADS哈迪斯 游戏原声",R.drawable.glist_hades,"No Escape","God of the Dead","2;10","3:10"),
            TestBean("two", "Nekopara 游戏原声",R.drawable.glist_nekopara,"SWEET×SWEET","タイヨウパラダイス","2;10","3:10"),
            TestBean("two", "Dead Cells OST",R.drawable.glist_deadcells),
            TestBean("two", "Dota2 Musics",R.drawable.glist_dota2),
            TestBean("two", "NIoh2 仁王2游戏原声",R.drawable.glist_nioh2),
            TestBean("two", "ori2精灵与萤火之森 OST",R.drawable.glist_ori2),
            TestBean("two", "2k22游戏原声",R.drawable.glist_2k22,"","","",""),
            TestBean("two", "CS:GO音乐盒OST",R.drawable.glist_csgo,"","","",""),
            TestBean("two", "Witch3巫师3",R.drawable.glist_witcher3,"","","",""),
            TestBean("two", "Pokemon 阿尔宙斯",R.drawable.glist_pokemona,"","","",""),
            TestBean("two", "Red Dead Redemption2",R.drawable.glist_red_dead_2,"","","",""),
            TestBean("two", "古墓丽影9 游戏原声",R.drawable.glist_tombraider9,"","","",""),
            TestBean("two", "艾尔登法环 ",R.drawable.glist_eldenring,"","","",""),
            TestBean("two", "GHOST对马岛之魂",R.drawable.glist_ghost,"","","",""),
            TestBean("two", "GTA5",R.drawable.glist_gta5,"","","",""),
            TestBean("two", "罗德岛音乐特辑",R.drawable.glist_mrfz,"","","",""),
            TestBean("two", "Witch Spring3魔女之泉3",R.drawable.glist_witchspring3,"","","",""),
            TestBean("two", "只狼:影逝二度",R.drawable.glist_zhilang,"","","",""),
            TestBean("two", "主播女孩重度依赖:OST",R.drawable.glist_zhubonvhai,"","","","")
        )

        recyclerView.layoutManager = LinearLayoutManager(MyApplication.context)
//        recyclerView.adapter = SingleItemAdapter(this, datas)
        recyclerView.adapter = MultiItemAdapter(MyApplication.context, datas)
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