package com.xa.food_city.Private

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.xa.food_city.Firebase.HorizontalDataUser
import com.xa.food_city.Fragments.MainFragment
import com.xa.food_city.R
import com.xa.food_city.Util.loadImage


class Private_product : Fragment() {

    private var math: Int = 0
    lateinit var ref: DatabaseReference
    lateinit var userList: ArrayList<HorizontalDataUser>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_praduct_page, container, false)


        val rate_bar: RatingBar = view.findViewById(R.id.rate_bar)

        rate_bar.rating = 2.5f
        rate_bar.stepSize = 1f


        val imageView: ImageView = view.findViewById(R.id.image_iv)
        val name: TextView = view.findViewById(R.id.praduct_name)
        val consts: TextView = view.findViewById(R.id.costs_text)
        val cost2: TextView = view.findViewById(R.id.costs_text2)
        val info_text: TextView = view.findViewById(R.id.info_text)
        val product_type_: TextView = view.findViewById(R.id.type_of_product)



        //get extra from MainFragment
        val args = this.arguments

        //maxsulot nomi
        val inputData = args?.get("praduct_name")
        name.text = inputData.toString()

        //maxsulot narxi
        val inputCosts = args?.get("costs")
        consts.text = inputCosts.toString()

        //mahsulot turi
        val praduct_type = args?.get("cost_type")
        cost2.text = praduct_type.toString()

        //pul turi ,birligi
        val praduct_type2 = args?.get("praduct_type")
        product_type_.text = praduct_type2.toString()

        //info
        val info = args?.get("info")
        info_text.text = info.toString()


        //mahsulot rasmi
        val get_Img = args?.getString("image_view")
        imageView.loadImage(get_Img)





        val btn_back: ImageView = view.findViewById(R.id.back_btn)
        val last_btn: Button = view.findViewById(R.id.prev_btn)

        btn_back.setOnClickListener {
            val fragment = MainFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)?.commit()
        }
        last_btn.setOnClickListener {

        }

        val Plus: ImageView = view.findViewById(R.id.plus)
        val Minus: ImageView = view.findViewById(R.id.minus)
        val Zero: TextView = view.findViewById(R.id.zero_)


        Plus.setOnClickListener {
            while (math < 21) {
                math++
                Zero.text = math.toString()
                break
            }


        }
        Minus.setOnClickListener {
            while (math > 0) {
                math--
                Zero.text = math.toString()
                break
            }
        }


        return view
    }

    private fun readData() {
//        ref = FirebaseDatabase.getInstance().getReference("Users")
//        ref.child("Users").get().addOnSuccessListener {
//            if (it.exists()){
//                val product_name = it.child("name").value
//                val product_cost_type = it.child("product_type").value
//                val cost_number = it.child("vally").value
//                val product_type = it.child("vally_type").value
//                //add to text , onfinishd...
//            }else{
//                Toast.makeText(context,"else",Toast.LENGTH_SHORT).show()
//            }
//        }.addOnFailureListener {
//            Toast.makeText(context,"Faild lissener",Toast.LENGTH_SHORT).show()
//
//        }
    }


}