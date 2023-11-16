package com.creativeitinstitute.funhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.funhub.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding> (FragmentLoginBinding::inflate){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dontHaveAnAccount.setOnClickListener {


            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)


        }




    }





}