package com.example.mdz.ui.turn.serviceAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mdz.R

class ServiceAdapter(private val services: List<Service>, private val onItemSelected: (String) -> Unit): Adapter<ServiceHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ServiceHolder(layoutInflater.inflate(R.layout.item_service, parent, false))
    }

    override fun getItemCount(): Int = services.size

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        holder.render(services[position], onItemSelected)
    }
}