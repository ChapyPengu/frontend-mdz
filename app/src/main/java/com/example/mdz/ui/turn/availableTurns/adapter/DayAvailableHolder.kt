package com.example.mdz.ui.turn.availableTurns.adapter

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mdz.databinding.ItemDayAvailableBinding

class DayAvailableHolder(view: View): ViewHolder(view) {

    private val binding = ItemDayAvailableBinding.bind(view)

    fun render(dayAvailable: DayAvailable, onItemSelected: (String) -> Unit) {
        val day = "${dayAvailable.dayWeek} ${dayAvailable.dayMonth}".capitalize()
        val scheduleAvailableAdapter = ScheduleAdapter(dayAvailable.scheduleAvailable, onItemSelected, day)
        binding.rvAvailableTurnsOfDays.layoutManager = GridLayoutManager(itemView.context, 2)
        binding.rvAvailableTurnsOfDays.adapter = scheduleAvailableAdapter
        binding.day.text = "${dayAvailable.dayWeek} ${dayAvailable.dayMonth}".capitalize()
    }
}