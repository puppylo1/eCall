package com.ecnu.lucky.ecallbeta0.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper
{
    private Context mContext;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "eCall.db";

    private static final String CREATE_USER = "";

    public MyDBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_USER);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }
}
