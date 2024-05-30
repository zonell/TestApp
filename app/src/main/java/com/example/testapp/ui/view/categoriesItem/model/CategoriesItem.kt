package com.example.testapp.ui.view.categoriesItem.model

import com.example.testapp.R

data class CategoriesItem(
    val icon: Int,
    val title: String,
    val description: String,
    var isError: Boolean
) {

    fun updateIsError(isError: Boolean): CategoriesItem {
        return copy(isError = isError)
    }


    companion object {
        fun getCategories() = listOf(
            CategoriesItem(
                R.drawable.ic_info_square,
                "Device info",
                "Show you all info about phone",
                false
            ),
            CategoriesItem(
                R.drawable.ic_smartphone_rotate_angle,
                "Calibration of sensors",
                "Show you all info about",
                false
            ),
            CategoriesItem(
                R.drawable.ic_object_scan,
                "App monitoring",
                "Show you all info about",
                false
            ),
            CategoriesItem(
                R.drawable.ic_virus_blue,
                "AntiVirus",
                "Show you all info about",
                false
            ),
            CategoriesItem(
                R.drawable.ic_library,
                "Device Memory Information",
                "Show you all info about",
                false
            ),
            CategoriesItem(
                R.drawable.ic_file_smile,
                "File manager",
                "Show you all info about",
                false
            ),
            CategoriesItem(
                R.drawable.ic_battery_full,
                "Battery info",
                "Show you all info about",
                false
            )
        )
    }
}
