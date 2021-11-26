package com.example.servisengineering.db93

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper93(context: Context): SQLiteOpenHelper(context, DbSchool.TABLE_NAME93, null, DbSchool.DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbSchool.CREATE_TABLE93)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbSchool.SQL_DELETE_TABLE93)
        onCreate(db)
    }
}