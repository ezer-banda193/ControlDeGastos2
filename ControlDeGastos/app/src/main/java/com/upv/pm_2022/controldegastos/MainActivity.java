package com.upv.pm_2022.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button Ok;
    String array[]= new String[]{"Ezer","Arturo","Sandra","Ares"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lv1);
        Ok = (Button)findViewById(R.id.buttonCuenta);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,array));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Elemento = ((CheckedTextView) view).getText().toString();
                Ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, ControlGastos.class));
                        Toast.makeText(getApplicationContext(),"Bienvenido(a) "+Elemento,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}