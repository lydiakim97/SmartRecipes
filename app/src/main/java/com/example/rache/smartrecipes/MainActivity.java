package com.example.rache.smartrecipes;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        initDB();
    }

    private void initDB(){
        RecipesOpenHelper helper = new RecipesOpenHelper(getApplicationContext());
        final SQLiteDatabase db = helper.getWritableDatabase();

        if(helper.getAllNumOfRecipes(db)==0){
            db.beginTransaction();
            try{
                //insert 6 dinner recipes
                String[] d_1 = getResources().getStringArray(R.array.dinner1);
                String[] d_2 = getResources().getStringArray(R.array.dinner2);
                String[] d_3 = getResources().getStringArray(R.array.dinner3);
                String[] d_4 = getResources().getStringArray(R.array.dinner4);
                String[] d_5 = getResources().getStringArray(R.array.dinner5);
                String[] d_6 = getResources().getStringArray(R.array.dinner6);

                helper.insertRecipe(db, d_1[0], d_1[1], d_1[2], d_1[3], d_1[4], Integer.parseInt(d_1[5]));
                helper.insertRecipe(db, d_2[0], d_2[1], d_2[2], d_2[3], d_2[4], Integer.parseInt(d_2[5]));
                helper.insertRecipe(db, d_3[0], d_3[1], d_3[2], d_3[3], d_3[4], Integer.parseInt(d_3[5]));
                helper.insertRecipe(db, d_4[0], d_4[1], d_4[2], d_4[3], d_4[4], Integer.parseInt(d_4[5]));
                helper.insertRecipe(db, d_5[0], d_5[1], d_5[2], d_5[3], d_5[4], Integer.parseInt(d_5[5]));
                helper.insertRecipe(db, d_6[0], d_6[1], d_6[2], d_6[3], d_6[4], Integer.parseInt(d_6[5]));

                //insert 6 breakfast recipes
                String[] b_1 = getResources().getStringArray(R.array.breakfast1);
                String[] b_2 = getResources().getStringArray(R.array.breakfast2);
                String[] b_3 = getResources().getStringArray(R.array.breakfast3);
                String[] b_4 = getResources().getStringArray(R.array.breakfast4);
                String[] b_5 = getResources().getStringArray(R.array.breakfast5);
                String[] b_6 = getResources().getStringArray(R.array.breakfast6);

                helper.insertRecipe(db, b_1[0], b_1[1], b_1[2], b_1[3], b_1[4], Integer.parseInt(b_1[5]));
                helper.insertRecipe(db, b_2[0], b_2[1], b_2[2], b_2[3], b_2[4], Integer.parseInt(b_2[5]));
                helper.insertRecipe(db, b_3[0], b_3[1], b_3[2], b_3[3], b_3[4], Integer.parseInt(b_3[5]));
                helper.insertRecipe(db, b_4[0], b_4[1], b_4[2], b_4[3], b_4[4], Integer.parseInt(b_4[5]));
                helper.insertRecipe(db, b_5[0], b_5[1], b_5[2], b_5[3], b_5[4], Integer.parseInt(b_5[5]));
                helper.insertRecipe(db, b_6[0], b_6[1], b_6[2], b_6[3], b_6[4], Integer.parseInt(b_6[5]));

                //insert 6 lunch recipes
                String[] l_1 = getResources().getStringArray(R.array.lunch1);
                String[] l_2 = getResources().getStringArray(R.array.lunch2);
                String[] l_3 = getResources().getStringArray(R.array.lunch3);
                String[] l_4 = getResources().getStringArray(R.array.lunch4);
                String[] l_5 = getResources().getStringArray(R.array.lunch5);
                String[] l_6 = getResources().getStringArray(R.array.lunch6);

                helper.insertRecipe(db, l_1[0], l_1[1], l_1[2], l_1[3], l_1[4], Integer.parseInt(l_1[5]));
                helper.insertRecipe(db, l_2[0], l_2[1], l_2[2], l_2[3], l_2[4], Integer.parseInt(l_2[5]));
                helper.insertRecipe(db, l_3[0], l_3[1], l_3[2], l_3[3], l_3[4], Integer.parseInt(l_3[5]));
                helper.insertRecipe(db, l_4[0], l_4[1], l_4[2], l_4[3], l_4[4], Integer.parseInt(l_4[5]));
                helper.insertRecipe(db, l_5[0], l_5[1], l_5[2], l_5[3], l_5[4], Integer.parseInt(l_5[5]));
                helper.insertRecipe(db, l_6[0], l_6[1], l_6[2], l_6[3], l_6[4], Integer.parseInt(l_6[5]));

                db.setTransactionSuccessful();
            }finally {
                db.endTransaction();
            }
        }
        db.close();
    }

    public void customizeRecipe(final View v){
        final Intent intent_userInfo = new Intent(this, UserInfo.class);
        startActivity(intent_userInfo);
    }

    public void breakfastGallery(final View v){
        Intent intent_bfGallery= new Intent(this, RecipesGallery.class);
        intent_bfGallery.putExtra("type", "breakfast");
        startActivity(intent_bfGallery);
    }

    public void lunchGallery(final View v){
        final Intent intent_lunchGallery = new Intent(this, RecipesGallery.class);
        intent_lunchGallery.putExtra("type", "lunch");
        startActivity(intent_lunchGallery);
    }

    public void dinnerGallery(final View v){
        final Intent intent_dinnerGallery = new Intent(this, RecipesGallery.class);
        intent_dinnerGallery.putExtra("type", "dinner");
        startActivity(intent_dinnerGallery);
    }
}
