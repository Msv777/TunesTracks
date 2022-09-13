package com.example.constraintlayout_navigation.delegate

import android.content.Context
import com.example.constraintlayout_navigation.Bean.TestBean
import base.DelegateType
import base.ViewHolder
import com.example.constraintlayout_navigation.R
import kotlinx.android.synthetic.main.home_nest_cross.view.*
import kotlinx.android.synthetic.main.item_left.view.*
import toast

class SingleItemDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.home_nest_cross

    override fun isItemViewType(item: TestBean, position: Int): Boolean = true

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_nest_text.text = item.text
            setOnClickListener {
                context.toast("SingleItemDelegate")
            }
        }
    }
}