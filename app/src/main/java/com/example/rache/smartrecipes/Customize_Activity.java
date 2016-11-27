package com.example.rache.smartrecipes;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Customize_Activity extends AppCompatActivity {
    private String[][] arr_recipes;
    private String[][] recipe;
    private double level;
    private double BMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        BMR();
        recipe = new String[3][5];
        display("breakfast");
        display("lunch");
        display("dinner");

    }

    private void BMR() {

        int age = Integer.parseInt(getIntent().getStringExtra("age"));
        int height = Integer.parseInt(getIntent().getStringExtra("height"));
        int weight = Integer.parseInt(getIntent().getStringExtra("weight"));

        String gender = getIntent().getStringExtra("gender");
        String activity = getIntent().getStringExtra("activity");
        if (activity.equals("Low")) {
            level = 1.2;
        } else if(activity.equals("Medium")) {
            level = 1.55;
        } else if(activity.equals("High")) {
            level = 1.9;
        }

        if (gender.equals("Male")) {
            BMR = (66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age)) * level;
        } else if(gender.equals("Female")) {
            BMR = (655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age) * level);
        }
    }

    private void display(String type){
        RecipesOpenHelper helper = new RecipesOpenHelper(getApplicationContext());
        final SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = helper.getTypeRecipes(db, type);

        int x=0;
        arr_recipes = new String[6][5];
        while(cursor.moveToNext()){
            String name = cursor.getString(2);
            String picPath = cursor.getString(3);
            String ingredients = cursor.getString(4);
            String method = cursor.getString(5);
            String calries = new Integer(cursor.getInt(6)).toString();
            arr_recipes[x][0]= name;
            arr_recipes[x][1]= picPath;
            arr_recipes[x][2]= ingredients;
            arr_recipes[x][3]= method;
            arr_recipes[x][4]= calries;
            x++;
        }


        Random random = new Random();

        TextView t1=(TextView)findViewById(R.id.imgTx1);
        TextView t2=(TextView)findViewById(R.id.imgTx2);
        TextView t3=(TextView)findViewById(R.id.imgTx3);



        switch (type) {
            case "breakfast":
                ImageButton b1 = (ImageButton) findViewById(R.id.imgB1);
                if (BMR * 0.11 >= 400) {
                    b1.setImageResource(getDrawable(arr_recipes[5][1]));
                    t1.setText(arr_recipes[5][0]);
                    recipe[0][0] = arr_recipes[5][0];
                    recipe[0][1] = arr_recipes[5][1];
                    recipe[0][2] = arr_recipes[5][2];
                    recipe[0][3] = arr_recipes[5][3];
                    recipe[0][4] = arr_recipes[5][4];
                } else if (BMR * 0.11 > 240 && BMR * 0.11 < 400) {
                    int n [] = {0,2,4};
                    int rand = random.nextInt(n.length);
                    b1.setImageResource(getDrawable(arr_recipes[n[rand]][1]));
                    t1.setText(arr_recipes[n[rand]][0]);
                    recipe[0][0] = arr_recipes[n[rand]][0];
                    recipe[0][1] = arr_recipes[n[rand]][1];
                    recipe[0][2] = arr_recipes[n[rand]][2];
                    recipe[0][3] = arr_recipes[n[rand]][3];
                    recipe[0][4] = arr_recipes[n[rand]][4];
                } else if (BMR * 0.11 <= 240) {
                    int n [] = {1, 3};
                    int rand = random.nextInt(n.length);
                    b1.setImageResource(getDrawable(arr_recipes[n[rand]][1]));
                    t1.setText(arr_recipes[n[rand]][0]);
                    recipe[0][0] = arr_recipes[n[rand]][0];
                    recipe[0][1] = arr_recipes[n[rand]][1];
                    recipe[0][2] = arr_recipes[n[rand]][2];
                    recipe[0][3] = arr_recipes[n[rand]][3];
                    recipe[0][4] = arr_recipes[n[rand]][4];
                }

                break;

            case "lunch":
                ImageButton b2 = (ImageButton) findViewById(R.id.imgB2);
                if (BMR * 0.11 >= 400) {
                    int n [] = {2, 3};
                    int rand = random.nextInt(n.length);
                    b2.setImageResource(getDrawable(arr_recipes[n[rand]][1]));
                    t2.setText(arr_recipes[n[rand]][0]);
                    recipe[1][0] = arr_recipes[n[rand]][0];
                    recipe[1][1] = arr_recipes[n[rand]][1];
                    recipe[1][2] = arr_recipes[n[rand]][2];
                    recipe[1][3] = arr_recipes[n[rand]][3];
                    recipe[1][4] = arr_recipes[n[rand]][4];
                } else if (BMR * 0.11 > 300 && BMR * 0.11 < 400) {
                    b2.setImageResource(getDrawable(arr_recipes[4][1]));
                    t2.setText(arr_recipes[4][0]);
                    recipe[1][0] = arr_recipes[4][0];
                    recipe[1][1] = arr_recipes[4][1];
                    recipe[1][2] = arr_recipes[4][2];
                    recipe[1][3] = arr_recipes[4][3];
                    recipe[1][4] = arr_recipes[4][4];
                } else if (BMR * 0.11 <= 300) {
                    int n [] = {0, 1, 5};
                    int rand = random.nextInt(n.length);
                    b2.setImageResource(getDrawable(arr_recipes[n[rand]][1]));
                    t2.setText(arr_recipes[n[rand]][0]);
                    recipe[1][0] = arr_recipes[n[rand]][0];
                    recipe[1][1] = arr_recipes[n[rand]][1];
                    recipe[1][2] = arr_recipes[n[rand]][2];
                    recipe[1][3] = arr_recipes[n[rand]][3];
                    recipe[1][4] = arr_recipes[n[rand]][4];
                }
                break;

            case "dinner":
                ImageButton b3 = (ImageButton) findViewById(R.id.imgB3);
                if (BMR * 0.11 >= 400) {
                    int n [] = {0, 5};
                    int rand = random.nextInt(n.length);
                    b3.setImageResource(getDrawable(arr_recipes[n[rand]][1]));
                    t3.setText(arr_recipes[n[rand]][0]);
                    recipe[2][0] = arr_recipes[n[rand]][0];
                    recipe[2][1] = arr_recipes[n[rand]][1];
                    recipe[2][2] = arr_recipes[n[rand]][2];
                    recipe[2][3] = arr_recipes[n[rand]][3];
                    recipe[2][4] = arr_recipes[n[rand]][4];
                } else if (BMR * 0.11 > 300 && BMR * 0.11 < 400) {
                    int n [] = {1, 2, 3};
                    int rand = random.nextInt(n.length);
                    b3.setImageResource(getDrawable(arr_recipes[n[rand]][1]));
                    t3.setText(arr_recipes[n[rand]][0]);
                    recipe[2][0] = arr_recipes[n[rand]][0];
                    recipe[2][1] = arr_recipes[n[rand]][1];
                    recipe[2][2] = arr_recipes[n[rand]][2];
                    recipe[2][3] = arr_recipes[n[rand]][3];
                    recipe[2][4] = arr_recipes[n[rand]][4];
                } else if (BMR * 0.11 <= 300) {
                    b3.setImageResource(getDrawable(arr_recipes[4][1]));
                    t3.setText(arr_recipes[4][0]);
                    recipe[2][0] = arr_recipes[4][0];
                    recipe[2][1] = arr_recipes[4][1];
                    recipe[2][2] = arr_recipes[4][2];
                    recipe[2][3] = arr_recipes[4][3];
                    recipe[2][4] = arr_recipes[4][4];
                }
                break;
        }
    }

    public int getDrawable(String name) {
        Resources resources = getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                this.getPackageName());
        return resourceId;
    }

    public void imgB1OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = recipe[0];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB2OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = recipe[1];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB3OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = recipe[2];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
