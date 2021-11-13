package com.alisamir.healthapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alisamir.healthapp.databinding.FragmentBMIBinding
import java.text.DecimalFormat


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mysharedpreference = context?.getSharedPreferences("health", Context.MODE_PRIVATE)
        binding.BMITV.text = mysharedpreference?.getString("bmi","")
        binding.stateTV.text = mysharedpreference?.getString("state","")
        binding.weithtET.setText(mysharedpreference?.getString("weight",""))
        binding.heightET.setText(mysharedpreference?.getString("height",""))
        binding.calcBtn.setOnClickListener {
            if (binding.weithtET.text!!.isEmpty()){
                binding.weithtET.setError("Enter Weight")
                binding.weithtET.requestFocus()
            }else if(binding.heightET.text!!.isEmpty()){
                binding.heightET.setError("Enter Height")
                binding.heightET.requestFocus()
            }else{
                mysharedpreference?.edit()?.putString("weight",binding.weithtET.text.toString())?.apply()
                mysharedpreference?.edit()?.putString("height",binding.heightET.text.toString())?.apply()
                var state:String = ""
                val height = binding.heightET.text.toString().toDouble()
                val weight = binding.weithtET.text.toString().toDouble()
                val tempbmi = (weight / height / height) * 10000
                val bmi = DecimalFormat("##.#").format(tempbmi).toDouble()
                Toast.makeText(context,"$bmi",Toast.LENGTH_SHORT).show()
                if(bmi<=18.4){
                    state = "Underweight, Malnutrition risk"
                    Toast.makeText(context,"under",Toast.LENGTH_SHORT).show()
                }else if(bmi>=18.5 && bmi<=24.9){
                    state = "Normal weight"
                    Toast.makeText(context,"normal",Toast.LENGTH_SHORT).show()
                }else if(bmi>=25 && bmi<=29.9){
                    state = "Overweight, Enchanced risk"
                    Toast.makeText(context,"over",Toast.LENGTH_SHORT).show()
                }else if(bmi>=30){
                    state = "Obese, high risk"
                    Toast.makeText(context,"obese",Toast.LENGTH_SHORT).show()
                }
                binding.BMITV.text = bmi.toString()
                binding.stateTV.text = state
                mysharedpreference?.edit()?.putString("bmi",bmi.toString())?.apply()
                mysharedpreference?.edit()?.putString("state",state)?.apply()
            }
        }
    }


}