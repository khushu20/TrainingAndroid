package com.example.newapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.newapplication.R;

public class SecondTaskActivity extends AppCompatActivity {
    private ToggleButton onoff;
    private RadioGroup gender;
    private AutoCompleteTextView actDist;
    private CheckBox c1, c2, c3;
    private RadioButton r1, r2;
    private Spinner disctrict;
    private Button submit;
    String colorsList[] = {"Red", "Blue", "White", "Yellow", "Black", "Green", "Purple", "Orange", "Grey"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        submit = findViewById(R.id.btn_submit);
        c1 = findViewById(R.id.cb_pizza);
        c2 = findViewById(R.id.cb_coffee);
        c3 = findViewById(R.id.cg_burger);

        r1 = findViewById(R.id.rb_male);
        r2 = findViewById(R.id.rb_female);
        gender = findViewById(R.id.rg_gender);
        onoff = findViewById(R.id.tb_onoff);
        disctrict = findViewById(R.id.istrict);
        actDist = findViewById(R.id.act_dist);
        // dropdown
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colorsList);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        disctrict.setAdapter(districtAdapter);
        // autocompltettextview
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,colorsList);
       // actDist.setThreshold(3);
        actDist.setAdapter(adapter);

        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("toggleValue", "" + onoff.getText().toString());
            }
        });
        disctrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SecondTaskActivity.this, "" + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    int selectedId = gender.getCheckedRadioButtonId();
                    // find the radiobutton by returned id
                    r1 = (RadioButton) findViewById(selectedId);
                    Toast.makeText(getApplicationContext(), r1.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();


                }
            }
        });

    }

    private boolean validation() {
        if (gender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}