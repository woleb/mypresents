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

    fun alleEintraege(){

        val auswahl= arrayOf(databaseValues._ID,databaseValues.NAME,databaseValues.BESCHREIBUNG,databaseValues.BILD_ID,databaseValues.GEKAUFT,databaseValues.GESCHECK_FUER,databaseValues.SHOP)

        val db = helper.readableDatabase
        val cursor = db.query(databaseValues.TABLE_NAME,auswahl, null, null,null,null,null)
        var giftDaten = GiftObject(0,"",0,"","",0,"")
        Log.i("test", "Leeres Object: ${giftDaten.toString()}")

        while (cursor.moveToNext()){
            giftDaten.id = cursor.getInt(cursor.getColumnIndex(databaseValues._ID))
            giftDaten.beschreibung = cursor.getString(cursor.getColumnIndex(databaseValues.BESCHREIBUNG))
            giftDaten.bild = cursor.getInt(cursor.getColumnIndex(databaseValues.BILD_ID))
            giftDaten.gekauft = cursor.getInt(cursor.getColumnIndex(databaseValues.GEKAUFT))
            giftDaten.geschenkFuer = cursor.getString(cursor.getColumnIndex(databaseValues.GESCHECK_FUER))
            giftDaten.name = cursor.getString(cursor.getColumnIndex(databaseValues.NAME))
            giftDaten.shop = cursor.getString(cursor.getColumnIndex(databaseValues.SHOP))
            Log.i("test", "Datensatz abgerufen ${giftDaten.toString()}")
        }
        cursor.close()
    }

}