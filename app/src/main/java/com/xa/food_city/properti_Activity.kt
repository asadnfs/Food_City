package com.xa.food_city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.xa.food_city.Fragments.MainFragment
import com.xa.food_city.UiAdapters.Horizontal_cartAdapter

class properti_Activity : Fragment() ,Horizontal_cartAdapter.MyOnClickListener{

    private var layoutManager_: RecyclerView.LayoutManager? = null
    private var adapter_: RecyclerView.Adapter<Horizontal_cartAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_sort, container, false)

        val btn_back = view.findViewById<ImageView>(R.id.btn_back)
        btn_back.setOnClickListener {
            val fragment = MainFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }



        return view


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        layoutManager_ = GridLayoutManager(context,2)
//
//        product_recycle_view.layoutManager = layoutManager_
//
//        adapter_ = Horizontal_cartAdapter(context)
//        product_recycle_view.adapter = adapter_


    }

//    override fun OnClick(position: Int) {
//        super.OnClick(position)
//
//        val bundle = Bundle()
//        bundle.putString("data", praduct_name[position])
//        bundle.putString("costs", costs_text[position])
//        bundle.putInt("img", image_iv[position])
//
//        val fragment = Private_product()
//        val trans = fragmentManager?.beginTransaction()
//        fragment.arguments = bundle
//        trans?.replace(R.id.frameLayout, fragment)?.commit()
//    }


}


//
// : AppCompatActivity() {
//
//
//    private var layoutManager_p: RecyclerView.LayoutManager? = null
//    private var adapter_p: RecyclerView.Adapter<Horizontal_cartAdapter.ViewHolder>? = null
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_properti)
//
//        layoutManager_p = GridLayoutManager(this, 2)
//        product_recycle_view.layoutManager = layoutManager_p
//
//        adapter_p = Horizontal_cartAdapter(MainFragment())
//        product_recycle_view.adapter = adapter_p
//
//
//
//
//    }
//}
//




