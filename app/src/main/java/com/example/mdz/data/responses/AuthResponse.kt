package com.example.mdz.data.responses

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("message") val message: String
)
