package com.example.servisengineering.dbPriut

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.servisengineering.db93.DbSchool

class MyDbHelperPriut(context: Context): SQLiteOpenHelper(context, DbSchool.TABLE_NAME_PRIUT, null, DbSchool.DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbSchool.CREATE_TABLE_PRIUT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbSchool.SQL_DELETE_TABLE_PRIUT)
        onCreate(db)
    }
}