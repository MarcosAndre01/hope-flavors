package br.ufpb.care.login

import android.app.FragmentContainer
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.ufpb.care.R
import br.ufpb.care.databinding.FragmentSignInBinding

class SigninFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListiners()
    }

    private fun setListiners() {

        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(NavAction(R.id.action_signinFragment_to_selectUserKindFragment).destinationId)
        }
    }
}
