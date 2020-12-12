package com.annalubawa.reposearchapp.data.network.mapper

import com.annalubawa.reposearchapp.data.network.model.ApiRepository
import com.annalubawa.reposearchapp.domain.model.Repository

interface EntityMapper {
    fun mapApiRepositoryToRepositoryEntity(apiRepository: ApiRepository): Repository
}