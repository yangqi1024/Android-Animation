package cn.itpiggy.animation.view

import android.os.Bundle
import android.transition.Transition
import android.transition.Transition.TransitionListener
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import cn.itpiggy.animation.R
import cn.itpiggy.animation.data.Item
import cn.itpiggy.animation.databinding.ActivityDetailBinding
import cn.itpiggy.animation.viewmodels.ItemDetailModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val itemDetailModel: ItemDetailModel by viewModels()
    private lateinit var mItem: Item
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
                .apply {
                    viewModel = itemDetailModel
                    lifecycleOwner = this@DetailActivity
                }
        ViewCompat.setTransitionName(binding.ivItem, HEADER_IMAGE)
        ViewCompat.setTransitionName(binding.tvName, HEADER_TITLE)

        itemDetailModel.item.observe(this) { item ->
            mItem = item
            binding.tvName.text = getString(R.string.image_header, item.name, item.author)
            itemDetailModel.setImageUrl(item.thumbnailUrl)
            addTransitionListener()
        }
    }

    private fun addTransitionListener() {
        val sharedElementEnterTransition = window.sharedElementEnterTransition

        with(sharedElementEnterTransition) {
            addListener(object : TransitionListener {
                override fun onTransitionStart(transition: Transition?) {

                }

                override fun onTransitionEnd(transition: Transition?) {
                    itemDetailModel.setImageUrl(mItem.photoUrl)
                    sharedElementEnterTransition.removeListener(this)
                }

                override fun onTransitionCancel(transition: Transition?) {
                    sharedElementEnterTransition.removeListener(this)
                }

                override fun onTransitionPause(transition: Transition?) {
                }

                override fun onTransitionResume(transition: Transition?) {
                }
            })
        }
    }

    companion object {
        const val HEADER_IMAGE = "detail:header:image";
        const val HEADER_TITLE = "detail:header:title";
    }
}