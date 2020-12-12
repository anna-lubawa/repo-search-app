package com.annalubawa.reposearchapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.annalubawa.reposearchapp.data.GithubRepoRepository

class RepositorySearchViewModel @ViewModelInject constructor(
    private val repository: GithubRepoRepository
): ViewModel() {

}