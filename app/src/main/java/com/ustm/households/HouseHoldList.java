package com.ustm.households;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ustm.data.houseHoldDAO;
import com.ustm.domains.household;

import java.util.ArrayList;
import java.util.List;

public class HouseHoldList extends AppCompatActivity {

    private ListView list;
    private com.ustm.data.houseHoldDAO dao;
    private List<household> households;
    private List<household> householdsFilter = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.household_list);


        list = findViewById(R.id.hh_list_view);
        dao = new houseHoldDAO(this);
        households = dao.read();
        householdsFilter.addAll(households);

        // adapter for generics of listView
        ArrayAdapter<household> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,households);
        list.setAdapter(adapter);
    }
}