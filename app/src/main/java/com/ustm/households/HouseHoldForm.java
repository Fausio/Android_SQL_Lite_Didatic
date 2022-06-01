package com.ustm.households;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.household_form);

        famName = findViewById(R.id.editTextTextPersonName);
        famAddress = findViewById(R.id.editTextTextPersonName2);
        famCell = findViewById(R.id.editTextPhone);
        dao = new houseHoldDAO(this);

        Button btnSave =  findViewById(R.id.BtnSaveHouseHold);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                household model = new household();
                model.setName(famName.getText().toString());
                model.setAddress(famAddress.getText().toString());
                model.setCell(new Integer(famCell.getText().toString()));

                long id =  dao.add(model);

                Toast toast =  Toast.makeText(getApplicationContext(), "Família:" + model.getName() + " id"+ id +", adicionada com sucesso !", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
