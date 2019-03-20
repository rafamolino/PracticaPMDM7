package com.example.rafa.practicapmdm7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import com.example.rafa.practicapmdm7.Logic.LogicSitio;
import com.example.rafa.practicapmdm7.Model.Sitio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ListView card_listView;
    private static List<Sitio> lstSitio;


    Spinner categorias;
    ImageView imgMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMapa = findViewById(R.id.imgMapa);

        categorias = findViewById(R.id.categorias);
        List<String> list = new ArrayList<String>();
        list.add(getResources().getString(R.string.todos));
        list.add(getResources().getString(R.string.restaurantes));
        list.add(getResources().getString(R.string.cines));
        list.add(getResources().getString(R.string.tiendas));
        list.add(getResources().getString(R.string.parques));
        list.add(getResources().getString(R.string.pubs));
        final int listsize = list.size();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list) {
            @Override
            public int getCount() {
                return(listsize); // Truncate the list
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(dataAdapter);
        imgMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                App.sitio3 =(int) (long) categorias.getSelectedItemId();

            }
        });

        categorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (categorias.getSelectedItem().toString()==getResources().getString(R.string.todos)){
                    mostrarTodos();
                }else{
                    mostrarUno();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        card_listView = findViewById(R.id.card_listView);
        card_listView.addHeaderView(new View(this)); // añade espacio arriba de la primera tarjeta
        card_listView.addFooterView(new View(this)); // añade espacio debajo de la última tarjeta
        card_listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        App.sitioActivo = lstSitio.get(position - 1);
                        App.accion = App.INFORMACION;
                        startActivity(new Intent(getApplicationContext(), Informacion.class));
                    }
                }
        );

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        if(categorias.getSelectedItem().toString() == getResources().getString(R.string.todos))
        {
            mostrarTodos();
        }
        else
        {
            mostrarUno();
        }
    }

    public void clicNuevo(View view) {
        App.sitioActivo = new Sitio();
        App.accion = App.INSERTAR;
        App.SALIDA=2;
        startActivity(new Intent(this, Edicion.class));
    }
    public void mostrarUno() {
        CardAdapter listadoDeTarjetas = new CardAdapter(getApplicationContext(), R.layout.lista);
        lstSitio = LogicSitio.listaSitios2(this, categorias);
        if (lstSitio == null) {
            card_listView.setAdapter(null);
        } else {
            for (Sitio p : lstSitio) {
                listadoDeTarjetas.add(p);
            }
            card_listView.setAdapter(listadoDeTarjetas);
        }
    }
    public void mostrarTodos()
    {
        CardAdapter listadoDeTarjetas = new CardAdapter(getApplicationContext(), R.layout.lista);
        lstSitio= LogicSitio.listaSitios(this);
        if (lstSitio == null) {
            card_listView.setAdapter(null);
        } else {
            for (Sitio p : lstSitio) {
                listadoDeTarjetas.add(p);
            }
            card_listView.setAdapter(listadoDeTarjetas);
        }
    }
}
