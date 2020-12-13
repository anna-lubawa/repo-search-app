package com.annalubawa.reposearchapp.data

import com.annalubawa.reposearchapp.data.network.client.GithubRepoApiService
import com.annalubawa.reposearchapp.data.network.mapper.EntityMapper
import com.annalubawa.reposearchapp.domain.model.Commit
import com.annalubawa.reposearchapp.domain.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GithubRepoRepository @Inject constructor(
    private val apiService: GithubRepoApiService,
    private val mapper: EntityMapper
) {

    suspend fun getRepositories(query: String): Flow<List<Repository>> {
        return flow {
            val searchResult = apiService.getRepositories(query)
            val repos = mapper.mapToRepositoryEntityList(searchResult.items)
            emit(repos)
        }
        .catch { emit(emptyList()) }
        .flowOn(Dispatchers.IO)
    }

    suspend fun getCommits(owner: String, repoName: String): Flow<List<Commit>> {
        return flow {
            val commitsResult = apiService.getRepositoryCommits(owner, repoName)
            val commits = ArrayList<Commit>()

            commitsResult
                .sortedByDescending { it.commit.committer.date }
                .take(3)
                .map { mapper.mapToCommitEntity(it) }
                .toCollection(commits)

            emit(commits)
        }
        .catch { emit(ArrayList()) }
        .flowOn(Dispatchers.IO)
    }

}