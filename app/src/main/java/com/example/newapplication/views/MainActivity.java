package com.example.newapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newapplication.R;
import com.example.newapplication.model.VersionCheckRequest;
import com.example.newapplication.utils.Utils;
import com.example.newapplication.viewmodel.SplashViewModel;

public class MainActivity extends AppCompatActivity {
    private EditText et_namee, et_passwordd;
    private Button btn_registerr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SplashViewModel  splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        et_namee = findViewById(R.id.et_name);

        et_passwordd = findViewById(R.id.et_password);
        btn_registerr = findViewById(R.id.btn_register);
        et_namee.setText("Khushboo");
        et_passwordd.setText("password");

        if(Utils.checkInternetConnection(MainActivity.this)){
            VersionCheckRequest versionCheckRequest=new VersionCheckRequest();
            versionCheckRequest.setAppName("MJPHRMS");
            versionCheckRequest.setMobileType("Android");
            versionCheckRequest.setWebServiceName("versionCheck");
            splashViewModel.callVersioncheckApi(versionCheckRequest);
        }else{
            Toast.makeText(this, "Please check your Internet connection", Toast.LENGTH_SHORT).show();
        }
        splashViewModel.getVersionResponse().observe(this,versionCheckResponse ->  {
            if(versionCheckResponse!=null){
                if(versionCheckResponse.getStatusCode()==200){
                  Intent intent=new Intent(this,TaskActivity.class) ;
                  startActivity(intent);
                }

            }
                }

                );

        btn_registerr.setOnClickListener(v -> {
            if (validations()) {
                // navigation from Main screen to splash
                        Intent intent = new Intent(MainActivity.this, splash.class);
                startActivity(intent);
                finish();

            }


        });


    }

    private boolean validations() {
        if (et_namee.getText().toString().isEmpty()) {

            Toast.makeText(this, "Name is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_passwordd.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;
    }
}