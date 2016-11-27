package com.example.rache.smartrecipes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RecipesOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "recipes.db";
    private static final int SCHEMA_VERSION = 1;
    private static final String TABLE_NAME = "recipes";
    private static final String COL_ID = "_id";
    private static final String COL_TYPE = "type";
    private static final String COL_NAME = "name";
    private static final String COL_PIC = "picturePath";
    private static final String COL_INGREDIENTS = "ingredients";
    private static final String COL_METHODS = "methods";
    private static final String COL_CALORIES = "calories";

    public RecipesOpenHelper(final Context context){
        super(context, DB_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String create_table = "create table if not exists "+TABLE_NAME+
                "("+COL_ID+" integer primary key autoincrement,"+
                COL_TYPE+" text not null,"+
                COL_NAME+" text not null,"+
                COL_PIC+" text not null,"+
                COL_INGREDIENTS+" text not null,"+
                COL_METHODS+" text not null,"+
                COL_CALORIES+" integer not null);";
        db.execSQL(create_table);
    }

    public void insertRecipe(SQLiteDatabase db, final String type, final String name, final String pic, final String ingredients, final String methods, final int calories){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TYPE, type);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_PIC, pic);
        contentValues.put(COL_INGREDIENTS, ingredients);
        contentValues.put(COL_METHODS, methods);
        contentValues.put(COL_CALORIES, calories);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public long getAllNumOfRecipes(SQLiteDatabase db){
        return DatabaseUtils.queryNumEntries(db, TABLE_NAME);
    }

    public Cursor getTypeRecipes(final SQLiteDatabase db, final String type){
        return db.query(TABLE_NAME, null,COL_TYPE + "=?", new String[]{type},null, null, null, null);
    }


}
