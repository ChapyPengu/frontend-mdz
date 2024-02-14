package com.example.mdz.ui.turn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mdz.databinding.FragmentTurnBinding
import com.example.mdz.ui.home.HomeFragment
import com.example.mdz.ui.turn.availableTurns.AvailableTurnsActivity
import com.example.mdz.ui.turn.serviceAdapter.ServiceAdapter
import com.example.mdz.ui.turn.serviceAdapter.Service

class TurnFragment : Fragment() {

    private var _binding: FragmentTurnBinding? = null
    private val binding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter
    private var currentService = ""
    private var listService = listOf(
        Service("corte", "3000", "30min"),
        Service("trenzas", "5000", "60min"),
        Service("barba", "1500", "20min"),
        Service("colorado", "20000", "90min")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTurnBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initUI() {
        serviceAdapter = ServiceAdapter(listService) {
            changeCurrentService(it)
            navigationToAvailableTurnsActivity()
        }
        binding.rv.layoutManager = LinearLayoutManager(binding.rv.context)
        binding.rv.adapter = serviceAdapter
    }

    private fun navigationToAvailableTurnsActivity() {
        findNavController().navigate(
            TurnFragmentDirections.actionTurnFragmentToAvailableTurnsActivity2(currentService)
        )
    }

    private fun changeCurrentService(service: String) {
        currentService = service
    }
}