package com.example.servisengineering.dbPriut

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.servisengineering.db93.DbSchool

class MyDbManagerPriut(context: Context) {

    val myDbHelper = MyDbHelperPriut(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String, uri: String, date: String){
        val values = ContentValues().apply{
            put(DbSchool.COLUMN_NAME_TITLE, title)
            put(DbSchool.COLUMN_NAME_CONTENT, content)
            put(DbSchool.COLUMN_NAME_IMAGE_URI, uri)
            put(DbSchool.COLUMN_NAME_DATE, date)
        }
        db?.insert(DbSchool.TABLE_NAME_PRIUT, null, values)
    }

    fun readDbData(): ArrayList<ListItemPriut>{
        val dataList = ArrayList<ListItemPriut>()
        val cursor = db?.query(DbSchool.TABLE_NAME_PRIUT, null, null, null, null, null, null)
        while(cursor?.moveToNext()!!){
            val dataTitle = cursor.getString(cursor.getColumnIndex(DbSchool.COLUMN_NAME_TITLE))
            val dataContent = cursor.getString(cursor.getColumnIndex(DbSchool.COLUMN_NAME_CONTENT))
            val dataUri = cursor.getString(cursor.getColumnIndex(DbSchool.COLUMN_NAME_IMAGE_URI))
            val dataId = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val dataDate = cursor.getString(cursor.getColumnIndex(DbSchool.COLUMN_NAME_DATE))
            val item = ListItemPriut()
            item.title = dataTitle
            item.desc = dataContent
            item.uri = dataUri
            item.id = dataId
            item.date = dataDate
            dataList.add(item)
        }
        cursor.close()
        return dataList
    }

    fun closeDb(){
        myDbHelper.close()
    }

    fun removeItemFromDb(id: String){

        val selection = BaseColumns._ID + "=$id"
        db?.delete(DbSchool.TABLE_NAME_PRIUT, selection, null)
    }

    //UPDATING ELEMENTS WITHOUT CREATING NEW
    fun updateItem(title: String, content: String, uri: String, id: Int, date: String){
        val selection = BaseColumns._ID + "=$id"
        val values = ContentValues().apply{
            put(DbSchool.COLUMN_NAME_TITLE, title)
            put(DbSchool.COLUMN_NAME_CONTENT, content)
            put(DbSchool.COLUMN_NAME_IMAGE_URI, uri)
            put(DbSchool.COLUMN_NAME_DATE, date)
        }
        db?.update(DbSchool.TABLE_NAME_PRIUT, values, selection, null)
    }

}