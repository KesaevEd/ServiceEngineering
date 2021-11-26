package com.example.servisengineering.checkBox59

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.servisengineering.checkBox93.DbCheckBoxClass

class CheckBoxDbHelper59(context: Context): SQLiteOpenHelper(context, DbCheckBoxClass.TABLE_NAME59, null, DbCheckBoxClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbCheckBoxClass.CREATE_TABLE59)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbCheckBoxClass.SQL_DELETE_TABLE59)
        onCreate(db)
    }

}