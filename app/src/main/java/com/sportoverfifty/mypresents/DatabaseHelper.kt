package com.sportoverfifty.mypresents

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,
    databaseValues.DATABASE_NAME,
    null,
    databaseValues.DATABASE_VERSION){

    val tabelle = "CREATE TABLE gifttabelle (_id INTEGER PRIMARY KEY, name TEXT, gekauft INTEGER, shop TEXT, beschreibung TEXT, bildid INTEGER, geschenkfuer TEXT);"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(tabelle)
        Log.i("test_aus", "Tabelle angelegt!")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${databaseValues.TABLE_NAME}" )
        db?.execSQL(tabelle)
        Log.i("test_aus", "Tabelle gelöscht und neu angelegt!")
    }
}
