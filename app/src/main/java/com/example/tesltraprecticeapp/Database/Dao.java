package com.example.tesltraprecticeapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

    SQLiteDatabase database;
    FeedReaderDbHelper helper;

    public Dao(Context context) {
        helper = new FeedReaderDbHelper(context);
    }

    public  void openDb(){
        database = helper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }

    public void createRow(String title, String subTitle){
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, subTitle);
        database.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
    }

    public void readRows(){
        Cursor cursor = database.query(FeedReaderContract.FeedEntry.TABLE_NAME, null,null,null, null,null,null );
    }
    public String readRow(){
        Cursor cursor = database.query(FeedReaderContract.FeedEntry.TABLE_NAME,
                null,null,null,
                null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE); //1= index of title
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE); //2

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);

        return  title +"\n"+ subtitle;
    }
    public void updateRow(){}
    public void deleteRow(){}


}
