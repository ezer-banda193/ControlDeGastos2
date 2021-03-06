package com.upv.pm_2022.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarIngreso extends AppCompatActivity {

    EditText concepto, cantidad, fecha;
    Button AgregarIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ingreso);

        this.setTitle("Agregar Ingreso");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        concepto = findViewById(R.id.editTextConcepto1);
        cantidad = findViewById(R.id.editTextCantidad1);
        fecha = findViewById(R.id.editTextFecha1);
        AgregarIngreso = findViewById(R.id.buttonAgregar1);

        AgregarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Concepto = concepto.getText().toString().trim();
                String Cantidad = cantidad.getText().toString().trim();
                String Fecha = fecha.getText().toString().trim();

                if(Concepto.isEmpty() && Cantidad.isEmpty() && Fecha.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    datosIngreso(Concepto, Cantidad, Fecha);
                }
            }
        });
    }

    private void datosIngreso(String concepto, String cantidad, String fecha) {
        Toast.makeText(getApplicationContext(), "Agregaste un Ingreso", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}