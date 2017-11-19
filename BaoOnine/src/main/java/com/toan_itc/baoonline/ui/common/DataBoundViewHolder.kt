package com.toan_itc.baoonline.ui.common

import android.support.v7.widget.RecyclerView

/**
 * Created by Toan.IT on 11/2/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
class DataBoundViewHolder<out T : ViewDataBinding>
internal constructor(val binding: T) : RecyclerView.ViewHolder(binding.root)
