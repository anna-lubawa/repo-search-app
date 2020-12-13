package com.annalubawa.reposearchapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiParents (
    @SerializedName("url")
    val url : String,

    @SerializedName("sha")
    val sha : String
)