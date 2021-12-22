package cn.itpiggy.animation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.itpiggy.animation.R
import cn.itpiggy.animation.databinding.ActivityMealMonkeyBinding

class MealMonkeyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMealMonkeyBinding>(
            this,
            R.layout.activity_meal_monkey
        )
        Handler(Looper.myLooper()!!).postDelayed({
            binding.motionLayout.transitionToEnd()
        }, 300)
    }
}