package com.example.rafa.practicapmdm7;

import android.content.Context;

import com.example.rafa.practicapmdm7.Model.Sitio;

import java.util.ArrayList;
import java.util.List;

public class App {
    public final static int INSERTAR = 1;
    public final static int EDITAR = 2;
    public final static int INFORMACION = 3;
    public static int accion;
    public static int SALIDA;
    public static int sitio3;
    public static Sitio sitioActivo;
    public static List<String> getListCategorias(Context context) {
        List<String> list = new ArrayList<String>();
        list.add(context.getResources().getString(R.string.restaurantes));
        list.add(context.getResources().getString(R.string.cines));
        list.add(context.getResources().getString(R.string.tiendas));
        list.add(context.getResources().getString(R.string.parques));
        list.add(context.getResources().getString(R.string.pubs));
        list.add(context.getResources().getString(R.string.todos));
        return list;
    }
}
