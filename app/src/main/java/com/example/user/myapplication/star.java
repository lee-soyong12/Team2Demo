package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2017-07-17.
 */

public class star  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.star);
    }

    public void onClick3(View view){

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
