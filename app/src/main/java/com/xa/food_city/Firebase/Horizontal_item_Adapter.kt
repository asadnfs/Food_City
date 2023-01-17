//package com.xa.food_city.Firebase
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.google.firebase.database.DatabaseReference
//import com.xa.food_city.Fragments.MainFragment
//import com.xa.food_city.R
//
//class Horizontal_item_Adapter(
//    val listener :MainFragment,
//    private val userList: ArrayList<HorizontalDataUser>,
//) : RecyclerView.Adapter<Horizontal_item_Adapter.ViewHolder>() {
//
//    lateinit var ref :DatabaseReference
//
//    interface MyOnClickListener{
//
//        fun OnClick(position: Int){
//
//        }
//    }
//
//    inner class ViewHolder (itemVIew: View):RecyclerView.ViewHolder(itemVIew){
//
//        val product_name :TextView = itemVIew.findViewById(R.id.name_item_)
//        val product_vally :TextView = itemVIew.findViewById(R.id.value_item_)
//        val imageItem :ImageView = itemVIew.findViewById(R.id.image_item_adapter)
//        init {
//
//            itemView.setOnClickListener {
//                val position = adapterPosition
//                listener.OnClick(position)
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_card_adapter,parent,false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val current = userList[position]
//        Glide.with(this@Horizontal_item_Adapter.listener).load(userList[position].image).into(holder.imageItem)
//        holder.product_name.text = current.name
//        holder.product_vally.text = current.vally
//    }
//
//    override fun getItemCount(): Int {
//       return userList.size
//    }
//
//
//}