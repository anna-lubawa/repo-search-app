package com.annalubawa.reposearchapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiCommit (
    @SerializedName("url")
    val url : String,

    @SerializedName("author")
    val author : ApiCommitAuthor,

    @SerializedName("committer")
    val committer : ApiCommitCommitter,

    @SerializedName("message")
    val message : String,

    @SerializedName("tree")
    val tree : ApiTree,

    @SerializedName("comment_count")
    val commentCount : Int,

    @SerializedName("verification")
    val verification : ApiVerification
)