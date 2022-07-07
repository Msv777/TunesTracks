package com.example.constraintlayout_navigation.delegate

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constraintlayout_navigation.Bean.TestBean
import base.DelegateType
import base.ViewHolder
import com.example.constraintlayout_navigation.MyApplication
import com.example.constraintlayout_navigation.R
import com.example.constraintlayout_navigation.adapter.MultiItemAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_center.view.*
import kotlinx.android.synthetic.main.item_left.view.*
import toast

class CenterDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_center

    override fun isItemViewType(item: TestBean, position: Int): Boolean = "two" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_center_text.text = item.text
            item_center_image.setImageResource(item.img)
            Center_textView_songname1.text = item.text1
            Center_textView_songname2.text = item.text2
            Center_lefttime1.text = item.text3
            Center_lefttime2.text = item.text4
            setOnClickListener {
                context.toast("CenterDelegate")
            }
        }
    }
}