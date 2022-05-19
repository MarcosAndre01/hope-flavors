package br.ufpb.care.register.formregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import br.ufpb.care.R
import br.ufpb.care.core.users.data.UsersRepository
import br.ufpb.care.core.users.data.remote.UsersFakeDataSource
import br.ufpb.care.core.users.model.User
import br.ufpb.care.databinding.FragmentFormRegisterBinding

class FormRegisterFragment : Fragment() {

    private var _binding: FragmentFormRegisterBinding? = null
    private val binding get() = _binding!!
    private val args: FormRegisterFragmentArgs by navArgs()
    private val viewModel: FormRegisterViewModelImp by viewModels{
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

    private fun setListeners(){
        binding.next.setOnClickListener {

            if (binding.editTextTextPassword.text == binding.editTextTextPassword2.text) {
                val user = User(
                    addressZipcode = binding.editTextTextPostalAddress.text.toString(),
                    cpf = binding.editTextCPF.text.toString(),
                    age = binding.editTextAge.text.toString().toInt(),
                    firstName = binding.editTextName.text.toString(),
                    lastName = binding.editTextLastName.text.toString(),
                    email = binding.editTextTextEmailAddress.text.toString(),
                    password = binding.editTextTextPassword2.text.toString(),
                    validateUser = null,
                    userType = args.type
                )

                viewModel.submitUserDetails(user)
            }else{
                Toast.makeText(requireContext(), getString(R.string.senhas_nao_sao_iguais),Toast.LENGTH_SHORT).show()
            }

        }
    }

}