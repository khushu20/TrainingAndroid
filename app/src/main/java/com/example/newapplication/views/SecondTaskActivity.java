package com.example.newapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
import com.example.newapplication.adapter.ExportTreatmentListAdapter;
import com.example.newapplication.model.VersionCheckRequest;
import com.example.newapplication.model.VersionData;
import com.example.newapplication.utils.Utils;
import com.example.newapplication.viewmodel.SplashViewModel;

import java.util.ArrayList;
import java.util.List;

public class SecondTaskActivity extends AppCompatActivity {
    private ToggleButton onoff;
    private RadioGroup gender;
    private AutoCompleteTextView actDist;
    private CheckBox c1, c2, c3;
    private RadioButton r1, r2;
    private Spinner disctrict;
    private Button submit;
    private RecyclerView recyclerView;
    List<VersionData> versionDatalist=new ArrayList<>();
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
        recyclerView = findViewById(R.id.recyclerView1);
        SplashViewModel splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        if(Utils.checkInternetConnection(SecondTaskActivity.this)){
            VersionCheckRequest versionCheckRequest=new VersionCheckRequest();
            versionCheckRequest.setAppName("MJPHRMS");
            versionCheckRequest.setMobileType("Android");
            versionCheckRequest.setWebServiceName("versionCheck");
            splashViewModel.callVersioncheckApi(versionCheckRequest);
        }else{
            Toast.makeText(this, "Please check your Internet connection", Toast.LENGTH_SHORT).show();
        }
        splashViewModel.getVersionResponse().observe(this,versionCheckResponse -> {
                    if (versionCheckResponse != null) {
                        if (versionCheckResponse.getStatusCode() == 200) {
                            VersionData v1 = new VersionData();
                            v1.setAppName(versionCheckResponse.getData().getAppName());
                            v1.setWebServiceName(versionCheckResponse.getData().getWebServiceName());
                           v1.setLastUpdatedDate(versionCheckResponse.getData().getLastUpdatedDate());
/////
                            versionDatalist.add(v1);
                            ExportTreatmentListAdapter issueDetailsAdapter = new ExportTreatmentListAdapter(this, versionDatalist );
                            recyclerView.setAdapter(issueDetailsAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(SecondTaskActivity.this));
                            recyclerView.addItemDecoration(new DividerItemDecoration(SecondTaskActivity.this, 0));
                            recyclerView.setHasFixedSize(true);
                            issueDetailsAdapter.setData(versionDatalist);



                        }
                    }
                }

        );
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