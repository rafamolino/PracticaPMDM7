package com.example.rafa.practicapmdm7;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rafa.practicapmdm7.DataBaseManager.DB_SQLite;
import com.example.rafa.practicapmdm7.DataBaseManager.Esquema;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtLatitud = findViewById(R.id.txtLatitud);
        TextView txtLongitud = findViewById(R.id.txtLongitud);
        TextView txtCategoria = findViewById(R.id.txtCategoria);
        TextView txtComentario = findViewById(R.id.txtComentario);
        RatingBar rbValoracion = findViewById(R.id.rbValoracion);

        if(App.sitioActivo==null)
        {

        }
        else
        {
            txtNombre.setText(App.sitioActivo.getNombre());
            txtLatitud.setText(App.sitioActivo.getLatitud().toString());
            txtLongitud.setText(App.sitioActivo.getLongitud().toString());
            txtCategoria.setText(App.getListCategorias(this).get(App.sitioActivo.getCategoria() - 1));
            txtComentario.setText(App.sitioActivo.getComentario());
            rbValoracion.setRating(App.sitioActivo.getValoracion());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_informacion, menu);
        return true;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcionEditar:
                App.SALIDA = 1;
                startActivity(new Intent(getApplicationContext(), Edicion.class));
                finish();
                break;
            case R.id.opcionBorrar:
                confirmacionEliminar();

                break;
        }
        return false;
    }

    private void eliminar()
    {
        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getWritableDatabase();
        String sqlWhere = Esquema.Sitio.COLUMN_NAME_ID + " LIKE '" + App.sitioActivo.getId() + "'";
        conn.delete(Esquema.Sitio.TABLE_NAME, sqlWhere, null);
        Toast.makeText(this, getResources().getString(R.string.toastEliminado), Toast.LENGTH_LONG).show();
        conn.close();
    }
    private void confirmacionEliminar()
    {
        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.eliminarInformacion))
                .setMessage(getResources().getString(R.string.confirmareliminar))
                .setPositiveButton(getResources().getString(R.string.eliminar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        eliminar();
                        finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
