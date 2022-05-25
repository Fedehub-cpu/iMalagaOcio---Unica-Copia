package com.cdp.malaga_ocio;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cdp.malaga_ocio.databinding.ActivityMapsBinding;

public class Maps_Restaurantes extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
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


        LatLng tintero = new LatLng(36.716812, -4.348082);
        mMap.addMarker(new MarkerOptions().position(tintero).title("El Tintero"));
        LatLng hidalgos = new LatLng(36.721333146781184, -4.419684664459294);
        mMap.addMarker(new MarkerOptions().position(hidalgos).title("Los Hidalgos"));
        LatLng tranca = new LatLng(36.72434407039864, -4.421138988402036);
        mMap.addMarker(new MarkerOptions().position(tranca).title("La Tranca"));
        LatLng tunel = new LatLng(36.7811383338127, -4.435062086551398);
        mMap.addMarker(new MarkerOptions().position(tunel).title("La Venta del Túnel"));
        LatLng fernandez = new LatLng(36.7440538809191, -4.421941182453985);
        mMap.addMarker(new MarkerOptions().position(fernandez).title("Bar Los Fernández"));
        LatLng lacaliza = new LatLng(36.71917651921393, -4.296607683678349);
        mMap.addMarker(new MarkerOptions().position(lacaliza).title("Lacaliza"));
        LatLng duranduran = new LatLng(36.690518495887986, -4.445032528881798);
        mMap.addMarker(new MarkerOptions().position(duranduran).title("Hamburguesería Durán Durán"));
        LatLng chacha = new LatLng(36.74892537661007, -4.418920530726185);
        mMap.addMarker(new MarkerOptions().position(chacha).title("Cha-Cha Café Terraza"));
        LatLng pimpi = new LatLng(36.72193536891017, -4.418129656774526);
        mMap.addMarker(new MarkerOptions().position(pimpi).title("El Pimpi"));
        LatLng kosei = new LatLng(36.72335505318268, -4.423514218460807);
        mMap.addMarker(new MarkerOptions().position(pimpi).title("Kosei Ramen"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tintero, 12));
    }
}