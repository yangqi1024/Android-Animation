package cn.itpiggy.animation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.itpiggy.animation.R

class MotionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getIntExtra("layout_file_id", R.layout.activity_motion).apply {
            DataBindingUtil.setContentView<ViewDataBinding>(this@MotionActivity, this)
        }
    }
}