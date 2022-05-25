package com.cdp.malaga_ocio;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cdp.malaga_ocio.databinding.ActivityMapsDiscosBinding;

public class Maps_Discos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsDiscosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsDiscosBinding.inflate(getLayoutInflater());
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


        LatLng wenge = new LatLng(36.72209547829764, -4.42196569759701);
        mMap.addMarker(new MarkerOptions().position(wenge).title("La Wengué"));
        LatLng bubbles = new LatLng(36.72215024883813, -4.422679653523334);
        mMap.addMarker(new MarkerOptions().position(bubbles).title("Sala Bubbles"));
        LatLng barsovia = new LatLng(36.72220067996817, -4.419804401895107);
        mMap.addMarker(new MarkerOptions().position(barsovia).title("Barsovia"));
        LatLng malafama = new LatLng(36.722404280747355, -4.421004673059467);
        mMap.addMarker(new MarkerOptions().position(malafama).title("Malafama"));
        LatLng ritual = new LatLng(36.69199007695951, -4.459790673060047);
        mMap.addMarker(new MarkerOptions().position(ritual).title("Ritual Vip Club"));
        LatLng teatro = new LatLng(36.72253747956522, -4.421354373059464);
        mMap.addMarker(new MarkerOptions().position(teatro).title("Teatro Club Málaga"));
        LatLng anden = new LatLng(36.72274957911551, -4.420315030730741);
        mMap.addMarker(new MarkerOptions().position(anden).title("El Andén"));
        LatLng paris15 = new LatLng(36.70467117678075, -4.476439144224123);
        mMap.addMarker(new MarkerOptions().position(paris15).title("Paris 15"));
        LatLng akari = new LatLng(36.692041695035556, -4.45976921538874);
        mMap.addMarker(new MarkerOptions().position(akari).title("Akari Dance Club"));
        LatLng zzpub = new LatLng(36.723974276598916, -4.421523044223797);
        mMap.addMarker(new MarkerOptions().position(zzpub).title("ZZ Pub"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wenge, 12));
    }
}