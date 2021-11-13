package com.alisamir.healthapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alisamir.healthapp.databinding.FragmentBMIBinding


class BMIFragment : Fragment() {

    lateinit var binding: FragmentBMIBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBMIBinding.inflate(inflater,container,false)
        return binding.root
    }


}