package com.example.newapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.newapplication.R;

public class TaskActivity extends AppCompatActivity {
    private CardView firstTask,secTask,thirdTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        firstTask=findViewById(R.id.cvvv_task);
        secTask=findViewById(R.id.cvvv_task2);
        thirdTask=findViewById(R.id.cvvv_task3);

        firstTask.setOnClickListener(v->{
            // navigation from Task screen to Main
            Intent intent = new Intent(TaskActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        secTask.setOnClickListener(v->{
            Toast.makeText(this, "Navigate to Second Screen", Toast.LENGTH_SHORT).show();
            // navigation from Task screen to Main
            Intent intent = new Intent(TaskActivity.this, SecondTaskActivity.class);
            startActivity(intent);
            finish();
        });
        thirdTask.setOnClickListener(v->{
            //Toast.makeText(this, "Navigate to Second Screen", Toast.LENGTH_SHORT).show();
            // navigation from Task screen to constrain screen
            Intent intent = new Intent(TaskActivity.this, Dashboard.class);
            startActivity(intent);
            finish();
        });



    }
}