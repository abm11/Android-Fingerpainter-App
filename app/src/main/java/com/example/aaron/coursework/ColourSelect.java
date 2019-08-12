package com.example.aaron.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ColourSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_select); //Set UI to match code

        Bundle bundle = getIntent().getExtras(); //Bundle for receiving current colour
        String text = bundle.getString("currentColour");
        final TextView currentColour = (TextView) findViewById(R.id.textView1);
        currentColour.setText(text);
    }

    public void onColourClickRed(View v){ //Button for setting activity main bundle string/colour to red
        Bundle bundle = new Bundle();
        bundle.putString("myColourString", "RED");
        Intent colourChoice = new Intent();
        colourChoice.putExtras(bundle);
        setResult(ColourSelect.RESULT_OK, colourChoice);
        finish();
    }

    public void onColourClickGreen(View v){  //Button for setting activity main bundle string/colour to green
        Bundle bundle = new Bundle();
        bundle.putString("myColourString", "GREEN");
        Intent colourChoice = new Intent();
        colourChoice.putExtras(bundle);
        setResult(ColourSelect.RESULT_OK, colourChoice);
        finish();
    }

    public void onColourClickBlue(View v){ //Button for setting activity main bundle string/colour to blue
        Bundle bundle = new Bundle();
        bundle.putString("myColourString", "BLUE");
        Intent colourChoice = new Intent();
        colourChoice.putExtras(bundle);
        setResult(ColourSelect.RESULT_OK, colourChoice);
        finish();
    }

    public void onColourClickYellow(View v){ //Button for setting activity main bundle string/colour to yellow
        Bundle bundle = new Bundle();
        bundle.putString("myColourString", "YELLOW");
        Intent colourChoice = new Intent();
        colourChoice.putExtras(bundle);
        setResult(ColourSelect.RESULT_OK, colourChoice);
        finish();
    }

    public void onColourClickBlack(View v){ //Button for setting activity main bundle string/colour to black
        Bundle bundle = new Bundle();
        bundle.putString("myColourString", "BLACK");
        Intent colourChoice = new Intent();
        colourChoice.putExtras(bundle);
        setResult(ColourSelect.RESULT_OK, colourChoice);
        finish();
    }
}

