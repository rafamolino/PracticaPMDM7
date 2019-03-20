package com.example.rafa.practicapmdm7.DataBaseManager;

import android.provider.BaseColumns;

public class Esquema {
    public Esquema() {
    }

    public static abstract class Sitio implements BaseColumns {
        //nombre de la tabla
        public static final String TABLE_NAME = "Sitio";

        //nombre de las variables
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_LATITUD = "latitud";
        public static final String COLUMN_NAME_LONGITUD = "longitud";
        public static final String COLUMN_NAME_COMENTARIO = "comentario";
        public static final String COLUMN_NAME_VALORACION = "valoracion";
        public static final String COLUMN_NAME_CATEGORIA = "categoria";

        //variables

        public static final String COLUMN_TYPE_ID = "INTEGER";
        public static final String COLUMN_TYPE_NOMBRE = "TEXT";
        public static final String COLUMN_TYPE_LATITUD = "DOUBLE";
        public static final String COLUMN_TYPE_LONGITUD = "DOUBLE";
        public static final String COLUMN_TYPE_COMENTARIO = "TEXT";
        public static final String COLUMN_TYPE_VALORACION = "FLOAT";
        public static final String COLUMN_TYPE_CATEGORIA = "INT";

    }
}
