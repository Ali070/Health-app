package com.alisamir.healthapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alisamir.healthapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mysharedpreferences = context?.getSharedPreferences("health", Context.MODE_PRIVATE)
        binding.nameTV.text = mysharedpreferences?.getString("name","")
        binding.ageTv.text = mysharedpreferences?.getString("age","")
        binding.genderTv.text = mysharedpreferences?.getString("gender","")
        binding.weightTV.text = mysharedpreferences?.getString("weight","")
        binding.heightTV.text = mysharedpreferences?.getString("height","")
        binding.bmiTV.text = mysharedpreferences?.getString("bmi","")
    }


}