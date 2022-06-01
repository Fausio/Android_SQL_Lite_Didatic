package com.ustm.households;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.ustm.data.houseHoldDAO;
import com.ustm.domains.household;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        ArrayAdapter<household> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,householdsFilter);
        list.setAdapter(adapter);

        // open menu context on old press
        registerForContextMenu(list);
    }
    @Override
    public  void onResume(){
        super.onResume();
        households = dao.read();
        householdsFilter.clear();
        householdsFilter.addAll(households);
        // invalid last list data
        list.invalidateViews();
    }

    @Override
    public  void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.main_menu, menu);

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.main_menu,menu);

         //for search
        SearchView search =(SearchView) menu.findItem(R.id.app_bar_search).getActionView();
      // pressed keys
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchHH(s);
                return false;
            }
        });
        return true;
    }

    public  void deleteHousehold(MenuItem item){
        // get position item
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

      final  household modelTOdelete = householdsFilter.get(menuInfo.position);

        AlertDialog.Builder dialg = new AlertDialog.Builder(this)
                .setTitle("Aviso !")
                .setMessage("❌: Quer Deletar esse item ?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        householdsFilter.remove(modelTOdelete);
                        households.remove(modelTOdelete);
                        dao.delete(modelTOdelete);
                        list.invalidateViews();
                    }
                });

        dialg.create();
        dialg.show();

    }

    public  void editHousehold(MenuItem item){
        // get position item
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final  household modelTOUpdate= householdsFilter.get(menuInfo.position);

        Intent i = new Intent(this,HouseHoldList.class);
        i.putExtra("Familia",modelTOUpdate);
        startActivity(i);
    }

    public void searchHH(String value){
        householdsFilter.clear();
        for(household item : households){
            if (item.getName().toLowerCase().contains(value.toLowerCase())){
                householdsFilter.add(item);
            }
        }
        list.invalidateViews();
    }

    public  void addHousehold(MenuItem item){
    Intent i = new Intent(HouseHoldList.this,HouseHoldForm.class);
    startActivity(i);
    }
}