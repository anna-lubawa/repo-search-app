package com.annalubawa.reposearchapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.annalubawa.reposearchapp.data.GithubRepoRepository
import com.annalubawa.reposearchapp.domain.model.Repository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


@FlowPreview
@ExperimentalCoroutinesApi
class RepositorySearchViewModel @ViewModelInject constructor(
    private val repository: GithubRepoRepository
): ViewModel() {

    val repos = ArrayList<Repository>()

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories = _repositories

    fun getRepositories(query: String) {
        viewModelScope.launch {
            repository.getRepositories(query)
                .collect { items ->
                    _repositories.value = items
                }
        }
    }

}