package com.example.constraintlayout_navigation.delegate

import android.content.Context
import android.widget.Toast
import base.DelegateType
import base.ViewHolder
import com.example.constraintlayout_navigation.Bean.TestBean
import com.example.constraintlayout_navigation.MyApplication
import com.example.constraintlayout_navigation.R
import kotlinx.android.synthetic.main.item_center.view.*
import toast


class CenterDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_center
    interface ROnItemClickListener {
        fun onItemClick(position: Int)
    }
    var mOnItemClickListener : ROnItemClickListener? =null
    private val mPosition = 0
    fun setOnItemClickListener(listener: ROnItemClickListener) {
        mOnItemClickListener = listener
    }


override fun isItemViewType(item: TestBean, position: Int): Boolean = "two" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_center_text.text = item.text
            item_center_image.setImageResource(item.img)
            Center_textView_songname1.text = item.text1
            Center_textView_songname2.text = item.text2
            Center_lefttime1.text = item.text3
            Center_lefttime2.text = item.text4
        }
    }

}