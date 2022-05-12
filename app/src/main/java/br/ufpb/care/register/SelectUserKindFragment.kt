package br.ufpb.care.register

import UserKindAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpb.care.databinding.FragmentSelectUserKindBinding

class SelectUserKindFragment : Fragment() {

    private lateinit var binding: FragmentSelectUserKindBinding
    private val adapter = UserKindAdapter()

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
        adapter.userKinds = UserKindsImpl().value
    }
}