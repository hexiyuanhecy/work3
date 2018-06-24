package com.example.closetome.work3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table USER ("
            + "user_id integer primary key autoincrement, "
            + "user_name text, "
            + "password text, "
            + "days integer, "
            + "logintime text, "
            + "items integer)";

    public static final String CREATE_ITEM = "create table ITEM ("
            + "item_id integer primary key autoincrement, "
            + "user_id integer, "
            + "remind integer, "
            + "address text)";

    public static final String CREATE_TAG = "create table TAG ("
            + "tag_id integer primary key autoincrement, "
            + "item_id integer, "
            + "tag text)";

    public static final String CREATE_PICTRUE = "create table PICTRUE ("
            + "pic_id integer primary key autoincrement, "
            + "item_id integer, "
            + "pic_name text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_ITEM);
        db.execSQL(CREATE_TAG);
        db.execSQL(CREATE_PICTRUE);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists USER");
        db.execSQL("drop table if exists ITEM");
        db.execSQL("drop table if exists TAG");
        db.execSQL("drop table if exists PICTRUE");
        onCreate(db);
    }

}