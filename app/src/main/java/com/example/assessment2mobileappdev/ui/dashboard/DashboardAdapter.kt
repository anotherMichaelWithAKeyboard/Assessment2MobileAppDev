package com.example.assessment2mobileappdev.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2mobileappdev.R
import com.example.assessment2mobileappdev.data.model.Entity

class DashboardAdapter(
    private var items: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    fun updateData(newItems: List<Entity>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.itemNameText)
        private val designer: TextView = itemView.findViewById(R.id.designerText)

        fun bind(entity: Entity) {
            name.text = entity.itemName?.ifBlank { "(Unnamed)" }
            designer.text = entity.designer?.ifBlank { "(Unknown)" }
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dashboard_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}
