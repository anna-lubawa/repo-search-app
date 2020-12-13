package com.annalubawa.reposearchapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.annalubawa.reposearchapp.R
import com.annalubawa.reposearchapp.domain.model.Repository
import com.annalubawa.reposearchapp.ui.adapters.RepositoriesRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repository_search.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RepositorySearchFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var viewModel: RepositorySearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_repository_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RepositorySearchViewModel::class.java)
        navController = Navigation.findNavController(view)

        repositoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        repositoriesRecyclerView.adapter = RepositoriesRecyclerViewAdapter(viewModel.repos, ::onItemSelected)

        initSearchView()
        initObservers()
    }

    private fun initSearchView() {
        val id = searchView.context.resources.getIdentifier("android:id/search_src_text", null, null)
        val textView = searchView.findViewById(id) as TextView
        textView.compoundDrawablePadding = 32
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search_icon, 0, 0, 0)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    onLoading()
                    viewModel.getRepositories(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
        })
    }

    private fun initObservers() {
        viewModel.repositories.observe(viewLifecycleOwner, Observer {
            progressBar.visibility = View.INVISIBLE

            viewModel.repos.clear()
            viewModel.repos.addAll(it)
            repositoriesRecyclerView.adapter!!.notifyDataSetChanged()

            if(it.isEmpty())
                noResultsTextView.visibility = View.VISIBLE
        })

    }

    private fun onItemSelected(item: Repository) {
        Toast.makeText(requireContext(), item.name, Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {
        noResultsTextView.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE
    }

    companion object {
        @JvmStatic
        fun newInstance() = RepositorySearchFragment()
    }
}