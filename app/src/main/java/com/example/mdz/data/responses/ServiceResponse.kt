package com.example.mdz.data.responses

import com.google.gson.annotations.SerializedName

data class ServiceResponse(
    @SerializedName("name") val name: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("price") val price: String
)
