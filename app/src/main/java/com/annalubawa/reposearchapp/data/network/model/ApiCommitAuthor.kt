package com.annalubawa.reposearchapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiCommitAuthor(
    @SerializedName("name")
    val name : String,

    @SerializedName("email")
    val email : String,

    @SerializedName("date")
    val date : String
)