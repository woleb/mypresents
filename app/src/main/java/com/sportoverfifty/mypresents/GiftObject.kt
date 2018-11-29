package com.sportoverfifty.mypresents

import android.graphics.drawable.Drawable
import android.provider.BaseColumns

data class GiftObject (var id: Int, var name: String, var gekauft: Int, var shop: String, var beschreibung: String, var bild: Int, var geschenkFuer: String){
    override fun toString(): String {
        return "GiftObject(id=$id, name='$name', gekauft=$gekauft, shop='$shop', beschreibung='$beschreibung', bild=$bild, geschenkFuer='$geschenkFuer')"
    }
}

object databaseValues : BaseColumns{
    val DATABASE_NAME = "giftdb"
    val DATABASE_VERSION = 2
    val TABLE_NAME = "gifttabelle"
    val _ID = "_id"
    val NAME = "name"
    val GEKAUFT = "gekauft"
    val SHOP = "shop"
    val BESCHREIBUNG = "beschreibung"
    val BILD_ID = "bildid"
    val GESCHENCK_FUER = "geschenkfuer"


}