package com.drbs.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

//        Intent intent = getIntent();
//        int drinkId = intent.getIntExtra(EXTRA_DRINKID, 0);

        // Get the drink from the intent
        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
        Drink drink = Drink.drinks[drinkId];

//        // Create a cursor
//        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
//        try {
//            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
////            Cursor cursor
//        } catch (SQLiteException e) {
//            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }

        // Populate the drink name
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        // Populate the drink description
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(drink.getDescription());

        // Populate the drink image
        ImageView photo = (ImageView) findViewById(R.id.photo);
//        photo.setImageDrawable(getResources().getDrawable(drink.getImageResourceId()));
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}