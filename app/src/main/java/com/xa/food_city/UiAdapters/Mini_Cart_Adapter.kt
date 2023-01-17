package com.xa.food_city.UiAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xa.food_city.R

class Mini_Cart_Adapter : RecyclerView.Adapter<Mini_Cart_Adapter.ViewHolder>() {


    private val name_item = arrayOf(
        "Mevalar",
        "Sabzavotlar",
        "Non maxsulotlari",
        "Bolka non maxsulotlari",
        "Quruq mevalar",
        "Gosht maxsulotlari",
        "Sut maxsulotlari",
        "Don maxsulotlari",
        "Tort maxsulotlari",
        "Tayor maxsulotlari",
        "Mevalar",

        )
    private val tip_item = arrayOf(
        "23 xil",
        "13 xil",
        "6 xil",
        "4 xil",
        "24 xil",
        "7 xil",
        "11 xil",
        "18 xil",
        "23 xil",
        "32 xil",
        "23 xil",

        )
    private val itemImage = intArrayOf(
        R.drawable.limon,
        R.drawable.gul_karam,
        R.drawable.non,
        R.drawable.non_2,
        R.drawable.donak,
        R.drawable.gosht,
        R.drawable.sut,
        R.drawable.donak,
        R.drawable.tort2,
        R.drawable.gosht,
        R.drawable.limon,

        )
    private val item_circle = intArrayOf(
        R.drawable.yellow_circle,
        R.drawable.green,
        R.drawable.yellow2,
        R.drawable.grey,
        R.drawable.grey,
        R.drawable.red,
        R.drawable.blue,
        R.drawable.green,
        R.drawable.green,
        R.drawable.red,
        R.drawable.yellow_circle,



        )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var circle: ImageView
        var textName: TextView
        var textNumber: TextView

        init {
            image = itemView.findViewById(R.id.image_item)
            circle = itemView.findViewById(R.id.circle_color)
            textName = itemView.findViewById(R.id.Ename_item)
            textNumber = itemView.findViewById(R.id.Enumber_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.mini_cart_adapter, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textName.text = name_item[position]
        holder.textNumber.text = tip_item[position]
        holder.circle.setImageResource(item_circle[position])
        holder.image.setImageResource(itemImage[position])

    }

    override fun getItemCount(): Int {
        return name_item.size
    }


}