package com.ustm.households;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncall = findViewById(R.id.call_hh_form);
        btncall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, HouseHoldForm.class);
                 startActivity(intent);
            }
        });

        Button btnlist = findViewById(R.id.call_hh_list);
        btnlist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, HouseHoldList.class);
                startActivity(intent);
            }
        });
    }



}