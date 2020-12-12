package com.annalubawa.reposearchapp.domain.model

data class Repository(
    val name: String,
    val numberOfStars: Int,
    val repoUrl: String,
    val owner: RepositoryOwner
)