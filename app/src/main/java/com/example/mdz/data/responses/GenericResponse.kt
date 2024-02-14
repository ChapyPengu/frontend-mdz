package com.example.mdz.data.responses

import com.google.gson.annotations.SerializedName

data class GenericResponse (
    @SerializedName("message") val message: String
)