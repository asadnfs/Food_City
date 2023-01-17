//package com.xa.food_city.Private
//
//import android.app.Fragment
//import android.media.Image
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.airbnb.lottie.utils.Utils
//import com.xa.food_city.Fragments.MainFragment
//import com.xa.food_city.R
//import kotlinx.android.synthetic.main.fragment_private.*
//import kotlinx.android.synthetic.main.horizontal_card_adapter.*
//import kotlinx.android.synthetic.main.item_pager.*
//
//class Private_page_products :AppCompatActivity() {
//
//    private var math:Int = 0
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_private)
//
//
//
//
//        rate_bar.rating = 2.5f
//        rate_bar.stepSize = .5f
////
////
////
//        val image : ImageView = findViewById(R.id.image_iv)
//        val name : TextView = findViewById(R.id.praduct_name)
//        val consts : TextView = findViewById(R.id.costs_text)
//
//
////        // get data  N1  start.          for fragment            -------------------->
//////        val args = this.baseContext
//////
//////        val inputData = args?.getDatabasePath("data")
//////        name.text = inputData.toString()
//////
//////        val inputCosts = args?.getDatabasePath("costs")
//////        consts.text = inputCosts.toString()
//////
//////        val inputimg = args?.getDrawable(R.drawable.banan2)
//////        image.setImageResource(inputimg!!.alpha)
//
////        //get data    end.
//
////        //alternative way.  N2  start.       for aktivity       -----------
//
//        val name_i = intent.getStringExtra("data")
//        val costs_i = intent.getStringExtra("costs")
//        val image_i = intent.getIntExtra("img",0)
//
//
//        name.text = name_i
//        consts.text = costs_i
//        image.setImageResource(image_i.toInt())
//
//        //get data    N2   end.
//
////                                                  -------------------------------------->
////
////        val last_btn : Button =findViewById(R.id.prev_btn)
////        val image_btn = findViewById<ImageView>(R.id.back_btn)
//////
////        image_btn.setOnClickListener {
////            val Myfragment = MainFragment()
////            val fragment : androidx.fragment.app.Fragment? =
////            supportFragmentManager.findFragmentByTag(MainFragment::class.java.simpleName)
////            if (fragment !is MainFragment ){
////                supportFragmentManager.beginTransaction()
////                    .add(R.id.frameLayout,Myfragment,MainFragment::class.java.simpleName)
////                    .commit()
////        }
////
////        last_btn.setOnClickListener {
////        }
//
//        val Plus: ImageView = findViewById(R.id.plus)
//        val Minus: ImageView = findViewById(R.id.minus)
//        val Zero: TextView =findViewById(R.id.zero)
//
//
//        Plus.setOnClickListener {
//            while (math<21){
//                math++
//                Zero.text = math.toString()
//                break
//            }
//
//
//
//        }
//        Minus.setOnClickListener {
//            while (math>0){
//                math--
//                Zero.text = math.toString()
//                break
//            }
//        }
//
//
//
//    }
////    public fun like_favorite_btn_off(view: View) {
////    }
////    public fun like_favorite_btn_on(view: View) {
////    }
////    public fun gott_cart_n1(view: View) {
////    }
//
//}