package com.example.testapp.ui.view.mainItem.model

import com.example.testapp.R

data class MainItemModel(
    val icon: Int,
    val title: String,
    val description: String,
    val titleAction: String
) {

    companion object {

        fun getScanItem() = MainItemModel(
            R.drawable.ic_smartphone,
            "Device Scan",
            "Show you all info about phone",
            "Scan"
        )

        fun getCheckItem() = MainItemModel(
            R.drawable.ic_virus,
            "Check for Viruses",
            "Show you all info about phone",
            "Check"
        )
    }

}
