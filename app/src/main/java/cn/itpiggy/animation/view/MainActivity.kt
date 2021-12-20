package cn.itpiggy.animation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.itpiggy.animation.R
import cn.itpiggy.animation.activityscenetransitionbasic.GridAdapter
import cn.itpiggy.animation.adapters.MainAdapter
import cn.itpiggy.animation.data.Item
import cn.itpiggy.animation.viewmodels.GridViewModel
import cn.itpiggy.animation.databinding.ActivityMainBinding
import cn.itpiggy.animation.databinding.LayoutActivitySceneTransitionItemBinding
import cn.itpiggy.animation.viewmodels.ItemDetailModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bindingUtil: ActivityMainBinding

    private val dataset: Array<MainAdapter.Row> = arrayOf(
        MainAdapter.Row("Activity Transition", "Activity Transition", TransitionActivity::class.java),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    recyclerView.adapter = MainAdapter(dataset)

                }

    }

}
