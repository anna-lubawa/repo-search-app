package com.annalubawa.reposearchapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryOwner(
    val avatarUrl: String,
    val name: String
): Parcelable