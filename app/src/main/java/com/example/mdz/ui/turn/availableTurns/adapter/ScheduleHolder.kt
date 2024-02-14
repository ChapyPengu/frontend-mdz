package com.example.mdz.ui.turn.availableTurns.adapter

import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mdz.R
import com.example.mdz.databinding.ItmeShcheduleAvailableBinding

object ListCards {
    val listViews = mutableListOf<ScheduleHolder>()
}

class ScheduleHolder(view: View): ViewHolder(view) {

    private val binding = ItmeShcheduleAvailableBinding.bind(view)

    private var colorState = false

    fun render(scheduleAvailable: ScheduleAvailable, onItemSelected: (String) -> Unit, day: String) {
        binding.tvStart.text = scheduleAvailable.start
        binding.tvEnd.text = scheduleAvailable.end
        ListCards.listViews.add(this)
        itemView.setOnClickListener {
            resetColorCards()
            if (!colorState) {
                changeCardColorActive()
            } else {
                changeCardColorDeactivate()
            }
            colorState = !colorState
            onItemSelected("$day ${scheduleAvailable.start}-${scheduleAvailable.end}")
        }
    }

    private fun resetColorCards() {
        ListCards.listViews.forEach {
            deactivateColorCard(it.binding.cvScheduleAvailable)
            if (!(it == this)) {
                resetStateCalor(it)
            }
        }
    }

    private fun changeCardColorActive() {
        binding.cvScheduleAvailable.setCardBackgroundColor(itemView.context.getColor(R.color.crowdedGold))
    }

    private fun changeCardColorDeactivate() {
        binding.cvScheduleAvailable.setCardBackgroundColor(itemView.context.getColor(R.color.primary))
    }

    private fun deactivateColorCard(cardView: CardView) {
        cardView.setCardBackgroundColor(itemView.context.getColor(R.color.primary))
    }

    private fun resetStateCalor(scheduleAvailableHolder: ScheduleHolder) {
        scheduleAvailableHolder.colorState = false
    }
}