package cn.itpiggy.animation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.itpiggy.animation.databinding.LayoutLoadingCardBinding

class YouTubeAdapter(
    private val size: Int
) : RecyclerView.Adapter<YouTubeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutLoadingCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = size

    class ViewHolder(
        private val binding: LayoutLoadingCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    }

}