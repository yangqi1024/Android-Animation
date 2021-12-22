package cn.itpiggy.animation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import cn.itpiggy.animation.R
import cn.itpiggy.animation.adapters.ViewPagerAdapter
import cn.itpiggy.animation.databinding.ActivityViewPagerMotionBinding

class ViewPagerMotionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_motion)
        DataBindingUtil.setContentView<ActivityViewPagerMotionBinding>(
            this,
            R.layout.activity_view_pager_motion
        ).apply {
            val adapter = ViewPagerAdapter(supportFragmentManager)
            adapter.addPageFragment(PageFragment(), "热点")
            adapter.addPageFragment(PageFragment(), "推荐")
            adapter.addPageFragment(PageFragment(), "短视频")
            viewpager.adapter = adapter
            tabs.setupWithViewPager(viewpager)
            viewpager.addOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    Log.d(
                        "ViewPagerMotionActivity",
                        "position:$position,positionOffset:$positionOffset"
                    )
                    val progress = (position + positionOffset) / (adapter.count - 1)
                    flBg.progress = progress
                }

                override fun onPageSelected(position: Int) {
                }

                override fun onPageScrollStateChanged(state: Int) {
                }
            })
        }
    }
}

class PageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_page, container, false)
    }
}