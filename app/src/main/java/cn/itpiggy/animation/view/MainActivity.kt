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
import cn.itpiggy.animation.data.Item
import cn.itpiggy.animation.viewmodels.GridViewModel
import cn.itpiggy.animation.databinding.ActivityMainBinding
import cn.itpiggy.animation.databinding.LayoutActivitySceneTransitionItemBinding
import cn.itpiggy.animation.viewmodels.ItemDetailModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemClickListener {
    private val viewModel: GridViewModel by viewModels()
    private lateinit var bindingUtil: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    val gridAdapter = GridAdapter(this@MainActivity)
                    recyclerView.adapter = gridAdapter
                    subscribeUi(gridAdapter)
                }

    }

    private fun subscribeUi(gridAdapter: GridAdapter) {
        viewModel.items.observe(this) { items ->
            Log.d("subscribeUi", "items.size:" + items.size)
            gridAdapter.submitList(items)
        }
    }

    override fun onClick(item: Item, binding: ViewDataBinding) {
        item.itemId.let { itemId ->
            val layoutActivitySceneTransitionItemBinding =
                binding as LayoutActivitySceneTransitionItemBinding
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair.create(
                    layoutActivitySceneTransitionItemBinding.ivItem,
                    DetailActivity.HEADER_IMAGE
                ),
                Pair.create(
                    layoutActivitySceneTransitionItemBinding.tvName,
                    DetailActivity.HEADER_TITLE
                )
            )
            val intent = Intent(this, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putLong(ItemDetailModel.ITEM_ID_SAVED_STATE_KEY, itemId)
            intent.putExtras(bundle)
            ActivityCompat.startActivity(this, intent, activityOptions.toBundle())
        }
    }


}

interface ItemClickListener {
    fun onClick(item: Item, binding: ViewDataBinding);
}