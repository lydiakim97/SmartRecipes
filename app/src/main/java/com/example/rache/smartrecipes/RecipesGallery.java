package com.example.rache.smartrecipes;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecipesGallery extends AppCompatActivity {
    private String[][] arr_recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_gallery);
        Intent intent= getIntent();
        String type = intent.getStringExtra("type");

        TextView typeView = (TextView)findViewById(R.id.type);
        switch (type) {
            case "breakfast":
                typeView.setText("Breakfast");
                break;
            case "lunch":
                typeView.setText("Lunch");
                break;
            case "dinner":
                typeView.setText("Dinner");
                break;
        }
        display(type);
    }

    public int getDrawable(String name) {
        Resources resources = getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                this.getPackageName());
        return resourceId;
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

        ImageButton b1=(ImageButton)findViewById(R.id.imgB1);
        b1.setImageResource(getDrawable(arr_recipes[0][1]));
        TextView t1=(TextView)findViewById(R.id.imgTx1);
        t1.setText(arr_recipes[0][0]);

        ImageButton b2=(ImageButton)findViewById(R.id.imgB2);
        b2.setImageResource(getDrawable(arr_recipes[1][1]));
        TextView t2=(TextView)findViewById(R.id.imgTx2);
        t2.setText(arr_recipes[1][0]);


        ImageButton b3=(ImageButton)findViewById(R.id.imgB3);
        b3.setImageResource(getDrawable(arr_recipes[2][1]));
        TextView t3=(TextView)findViewById(R.id.imgTx3);
        t3.setText(arr_recipes[2][0]);

        ImageButton b4=(ImageButton)findViewById(R.id.imgB4);
        b4.setImageResource(getDrawable(arr_recipes[3][1]));
        TextView t4=(TextView)findViewById(R.id.imgTx4);
        t4.setText(arr_recipes[3][0]);

        ImageButton b5=(ImageButton)findViewById(R.id.imgB5);
        b5.setImageResource(getDrawable(arr_recipes[4][1]));
        TextView t5=(TextView)findViewById(R.id.imgTx5);
        t5.setText(arr_recipes[4][0]);

        ImageButton b6=(ImageButton)findViewById(R.id.imgB6);
        b6.setImageResource(getDrawable(arr_recipes[5][1]));
        TextView t6=(TextView)findViewById(R.id.imgTx6);
        t6.setText(arr_recipes[5][0]);
    }

    public void imgB1OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = arr_recipes[0];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB2OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = arr_recipes[1];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB3OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = arr_recipes[2];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB4OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = arr_recipes[3];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB5OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = arr_recipes[4];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imgB6OnClick(final View view){
        Intent intent = new Intent(this, Recipe_Activity.class);
        String[] recipeInfo = arr_recipes[5];

        Bundle bundle = new Bundle();
        bundle.putStringArray("recipe_info", recipeInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
