package com.example.rache.smartrecipes;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Recipe_Activity extends AppCompatActivity {

    public int getDrawable(String name) {
        Resources resources = getResources();
        final int resourceId = resources.getIdentifier("original_" + name, "drawable",
                this.getPackageName());
        return resourceId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Bundle bundle = getIntent().getExtras();
        String[] recipeInfo = bundle.getStringArray("recipe_info");

        TextView title = (TextView)findViewById(R.id.title);
        title.setText(recipeInfo[0]);

        ImageView img=(ImageView)findViewById(R.id.imageView);
        img.setImageResource(getDrawable(recipeInfo[1]));

        TextView ingredients = (TextView)findViewById(R.id.ingText);
        String raw_ingredients = recipeInfo[2];
        ingredients.setText(raw_ingredients.replace(";","\n"));

        TextView method = (TextView)findViewById(R.id.methodText);
        String raw_method = recipeInfo[3];
        method.setText(raw_method.replace(";","\n\n"));

        TextView calories = (TextView)findViewById(R.id.cal_text);
        calories.setText("Calories: " + recipeInfo[4]);
    }
}
