package cn.itpiggy.animation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.itpiggy.animation.R
import cn.itpiggy.animation.adapters.YouTubeAdapter
import cn.itpiggy.animation.databinding.ActivityYouTubeBinding

class YouTubeActivity : AppCompatActivity() {
    private lateinit var bindingUtil: ActivityYouTubeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil =
            DataBindingUtil.setContentView<ActivityYouTubeBinding>(this, R.layout.activity_you_tube)
                .apply {
                    val adapter = YouTubeAdapter(20)
                    recyclerView.adapter = adapter
                }
    }
}