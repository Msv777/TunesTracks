package com.example.constraintlayout_navigation.delegate

import android.content.Context
import com.example.constraintlayout_navigation.Bean.TestBean
import base.DelegateType
import base.ViewHolder
import com.example.constraintlayout_navigation.R
import kotlinx.android.synthetic.main.item_center.view.*
import kotlinx.android.synthetic.main.item_left.view.*
import toast

class LeftDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_left

    override fun isItemViewType(item: TestBean, position: Int): Boolean = "one" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_left_text.text = item.text
           // item_left_image.setImageResource(item.img)
            setOnClickListener {
                context.toast("LeftDelegate")
            }
        }
    }
}