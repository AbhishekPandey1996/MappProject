package com.abhishek.tempmapproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;

import android.location.Address;
import android.location.Geocoder;
public class MapsActivity extends FragmentActivity implements View.OnClickListener {
    int counter=0;
    double latitude;
    double longitude;
    private GoogleMap mMap;
    LocationManager locm;
    String provider;
    int longitu, latitu;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(this);

        /****** To add NavigATION dRAWER ******/

       /* MainActivity fr = new MainActivity();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.tetslayout,fr,"asdf");
        ft.commit();*/
        if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }else {
            Toast.makeText(this,"mMap Null",Toast.LENGTH_SHORT).show();
        }


   // mAP sETTINGS
       UiSettings mapSettings;
        mapSettings = mMap.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);
      mapSettings.setScrollGesturesEnabled(true);
      mapSettings.setTiltGesturesEnabled(true);
      mapSettings.setRotateGesturesEnabled(true);
      mapSettings.setMyLocationButtonEnabled(true);

    }

    @Override
    public void onClick(View v) {

        if(counter==0) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            counter =1;
            Toast.makeText(this,"Satellite View Enabled",Toast.LENGTH_SHORT).show();
        }
    else if (counter==1){
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            counter =2;
            Toast.makeText(this,"Normal View Enabled",Toast.LENGTH_SHORT).show();
        }
        else if (counter==2){
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            counter =3;
            Toast.makeText(this,"Hybrid View Enabled",Toast.LENGTH_SHORT).show();
        }
        else if (counter==3){
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            counter =4;
            Toast.makeText(this,"Terrain View Enabled",Toast.LENGTH_SHORT).show();
        }
        else if (counter==4){
            mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
            counter =0;
            Toast.makeText(this,"No View Enabled",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {

        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker").snippet("Snippet"));

        mMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        String provider = locationManager.getBestProvider(criteria, true);

        Location myLocation = locationManager.getLastKnownLocation(provider);


        double latitude = myLocation.getLatitude();

        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!").snippet("Consider yourself located"));


    }

   


}
