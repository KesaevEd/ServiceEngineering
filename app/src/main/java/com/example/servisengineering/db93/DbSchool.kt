package com.example.servisengineering.db93

import android.provider.BaseColumns

object DbSchool : BaseColumns{

    const val TABLE_NAME93 = "School93"
    const val TABLE_NAME59 = "School59"
    const val TABLE_NAME_PRIUT = "Priut"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "content"
    const val COLUMN_NAME_IMAGE_URI = "uri"
    const val COLUMN_NAME_DATE = "date"
    const val COLUMN_NAME_STATUS = "status"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "ServisEngeneering.db"

    const val CREATE_TABLE93 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME93 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT, $COLUMN_NAME_IMAGE_URI TEXT, $COLUMN_NAME_DATE TEXT, $COLUMN_NAME_STATUS TEXT)"

    const val CREATE_TABLE59 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME59 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT, $COLUMN_NAME_IMAGE_URI TEXT, $COLUMN_NAME_DATE TEXT, $COLUMN_NAME_STATUS TEXT)"

    const val CREATE_TABLE_PRIUT = "CREATE TABLE IF NOT EXISTS $TABLE_NAME_PRIUT (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT, $COLUMN_NAME_IMAGE_URI TEXT, $COLUMN_NAME_DATE TEXT, $COLUMN_NAME_STATUS TEXT)"

    const val SQL_DELETE_TABLE93 = "DROP TABLE IF EXISTS $TABLE_NAME93"
    const val SQL_DELETE_TABLE59 = "DROP TABLE IF EXISTS $TABLE_NAME59"
    const val SQL_DELETE_TABLE_PRIUT = "DROP TABLE IF EXISTS $TABLE_NAME_PRIUT"
}