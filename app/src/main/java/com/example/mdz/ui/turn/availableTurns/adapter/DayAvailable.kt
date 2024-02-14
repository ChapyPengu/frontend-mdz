package com.example.mdz.ui.turn.availableTurns.adapter

data class DayAvailable(
    val dayWeek: String,
    val dayMonth: String,
    val scheduleAvailable: List<ScheduleAvailable>
)
