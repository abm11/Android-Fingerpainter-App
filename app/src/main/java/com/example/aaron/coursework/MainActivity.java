package com.example.aaron.coursework;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    static final int ACTIVITY_REQUEST_CODE = 1;

    private FingerPainterView fingerPainterView; //Init FingerPainterView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fingerPainterView = (FingerPainterView) findViewById(R.id.fingerPainterView0); //Load FingerPainterView into interface

        Intent intentDownload = getIntent(); //Code for loading img into app
        if(intentDownload.getData()!=null);
        fingerPainterView.load(intentDownload.getData());
    }

    public void onColourClick(View v) {
        int rawInt = fingerPainterView.getColour(); //int for colour code as value

        String text = "FAIL"; //Error code
        if(rawInt==-16777216) //Comparisons for comparing int value of colour and real world name
            text="Black";
        if(rawInt==-65536)
            text="Red";
        if(rawInt==-16711936)
            text="Green";
        if(rawInt==-16776961)
            text="Blue";
        if(rawInt==-256)
            text="Yellow";


        Bundle bundle = new Bundle(); //Bundle for passing colour name to other activity
        bundle.putString("currentColour", text);
        Intent intent = new Intent(MainActivity.this, ColourSelect.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
    }

    public void onBrushClick(View v) { //Bundle for passing brush type and size to other activity
        String Brush = valueOf(fingerPainterView.getBrush());
        int IntBrushWidth = fingerPainterView.getBrushWidth();
        String BrushWidth = Integer.toString(IntBrushWidth);
        Bundle bundle = new Bundle();
        bundle.putString("currentBrush", Brush);
        bundle.putString("currentBrushWidth", BrushWidth);
        Intent intent = new Intent(MainActivity.this, BrushSelect.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, ACTIVITY_REQUEST_CODE);

    }

    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) { //Method for bundles returned to main.
        if (requestCode == ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String textColour = bundle.getString("myColourString"); //Colour bundle code
                if (textColour!=null) { //To avoid Null exception
                    if (textColour.equals("RED"))
                        fingerPainterView.setColour(0xFFFF0000);
                    if (textColour.equals("GREEN"))
                        fingerPainterView.setColour(0xFF00FF00);
                    if (textColour.equals("BLUE"))
                        fingerPainterView.setColour(0xFF0000FF);
                    if (textColour.equals("YELLOW"))
                        fingerPainterView.setColour(0xFFFFFF00);
                    if (textColour.equals("BLACK"))
                        fingerPainterView.setColour(0xFF000000);
                }

                String textBrushType = bundle.getString("brushType"); //Brush type bundle code
                if (textBrushType!=null) { //To avoid Null exception
                    if (textBrushType.equals("ROUND"))
                        fingerPainterView.setBrush(Paint.Cap.ROUND);
                    if (textBrushType.equals("SQUARE"))
                        fingerPainterView.setBrush(Paint.Cap.SQUARE);
                }

                String textBrushWidth = bundle.getString("brushWidth"); //Brush size bundle code
                if (textBrushWidth!=null) //To avoid Null exception
                    fingerPainterView.setBrushWidth(Integer.parseInt(textBrushWidth));

            } else if (resultCode == RESULT_CANCELED) {
            }
        }
    }
}


