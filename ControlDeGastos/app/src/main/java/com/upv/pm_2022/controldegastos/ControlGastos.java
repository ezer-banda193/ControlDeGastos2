package com.upv.pm_2022.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class ControlGastos extends AppCompatActivity {

    ListView listaGastos, listaIngresos;
    Button gastos, ingresos;
    String array[]=new String[]{"Gasto 1","Gasto 2","Gasto 3","Gasto 4","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5"};
    String array2[]=new String[]{"Ingreso 1","Ingreso 2","Ingreso 3","Ingreso 4","Ingreso 5"};
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_gastos);

        listaGastos = (ListView)findViewById(R.id.lv1);
        listaIngresos = (ListView) findViewById(R.id.lv2);
        gastos = (Button)findViewById(R.id.buttonGastos);
        ingresos = (Button)findViewById(R.id.buttonIngresos);

        // Agregar las pestañas---
        Resources res = getResources();
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("GASTOS");

        TabHost.TabSpec spec2 = tabHost.newTabSpec("");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("INGRESOS");

        TabHost.TabSpec spec3 = tabHost.newTabSpec("");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("BALANCE");
        //spec3.setIndicator("",getResources().getDrawable(R.mipmap.ic_launcher));

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);

        listaGastos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,array));
        listaIngresos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,array2));
        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listaGastos.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listaIngresos.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listaGastos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Estatus = (((CheckedTextView) view).isChecked() ? "Seleccionado" : "Des-seleccionado");
                String Elemento = ((CheckedTextView) view).getText().toString();
                Toast.makeText(getApplicationContext(),"Seleccionaste el "+Elemento,Toast.LENGTH_SHORT).show();
            }
        });
        listaIngresos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Estatus = (((CheckedTextView) view).isChecked() ? "Seleccionado" : "Des-seleccionado");
                String Elemento = ((CheckedTextView) view).getText().toString();
                Toast.makeText(getApplicationContext(),"Seleccionaste el "+ Elemento,Toast.LENGTH_SHORT).show();
            }
        });

        gastos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ControlGastos.this, AgregarGasto.class));
            }
        });

        ingresos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ControlGastos.this, AgregarIngreso.class));
            }
        });

        // Importante: Esto va antes de instanciar controles dentro de cada pestaña



        // Otros Recursos (TextView, Buttons, ListView, EditText, etx)
    }
}