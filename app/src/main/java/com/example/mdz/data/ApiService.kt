package com.example.mdz.data

import com.example.mdz.data.request.AuthRequest
import com.example.mdz.data.request.ShiftRequest
import com.example.mdz.data.responses.AuthResponse
import com.example.mdz.data.responses.GenericResponse
import com.example.mdz.data.responses.ServiceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("service")
    suspend fun getServices(): List<ServiceResponse>

    @POST("login/auth")
    suspend fun postAuth(@Body authRequest: AuthRequest): AuthResponse

    @POST("shift")
    suspend fun postShift(@Body shiftRequest: ShiftRequest): GenericResponse
}