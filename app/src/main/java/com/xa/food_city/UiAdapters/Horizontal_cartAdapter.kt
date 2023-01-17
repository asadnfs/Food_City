package com.xa.food_city.UiAdapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.xa.food_city.Firebase.HorizontalDataUser
import com.xa.food_city.Fragments.BascetFragment
import com.xa.food_city.Fragments.MainFragment
import com.xa.food_city.Private.Private_product
import com.xa.food_city.R
import com.xa.food_city.Util.loadImage

class Horizontal_cartAdapter(
    var listener: MainFragment,
    private var mContext: Context,
    private val userList: ArrayList<HorizontalDataUser>
) :
    RecyclerView.Adapter<Horizontal_cartAdapter.ViewHolder>() {

    interface MyOnClickListener {

        fun OnClick(position: Int) {


        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var products: TextView
        var productsName: TextView
        var cost: TextView
        var currency_: TextView


        init {
            imageView = itemView.findViewById(R.id.image_view)
            products = itemView.findViewById(R.id.product_type)
            productsName = itemView.findViewById(R.id.name_item_)
            cost = itemView.findViewById(R.id.cost)
            currency_ = itemView.findViewById(R.id.currency)


            itemView.setOnClickListener {
                val position = adapterPosition
                listener.OnClick(position)
            }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_card_adapter, parent, false)


        val Plus = v.findViewById(R.id.plus) as ImageView
        val Minus = v.findViewById(R.id.minus) as ImageView
        val Zero = v.findViewById(R.id.zero_) as TextView
        //
        //
        //toggleButton                             clicked
        val like_btn_: ToggleButton = v.findViewById(R.id.like_btn)
        like_btn_.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(mContext, "is cheked", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(mContext, "removed", Toast.LENGTH_SHORT).show()
            }
        }

        val backetbtn = v.findViewById<ImageView>(R.id.backet_btn)
        backetbtn.setOnClickListener {
            //
        }

        var math = 0

        Plus.setOnClickListener {
            while (math < 11) {
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





        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = userList[position]

        holder.productsName.text = current.name
        holder.products.text = current.product_type
        holder.currency_.text = current.vally_type
        holder.cost.text = current.cost
        holder.imageView.loadImage(current.image)


//        Glide.with(this@Horizontal_cartAdapter.listener).load(current.image).into(holder.image)


    }

    override fun getItemCount(): Int {
        return userList.size
    }


}