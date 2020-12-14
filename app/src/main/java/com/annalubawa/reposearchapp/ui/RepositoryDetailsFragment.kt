package com.annalubawa.reposearchapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.annalubawa.reposearchapp.R
import com.annalubawa.reposearchapp.databinding.CommitListItemLayoutBinding
import com.annalubawa.reposearchapp.databinding.FragmentRepositoryDetailsBinding
import com.annalubawa.reposearchapp.domain.model.Commit
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repository_details.*


@AndroidEntryPoint
class RepositoryDetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var viewModel: RepositoryDetailsViewModel
    private lateinit var binding: FragmentRepositoryDetailsBinding

    private val args: RepositoryDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_repository_details,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.decorView.systemUiVisibility = 0

        navController = Navigation.findNavController(view)

        initViewModel()
        initObservers()
        initOnCLickListeners()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RepositoryDetailsViewModel::class.java)
        viewModel.githubRepo = args.repository
        binding.repo = viewModel.githubRepo
    }

    private fun initOnCLickListeners() {
        backTextView.setOnClickListener {
            navController.popBackStack()
        }

        backArrow.setOnClickListener {
            navController.popBackStack()
        }

        viewOnlineButton.setOnClickListener {
            val url = viewModel.githubRepo.repoUrl
            val viewOnlineIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            if (viewOnlineIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(viewOnlineIntent)
            }
        }

        shareButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_SUBJECT, viewModel.githubRepo.name);
            intent.putExtra(Intent.EXTRA_TEXT, viewModel.githubRepo.repoUrl)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Share repository to:"))
        }
    }

    private fun initObservers() {
        viewModel.commits.observe(viewLifecycleOwner, Observer {
            var position = 1
            for (commit in it) {
                addCommitToList(commitsLiinearLayout, commit, position)
                position++
            }
        })
    }

    private fun addCommitToList(layout: LinearLayout, commit: Commit, position: Int) {
        val inflater = LayoutInflater.from(layout.context)
        val binding: CommitListItemLayoutBinding = CommitListItemLayoutBinding.inflate(
            inflater,
            layout,
            true
        )

        binding.commitNumTextView.text = "$position"

        if(position == 3)
            binding.divider.visibility = View.INVISIBLE

        binding.commit = commit
    }

    companion object {
        @JvmStatic
        fun newInstance() = RepositoryDetailsFragment()
    }
}