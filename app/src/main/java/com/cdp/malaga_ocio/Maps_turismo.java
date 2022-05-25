package com.cdp.malaga_ocio;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cdp.malaga_ocio.databinding.ActivityMapsTurismoBinding;

public class Maps_turismo extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsTurismoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsTurismoBinding.inflate(getLayoutInflater());
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


        LatLng alcazaba = new LatLng(36.72114337972158, -4.4158451442238285);
        mMap.addMarker(new MarkerOptions().position(alcazaba).title("La Alcazaba"));
        LatLng museopicasso = new LatLng(36.721744879654004, -4.418407644223806);
        mMap.addMarker(new MarkerOptions().position(museopicasso).title("Museo Picasso"));
        LatLng thysen = new LatLng(36.721400880244964, -4.422966415388178);
        mMap.addMarker(new MarkerOptions().position(thysen).title("Museo Carmen Thyssen"));
        LatLng frigiliana = new LatLng(36.79402362608128, -3.8969737267239846);
        mMap.addMarker(new MarkerOptions().position(frigiliana).title("Frigiliana"));
        LatLng catedral = new LatLng(36.720167779968776, -4.419256957716884);
        mMap.addMarker(new MarkerOptions().position(catedral).title("Catedral de la Encarnación"));
        LatLng cuevasnerja = new LatLng(36.76206528481483, -3.844922817783007);
        mMap.addMarker(new MarkerOptions().position(cuevasnerja).title("Cuevas de Nerja"));
        LatLng cementerioingles = new LatLng(36.72119318047644, -4.407130915388158);
        mMap.addMarker(new MarkerOptions().position(cementerioingles).title("Cementerio Inglés"));
        LatLng jardinespl = new LatLng(36.7206799782479, -4.414291388402097);
        mMap.addMarker(new MarkerOptions().position(jardinespl).title("Jardines de Pedro Luis Alonso"));
        LatLng caminitodelrey = new LatLng(36.93016475105151, -4.800582530726754);
        mMap.addMarker(new MarkerOptions().position(caminitodelrey).title("El Caminito del Rey"));
        LatLng torcal = new LatLng(36.95212495846101, -4.5422786018906915);
        mMap.addMarker(new MarkerOptions().position(torcal).title("Parque Natural Torcal"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(alcazaba, 8));
    }
}