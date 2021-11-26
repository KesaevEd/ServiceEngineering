package com.example.servisengineering.checkBox93

import android.provider.BaseColumns

object DbCheckBoxClass: BaseColumns {

    const val TABLE_NAME93 = "checkBox93"
    const val TABLE_NAME59 = "checkBox59"
    const val TABLE_NAME_PRIUT = "checkBoxpPriut"
    const val COLUMN_NAME_STATUS1 = "status1"
    const val COLUMN_NAME_STATUS2 = "status2"
    const val COLUMN_NAME_STATUS3 = "status3"
    const val COLUMN_NAME_STATUS4 = "status4"
    const val COLUMN_NAME_STATUS5 = "status5"
    const val COLUMN_NAME_STATUS6 = "status6"
    const val COLUMN_NAME_STATUS7 = "status7"
    const val COLUMN_NAME_STATUS8 = "status8"
    const val COLUMN_NAME_STATUS9 = "status9"
    const val COLUMN_NAME_STATUS10 = "status10"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "ServisEngeneering.db"

    const val CREATE_TABLE93 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME93 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_STATUS1 TEXT, $COLUMN_NAME_STATUS2 TEXT," +
    "$COLUMN_NAME_STATUS3 TEXT, $COLUMN_NAME_STATUS4 TEXT, $COLUMN_NAME_STATUS5 TEXT, $COLUMN_NAME_STATUS6 TEXT," +
    "$COLUMN_NAME_STATUS7 TEXT, $COLUMN_NAME_STATUS8 TEXT, $COLUMN_NAME_STATUS9 TEXT, $COLUMN_NAME_STATUS10 TEXT)"

    const val CREATE_TABLE59 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME59 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_STATUS1 TEXT, $COLUMN_NAME_STATUS2 TEXT," +
            "$COLUMN_NAME_STATUS3 TEXT, $COLUMN_NAME_STATUS4 TEXT, $COLUMN_NAME_STATUS5 TEXT, $COLUMN_NAME_STATUS6 TEXT," +
            "$COLUMN_NAME_STATUS7 TEXT, $COLUMN_NAME_STATUS8 TEXT)"

    const val CREATE_TABLE_PRIUT = "CREATE TABLE IF NOT EXISTS $TABLE_NAME_PRIUT (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_STATUS1 TEXT, $COLUMN_NAME_STATUS2 TEXT," +
            "$COLUMN_NAME_STATUS3 TEXT, $COLUMN_NAME_STATUS4 TEXT, $COLUMN_NAME_STATUS5 TEXT, $COLUMN_NAME_STATUS6 TEXT," +
            "$COLUMN_NAME_STATUS7 TEXT, $COLUMN_NAME_STATUS8 TEXT)"

    const val SQL_DELETE_TABLE93 = "DROP TABLE IF EXISTS $TABLE_NAME93"
    const val SQL_DELETE_TABLE59 = "DROP TABLE IF EXISTS $TABLE_NAME59"
    const val SQL_DELETE_TABLE_PRIUT = "DROP TABLE IF EXISTS $TABLE_NAME_PRIUT"
}