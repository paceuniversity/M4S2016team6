package com.example.evelyne_ines.expensemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.evelyne_ines.expensemanager.earnings;
import com.example.evelyne_ines.expensemanager.expenses;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by evelyne-ines on 07/08/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "expenseManager";

    // Table Names
    private static final String TABLE_EXPENSE = "expenses";
    private static final String TABLE_EARNING = "earnings";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";

    // NOTES Table - column names
    private static final String KEY_ARTICLE = "article";
    private static final String KEY_PRICE = "price";

    // TAGS Table - column names
    private static final String KEY_AMOUNT = "amount";

    // NOTE_TAGS Table - column names
    private static final String KEY_EXPENSE_ID = "expense_id";
    private static final String KEY_EARNING_ID = "earning_id";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_EXPENSE = "CREATE TABLE "
            + TABLE_EXPENSE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ARTICLE
            + " TEXT," + KEY_PRICE + " INTEGER," + KEY_DATE
            + " DATETIME" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_EARNING = "CREATE TABLE " + TABLE_EARNING
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_AMOUNT + " TEXT,"
            + KEY_DATE + " DATETIME" + ")";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_EXPENSE);
        db.execSQL(CREATE_TABLE_EARNING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EARNING);

        // create new tables
        onCreate(db);
    }

    /*
 * Creating an Expense
 */
    public long createExpense(expenses exp) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ARTICLE, exp.getArticle());
        values.put(KEY_PRICE, exp.getPrice());
        values.put(KEY_DATE, getDate());

        // insert row
        long exp_id = db.insert(TABLE_EXPENSE, null, values);

        return exp_id;
    }

    /*
 * getting all expense
 * */
    public List<expenses> getAllExpense() {
        List<expenses> expenses = new ArrayList<expenses>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSE;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                expenses td = new expenses();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setArticle((c.getString(c.getColumnIndex(KEY_ARTICLE))));
                td.setDate((c.getString(c.getColumnIndex(KEY_DATE))));

                // adding to expense list
                expenses.add(td);
            } while (c.moveToNext());
        }

        return expenses;
    }

    /*
 * Updating an Expense
 */
    public int updateExpense(expenses exp) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ARTICLE, exp.getArticle());
        values.put(KEY_PRICE, exp.getPrice());

        // updating row
        return db.update(TABLE_EXPENSE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(exp.getId()) });
    }

    /*
 * Deleting an Expense
 */
    public void deleteExpense(long exp_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXPENSE, KEY_ID + " = ?",
                new String[] { String.valueOf(exp_id) });
    }

    /*
 * Creating Earning
 */
    public long createEarning(earnings earnings) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNT, earnings.getAmount());
        values.put(KEY_DATE, getDate());

        // insert row
        long earning_id = db.insert(TABLE_EARNING, null, values);

        return earning_id;
    }

    /**
     * getting all earnings
     * */
    public List<earnings> getAllEarnings() {
        List<earnings> earnings = new ArrayList<earnings>();
        String selectQuery = "SELECT  * FROM " + TABLE_EARNING;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                earnings t = new earnings();
                t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                t.setAmount(c.getFloat(c.getColumnIndex(KEY_AMOUNT)));

                // adding to tags list
                earnings.add(t);
            } while (c.moveToNext());
        }
        return earnings;
    }

    /*
 * Updating an Earning
 */
    public int updateEarning(earnings earnings) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNT, earnings.getAmount());

        // updating row
        return db.update(TABLE_EARNING, values, KEY_ID + " = ?",
                new String[] { String.valueOf(earnings.getId()) });
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    /**
     * get datetime
     * */
    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
