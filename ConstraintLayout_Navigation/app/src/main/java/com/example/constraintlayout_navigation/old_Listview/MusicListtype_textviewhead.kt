package com.example.constraintlayout_navigation.old_Listview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.constraintlayout_navigation.Bean.ListBean
import com.example.constraintlayout_navigation.MyApplication.Companion.context
import com.example.constraintlayout_navigation.R

//此文件意在实现按type索引adapter实现的路径,具体实现是由holder(inputer)来对应xml资源,通过重写getItemViewType分配type,再在getview通过switch语句来对应type返回
//position是钥匙,串起来的线索,首先要将定义的数据,以自定义类listbean方式存储在List中,然后可以通过包裹一个data,通过data.get(position)来获取对应位置的数据传入getItemViewType
open class Listadapter(context: Context, val resourceId: Int, data: List<ListBean>):BaseAdapter()
{
    //定义变量
    private var inflater: LayoutInflater? = null
    var datas:List<ListBean> = data
    private val TYPE_ITEMLIST = 0
    private val TYPE_TEXTVIEW = 1

    //对应xml
    inner class inputListviewType_1(view:View?)//view由重写的getView传入
    {
        init{
        //类似 class a(变量1.变量2){init{}}的写法,是指定类的构造函数,init{}内是构造函数体,变量1,2在使用时必须传入;
            val musicImage: ImageView? = view?.findViewById<ImageView>(R.id.MusicImage)
            val musicName: TextView? = view?.findViewById(R.id.MusicName)//在music_linear_listitem.xml定义
//           var music : ListBean //返回当前生成的实例
//        lateinit var i :Musicitem
            if(datas != null){
             musicImage?.setImageResource(datas.get(1).img)
             musicName?.text = datas.get(1).text
            }
        }
    }
    inner class inputListviewType_2(view:View?)//view由重写的getView传入
    {
        init{

            //类似 class a(变量1.变量2){init{}}的写法,是指定类的构造函数,init{}内是构造函数体,变量1,2在使用时必须传入;
            val Titletext: TextView? = view?.findViewById(R.id.TextviewText)//在music_linear_listitem.xml定义
//            lateinit var music : Musicitem//返回当前生成的实例
//        lateinit var i :Musicitem
            if(datas != null){
                Titletext?.text = datas.get(0).name
            }
        }
    }

    //对应布局
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 使用LayoutInflater来为这个子项加载我们传入的布局。
        //第一个指定活动,第二个定义资源id
        //第三个参数指定成false，表示只让我们在父布局中声明的layout属性生效，但不会为这个
        //View 添加父布局。因为一旦View 有了父布局之后，它就不能再添加到ListView 中了。
        val view = LayoutInflater.from(context).inflate(resourceId,parent,false)
        val musiclist: inputListviewType_1?
        val musicText: inputListviewType_2?
        var LocalconvertView=convertView
        val type = getItemViewType(position)
        Log.d("convertviewFirst",convertView.toString())
        if(LocalconvertView == null)
        {
            when(type)
            {
                TYPE_ITEMLIST->
                {
                    LocalconvertView = LayoutInflater.from(context).inflate(resourceId,parent,false)
                    musiclist = inputListviewType_1(convertView);
                    convertView?.setTag(musiclist);
                }
                TYPE_TEXTVIEW->
                {
                    LocalconvertView = LayoutInflater.from(context).inflate(resourceId,parent,false)
                    musicText = inputListviewType_2(convertView);
                    convertView?.setTag(musicText);
                }
            }
        }
        else{
            when(type)
            {
                TYPE_ITEMLIST->
                {
                    Log.d("convertviewLook",convertView.toString())
                    musiclist = convertView!!.tag as? inputListviewType_1
                }
                TYPE_TEXTVIEW->
                {
                    Log.d("convertviewLookText",convertView.toString())
                    musicText = convertView!!.tag as? inputListviewType_2
                }
            }
        }
//        val musicImage: ImageView = view.findViewById<ImageView>(R.id.MusicImage)
//        val musicName: TextView = view.findViewById(R.id.MusicName)//在music_linear_listitem.xml定义
//        val music = getItem(position)//返回当前生成的实例
////        lateinit var i :Musicitem
//        if(music != null){
//            musicImage.setImageResource(music.imageId)
//            musicName.text = music.name
//        }

        return view
    }
    //定义type
    override fun getItemViewType(position: Int): Int {
        val type:String = datas.get(position).type
        if ("1"==type) {//
            Log.d("errorTYPE","1")
            return TYPE_ITEMLIST;
        } else if ("0"==type) {//
            Log.d("errorTYPE","0")
            return TYPE_TEXTVIEW;
        } else {
          Log.d("errorTYPE","TYPE_ERROR!")
            return -1;
        }
    }

    override fun getItem(position: Int): Any {
      return datas.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getCount(): Int {
        return datas.size
    }
}