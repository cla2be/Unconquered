package com.example.matt.groundwork; /**
 * Created by Matt on 4/9/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter
{
    private static final String DATABASE_TABLE = "users";
    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LON = "lon";
    String currentUser;

    SQLiteDatabase mDb;
    Context mCtx;
    DBHelper mDbHelper;

    Global global = Global.getInstance();

    public DBAdapter(Context context)
    {
        this.mCtx = context;
    }

    public DBAdapter() {}

    public DBAdapter open() throws SQLException
    {
        mDbHelper = new DBHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public long register(String user,String pw)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USERNAME, user);
        initialValues.put(KEY_PASSWORD, pw);

        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean updateLatAndLong(String latCoord, String longCoord)
    {
//        ContentValues initalValues = new ContentValues();
//        initalValues.put(KEY_LAT, latCoord);
//        initalValues.put(KEY_LON, longCoord);

        Cursor mCursor = mDb.rawQuery("update" + DATABASE_TABLE +  "set recentLat = " + latCoord + ", recentLong = " + longCoord + "where email = " + global.getCurrentEmail(),null);

        if(mCursor != null)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public String getLat()
    {
        Cursor mCursor = mDb.rawQuery("SELECT recentLat FROM " + DATABASE_TABLE + "WHERE username =?", new String[]{global.getCurrentEmail()});
        mCursor.moveToFirst();
        String str = mCursor.getString(mCursor.getColumnIndex("recentLat"));
        return str;
    }

    public boolean Login(String username, String password) throws SQLException
    {
        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE username=? AND password=?", new String[]{username,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }


}
