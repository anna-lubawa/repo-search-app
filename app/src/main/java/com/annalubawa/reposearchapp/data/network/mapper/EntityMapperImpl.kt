package com.annalubawa.reposearchapp.data.network.mapper

import com.annalubawa.reposearchapp.data.network.model.ApiRepository
import com.annalubawa.reposearchapp.domain.model.Repository
import com.annalubawa.reposearchapp.domain.model.RepositoryOwner

class EntityMapperImpl: EntityMapper {
    override fun mapApiRepositoryToRepositoryEntity(apiRepository: ApiRepository): Repository {
        val owner = RepositoryOwner(apiRepository.repositoryOwner.avatarUrl, apiRepository.repositoryOwner.login)
        return Repository(apiRepository.name, apiRepository.score, apiRepository.htmlUrl, owner)
    }
}