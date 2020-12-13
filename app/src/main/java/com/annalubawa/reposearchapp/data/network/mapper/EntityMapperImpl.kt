package com.annalubawa.reposearchapp.data.network.mapper

import com.annalubawa.reposearchapp.data.network.model.ApiRepository
import com.annalubawa.reposearchapp.data.network.model.ApiRepositoryCommit
import com.annalubawa.reposearchapp.domain.model.Commit
import com.annalubawa.reposearchapp.domain.model.Repository
import com.annalubawa.reposearchapp.domain.model.RepositoryOwner
import javax.inject.Inject

class EntityMapperImpl @Inject constructor(): EntityMapper {

    override fun mapToRepositoryEntity(apiRepository: ApiRepository): Repository {
        val owner = RepositoryOwner(apiRepository.repositoryOwner.avatarUrl, apiRepository.repositoryOwner.login)
        return Repository(apiRepository.name, apiRepository.stargazersCount, apiRepository.htmlUrl, owner)
    }

    override fun mapToRepositoryEntityList(apiRepository: List<ApiRepository>): List<Repository> {
        return apiRepository.map {
            mapToRepositoryEntity(it)
        }
    }

    override fun mapToCommitEntity(apiRepositoryCommit: ApiRepositoryCommit): Commit {
        val message = apiRepositoryCommit.commit.message
        val committerName = apiRepositoryCommit.commit.committer.name
        val committerEmail = apiRepositoryCommit.commit.committer.email

        return Commit(committerName, committerEmail, message)
    }

    override fun mapToCommitEntityList(apiRepositoryCommit: List<ApiRepositoryCommit>): List<Commit> {
        return apiRepositoryCommit.map {
            mapToCommitEntity(it)
        }
    }

}