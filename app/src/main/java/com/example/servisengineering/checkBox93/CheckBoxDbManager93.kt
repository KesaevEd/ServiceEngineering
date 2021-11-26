package com.example.servisengineering.checkBox93

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class CheckBoxDbManager93(context: Context) {

    val checkBoxDbHelper = CheckBoxDbHelper93(context)
    var db:SQLiteDatabase? = null

    fun openDb(){
        db = checkBoxDbHelper.writableDatabase
    }

    fun closeDb(){
        checkBoxDbHelper.close()
    }

    fun insertToDb(status1: String, status2: String, status3: String, status4: String, status5: String, status6: String, status7: String, status8: String, status9: String, status10: String){
        val values = ContentValues().apply {
            put(DbCheckBoxClass.COLUMN_NAME_STATUS1, status1)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS2, status2)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS3, status3)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS4, status4)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS5, status5)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS6, status6)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS7, status7)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS8, status8)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS9, status9)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS10, status10)
        }
        db?.insert(DbCheckBoxClass.TABLE_NAME93, null, values)
    }

    fun readDbData(): ArrayList<String>{
        val statusList = ArrayList<String>()

        val cursor = db?.query(DbCheckBoxClass.TABLE_NAME93, null, null, null, null, null, null)

        while (cursor?.moveToNext()!!){
            val dataStatus1 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS1))
            val dataStatus2 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS2))
            val dataStatus3 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS3))
            val dataStatus4 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS4))
            val dataStatus5 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS5))
            val dataStatus6 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS6))
            val dataStatus7 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS7))
            val dataStatus8 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS8))
            val dataStatus9 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS9))
            val dataStatus10 = cursor.getString(cursor.getColumnIndex(DbCheckBoxClass.COLUMN_NAME_STATUS10))

            statusList.add(dataStatus1)
            statusList.add(dataStatus2)
            statusList.add(dataStatus3)
            statusList.add(dataStatus4)
            statusList.add(dataStatus5)
            statusList.add(dataStatus6)
            statusList.add(dataStatus7)
            statusList.add(dataStatus8)
            statusList.add(dataStatus9)
            statusList.add(dataStatus10)
            statusList.add(statusList.toString())
        }

        cursor.close()
        return statusList
    }

    //ФУНКЦИЯ ИЗМЕНЕНИЯ ДАННЫХ
    fun updateItem(status1: String, status2: String, status3: String, status4: String, status5: String, status6: String, status7: String, status8: String, status9: String, status10: String, id: Int){

        val selection = BaseColumns._ID + "=$id"

        val values = ContentValues().apply {
            put(DbCheckBoxClass.COLUMN_NAME_STATUS1, status1)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS2, status2)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS3, status3)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS4, status4)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS5, status5)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS6, status6)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS7, status7)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS8, status8)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS9, status9)
            put(DbCheckBoxClass.COLUMN_NAME_STATUS10, status10)
        }
        db?.update(DbCheckBoxClass.TABLE_NAME93, values, selection, null)
    }

}