package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class kart extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kart);
    }

    public void onClick1(View view){
        Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_SHORT).show();
        super.onBackPressed();

    }

    public void foo(View view){
        Intent kartservice = new Intent(this, MyIntentService.class);
        kartservice.setAction("com.example.user.myapplication.action.FOO");
        startService(kartservice);
    }
    public void vaz(View view){
        Intent kartservice = new Intent(this, MyIntentService.class);
        kartservice.setAction("com.example.user.myapplication.action.BAZ");
        startService(kartservice);
    }


}
