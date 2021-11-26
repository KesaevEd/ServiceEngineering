package com.example.servisengineering.checkBoxPriut

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.servisengineering.checkBox93.DbCheckBoxClass

class CheckBoxDbHelperPriut(context: Context): SQLiteOpenHelper(context, DbCheckBoxClass.TABLE_NAME_PRIUT, null, DbCheckBoxClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbCheckBoxClass.CREATE_TABLE_PRIUT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbCheckBoxClass.SQL_DELETE_TABLE_PRIUT)
        onCreate(db)
    }

}