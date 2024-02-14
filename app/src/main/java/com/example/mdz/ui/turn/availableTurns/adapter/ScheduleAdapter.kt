package com.example.mdz.ui.turn.availableTurns.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mdz.R

class ScheduleAdapter(private val listScheduleAvailable: List<ScheduleAvailable>, private val onItemSelected: (String) -> Unit, private val day: String): Adapter<ScheduleHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ScheduleHolder(layoutInflater.inflate(R.layout.itme_shchedule_available, parent, false))
    }

    override fun getItemCount(): Int = listScheduleAvailable.size

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        holder.render(listScheduleAvailable[position], onItemSelected, day)
    }
}