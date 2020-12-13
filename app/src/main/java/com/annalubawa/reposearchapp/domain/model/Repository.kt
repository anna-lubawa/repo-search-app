package com.annalubawa.reposearchapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val name: String,
    val numberOfStars: Int,
    val repoUrl: String,
    val owner: RepositoryOwner
): Parcelable