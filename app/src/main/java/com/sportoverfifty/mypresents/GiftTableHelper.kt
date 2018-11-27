package com.sportoverfifty.mypresents

import android.content.ContentValues
import android.content.Context
import android.util.Log
import java.sql.SQLException

class GiftTableHelper(context: Context){

    private val helper = DatabaseHelper(context)

    fun speichereNeuenEintrag(daten: GiftObject) : Long {

        val db = helper.writableDatabase
        val datensatz = ContentValues()
        datensatz.put(databaseValues.NAME, daten.name)
        datensatz.put(databaseValues.BESCHREIBUNG,daten.beschreibung)
        datensatz.put(databaseValues.GEKAUFT,daten.gekauft)
        datensatz.put(databaseValues.GESCHECK_FUER, daten.geschenkFuer)
        datensatz.put(databaseValues.BILD_ID,daten.bild)
        datensatz.put(databaseValues.SHOP,daten.shop)
        db.beginTransaction()
        val id = try {
            val id = db.insert(databaseValues.TABLE_NAME,null,datensatz)
            db.setTransactionSuccessful()
            id
        } //catch (e: SQLException) {

        //}
    finally {
            db.endTransaction()
            db.close()

        }
        Log.i("test", "Datensatz eingefügt. $id")
        return id

    }
}