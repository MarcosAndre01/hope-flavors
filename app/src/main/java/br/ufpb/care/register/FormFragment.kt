package br.ufpb.care.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import br.ufpb.care.R
import br.ufpb.care.core.users.data.remote.UsersFakeDataSource
import br.ufpb.care.core.users.data.remote.repository.UsersRepository
import br.ufpb.care.databinding.FragmentFormRegisterBinding
import br.ufpb.care.register.formregister.FormRegisterViewModelFactory
import br.ufpb.care.register.formregister.FormRegisterViewModelImp

class FormFragment : Fragment() {

    private var _binding: FragmentFormRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FormRegisterViewModelImp by viewModels {
        FormRegisterViewModelFactory(UsersRepository(UsersFakeDataSource()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.next.setOnClickListener {
            if (binding.editTextTextPassword.text.toString() != binding.editTextTextPassword2.text.toString()
            ) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.senhas_nao_sao_iguais),
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }


        }
    }

}