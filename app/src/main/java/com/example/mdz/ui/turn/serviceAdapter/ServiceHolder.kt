package com.example.mdz.ui.turn.serviceAdapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mdz.databinding.ItemServiceBinding

class ServiceHolder(view: View): ViewHolder(view) {

    private val binding = ItemServiceBinding.bind(view)

    fun render(service: Service, onItemSelected: (String) -> Unit) {
        binding.tvName.text = service.name.capitalize()
        binding.tvDuration.text = service.duration
        binding.tvPrice.text = service.price
        itemView.setOnClickListener {
            onItemSelected("${service.name} ${service.price} ${service.duration}")
        }
    }
}