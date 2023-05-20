package com.example.myapplication;

import static com.example.myapplication.Home_Fragment.dataMedichineDetail;
import static com.example.myapplication.MainActivity2.temp_transactionAccount;
import static com.example.myapplication.MainActivity2.trasactionsArray_tempTransaction;
import static com.example.myapplication.login.tempPosisi;
import static com.example.myapplication.registerPage.account_dataTemp_arrayList;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrasactionFragment extends Fragment {
    private RecyclerView recyclerView;
    private Button logOut;
    private static ArrayList<trasaction> temp = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trasaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar icon_topApp = view.findViewById(R.id.toolbar_controlActionBarTransaction);
        AppCompatActivity getActivityToolBar = (AppCompatActivity) getActivity();
        getActivityToolBar.setSupportActionBar(icon_topApp);
        getActivityToolBar.setTitle("");
        getActivityToolBar.getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        recyclerView = view.findViewById(R.id.data_transaction_recycleView);
        logOut = view.findViewById(R.id.logOut_ToLoginPageTransaction);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterTrasaction recycleViewAdapter_trasactionPage = new adapterTrasaction(getContext(), temp_transactionAccount);
        recyclerView.setAdapter(recycleViewAdapter_trasactionPage);

        recycleViewAdapter_trasactionPage.setOnItemClickListener(new adapterTrasaction.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                temp_transactionAccount.remove(position);
                recycleViewAdapter_trasactionPage.notifyItemRemoved(position);
                Toast.makeText(getContext(), "delete transaction -"+position, Toast.LENGTH_SHORT).show();
            }
        });

        recycleViewAdapter_trasactionPage.setOnItemClickListenerUpdate(new adapterTrasaction.OnItemClickListenerUpdate() {
            @Override
            public void onItemClickUpdate(int position, int tempData) {
                if (tempData <= 0){
                    Toast.makeText(getContext(), "Must be Bigger than or equal 1", Toast.LENGTH_LONG).show();
                }
                else if(tempData >= 1){
                    Toast.makeText(getContext(), "credensial fill the requiretment", Toast.LENGTH_LONG).show();
                    temp_transactionAccount.get(position).setQuantity(tempData);
                    recycleViewAdapter_trasactionPage.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Upgrade transaction -"+position, Toast.LENGTH_LONG).show();
                }
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBackLogin_ViaTransactionFragment = new Intent(getActivity(), login.class);
                startActivity(goBackLogin_ViaTransactionFragment);
            }
        });
    }
}