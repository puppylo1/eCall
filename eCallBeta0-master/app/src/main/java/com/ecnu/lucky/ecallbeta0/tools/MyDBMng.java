package com.ecnu.lucky.ecallbeta0.tools;

import android.content.Context;

public class MyDBMng
{
    private Context mContext;
    public static MyDBHelper myDBHelper;

    public MyDBMng(Context context)
    {
        this.mContext = context;
        myDBHelper = new MyDBHelper(context);
    }
}
