package com.annalubawa.reposearchapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiVerification (
    @SerializedName("verified")
    val verified : Boolean,

    @SerializedName("reason")
    val reason : String,

    @SerializedName("signature")
    val signature : String,

    @SerializedName("payload")
    val payload : String
)