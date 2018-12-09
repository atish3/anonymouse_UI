package org.anonymouse.uidesign

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val post_dbName:String = "anonymouse.db"
val post_dbVersion = 4
val post_dbTable = "POSTTable"
class PostDatabaseHelper : SQLiteOpenHelper {

    var context: Context? = null
    var CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS POSTTable (Id INTEGER PRIMARY KEY, content TEXT, post_time INTEGER, rating INTEGER);"
    constructor(context: Context) : super(context, post_dbName, null, post_dbVersion) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE_SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("Drop table IF EXISTS " + post_dbTable)
    }
}
