package com.annalubawa.reposearchapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.annalubawa.reposearchapp.data.GithubRepoRepository
import com.annalubawa.reposearchapp.domain.model.Commit
import com.annalubawa.reposearchapp.domain.model.Repository
import kotlinx.coroutines.flow.collect

class RepositoryDetailsViewModel @ViewModelInject constructor(
    private val repository: GithubRepoRepository
): ViewModel() {

    lateinit var githubRepo: Repository

    val commits: LiveData<List<Commit>> = liveData {
        repository.getCommits(githubRepo.owner.name, githubRepo.name)
            .collect { emit(it) }
    }
}