package com.sportoverfifty.mypresents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class ShoppingListAdapter (context: Context, items: ArrayList<GiftObject>): BaseAdapter() {
    private val context: Context
    private val items : ArrayList<GiftObject>

    init{
        this.context = context
        this.items = items
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflator = LayoutInflater.from(context)
        val inflator = layoutInflator.inflate(R.layout.shopping_list_layout,parent, false)
        val title = inflator.findViewById<TextView>(R.id.textViewProduct)
        val bild = inflator.findViewById<ImageView>(R.id.imageViewCat)
        title.text = items.get(position).name
        bild.setImageResource(items.get(position).bild)
        return inflator
    }

    override fun getItem(position: Int): GiftObject {
        return items.get(position)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size

    }
}