package com.xa.food_city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.xa.food_city.Fragments.*
import com.xa.food_city.UiAdapters.Pager_cart_Adapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        link(MainFragment())

        nav_bar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Asosiy -> {
                    link(MainFragment())
                }
                R.id.Kategoria -> {
                    link(CatigoryFragment())
                }

                R.id.Sevimli -> {
                    link(FavoriteFragment())
                }
                R.id.Savat -> {
                    link(BascetFragment())
                }
                R.id.Profil -> {
                    link(AccountFragment())
                }
            }
            true

        }

    }

    private fun link(fra: Fragment) {
        if (fra != null) {
            val support = supportFragmentManager.beginTransaction()
            support.replace(R.id.frameLayout, fra)
            support.commit()
        }
    }

    public fun like_favorite_btn(view: View) {

//        Toast.makeText(this@MainActivity,"Saved",Toast.LENGTH_SHORT).show()

    }

    public fun like_favorite_btn_on(view: View) {
    }

    public fun gott_cart_n1(view: View) {
    }


}

