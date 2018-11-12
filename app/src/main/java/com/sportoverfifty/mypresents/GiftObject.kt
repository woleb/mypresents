package com.sportoverfifty.mypresents

import android.graphics.drawable.Drawable

data class GiftObject (val id: Int, val name: String, val gekauft: Boolean, val shop: String, val beschreibung: String, val bild: Drawable?, val geschenkFuer: String)