package com.example.constraintlayout_navigation.ui.dashboard

import android.content.Context
import com.example.constraintlayout_navigation.MyApplication
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constraintlayout_navigation.Bean.TestBean
import com.example.constraintlayout_navigation.R
import com.example.constraintlayout_navigation.nest_adapter
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.item_right.*
import showToast

class DashboardFragment : Fragment() {
    companion object {
        const val TAG = "FragmentDashLIFE"
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



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        //inflater其实是使用pull解析的方法，循环解析xml布局中的节点，使用createView方法创建布局，最后把创建好的布局返回。
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val root2 = inflater.inflate(R.layout.item_right, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer { textView.text = it })
        Log.d(TAG, "onCreateView")
        return root
    }

    override fun onStart() {
        super.onStart()
//        button.setOnClickListener { Toast.makeText(MyApplication.context,"id button ",Toast.LENGTH_LONG).show()}
//        button.setOnClickListener { "BUTTON CLICKED".showToast()}
//        val nestList = ArrayList<TestBean>()
//        fun initFruits() {
//            repeat(2) {
//                nestList.add(TestBean("three","Apple", R.drawable.apple_pic))
//                nestList.add(TestBean("three","Banana", R.drawable.banana_pic))
//                nestList.add(TestBean("three","Orange", R.drawable.orange_pic))
//                nestList.add(TestBean("three","Watermelon", R.drawable.watermelon_pic))
//                nestList.add(TestBean("three","Pear", R.drawable.pear_pic))
//                nestList.add(TestBean("three","Grape", R.drawable.grape_pic))
//                nestList.add(TestBean("three","Pineapple", R.drawable.pineapple_pic))
//                nestList.add(TestBean("three","Strawberry", R.drawable.strawberry_pic))
//                nestList.add(TestBean("three","Cherry", R.drawable.cherry_pic))
//                nestList.add(TestBean("three","Mango", R.drawable.mango_pic))
//            }
//        }
//        initFruits()
//        val layoutManager = LinearLayoutManager(MyApplication.context)
//        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
//        recyclerView_nest.layoutManager = layoutManager
//        val adapter = nest_adapter(nestList)
//        recyclerView_nest.adapter = adapter
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