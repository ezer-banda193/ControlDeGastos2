package com.upv.pm_2022.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarGasto extends AppCompatActivity {

    EditText concepto, cantidad, fecha;
    Button AgregarGasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_gasto);

        this.setTitle("Agregar Gasto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        concepto = findViewById(R.id.editTextConcepto);
        cantidad = findViewById(R.id.editTextCantidad);
        fecha = findViewById(R.id.editTextFecha);
        AgregarGasto = findViewById(R.id.buttonAgregar);

        AgregarGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Concepto = concepto.getText().toString().trim();
                String Cantidad = cantidad.getText().toString().trim();
                String Fecha = fecha.getText().toString().trim();

                if(Concepto.isEmpty() && Cantidad.isEmpty() && Fecha.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    datosGasto(Concepto, Cantidad, Fecha);
                }
            }
        });
    }

    private void datosGasto(String concepto, String cantidad, String fecha) {
        Toast.makeText(getApplicationContext(), "Agregaste un Gasto", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}