package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.flame_fragmentGoogleMap);
        if (map != null){
            map.getMapAsync(new OnMapReadyCallback() {
               @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                   LatLng latLng;
                   latLng = new LatLng(-6.201900, 106.781799);
                   MarkerOptions options = new MarkerOptions();
                   options.position(latLng).title("Jl. Kebon Jeruk Raya No.27,\nKabupaten: Kebon Jeruk, \nProvinsi: Jakarta Barat, \nKode Pos: 11530");
                   googleMap.clear();
                   googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,80));
                   googleMap.addMarker(options);
                   googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            });
        }
    }

//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//
//    }
}
