package com.example.mdz.ui.turn.availableTurns.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mdz.R

class DayAvailableAdapter(private val listDayAvailable: List<DayAvailable>, private val onItemSelected: (String) -> Unit): Adapter<DayAvailableHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayAvailableHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DayAvailableHolder(layoutInflater.inflate(R.layout.item_day_available, parent, false))
    }

    override fun getItemCount(): Int = listDayAvailable.size

    override fun onBindViewHolder(holder: DayAvailableHolder, position: Int) {
        holder.render(listDayAvailable[position], onItemSelected)
    }
}