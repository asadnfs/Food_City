package com.xa.food_city.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.xa.food_city.Firebase.Horizontal_Fragment_item_page
import com.xa.food_city.R
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_favorite, container, false)



        val favorite = view.findViewById<Button>(R.id.favorit_btn)
        favorite.setOnClickListener {
            val fragment = Horizontal_Fragment_item_page()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }
        return view
    }


}