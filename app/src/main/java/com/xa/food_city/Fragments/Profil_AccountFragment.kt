package com.xa.food_city.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.xa.food_city.R

class Profil_AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_profil__account, container, false)

        val btn_back :ImageView=view.findViewById(R.id.back_btn_profile)
        btn_back.setOnClickListener {
            val fragment = MainFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }

        return view


    }


}