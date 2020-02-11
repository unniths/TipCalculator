package com.example.tipcalculatorapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
*/
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity{

    private EditText editbillamount;
    private SeekBar seekBar;
    private TextView seekBarTV;
    private Button calculateButton;
    private TextView tipTV;
    private TextView totalTV;
    private TextView tipamount;
    private TextView totalamount;
    private int seekBarPercent;
    private Float billAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editbillamount = findViewById(R.id.editbillamount);
        seekBar = findViewById(R.id.seekBar);
        seekBarTV = findViewById(R.id.seekBarTV);
        calculateButton = findViewById(R.id.calculatebutton);
        tipTV = findViewById(R.id.tipTV);
        totalTV = findViewById(R.id.totalTV);
        tipamount = findViewById(R.id.tipamount);
        totalamount = findViewById(R.id.totalamount);

        seekBarTV.setText(String.valueOf(seekBar.getProgress()) + "%");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTV.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercent = seekBar.getProgress();

            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void calculate(){
        Float result = 0.00f;
        float finishedAmount;

        if (!editbillamount.getText().toString().equals("")){

            billAmount = Float.parseFloat(editbillamount.getText().toString());

            result = billAmount * seekBarPercent/100;
            finishedAmount = billAmount + result;
            String resultTwoDecimals = String.format("%,.2f", result);
            String billTwoDecimals = String.format("%,.2f", finishedAmount);
            tipamount.setText("$" + (resultTwoDecimals));
            totalamount.setText("$" + (billTwoDecimals));

        }
        else {
            Toast.makeText(this,"Please enter the bill amount", Toast.LENGTH_SHORT);
        }
    }



}