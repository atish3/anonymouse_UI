package org.anonymouse.uidesign

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val reply_dbName:String = "anonymouse.db"
val reply_dbVersion = 4
val reply_dbTable = "ReplyTable"
class ReplyDatabaseHelper : SQLiteOpenHelper {

    var context: Context? = null
    var CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS ReplyTable (Id INTEGER PRIMARY KEY,post_id INTEGER ,content TEXT, post_time INTEGER, author TEXT);"
    constructor(context: Context) : super(context, reply_dbName, null, reply_dbVersion) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE_SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("Drop table IF EXISTS " + reply_dbTable)
    }
}
