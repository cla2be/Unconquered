package com.example.matt.groundwork; /**
 * Created by Matt on 4/9/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "membersdb";
    private static final int DATABASE_VERSION = 1;

    //private static final String DATABASE_TABLE = "users";
    //private static final String DATABASE_CREATE = "create table users (_id integer primary key autoincrement," +"username text not null" + "password not null)";


    private static final String DATABASE_CREATE = "CREATE TABLE users (_id integer primary key autoincrement," +
            "email text not null,password text not null, " +
            "recentLat integer not null, " +
            "recentLong integer not null);";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("DROP TABLE IF EXISTS members");
        onCreate(db);

    }

}
