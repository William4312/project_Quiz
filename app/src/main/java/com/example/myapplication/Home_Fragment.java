package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    public static ArrayList<medichine_detailData> dataMedichineDetail = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button logOut;
    private static Boolean check_medicalDataInserted = false;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar icon_topApp = view.findViewById(R.id.toolbar_controlActionBar);
        AppCompatActivity getActivityToolBar = (AppCompatActivity) getActivity();
        getActivityToolBar.setSupportActionBar(icon_topApp);
        getActivityToolBar.setTitle("");
        getActivityToolBar.getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        recyclerView = view.findViewById(R.id.data_medichine_recycleView);
        logOut = view.findViewById(R.id.logOut_ToLoginPage);

        medichine_detailData data1 = new medichine_detailData("Pedsodene", "PT. Unilever", 12_000, "Pepsodent adalah merek pasta gigi yang digunakan untuk membersihkan gigi dan menjaga kesehatan gigi dan gusi.", R.drawable.baseline_email_24);
        medichine_detailData data2 = new medichine_detailData("Aspirin", "Health A2Z", 23_000, "analgesik (pereda nyeri), antipiretik (penurun demam), dan anti- inflamasi (mengobati peradangan). Aspirin juga memiliki efek antikoagulan dan dapat digunakan dalam dosis rendah dalam tempo lama untuk mencegah serangan jantung.", R.drawable.aspirin);
        medichine_detailData data3 = new medichine_detailData("Sumatriptan", "Tevn", 422_000, "Sumatriptan adalah obat untuk mengatasi serangan sakit kepala sebelah (migrain) dan sakit kepala cluster1. Sumatriptan bekerja dengan cara menghambat kinerja enzim tertentu pada otak yang menyebabkan peradangan dan menimbulkan rasa sakit atau nyeri2.", R.drawable.sumatriptan);
        medichine_detailData data4 = new medichine_detailData("Paracetamol", "PT. Riasima Abadi Farma", 17_000, "Paracetamol adalah obat yang digunkaan dalam meredakkan demam, flu, sakit kepala, nyeri gigi, otot, peradangan sendi ringan, sakit nyeri ringan pada area otot punggung", R.drawable.paracetamol);

        check_insertedData_Medichine(data1);
        check_insertedData_Medichine(data2);
        check_insertedData_Medichine(data3);
        check_insertedData_Medichine(data4);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(), dataMedichineDetail);
        recyclerView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.notifyDataSetChanged();

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBackLogin = new Intent(getActivity(), login.class);
                startActivity(goBackLogin);
            }
        });
    }
    public static void check_insertedData_Medichine(medichine_detailData check){
        final Integer temp_countArray = dataMedichineDetail.size();
        if(temp_countArray <= 0){
            dataMedichineDetail.add(check);
        } else if (temp_countArray >= 1) {
            for (int i=0; i<temp_countArray; i++){
                if(!(dataMedichineDetail.get(i).getMedichine_name().equals(check.getMedichine_name()))){
                    check_medicalDataInserted = false;
                }
                else if (dataMedichineDetail.get(i).getMedichine_name().equals(check.getMedichine_name())){
                    check_medicalDataInserted = true;
                    break;
                }
            }
            if(check_medicalDataInserted == false){
                dataMedichineDetail.add(check);
                return;
            }
            else if(check_medicalDataInserted == true){
                Log.i("Info Medichal Inserted Data", "Data Has Been Inserted Before");
                return;
            }
        }
    }
}