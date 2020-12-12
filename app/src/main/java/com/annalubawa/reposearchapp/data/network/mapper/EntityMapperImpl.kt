package com.annalubawa.reposearchapp.data.network.mapper

import com.annalubawa.reposearchapp.data.network.model.ApiRepository
import com.annalubawa.reposearchapp.domain.model.Repository
import com.annalubawa.reposearchapp.domain.model.RepositoryOwner
import javax.inject.Inject

class EntityMapperImpl @Inject constructor(): EntityMapper {

    override fun mapApiRepositoryToRepositoryEntity(apiRepository: ApiRepository): Repository {
        val owner = RepositoryOwner(apiRepository.repositoryOwner.avatarUrl, apiRepository.repositoryOwner.login)
        return Repository(apiRepository.name, apiRepository.stargazersCount, apiRepository.htmlUrl, owner)
    }

    override fun mapApiRepositoryListToRepositoryEntityList(apiRepository: List<ApiRepository>): List<Repository> {
        return apiRepository.map {
            mapApiRepositoryToRepositoryEntity(it)
        }
    }

}