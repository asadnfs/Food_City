package com.xa.food_city.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.xa.food_city.Private.Acount_Fragment
import com.xa.food_city.Private.Seller_AccountFragment
import com.xa.food_city.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)


        val login_person_seller_btn = view.findViewById<Button>(R.id.login_person_seller_btn)
        val login_person_btn = view.findViewById<Button>(R.id.login_person_btn)

        login_person_btn.setOnClickListener {
            val fragment = Acount_Fragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }
        login_person_seller_btn.setOnClickListener {
            val fragment = Seller_AccountFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()

        }


        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}