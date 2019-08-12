package com.example.aaron.coursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BrushSelect extends AppCompatActivity {
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_select);


        Bundle bundle = getIntent().getExtras();

        String currentBrushWidthText = bundle.getString("currentBrushWidth"); //Bundle for receiving brush width from main activity
        final EditText currentBrushWidth = (EditText) findViewById(R.id.editText0);
        currentBrushWidth.setText(currentBrushWidthText);

        String currentBrushText = bundle.getString("currentBrush");  //Bundle for receiving brush type from main activity
        final TextView currentBrush = (TextView) findViewById(R.id.textView2);
        currentBrush.setText("  " + currentBrushText);


    }

    public void onBrushRound(View v) {
        bundle.putString("brushType", "ROUND"); }
    //Bundle/button for sending brush type to main activity

    public void onBrushSquare(View v) {
        bundle.putString("brushType", "SQUARE");
    }
    //Bundle/button for sending brush type to main activity

    public void onConfirmClick(View v) {
        final EditText brushWidth = (EditText) findViewById(R.id.editText0); //Collect int from editText
        String text = brushWidth.getText().toString(); //Convert int to string

        bundle.putString("brushWidth", text);  //Bundle/button for sending brush size to main activity

        Intent result = new Intent();
        result.putExtras(bundle);
        setResult(BrushSelect.RESULT_OK, result);
        finish();
    }
}