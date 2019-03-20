package com.example.rafa.practicapmdm7;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.example.rafa.practicapmdm7.Logic.LogicSitio;
import com.example.rafa.practicapmdm7.Model.Sitio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static com.example.rafa.practicapmdm7.App.sitio3;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    LatLng nuevaPosicion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mostrarTodos();
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5), 2000, null);
        mMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(marker))
        {

            String cadena = marker.getSnippet();
            String cadena1[] = cadena.split(",");
            String latitud  = cadena1[0];
            String longitud = cadena1 [1];
            Sitio p = LogicSitio.listaSitios4(this, latitud, longitud);
            App.sitioActivo=p;

            Intent intent=new Intent(this,Informacion.class);
            startActivity(intent);


        }

        return false;
    }
    public void mostrarTodos() {
        float colorIcono []={0f, 60f, 120f, 180f, 240f, 320f};

        if(sitio3==0)
        {
            List<Sitio> lstSitio = LogicSitio.listaSitios(this);
            for (Sitio p : lstSitio) {
                nuevaPosicion = new LatLng(p.getLatitud(), p.getLongitud());
                mMap.addMarker(new MarkerOptions().position(nuevaPosicion).snippet(p.getLatitud()+ ","+ p.getLongitud()).title(p.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(colorIcono[p.getCategoria()])));
            }
        }
        else
        {
            List<Sitio> lstLugar = LogicSitio.listaSitios3(this, App.sitio3);
            for (Sitio p : lstLugar)
            {
                nuevaPosicion=new LatLng(p.getLatitud(),p.getLongitud());
                mMap.addMarker(new MarkerOptions().position(nuevaPosicion).snippet(p.getLatitud()+ ","+ p.getLongitud()).title(p.getNombre()).icon(BitmapDescriptorFactory.defaultMarker(colorIcono[p.getCategoria()])));
            }
        }
    }
}