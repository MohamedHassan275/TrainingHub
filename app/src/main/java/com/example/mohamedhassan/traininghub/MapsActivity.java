package com.example.mohamedhassan.traininghub;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import im.delight.android.location.SimpleLocation;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_LOCATION = 1;
    SimpleLocation location;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        Context context = this;
        boolean requireFineGranularity = false;
        boolean passiveMode = false;
        long updateIntervalInMilliseconds = 5 * 1000;
        boolean requireNewLocation = false;
        location = new SimpleLocation(context, requireFineGranularity, passiveMode, updateIntervalInMilliseconds, requireNewLocation);


        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (location.getLatitude() == 0 || location.getLongitude() == 0) {
            location.beginUpdates();
            // Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
        }
        LatLng mylocation = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.getUiSettings().setZoomControlsEnabled(true);
        Marker marker = mMap.addMarker(new MarkerOptions().position(mylocation).title("Your"));
        marker.showInfoWindow();
        mMap.setBuildingsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().isMyLocationButtonEnabled();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocation, 17));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Toast.makeText(MapsActivity.this, latLng.latitude+ " " + latLng.longitude , Toast.LENGTH_SHORT).show();
                marker.showInfoWindow();
            }
        });


    }


}


