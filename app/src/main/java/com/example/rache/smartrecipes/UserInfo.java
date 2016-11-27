package com.example.rache.smartrecipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }

    public void submit(final View v) {
        EditText ageField = (EditText) findViewById(R.id.age);
        EditText heightField = (EditText) findViewById(R.id.height);
        EditText weightField = (EditText) findViewById(R.id.weight);
        Spinner genderItem = (Spinner) findViewById(R.id.gender);
        Spinner activityItem = (Spinner) findViewById(R.id.activity);


        String age = ageField.getText().toString();
        String height = heightField.getText().toString();
        String weight = weightField.getText().toString();
        String gender = genderItem.getSelectedItem().toString();
        String activity = activityItem.getSelectedItem().toString();

        if (!age.isEmpty() && !height.isEmpty() && !weight.isEmpty()) {
            Intent myIntent = new Intent(this, Customize_Activity.class);
            myIntent.putExtra("age", age);
            myIntent.putExtra("height", height);
            myIntent.putExtra("weight", weight);
            myIntent.putExtra("gender", gender);
            myIntent.putExtra("activity", activity);
            startActivity(myIntent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Enter the required field", Toast.LENGTH_LONG).show();
        }



    }
}
