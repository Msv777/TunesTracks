package com.example.constraintlayout_navigation.old_Listview
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.constraintlayout_navigation.R
import com.example.constraintlayout_navigation.old_Listview.Musicitem

//MusicAdapter定义了一个主构造函数，用于将Activity 的实例、ListView 子项布局的id和数
//据源传递进来。另外又重写了getView()方法，这个方法在每个子项被滚动到屏幕内的时候会
//被调用。
class MusicAdapter(context: Context, val resourceId: Int, data: List<Musicitem>) : ArrayAdapter<Musicitem>(context, resourceId, data)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       // 使用LayoutInflater来为这个子项加载我们传入的布局。
        //第一个指定活动,第二个定义资源id
        //第三个参数指定成false，表示只让我们在父布局中声明的layout属性生效，但不会为这个
        //View 添加父布局。因为一旦View 有了父布局之后，它就不能再添加到ListView 中了。
        val view = LayoutInflater.from(context).inflate(resourceId,parent,false)
        val musicImage: ImageView = view.findViewById<ImageView>(R.id.MusicImage)
        val musicName: TextView = view.findViewById(R.id.MusicName)//在music_linear_listitem.xml定义
        val music = getItem(position)//返回当前生成的实例
//        lateinit var i :Musicitem
        if(music != null){
            musicImage.setImageResource(music.imageId)
            musicName.text = music.name
        }
        return view
    }
}