package com.annalubawa.reposearchapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiRepositoryCommit (
    @SerializedName("url")
    val url: String,

    @SerializedName("sha")
    val sha: String,

    @SerializedName("node_id")
    val nodeId: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("comments_url")
    val commentsUrl: String,

    @SerializedName("commit")
    val commit: ApiCommit,

    @SerializedName("author")
    val author: ApiAuthor,

    @SerializedName("committer")
    val committer: ApiCommitter,

    @SerializedName("parents")
    val parents: List<ApiParents>
)