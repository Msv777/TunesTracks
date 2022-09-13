package com.example.constraintlayout_navigation.delegate

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import base.DelegateType
import base.ViewHolder
import com.example.constraintlayout_navigation.Bean.TestBean
import com.example.constraintlayout_navigation.MyApplication
import com.example.constraintlayout_navigation.R
import com.example.constraintlayout_navigation.nest_adapter
import kotlinx.android.synthetic.main.item_left.view.*
import kotlinx.android.synthetic.main.item_right.*
import kotlinx.android.synthetic.main.item_right.view.*
import toast

class RightDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_right

    override fun isItemViewType(item: TestBean, position: Int): Boolean = "three" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
//            item_right_text.text = item.text
            val nestList = ArrayList<TestBean>()
            fun initNsetBeans() {
                repeat(2) {
                    nestList.add(TestBean("three","Nier Replicant", R.drawable.nier_rep_nest))
                    nestList.add(TestBean("three","Cyberpunk 2077", R.drawable.cyber2077_pic))
                    nestList.add(TestBean("three","Fall Guys", R.drawable.fallguys_nest))
                    nestList.add(TestBean("three","MonsterHunter Rise", R.drawable.mhr_nest))
                    nestList.add(TestBean("three","SIFU", R.drawable.sifu_nest))
                    nestList.add(TestBean("three","FF7 RE", R.drawable.ff7re_nest))
                }
            }
            initNsetBeans()
            val layoutManager = LinearLayoutManager(MyApplication.context)
            layoutManager.orientation= LinearLayoutManager.HORIZONTAL
            recyclerView_nest.layoutManager = layoutManager
            val adapter = nest_adapter(nestList)
            recyclerView_nest.adapter = adapter
            setOnClickListener {
                context.toast("RightDelegate")
            }
        }
    }
}