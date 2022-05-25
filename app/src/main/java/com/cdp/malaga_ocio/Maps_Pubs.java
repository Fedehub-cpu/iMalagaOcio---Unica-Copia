package com.cdp.malaga_ocio;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cdp.malaga_ocio.databinding.ActivityMapsPubsBinding;

public class Maps_Pubs extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsPubsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsPubsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);


        LatLng irishpub = new LatLng(36.72260735115874, -4.420624485845706);
        mMap.addMarker(new MarkerOptions().position(irishpub).title("Irishpub"));
        LatLng barindi = new LatLng(36.72357357789759, -4.422599073059439);
        mMap.addMarker(new MarkerOptions().position(barindi).title("El Muro Bar Independiente"));
        LatLng classicrock = new LatLng(36.69094946745444, -4.444866557717432);
        mMap.addMarker(new MarkerOptions().position(classicrock).title("Classic Rock Pub"));
        LatLng morriseys = new LatLng(36.72287867908658, -4.420665866312901);
        mMap.addMarker(new MarkerOptions().position(morriseys).title("Morrisey's Pub"));
        LatLng premier = new LatLng(36.72132945589846, -4.420274379927808);
        mMap.addMarker(new MarkerOptions().position(premier).title("Sala Premier"));
        LatLng chester = new LatLng(36.72221167887135, -4.419636488402064);
        mMap.addMarker(new MarkerOptions().position(chester).title("Chester & Punk"));
        LatLng colmao = new LatLng(36.72503047860437, -4.4206214730594136);
        mMap.addMarker(new MarkerOptions().position(colmao).title("El Colmao"));
        LatLng grandcafe = new LatLng(36.71807907977973, -4.485374073059551);
        mMap.addMarker(new MarkerOptions().position(grandcafe).title("Le Grand Café"));
        LatLng alquimia = new LatLng(36.72289009519961, -4.421922676278806);
        mMap.addMarker(new MarkerOptions().position(alquimia).title("Alquimia"));
        LatLng amsterdam = new LatLng(36.72230177977987, -4.417019866312937);
        mMap.addMarker(new MarkerOptions().position(amsterdam).title("Amsterdam"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(irishpub, 12));
    }
}