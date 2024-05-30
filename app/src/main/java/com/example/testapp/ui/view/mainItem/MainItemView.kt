package com.example.testapp.ui.view.mainItem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.testapp.databinding.ViewMainItemBinding
import com.example.testapp.ui.view.mainItem.model.MainItemModel

class MainItemView constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var binding: ViewMainItemBinding

    init {
        binding = ViewMainItemBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setMainItem(item: MainItemModel) {
        with(binding) {
            tvTitle.text = item.title
            tvDescription.text = item.description
            btnAction.text = item.titleAction
            ivIcon.setImageResource(item.icon)
        }
    }
}
