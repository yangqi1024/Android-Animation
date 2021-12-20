package cn.itpiggy.animation.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.itpiggy.animation.databinding.LayoutRowBinding

class MainAdapter(
    private val dataset: Array<Row>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size

    class ViewHolder(
        private val binding: LayoutRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clickListener = View.OnClickListener { view ->
                binding.row?.let { row ->
                    view.context.startActivity(Intent(view.context, row.activity))
                }

            }
        }

        fun bind(item: Row) {
            with(binding) {
                row = item
                executePendingBindings()
            }
        }
    }


    data class Row(
        val title: String,
        val description: String,
        val activity: Class<*>
    ) {

    }
}