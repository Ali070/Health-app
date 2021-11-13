package com.alisamir.healthapp

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.alisamir.healthapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    lateinit var binding:FragmentSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val anim:Animation = AnimationUtils.loadAnimation(context,R.anim.splash_anim)

        anim.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                Handler().postDelayed({
                    findNavController().navigate(R.id.action_splashFragment_to_gettingStartedFragment)
                },3000)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
        binding.constraintLayout.startAnimation(anim)

    }


}