package com.xa.food_city.UiAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.xa.food_city.R

class Pager_cart_Adapter (var context: Context) :RecyclerView.Adapter<Pager_cart_Adapter.MyViewHolder>(){

     var color = arrayOf<IntArray>(
         intArrayOf (R.drawable.baner, R.string.n1),
         intArrayOf( R.drawable.baner, R.string.n2),
         intArrayOf( R.drawable.baner, R.string.n3,),
         intArrayOf( R.drawable.baner, R.string.n4,),
     )
    val array = arrayOf(
        "Bahor uchun bizda foydali mahsulotlar. ",
        "Bahor uchun bizda foydali mahsulotlar 2. ",
        "Bahor uchun bizda foydali mahsulotlar 3. ",
        "Bahor uchun bizda foydali mahsulotlar 4. ",
    )



    class MyViewHolder( itemview :View) :RecyclerView.ViewHolder(itemview){
        lateinit var img_view :TextView
        lateinit var container: LinearLayout

        init {

            img_view = itemview.findViewById(R.id.img) as TextView
            container = itemview.findViewById(R.id.concr) as LinearLayout

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pager,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.img_view.setImageResource(color[position][1]) //because 1 is icon column
        holder.container.setBackgroundResource(color[position][0]) //because 0 is color column
        holder.img_view.text = array[position]


    }

    override fun getItemCount(): Int {
        return color.size
    }


}