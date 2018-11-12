package com.sportoverfifty.mypresents

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mManger = supportFragmentManager
    val shoppingFragment = ShoppingFragment()
    val uebersichtGeschenkeFragment = UebersichtGeschenkeFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_giftlist -> {
                val mTransaction = mManger.beginTransaction()
                mTransaction.replace(R.id.contentArea,uebersichtGeschenkeFragment)
                mTransaction.addToBackStack(null)
                mTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shoppinglist -> {
                val mTransaction = mManger.beginTransaction()
                mTransaction.replace(R.id.contentArea,shoppingFragment)
                mTransaction.addToBackStack(null)
                mTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
