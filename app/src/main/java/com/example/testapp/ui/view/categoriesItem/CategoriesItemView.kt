package com.example.testapp.ui.view.categoriesItem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.testapp.R
import com.example.testapp.databinding.ViewCategoriesItemBinding
import com.example.testapp.ui.view.categoriesItem.model.CategoriesItem
import com.example.testapp.utils.extension.gone
import com.example.testapp.utils.extension.visible

class CategoriesItemView constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var binding: ViewCategoriesItemBinding

    init {
        binding = ViewCategoriesItemBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setCategoryItem(item: CategoriesItem) {
        with(binding) {
            tvTitle.text = item.title
            tvDescription.text = item.description
            ivIcon.setImageResource(item.icon)
        }
    }

    fun setState(isError: Boolean) {
        with(binding) {
            if (isError) {
                tvError.visible()
                root.setBackgroundResource(R.drawable.background_error_item)
            } else {
                tvError.gone()
                root.setBackgroundResource(R.drawable.background_item)
            }
        }
    }
}
