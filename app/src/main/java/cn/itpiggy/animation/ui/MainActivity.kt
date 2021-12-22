package cn.itpiggy.animation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cn.itpiggy.animation.R
import cn.itpiggy.animation.adapters.MainAdapter
import cn.itpiggy.animation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bindingUtil: ActivityMainBinding

    private val dataset: Array<MainAdapter.Row> = arrayOf(
        MainAdapter.Row(
            "Activity Transition",
            "Activity Transition",
            TransitionActivity::class.java
        ),
        MainAdapter.Row(
            "复杂运动示例 (1/4)",
            "类似 CoordinatorLayout 的基本行为。 仅使用 MotionLayout 实现，使用移动指南。 请注意，视图未调整大小。 ",
            MotionActivity::class.java,
            R.layout.motion_complex_1
        ),
        MainAdapter.Row(
            "复杂运动示例 (2/4)",
            "类似 CoordinatorLayout 的高级行为（添加FAB）。 仅使用 MotionLayout 实现，使用移动指南。 请注意，视图未调整大小。 ",
            MotionActivity::class.java,
            R.layout.motion_complex_2
        ),

        MainAdapter.Row(
            "复杂运动示例 (3/4)",
            "类似 CoordinatorLayout 的高级行为（添加FAB。 仅使用 MotionLayout 实现，使用视图的直接调整大小。 ",
            MotionActivity::class.java,
            R.layout.motion_complex_3
        ),
        MainAdapter.Row(
            "复杂运动示例 (4/4)",
            "高级同步 reval 运动 + 助手（弹跳）。 仅使用 MotionLayout 实现。",
            MotionActivity::class.java,
            R.layout.motion_complex_4
        ),
        MainAdapter.Row(
            "YouTube 示例",
            "展示YouTube 过渡示例。",
            YouTubeActivity::class.java
        ),
        MainAdapter.Row(
            "MealMonkey Login 示例",
            "MealMonkey 登录页示例。",
            MealMonkeyActivity::class.java,
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    recyclerView.adapter = MainAdapter(dataset)
                    recyclerView.addItemDecoration(
                        DividerItemDecoration(
                            applicationContext,
                            LinearLayoutManager.VERTICAL
                        )
                    )
                }
    }

}
