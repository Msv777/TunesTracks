package com.example.constraintlayout_navigation.adapter

import android.content.Context
import com.example.constraintlayout_navigation.listviewLayout.DelegateItemAdapter
import com.example.constraintlayout_navigation.Bean.TestBean
import com.example.constraintlayout_navigation.delegate.CenterDelegate
import com.example.constraintlayout_navigation.delegate.LeftDelegate
import com.example.constraintlayout_navigation.delegate.RightDelegate


class MultiItemAdapter(mContext: Context, mDatas: List<TestBean>)
    : DelegateItemAdapter<TestBean>(mContext, mDatas) {
    init {
        addItemViewDelegate(LeftDelegate())
        addItemViewDelegate(CenterDelegate())
        addItemViewDelegate(RightDelegate())
    }
}