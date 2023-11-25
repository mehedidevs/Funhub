package com.creativeitinstitute.funhub

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.funhub.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var user = FirebaseAuth.getInstance().currentUser

        Log.d("TAG", "onCreateView: ${user?.email} ")

        if (user != null) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
           // findNavController().popBackStack()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        binding.loginBtn.setOnClickListener {

            var email = binding.editTextUserEmail.text.toString().trim()
            var password = binding.editTextPassword.text.toString().trim()

            userLogin(email, password)


        }


        binding.dontHaveAnAccount.setOnClickListener {


            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)


        }


    }

    private fun userLogin(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)


        }.addOnFailureListener {
            var alertDialog = AlertDialog.Builder(requireActivity()).setTitle("Error")
                .setMessage(it.message)

            alertDialog.create().show()

        }


    }


}