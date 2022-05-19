package br.ufpb.care.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import br.ufpb.care.R
import br.ufpb.care.databinding.FragmentFormRegisterBinding
import br.ufpb.care.core.users.model.UserDetailsForm
import br.ufpb.care.extension.showMessage

class FormRegisterFragment : Fragment() {

    private var _binding: FragmentFormRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by navGraphViewModels(R.id.register_navigation)

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
            val userDetails = UserDetailsForm(
                addressZipcode = binding.editTextTextPostalAddress.text.toString(),
                cpf = binding.editTextCPF.text.toString(),
                age = binding.editTextAge.text.toString().toInt(),
                firstName = binding.editTextName.text.toString(),
                lastName = binding.editTextLastName.text.toString(),
                email = binding.editTextTextEmailAddress.text.toString(),
                password = binding.editTextTextPassword2.text.toString()
            )

            if (binding.editTextTextPassword.text.toString() != binding.editTextTextPassword2.text.toString()) {
                getString(R.string.senhas_nao_sao_iguais).showMessage(context)

                return@setOnClickListener
            }
            if (binding.editTextName.text.toString().isBlank() ||
                binding.editTextLastName.text.toString().isBlank() ||
                binding.editTextTextEmailAddress.text.toString().isBlank() ||
                binding.editTextAge.text.toString().isBlank() ||
                binding.editTextTextPassword.text.toString().isBlank() ||
                binding.editTextCPF.text.toString().isBlank() ||
                binding.editTextTextPostalAddress.text.toString().isBlank()
            ) {
                getString(R.string.preencha_todos_campos).showMessage(context)

                return@setOnClickListener
            }
            viewModel.submitUserDetails(userDetails)
        }
    }
    
}