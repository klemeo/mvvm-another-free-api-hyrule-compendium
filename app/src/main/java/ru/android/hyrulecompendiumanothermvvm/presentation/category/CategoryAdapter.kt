package ru.android.hyrulecompendiumanothermvvm.presentation.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.android.hyrulecompendiumanothermvvm.databinding.ItemImageBinding
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleData

private val ITEM_VIEW_TYPE_ITEM = 0

class CategoryAdapter(val clickListener: HyruleListener) : ListAdapter<DataItem,
        RecyclerView.ViewHolder>(HyruleDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<HyruleData>) {
        adapterScope.launch {
            val items = list.map { DataItem.HyruleItem(it) }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.HyruleItem
                holder.bind(clickListener, item.data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.HyruleItem -> ITEM_VIEW_TYPE_ITEM
            else -> throw ClassCastException("Unknown ItemViewType ${getItem(position)}")
        }
    }

    class ViewHolder private constructor(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: HyruleListener, item: HyruleData) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemImageBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class HyruleDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.dataHyrule == newItem.dataHyrule
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

class HyruleListener(val clickListener: (data: HyruleData) -> Unit) {
    fun onClick(data: HyruleData) = clickListener(data)
}

sealed class DataItem {
    data class HyruleItem(val data: HyruleData) : DataItem() {
        override val dataHyrule = data
    }

    abstract val dataHyrule: HyruleData
}