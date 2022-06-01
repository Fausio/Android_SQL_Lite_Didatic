package com.ustm.households;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ustm.data.houseHoldDAO;
import com.ustm.domains.household;

import java.math.BigInteger;

public class HouseHoldForm extends AppCompatActivity {

    private EditText famName;
    private EditText famAddress;
    private EditText famCell;
    private com.ustm.data.houseHoldDAO dao;
    private household model = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.household_form);

        famName = findViewById(R.id.editTextTextPersonName);
        famAddress = findViewById(R.id.editTextTextPersonName2);
        famCell = findViewById(R.id.editTextPhone);
        dao = new houseHoldDAO(this);

        Intent i = getIntent();

        if (i.hasExtra("Familia")){
            model =(household) i.getSerializableExtra("Familia");
            famName.setText(model.getName());
            famAddress.setText(model.getAddress());
            famCell.setText(model.getCell().toString());
        }


        Button btnSave =  findViewById(R.id.BtnSaveHouseHold);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (model == null) {

                    model = new household();
                    model.setName(famName.getText().toString());
                    model.setAddress(famAddress.getText().toString());
                    model.setCell(new Integer(famCell.getText().toString()));

                    long id =  dao.add(model);

                    Toast toast =  Toast.makeText(getApplicationContext(), "Família:" + model.getName() + " id"+ id +", adicionada com sucesso !", Toast.LENGTH_SHORT);
                    toast.show();
                }else {

                    model.setName(famName.getText().toString());
                    model.setAddress(famAddress.getText().toString());
                    model.setCell(new Integer(famCell.getText().toString()));
                    dao.update(model);

                    Toast toast =  Toast.makeText(getApplicationContext(), "Família:" + model.getName() + " id"+ model.getId() +", Editada com sucesso !", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }
}
