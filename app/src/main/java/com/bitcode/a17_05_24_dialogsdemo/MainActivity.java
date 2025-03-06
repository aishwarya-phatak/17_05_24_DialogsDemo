package com.bitcode.a17_05_24_dialogsdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog, btnDatePickerDialog, btnTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        attachListeners();
    }

    private void initViews(){
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
    }

    private void attachListeners(){
        btnAlertDialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Submit Exam");
                        builder.setMessage("Are you sure you want to Submit the Exam?");
                        builder.setIcon(R.drawable.ic_launcher_background);
                        builder.setNegativeButton("Cancel",new MyButtonsClickListener());
                        builder.setPositiveButton("Ok",new MyButtonsClickListener());
                        builder.setNeutralButton("Neutral",new MyButtonsClickListener());
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
        );

        btnDatePickerDialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                MainActivity.this,
                                new MyDatePickerClickListener(),
                                2025,
                                2,
                                5
                        );

                        datePickerDialog.show();
                    }
                }
        );

        btnTimePickerDialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(
                                MainActivity.this,
                                new MyTimePickerClickListener(),
                                5,
                                45,
                                true
                        );

                        timePickerDialog.show();
                    }
                }
        );
    }

    class MyTimePickerClickListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(MainActivity.this,"Time Picker Dialog " + " - " + hourOfDay + " : " + minute,
                    Toast.LENGTH_LONG).show();
        }
    }

    class MyDatePickerClickListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Toast.makeText(MainActivity.this,"Date Picker Dialog : " + year + "-" + dayOfMonth + "-" + month  , Toast.LENGTH_LONG).show();
        }
    }

    class MyButtonsClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == -1){
                Toast.makeText(MainActivity.this,"Positive Button Clicked", Toast.LENGTH_LONG).show();
            } else if (which == -2){
                Toast.makeText(MainActivity.this, "Negative Button Clicked",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,"Neutral Button Clicked", Toast.LENGTH_LONG).show();
            }
        }
    }

    class MyNegativeButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Negative Button Clicked -- "
                    + which, Toast.LENGTH_LONG).show();
        }
    }

    class MyPositiveButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Positive Button Clicked -- "
                    + which, Toast.LENGTH_SHORT).show();
        }
    }

    class MyNeutralButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Neutral Button Clicked -- "
                    + which, Toast.LENGTH_SHORT).show();
        }
    }
}