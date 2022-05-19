package br.ufpb.care.register

import UserKindAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpb.care.R
import br.ufpb.care.databinding.FragmentSelectUserKindBinding
import br.ufpb.care.register.model.UserKind
import br.ufpb.care.register.model.UserKindsImpl

class SelectUserKindFragment : Fragment() {

    private lateinit var binding: FragmentSelectUserKindBinding
    private val adapter = UserKindAdapter(::onCardClicked)
    private val viewModel: RegisterViewModel by navGraphViewModels(R.id.register_navigation)

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
        adapter.userKinds = UserKindsImpl.value

        setListeners()
    }

    private fun onCardClicked(kind: UserKind) {
        viewModel.selectUserKind(kind)
    }

    private fun setListeners() {
        binding.next.setOnClickListener {
            val action =
                SelectUserKindFragmentDirections.actionSelectUserKindFragmentToFormFragment()
            findNavController().navigate(action)
        }
    }
}