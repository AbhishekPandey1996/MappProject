package com.abhishek.tempmapproject;

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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements View.OnClickListener {

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

       load.start();
        if(latitu != 0) {
            CameraPosition cam = new CameraPosition.Builder().target(new LatLng(latitu, longitu)).zoom(1).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
            mMap.addMarker(new MarkerOptions().position(new LatLng(latitu, longitu)).title("Marker"));
        }
        else {
            CameraPosition cam = new CameraPosition.Builder().target(new LatLng(17.3845, 69.457 )).zoom(1).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
            mMap.addMarker(new MarkerOptions().position(new LatLng(17.3845, 69.457)).title("Marker"));

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


    @Override
    public void onClick(View v) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}
