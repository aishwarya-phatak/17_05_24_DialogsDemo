package com.bitcode.a17_05_24_dialogsdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                        builder.setNegativeButton("Cancel",new MyNegativeButtonClickListener());
                        builder.setPositiveButton("Ok",new MyPositiveButtonClickListener());
                        builder.setNeutralButton("Neutral",new MyNeutralButtonClickListener());
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
        );
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