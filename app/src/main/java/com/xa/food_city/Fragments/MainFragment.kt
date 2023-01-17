package com.xa.food_city.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.*
import com.xa.food_city.Firebase.HorizontalDataUser
import com.xa.food_city.Private.Private_product
import com.xa.food_city.R
import com.xa.food_city.UiAdapters.Horizontal_cartAdapter
import com.xa.food_city.UiAdapters.Mini_Cart_Adapter
import com.xa.food_city.UiAdapters.Pager_cart_Adapter
import com.xa.food_city.properti_Activity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() ,Horizontal_cartAdapter.MyOnClickListener {

    lateinit var userList:ArrayList<HorizontalDataUser>
    lateinit var ref: DatabaseReference

    lateinit var ErecycleView2 :RecyclerView
    lateinit var ErecycleView3 :RecyclerView
    lateinit var ErecycleView4 :RecyclerView

    private var count: Int = 0

//adapter
    private var layoutManager1: RecyclerView.LayoutManager? = null
    private var adapter1: RecyclerView.Adapter<Mini_Cart_Adapter.ViewHolder>? = null


    private var layoutManager2: RecyclerView.LayoutManager? = null
    private var adapter2: RecyclerView.Adapter<Horizontal_cartAdapter.ViewHolder>? = null


    private var layoutManager3: RecyclerView.LayoutManager? = null
    private var adapter3: RecyclerView.Adapter<Horizontal_cartAdapter.ViewHolder>? = null


    private var layoutManager4: RecyclerView.LayoutManager? = null
    private var adapter4: RecyclerView.Adapter<Horizontal_cartAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        userList = arrayListOf()



//find
        val nextbtn: LinearLayout = view.findViewById(R.id.barchasi)
        val nextbtn2: LinearLayout = view.findViewById(R.id.barchasi2)
        val nextbtn3: LinearLayout = view.findViewById(R.id.barchasi3)
        val next_btn4: LinearLayout = view.findViewById(R.id.barchasi4)
        val next_btn5: LinearLayout = view.findViewById(R.id.barchasi5)
        val notify_btn:ImageView = view.findViewById(R.id.notify_image_btn)
        val profil_account:LinearLayout = view.findViewById(R.id.profil_account)
        val profil_account1:ImageView = view.findViewById(R.id.profil_account1)
        ErecycleView2 = view.findViewById(R.id.Erecycle_View2)
        ErecycleView3 = view.findViewById(R.id.Erecycle_View3)
        ErecycleView4 = view.findViewById(R.id.Erecycle_View4)

        nextbtn.setOnClickListener {
            val fragment = CatigoryFragment()
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.frameLayout,fragment)?.commit()
        }

        nextbtn2.setOnClickListener {
            //fragment ....
            val fragment = properti_Activity()
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.frameLayout,fragment)?.commit()

            //activity...
//            val intent = Intent(this@MainFragment.requireContext(),properti_Activity::class.java)
//            startActivity(intent)
        }
     //BUTToN
        nextbtn3.setOnClickListener {
            val fragment = CatigoryFragment()
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.frameLayout,fragment)?.commit()
        }
        next_btn5.setOnClickListener {
            val fragment = CatigoryFragment()
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.frameLayout,fragment)?.commit()
        }
        next_btn4.setOnClickListener {
            val fragment = CatigoryFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }
        notify_btn.setOnClickListener {
            val fragment = BascetFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }
        profil_account.setOnClickListener {
            val fragment = Profil_AccountFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }
        profil_account1.setOnClickListener {
            val fragment = Profil_AccountFragment()
            val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()
        }



        //view pager 2           starts
        val pager = view.findViewById<ViewPager2>(R.id.pager)
        val tabDots = view.findViewById<TabLayout>(R.id.tabDots)

        pager.adapter = context?.let { Pager_cart_Adapter(it) }
        TabLayoutMediator(tabDots,pager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->


        }).attach()
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                Snackbar.make(pager,"Page"+(position+1),Snackbar.LENGTH_SHORT).show()       //toast text maker
            }
        })


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//mini card adapter
        layoutManager1 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        Erecycle_View.setHasFixedSize(true)
        Erecycle_View.layoutManager = layoutManager1

        adapter1 = Mini_Cart_Adapter()
        Erecycle_View.adapter = adapter1


//horizontal card adapter 1
        layoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ErecycleView2.setHasFixedSize(true)
        ErecycleView2.layoutManager = layoutManager2
//
//        adapter2 = Horizontal_cartAdapter(this,userList)
//        Erecycle_View2.adapter = adapter2
        getUserData()

//
////horizontal card adapter 2
        layoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ErecycleView3.setHasFixedSize(true)
        ErecycleView3.layoutManager = layoutManager3
        getUserData3()
//        adapter3 = Horizontal_cartAdapter(this,userList)
//        Erecycle_View3.adapter = adapter3



        layoutManager4 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        ErecycleView4.setHasFixedSize(true)
        ErecycleView4.layoutManager = layoutManager4
        getUserData4()
//        adapter4 = Horizontal_cartAdapter(this,userList)
//        Erecycle_View4.adapter = adapter4
    }

    private fun getUserData() {
        ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                if (snapshot.exists()){
                    for(emp in snapshot.children){
                        val eData = emp.getValue(HorizontalDataUser::class.java)
                        userList.add(eData!!)
                    }
                    ErecycleView2.adapter = Horizontal_cartAdapter(this@MainFragment,context!!.applicationContext,userList,)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"onCancelled",Toast.LENGTH_SHORT).show()
            }

        })
    }

    //get userData 3
    private fun getUserData3() {
        ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                if (snapshot.exists()){
                    for(emp in snapshot.children){
                        val eData = emp.getValue(HorizontalDataUser::class.java)
                        userList.add(eData!!)
                    }
                    val mAdapter = Horizontal_cartAdapter(this@MainFragment,context!!.applicationContext,userList)
                    ErecycleView3.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
    //get userData 4
    private fun getUserData4() {
        userList = arrayListOf()
        ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                if (snapshot.exists()){
                    for(emp in snapshot.children){
                        val eData = emp.getValue(HorizontalDataUser::class.java)
                        userList.add(eData!!)
                    }
//                    val mAdapter = Horizontal_cartAdapter(userList,this@MainFragment)
                    ErecycleView4.adapter = Horizontal_cartAdapter(this@MainFragment,context!!.applicationContext,userList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }


    //horizontal card item click listener         starts

    override fun OnClick(position: Int) {

        val bundle = Bundle()

        //pul turi ,birligi
        bundle.putString("cost_type",userList[position].vally_type)

        //mahsulot turi
        bundle.putString("praduct_type",userList[position].product_type)

        //maxsulot nomi
        bundle.putString("praduct_name", userList[position].name)

        //maxsulot narxi
        bundle.putString("costs", userList[position].cost)

        //info
        bundle.putString("info",userList[position].info)

        //mahsulot rasmi
        bundle.putString("image_view",userList[position].image)

        val fragment = Private_product()
        val trans = fragmentManager?.beginTransaction()
        fragment.arguments = bundle
        trans?.replace(R.id.frameLayout, fragment)?.commit()

        //alternative way.  start.

//        val intent = Intent(context,Private_product::class.java).also {
//
//        it.putExtra("data",praduct_name[position])
//        it.putExtra("costs",costs_text[position])
//        it.putExtra("img",image_iv[position])
//        startActivity(it)
//        }


        //end.


    }


}