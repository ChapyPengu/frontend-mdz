package com.example.mdz.ui.turn.availableTurns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mdz.context.ContextApp
import com.example.mdz.data.ApiClient
import com.example.mdz.data.request.ShiftRequest
import com.example.mdz.databinding.ActivityAvailableTurnsBinding
import com.example.mdz.ui.turn.availableTurns.adapter.DayAvailable
import com.example.mdz.ui.turn.availableTurns.adapter.DayAvailableAdapter
import com.example.mdz.ui.turn.availableTurns.adapter.ScheduleAvailable
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AvailableTurnsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAvailableTurnsBinding
    private lateinit var dayAvailableAdapter: DayAvailableAdapter
    private var currentDate = ""
    private var currentService = ""
    private var currentPrice = ""
    private var currentDuration = ""
    private var currentEmail = ""
    private val args: AvailableTurnsActivityArgs by navArgs()

    private val listSchedule = listOf(
        ScheduleAvailable("09:00", "12:00"),
        ScheduleAvailable("12:00", "15:00"),
        ScheduleAvailable("15:00", "17:00"),
        ScheduleAvailable("17:00", "19:00"),
        ScheduleAvailable("19:00", "21:00"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvailableTurnsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initAdapter()
    }

    private fun initAdapter() {
        dayAvailableAdapter = DayAvailableAdapter(getListOfDayAvailable()) {
            changeCurrentTurn(it)
        }
        binding.rvDayAvailable.layoutManager = LinearLayoutManager(this)
        binding.rvDayAvailable.adapter = dayAvailableAdapter
    }

    private fun getShiftRequest(): ShiftRequest {
        val serviceInfo = args.service.split(" ")
        currentService = serviceInfo[0]
        currentPrice = serviceInfo[1]
        currentDuration = serviceInfo[2]
        currentEmail = ContextApp.email
        return ShiftRequest(
            email = currentEmail,
            service = currentService,
            date = currentDate,
            price = currentPrice,
            duration = currentDuration
        )
    }
    private fun initListeners() {
        binding.fabSaveTurn.setOnClickListener {
            val shiftRequest = getShiftRequest()
            CoroutineScope(Dispatchers.IO).launch {
//                val response = ApiClient.apiService.postShift(shiftRequest)
//                withContext(Dispatchers.Main) {
//                    Snackbar.make(binding.fabSaveTurn, response.toString(), Snackbar.LENGTH_LONG).show()
//                }
            }

        }
    }
    private fun changeCurrentTurn(date: String) {
        currentDate = date
    }

    private fun getListOfDayAvailable(): List<DayAvailable> {
        val daysAvailable = mutableListOf<DayAvailable>()
        val dayWeek = getDayOfWeek()
        var dayMonth = getDayOfMonth().toInt()
        val days = getDaysOfWeek()
        var indexDayWeek = days.indexOf(dayWeek)
        for (i in (0..6)) {
            daysAvailable.add(
                DayAvailable(
                    dayWeek = days[indexDayWeek],
                    dayMonth = dayMonth.toString(),
                    scheduleAvailable = listSchedule
                )
            )
            indexDayWeek += 1
            dayMonth += 1
            if (indexDayWeek >= 7) {
                indexDayWeek -= 7
            }
            if (dayMonth >= 31) {
                dayMonth -= 30
            }
        }
        return daysAvailable
    }

    private fun getDayOfWeek(): String {
        val formatter = SimpleDateFormat("EEEE", Locale("es", "AR"))
        return formatter.format(Date()).toString()
    }

    private fun getDayOfMonth(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("es", "AR"))
        val currentdate = sdf.format(Date())
        val fechaactual = sdf.parse(currentdate)
        val res = fechaactual?.toString().orEmpty().split(" ")
        return if (res.size > 2) res[2] else "0"
    }

    private fun getDaysOfWeek(): List<String> {
        return listOf(
            "domingo",
            "lunes",
            "martes",
            "miercoles",
            "jueves",
            "viernes",
            "sabado"
        )
    }
}