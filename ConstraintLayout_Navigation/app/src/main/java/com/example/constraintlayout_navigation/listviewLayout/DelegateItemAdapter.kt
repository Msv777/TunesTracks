package com.example.constraintlayout_navigation.listviewLayout
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import base.DelegateManager
import base.DelegateType
import base.ViewHolder
import com.example.constraintlayout_navigation.MyApplication
import com.example.constraintlayout_navigation.MyApplication.Companion.homerePosition
import com.example.constraintlayout_navigation.adapter.MultiItemAdapter
import toast

/*** itemView适配器，有多少类型就要添加多少个Delegate，并且不能添加相同的Delegate，不然会抛异常*/
open class DelegateItemAdapter<T>(val mContext: Context, val mDatas: List<T>) : RecyclerView.Adapter<ViewHolder>() {

    lateinit var onItemClick: (Int) -> Unit
    fun setOnItemClickListener(onItemClick: (Int) -> Unit) {
        this.onItemClick= onItemClick
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
       holder.itemView.setOnClickListener {
           homerePosition = position
           Log.d ("testForP","ada")
           onItemClick.invoke(position)//将方法作为参数，把position给到click事件；若传值写在后面，就会把上一次点击的值给到homerePistion；
        }
        convert(holder, mDatas[position])
    }

    /*** itemView管理器*/
    protected val mDelegateManager: DelegateManager<T> = DelegateManager()

    /*** 获取itemView类型*
     * @param position 当前position*/
    override fun getItemViewType(position: Int): Int = if (!useItemViewDelegateManager())
        super.getItemViewType(position)
    else
        mDelegateManager.getItemViewType(mDatas[position], position)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = convert(holder, mDatas[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder.createViewHolder(mContext, parent, mDelegateManager.getItemViewDelegate(viewType).itemViewLayoutId)

    override fun getItemCount(): Int = mDatas.size

    /*** 显示数据*
     * @param holder ViewHolder
     * @param item data数据*/
    fun convert(holder: ViewHolder, item: T) = mDelegateManager.convert(mContext, holder, item, holder.adapterPosition)

    /*** 添加itemView** @param delegate itemView
     * @throws IllegalArgumentException 已存在不能再添加*/
    fun addItemViewDelegate(delegate: DelegateType<T>) = mDelegateManager.addDelegate(delegate)

    /*** 添加itemView*
     * @param viewType itemView的下标
     * @param delegate itemView
     * @throws IllegalArgumentException 已存在不能再添加*/
    fun addItemViewDelegate(viewType: Int, delegate: DelegateType<T>) = mDelegateManager.addDelegate(viewType, delegate)

    /*** 获取List*
     * @return List*/
    fun getDatas(): List<T> = mDatas

    /*** 判断itemView类型总数是否大于0*
     * * @return Boolean*/
    protected fun useItemViewDelegateManager(): Boolean = mDelegateManager.delegateCount > 0

}