package com.aleshatech.sqlitekotlin.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.aleshatech.sqlitekotlin.model.Name

class DbHelper (context: Context,
                factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME,factory, DATABASE_VERSION){



    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "sample_db"
        val TABLE_NAME = "person"
        val COLUMN_ID = "_id"
        val COLUMN_NAME = "username"
        val COLUMN_MOBILE = "mobile"
        val COLUMN_EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PERSON_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT ," +
                COLUMN_MOBILE + " TEXT ," +
                COLUMN_EMAIL
                + " TEXT" + ")")
        db?.execSQL(CREATE_PERSON_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }



    fun addName(name: Name) {
        val values = ContentValues()
        values.put(COLUMN_NAME, name.name)
        values.put(COLUMN_MOBILE, name.mobile)
        values.put(COLUMN_EMAIL, name.email)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
//    fun getAllName(): Cursor? {
//        val db = this.readableDatabase
//        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
//    }

    fun getAllName(): ArrayList<Name> {
        val sql = "select * from $TABLE_NAME"
        val db = this.readableDatabase
        val personList =
                ArrayList<Name>()
        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0).toInt()
                val name = cursor.getString(1)
                val mobile = cursor.getString(2)
                val email = cursor.getString(3)
                personList.add(Name(name,mobile,email))
            }
            while (cursor.moveToNext())
        }
        cursor.close()
        return personList
    }
}