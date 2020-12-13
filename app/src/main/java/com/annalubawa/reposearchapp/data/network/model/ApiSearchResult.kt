package com.annalubawa.reposearchapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiSearchResult (
    @SerializedName("total_count")
    val totalCount: Int,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,

    @SerializedName("items")
    val items: List<ApiRepository>
)