package com.example.servisengineering.checkBox93

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CheckBoxDbHelper93(context: Context): SQLiteOpenHelper(context, DbCheckBoxClass.TABLE_NAME93, null, DbCheckBoxClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbCheckBoxClass.CREATE_TABLE93)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbCheckBoxClass.SQL_DELETE_TABLE93)
        onCreate(db)
    }

}