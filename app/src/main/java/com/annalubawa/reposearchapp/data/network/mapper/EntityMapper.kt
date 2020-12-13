package com.annalubawa.reposearchapp.data.network.mapper

import com.annalubawa.reposearchapp.data.network.model.ApiRepository
import com.annalubawa.reposearchapp.data.network.model.ApiRepositoryCommit
import com.annalubawa.reposearchapp.domain.model.Commit
import com.annalubawa.reposearchapp.domain.model.Repository

interface EntityMapper {

    fun mapToRepositoryEntity(apiRepository: ApiRepository): Repository

    fun mapToRepositoryEntityList(apiRepository: List<ApiRepository>): List<Repository>

    fun mapToCommitEntity(apiRepositoryCommit: ApiRepositoryCommit): Commit

    fun mapToCommitEntityList(apiRepositoryCommit: List<ApiRepositoryCommit>): List<Commit>

}