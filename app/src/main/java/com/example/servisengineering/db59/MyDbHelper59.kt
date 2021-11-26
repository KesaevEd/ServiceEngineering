package com.example.servisengineering.db59

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.servisengineering.db93.DbSchool

class MyDbHelper59(context: Context): SQLiteOpenHelper(context, DbSchool.TABLE_NAME59, null, DbSchool.DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbSchool.CREATE_TABLE59)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbSchool.SQL_DELETE_TABLE59)
        onCreate(db)
    }
}