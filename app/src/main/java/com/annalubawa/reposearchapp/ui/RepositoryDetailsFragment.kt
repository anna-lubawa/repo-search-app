package com.annalubawa.reposearchapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.annalubawa.reposearchapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryDetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var viewModel: RepositoryDetailsViewModel

    private val args: RepositoryDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_repository_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RepositoryDetailsViewModel::class.java)
        navController = Navigation.findNavController(view)

        viewModel.githubRepo = args.repository

        initObservers()
    }

    private fun initObservers() {
        viewModel.commits.observe(viewLifecycleOwner, Observer {
            it.forEach { commit -> Log.d("COMMIT", commit.message) }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = RepositoryDetailsFragment()
    }
}