package com.example.maptesting;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.maptesting.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        LatLng deoria = new LatLng(26.5024, 83.7791);
        mMap.addMarker(new MarkerOptions().position(deoria).title("Deoria District"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(deoria));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(deoria,16f));
//circle
        mMap.addCircle(new CircleOptions().center(deoria).radius(1000).fillColor(Color.BLUE).strokeColor(Color.RED));
      //polygon
      mMap.addPolygon(new PolygonOptions().add(new LatLng(27.5024,83.7791),
              new LatLng(27.5024,84.7791),
        new LatLng(26.5024,83.7791),
        new LatLng(26.5024,84.7791
    ),new LatLng(27.5024,83.7791)).fillColor(Color.GRAY).strokeColor(Color.CYAN));


     // mMap.addGroundOverlay(new GroundOverlayOptions().position(deoria,1000f,1000f)
      //        .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_background)).clickable(true));
    }
}