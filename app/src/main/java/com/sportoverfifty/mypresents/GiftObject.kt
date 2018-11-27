package com.sportoverfifty.mypresents

import android.graphics.drawable.Drawable
import android.provider.BaseColumns

data class GiftObject (val id: Int, val name: String, val gekauft: Boolean, val shop: String, val beschreibung: String, val bild: Drawable?, val geschenkFuer: String)

object databaseValues : BaseColumns{
    val DATABASE_NAME = "giftdb"
    val DATABASE_VERSION = 1
    val TABLE_NAME = "gifttabelle"
    val ID = "_id"
    val NAME = "name"
    val GEKAUFT = "gekauft"
    val SHOP = "shop"
    val BESCHREIBUNG = "beschreibung"
    val BILD_ID = "bildid"
    val GESCHECK_FUER = "geschkfuer"


}