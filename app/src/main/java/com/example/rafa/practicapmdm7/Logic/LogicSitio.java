package com.example.rafa.practicapmdm7.Logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Spinner;

import com.example.rafa.practicapmdm7.DataBaseManager.DB_SQLite;
import com.example.rafa.practicapmdm7.DataBaseManager.Esquema;
import com.example.rafa.practicapmdm7.Model.Sitio;

import java.util.ArrayList;
import java.util.List;

public class LogicSitio {

    public static void insertarSitio(Context context, Sitio p) {
        ContentValues content = new ContentValues();
        content.put(Esquema.Sitio.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Sitio.COLUMN_NAME_LATITUD, p.getLatitud());
        content.put(Esquema.Sitio.COLUMN_NAME_LONGITUD, p.getLongitud());
        content.put(Esquema.Sitio.COLUMN_NAME_COMENTARIO, p.getComentario());
        content.put(Esquema.Sitio.COLUMN_NAME_VALORACION, p.getValoracion());
        content.put(Esquema.Sitio.COLUMN_NAME_CATEGORIA, p.getCategoria());
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.insert(Esquema.Sitio.TABLE_NAME, null, content);
        DB_SQLite.desconectar(conn);
    }

    public static void eliminarSitio(Context context, Sitio p) {
        String sqlWhere = Esquema.Sitio.COLUMN_NAME_ID + " = " + p.getId();
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.delete(Esquema.Sitio.TABLE_NAME, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static void editarSitio(Context context, Sitio p) {
        ContentValues content = new ContentValues();
        content.put(Esquema.Sitio.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Sitio.COLUMN_NAME_LATITUD, p.getLatitud());
        content.put(Esquema.Sitio.COLUMN_NAME_LONGITUD, p.getLongitud());
        content.put(Esquema.Sitio.COLUMN_NAME_COMENTARIO, p.getComentario());
        content.put(Esquema.Sitio.COLUMN_NAME_VALORACION, p.getValoracion());
        content.put(Esquema.Sitio.COLUMN_NAME_CATEGORIA, p.getCategoria());
        String sqlWhere = Esquema.Sitio.COLUMN_NAME_ID + " = " + p.getId();
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.update(Esquema.Sitio.TABLE_NAME, content, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static List listaSitios(Context context) {
        List lug = new ArrayList<>();
        String[] sqlFields = {Esquema.Sitio.COLUMN_NAME_ID, Esquema.Sitio.COLUMN_NAME_LATITUD, Esquema.Sitio.COLUMN_NAME_LONGITUD, Esquema.Sitio.COLUMN_NAME_NOMBRE, Esquema.Sitio.COLUMN_NAME_COMENTARIO, Esquema.Sitio.COLUMN_NAME_VALORACION, Esquema.Sitio.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "";
        String sqlOrderBy = Esquema.Sitio.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Sitio.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_NOMBRE));
                Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LATITUD));
                Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LONGITUD));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_COMENTARIO));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_VALORACION));
                Integer dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_CATEGORIA));
                lug.add(new Sitio(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return lug;
    }

    public static List listaSitios2(Context context, Spinner spinner) {
        List lug = new ArrayList<>();
        String[] sqlFields = {Esquema.Sitio.COLUMN_NAME_ID, Esquema.Sitio.COLUMN_NAME_NOMBRE, Esquema.Sitio.COLUMN_NAME_LATITUD, Esquema.Sitio.COLUMN_NAME_LONGITUD, Esquema.Sitio.COLUMN_NAME_COMENTARIO, Esquema.Sitio.COLUMN_NAME_VALORACION, Esquema.Sitio.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "categoria=" + spinner.getSelectedItemPosition();
        String sqlOrderBy = Esquema.Sitio.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Sitio.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_NOMBRE));
                Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LATITUD));
                Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LONGITUD));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_COMENTARIO));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_VALORACION));
                int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_CATEGORIA));
                lug.add(new Sitio(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return lug;
    }

    public static List listaSitios3(Context context, int Spinner) {
        List lug = new ArrayList<>();
        String[] sqlFields = {Esquema.Sitio.COLUMN_NAME_ID, Esquema.Sitio.COLUMN_NAME_NOMBRE, Esquema.Sitio.COLUMN_NAME_LATITUD, Esquema.Sitio.COLUMN_NAME_LONGITUD, Esquema.Sitio.COLUMN_NAME_COMENTARIO, Esquema.Sitio.COLUMN_NAME_VALORACION, Esquema.Sitio.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "categoria=" + Spinner;
        String sqlOrderBy = Esquema.Sitio.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Sitio.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_NOMBRE));
                Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LATITUD));
                Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LONGITUD));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_COMENTARIO));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_VALORACION));
                int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_CATEGORIA));
                lug.add(new Sitio(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return lug;
    }

    public static Sitio listaSitios4(Context context, String latitud, String longitud) {
        Sitio lug = null;
        String[] sqlFields = {Esquema.Sitio.COLUMN_NAME_ID, Esquema.Sitio.COLUMN_NAME_NOMBRE, Esquema.Sitio.COLUMN_NAME_LATITUD, Esquema.Sitio.COLUMN_NAME_LONGITUD, Esquema.Sitio.COLUMN_NAME_COMENTARIO, Esquema.Sitio.COLUMN_NAME_VALORACION, Esquema.Sitio.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "latitud='" + latitud + "'and longitud='" + longitud + "'";
        String sqlOrderBy = Esquema.Sitio.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Sitio.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_ID));
            String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_NOMBRE));
            Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LATITUD));
            Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_LONGITUD));
            String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_COMENTARIO));
            Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_VALORACION));
            int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Sitio.COLUMN_NAME_CATEGORIA));
            lug = new Sitio(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria);


            cursor.close();
            DB_SQLite.desconectar(conn);
        }
        return lug;

    }
}
