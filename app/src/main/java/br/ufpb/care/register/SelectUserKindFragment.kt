package br.ufpb.care.register

import UserKindAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavAction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpb.care.R
import br.ufpb.care.databinding.FragmentSelectUserKindBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SelectUserKindFragment : Fragment() {

    private lateinit var binding: FragmentSelectUserKindBinding
    private val adapter = UserKindAdapter()
    private val viewModel by viewModels<RegisterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectUserKindBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.userKinds = viewModel.userKinds
        setListeners()
    }

    private fun setListeners() {
        binding.next.setOnClickListener {
            findNavController().navigate(NavAction(R.id.action_selectUserKindFragment_to_formRegisterFragment).destinationId)
        }
    }
}