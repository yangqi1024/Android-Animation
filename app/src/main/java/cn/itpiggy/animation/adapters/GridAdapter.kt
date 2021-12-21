package cn.itpiggy.animation.activityscenetransitionbasic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.itpiggy.animation.R
import cn.itpiggy.animation.data.Item
import cn.itpiggy.animation.databinding.LayoutActivitySceneTransitionItemBinding
import cn.itpiggy.animation.ui.ItemClickListener

class GridAdapter(val itemClickListener: ItemClickListener) :
    ListAdapter<Item, GridAdapter.ViewHolder>(GridDiffCallback()) {

    class ViewHolder(
        private val itemClickListener: ItemClickListener,
        private val binding: LayoutActivitySceneTransitionItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.data?.let { data ->
                    itemClickListener.onClick(data, binding)
                }
            }
        }


        fun bind(item: Item) {
            with(binding) {
                data = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemClickListener,
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_activity_scene_transition_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class GridDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name.equals(newItem.name)
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}