package com.example.assessment2mobileappdev.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2mobileappdev.R
import com.example.assessment2mobileappdev.data.model.Entity

class DashboardAdapter(
    private val onItemClick: (Entity) -> Unit
) : ListAdapter<Entity, DashboardAdapter.ViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Entity>() {
            override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                // If the API doesn’t give IDs, use a stable combination
                return oldItem.itemName == newItem.itemName &&
                        oldItem.designer == newItem.designer &&
                        oldItem.yearIntroduced == newItem.yearIntroduced
            }

            override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.itemNameText)
        private val designer: TextView = itemView.findViewById(R.id.designerText)

        fun bind(entity: Entity) {
            name.text = entity.itemName?.ifBlank { "(Unnamed)" } ?: "(Unnamed)"
            designer.text = entity.designer?.ifBlank { "(Unknown)" } ?: "(Unknown)"
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
