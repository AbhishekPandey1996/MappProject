package com.abhishek.tempmapproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
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

       /* MainActivity fr = new MainActivity();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.tetslayout,fr,"asdf");
        ft.commit();*/
        if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
       UiSettings mapSettings;
        mapSettings = mMap.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);
      mapSettings.setScrollGesturesEnabled(true);
      mapSettings.setTiltGesturesEnabled(true);
      mapSettings.setRotateGesturesEnabled(true);
      mapSettings.setMyLocationButtonEnabled(true);


        // List<Address> geocodeMatches = null;

       /* try {
            geocodeMatches =
                    new Geocoder(MapsActivity.this).getFromLocationName(
                            "Varanasi,India", 1);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Checking", e.toString());
        }

        if (!geocodeMatches.isEmpty())
        {
            latitude = geocodeMatches.get(0).getLatitude();
            longitude = geocodeMatches.get(0).getLongitude();
        }
*/
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

       /*load.start();
        if(latitude != 0) {
            CameraPosition cam = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(1).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
            mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Marker"));
        }
        else {
            CameraPosition cam = new CameraPosition.Builder().target(new LatLng(20.3845, 75.457 )).zoom(1).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
            mMap.addMarker(new MarkerOptions().position(new LatLng(20.3845, 75.457)).title("Marker"));

        }
        /**  mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

         try {
         Thread.sleep(5000);
         } catch (InterruptedException e) {
         e.printStackTrace();
         Log.d("Checking",e.toString());
         }
         Toast.makeText(this,"Going to Current Location",Toast.LENGTH_SHORT);
         getLocation();
         **/
    }

    public Thread load = new Thread() {

        public void run() {


            /*locm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria cri = new Criteria();

            provider = locm.getBestProvider(cri, false);
            Location loc = locm.getLastKnownLocation(provider);
            if (loc != null) {
                latitu = (int) (loc.getLatitude() * 1E6);
                longitu = (int) (loc.getLongitude() * 1E6);
                Log.d("Location", latitu + " is latitude " + longitu + " is longitude");

*/

           // mMap.setMyLocationEnabled(true);
            }



        };



}
