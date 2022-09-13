package com.example.constraintlayout_navigation.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name, null, version) {
    private val createGame = "create table Games (" +
            " id integer primary key autoincrement," +
            "game text," +
            "imgRid integer,"+
            "imgname text,"+
            "last text)"
private val createMusic = "create table Music (" +
        "id integer primary key autoincrement," +
        "music text," +
        "author text,"+
        "time text,"+
        "gamename text,"+
        "last text)"

    //private val createBook = "create table Book (id integer primary key autoincrement,author text,price real,pages integer,name text)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createGame)
        db.execSQL(createMusic)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists Games")
        db.execSQL("drop table if exists Music")
        onCreate(db)
        Toast.makeText(context, "update and crate succeeded", Toast.LENGTH_SHORT).show()
//       将这两张表删除，然后调用onCreate()方法重新创建
    }
}
