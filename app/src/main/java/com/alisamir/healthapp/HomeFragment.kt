package com.alisamir.healthapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alisamir.healthapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mySharedPreferences = context?.getSharedPreferences("health",Context.MODE_PRIVATE)
        binding.nameET.setText( mySharedPreferences?.getString("name",""))
        binding.ageET.setText( mySharedPreferences?.getString("age",""))
        binding.subBtn.setOnClickListener {
            if(binding.nameET.text!!.isEmpty()){
                binding.nameET.setError("Enter name")
                binding.nameET.requestFocus()
            }else if(binding.ageET.text!!.isEmpty()){
                binding.ageET.setError("Enter age")
                binding.ageET.requestFocus()
            }else{
                mySharedPreferences?.edit()?.putString("name",binding.nameET.text.toString())?.apply()
                mySharedPreferences?.edit()?.putString("age",binding.ageET.text.toString())?.apply()
                val genKey = "gender"
                if (binding.maleBtn.isChecked)
                    mySharedPreferences?.edit()?.putString(genKey,"male")?.apply()
                else
                    mySharedPreferences?.edit()?.putString(genKey,"female")?.apply()
            }
        }
    }


}