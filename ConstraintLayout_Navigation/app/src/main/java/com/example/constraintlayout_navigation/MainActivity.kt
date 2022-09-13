package com.example.constraintlayout_navigation

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import base.ViewHolder
import com.example.constraintlayout_navigation.Bean.TestBean
import com.example.constraintlayout_navigation.Database.MyDatabaseHelper
import com.example.constraintlayout_navigation.MyApplication.Companion.context
import com.example.constraintlayout_navigation.MyApplication.Companion.dbHelper
import com.example.constraintlayout_navigation.MyApplication.Companion.gametitleImageViewRid
import com.example.constraintlayout_navigation.MyApplication.Companion.homerePosition
import com.example.constraintlayout_navigation.adapter.MultiItemAdapter
import com.example.constraintlayout_navigation.delegate.CenterDelegate
import com.example.constraintlayout_navigation.listviewLayout.DelegateItemAdapter
import com.example.constraintlayout_navigation.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_music_bottom.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.item_left.*
import showToast
import toast
val testbeanList = listOf<TestBean>(TestBean("three","Nier Replicant", R.drawable.nier_rep_nest))
class RecyclerviewOnbindPositionforClickActions:DelegateItemAdapter<TestBean>(context,testbeanList)
{
    init {

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        Log.d("tgsssss","aaaa")
    }
}
    lateinit var ma  :MainActivity
class MainActivity : AppCompatActivity() {
    init {
       ma= this
        Log.d("tgsssss","ssss")
    }
    fun crossFade()
    {
        //将内容视图设置为0%不透明(就是透明的意思,不可见的状态),正常显示的为100%不透明可见
        // 以便在动画期间可见
        container.setAlpha(0.1f);
        container.setVisibility(View.VISIBLE);
//将内容视图设置为100%不透明，并清除视图上的任何动画监听器
        container.animate()
            .alpha(1f)
            .setDuration(500)
            .setListener(null);
    }

    public fun getNav():NavController
    {
        val navController = findNavController(R.id.nav_host_fragment)
        Log.d("NAVerrorLOG","1")
        return  navController
    }

    val mediaPlayer = MyApplication.mymediaPlayer
    //定义函数区域
    //seekbar控制
    private fun initProgress():SeekBar{
        var progress = findViewById<SeekBar>(R.id.seekBar)
        //progress就是seekbar的实例
        progress.max = mediaPlayer.duration
    return progress
    }
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
//        listView.adapter=adapter
        //设定navicontrol,配置跳转,
        // 导航图：读取这个切换目标及路径
        //NavHost：包含A、B、C的容器，用于显示Fragment。
        //NavController：在得知切换目标时，控制NavHost去显示B这个Fragment。
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController= getNav()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnNavigationItemReselectedListener {
//          解决重新点击事件bug
        }
//        crossFade()
        //当前数据库默认存在一个版本号
        //让onUpgrade()方法能够执行,只要传入一个比当前版本号大的数

        db_btn.setVisibility(View.INVISIBLE)
        addData_btn.visibility=View.INVISIBLE
        db_btn.setOnClickListener {
            dbHelper.writableDatabase//
            //调用SQLiteOpenHelper的getReadableDatabase()或 getWritableDatabase()方法可以用于创建和升级数据库
            //返回一个SQLiteDatabase对象
            //手动创建数据库
        }
        addData_btn.setOnClickListener {
            val oridatas = listOf<TestBean>(
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
            val db = dbHelper.writableDatabase
//            val values1 = ContentValues().apply {
//                // 开始组装第一条数据
//                put("game", "Legend of Zelda")
//                put("imgname", "null")
//                put("imgRid",R.drawable.glist_zelda)
//            }
//            db.insert("Games", null, values1) // 插入第一条数据
//            Toast.makeText(context, "add1", Toast.LENGTH_SHORT).show()
//            val values2 = ContentValues().apply {
//                // 开始组装第二条数据
//                put("game", "nier")
//                put("imgname", "null")
//                put("imgRid",R.drawable.glist_nierautometa)
//            }
//            db.insert("Games", null, values2) // 插入第二条数据
            var arrayvalues = mutableListOf<ContentValues>()
            for(i in 0 until 23)
            {
                arrayvalues.add(ContentValues().apply {
                    put("imgRid",oridatas[i].img)
                    put("game",oridatas[i].text)
                })
                Log.d("oridebug2",i.toString())
                Log.d("oridebug",arrayvalues.size.toString())
                db.insert("Games",null,arrayvalues[i])
            }
            Toast.makeText(context, "add2", Toast.LENGTH_SHORT).show()
        }

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
//                progressThread_p.flag=false
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
        nextbutton.setOnClickListener {
            if(!mediaPlayer.isPlaying)
            {
                play.setVisibility(View.INVISIBLE)
                pause.setVisibility(View.VISIBLE)
            }
            music_bottom_name.text="Kass`Theme "
            musicpicbutton.setBackgroundResource(R.drawable.glist_zelda)
            mediaPlayer.stop()
            mediaPlayer.reset()
            mymediaPlayer.fd = mymediaPlayer.assetManager.openFd("KassTheme.mp3")
            mymediaPlayer.initMediaPlayer()
            mediaPlayer.start()
        }

        pirorbutton.setOnClickListener {
            if(!mediaPlayer.isPlaying)
            {
                play.setVisibility(View.INVISIBLE)
                pause.setVisibility(View.VISIBLE)
            }
            music_bottom_name.text="记录夏日"
            musicpicbutton.setBackgroundResource(R.drawable.glist_nekopara)
            mediaPlayer.stop()
            mediaPlayer.reset()
            mymediaPlayer.fd = mymediaPlayer.assetManager.openFd("记录夏日.mp3")
            mymediaPlayer.initMediaPlayer()
            mediaPlayer.start()
        }
        musicpicbutton.setOnClickListener {
            crossFade()
            getNav().navigate(R.id.navigation_notifications)
        }
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.start()//完毕后的动作
        }
        HomeFragment.adapter.setOnItemClickListener {
            // do something
//           MyApplication.context.toast(homerePosition.toString())
            val  titlecursor= HomeFragment.db.rawQuery("select * from Games where id = ?", arrayOf((homerePosition-1).toString()))
            var gamename:String ="not init"
            var imgRid:Int = 0
            if (titlecursor.moveToFirst())
            {
                do
                {
                    gamename = titlecursor.getString(titlecursor.getColumnIndex("game"))
                    imgRid = titlecursor.getInt(titlecursor.getColumnIndex("imgRid"))
                    gametitleImageViewRid=imgRid
                    musicpicbutton.setBackgroundResource(imgRid)
                    music_bottom_gamename.setText(gamename)
                    Log.d ("TestforCursor",gamename)
                } while(titlecursor.moveToNext())
            }
            titlecursor.close()
//            var titleID =
//            gametitleImageView.setImageResource(titleID)
            Log.d ("testForP","MAIN")
            crossFade()
            getNav().navigate(R.id.navigation_notifications)
        }
        supportActionBar?.hide()

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }

}
//分阶段来看现在主要有几个问题：1，界面逻辑的继续完善，
// 2，数据库和后端管理程序，
// 3，应用web部分（收和发），
// 4.美工重新设计
