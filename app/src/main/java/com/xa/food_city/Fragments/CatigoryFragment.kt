package com.xa.food_city.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xa.food_city.R
import com.xa.food_city.UiAdapters.Mini_Cart_Adapter
import kotlinx.android.synthetic.main.fragment_catigory.*

class CatigoryFragment : Fragment() {


    private var layoutManager :RecyclerView.LayoutManager? = null
    private var adapter :RecyclerView.Adapter<Mini_Cart_Adapter.ViewHolder>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_catigory, container, false)


        val back_btn: ImageView = view.findViewById(R.id.back_btn)

        back_btn.setOnClickListener {
            val fragment = MainFragment()
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.frameLayout,fragment)?.commit()
        }

        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = GridLayoutManager(context,2)
        recycle_view_mini_card.setHasFixedSize(true)
        recycle_view_mini_card.layoutManager = layoutManager

        adapter = Mini_Cart_Adapter()
        recycle_view_mini_card.adapter = adapter

    }
}