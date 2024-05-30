package com.example.testapp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.window.layout.WindowMetricsCalculator
import com.example.testapp.R
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.ui.main.adapter.CategoriesAdapter
import com.example.testapp.ui.view.mainItem.model.MainItemModel
import com.example.testapp.utils.extension.visible
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    private val adapter = CategoriesAdapter {
        Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        observe()
        setListener()
        initView()
    }

    private fun initView() {
        with(binding) {
            miScan.setMainItem(MainItemModel.getScanItem())
            miCheck.setMainItem(MainItemModel.getCheckItem())

            BottomSheetBehavior.from(llBottomSheet).apply {
                peekHeight = setMaxHeight()
                state = BottomSheetBehavior.STATE_COLLAPSED
            }

            rvCategories.adapter = adapter

        }
    }

    private fun ActivityMainBinding.setMaxHeight(): Int {
        val windowMetrics =
            WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this@MainActivity)
        val currentBounds = windowMetrics.bounds
        val height = currentBounds.height()

        val viewHeight = (height * 0.8).toInt()

        val layoutParams = llBottomSheet.layoutParams
        layoutParams.height = viewHeight
        llBottomSheet.layoutParams = layoutParams

        return (height * 0.25).toInt()
    }

    private fun setListener() {
        with(binding) {
            vScanBackground.setOnClickListener {
                lottieAnimationView.apply {
                    playAnimation()
                    visible()
                }

                mainViewModel.generateNumbers()
            }
        }
    }

    private fun observe() {
        with(mainViewModel) {
            notifications.observe(this@MainActivity) { notifications ->
                notifications
                    ?.takeIf { it.isNotEmpty() }
                    ?.apply {
                        adapter.list.submitList(this)
                    }
                    ?: run {
                        Toast.makeText(this@MainActivity, "Is empty", Toast.LENGTH_LONG).show()
                    }
            }


            error.observe(this@MainActivity) { error ->
                error
                    ?.takeIf { it.isNotEmpty() }
                    ?.apply {
                        Toast.makeText(this@MainActivity, this, Toast.LENGTH_LONG).show()
                    }
            }

            uniqueNumbers.observe(this@MainActivity) { count ->
                count
                    ?.takeIf { it.isNotEmpty() }
                    ?.apply {
                        binding.tvAlert.visible()
                        binding.tvAlert.text =
                            getString(R.string.tv_count_problems, "${this@apply.size}")
                    }
            }
        }
    }
}