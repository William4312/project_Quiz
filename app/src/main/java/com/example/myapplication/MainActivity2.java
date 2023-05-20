package com.example.myapplication;

import static com.example.myapplication.Home_Fragment.dataMedichineDetail;
import static com.example.myapplication.login.tempPosisi;
import static com.example.myapplication.registerPage.account_dataTemp_arrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    public static ArrayList<trasaction> trasactionsArray_tempTransaction = new ArrayList<>();
    public static ArrayList<trasaction> temp_transactionAccount = new ArrayList<>();
    private ImageView image_medichine;
    private TextView title, manufacture_name, detail, price;
    private String title_page, manufacture_page, detailText_page;
    private Integer price_page;
    private Integer temp_imageDetailPage;
    private TextInputLayout confirm_quantity;
    private TextInputEditText confirm_quantityModel;
    private Integer posisiDataMedical;
    private static Boolean check_TransactionData_InputtedData = false;
    private static Boolean check_TempTransactionData_InputtedData = false;
    private static Integer transaction_Plus = -1;
    Button buy_medichine, backHomePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        image_medichine = findViewById(R.id.model_image_medichine);
        title = findViewById(R.id.name_detailPage);
        manufacture_name = findViewById(R.id.manufactur_detailPage);
        detail = findViewById(R.id.detail_detailPage);
        price = findViewById(R.id.price_detailPage);
        confirm_quantity = findViewById(R.id.Quantity_inputArea);
        confirm_quantityModel = findViewById(R.id.textEdit_quantity);
        buy_medichine = findViewById(R.id.buy_confirm);
        backHomePage = findViewById(R.id.button_backHome);

        title_page = getIntent().getStringExtra("dataTitle_DetailPage");
        manufacture_page = getIntent().getStringExtra("dataManufacture_DetailPage");
        price_page = Integer.valueOf(getIntent().getExtras().getInt("dataPrice_DetailPage"));
        detailText_page = getIntent().getStringExtra("dataDetail_DetailPage");
        temp_imageDetailPage = getIntent().getExtras().getInt("dataImage_DetailPage");
        posisiDataMedical = getIntent().getExtras().getInt("posisiData");

        title.setText(title_page);
        manufacture_name.setText(manufacture_page);
        detail.setText(detailText_page);
        price.setText(NumberFormat.getIntegerInstance(Locale.GERMAN).format(price_page));
        image_medichine.setImageResource(temp_imageDetailPage);

        buy_medichine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer quantity_validasi = (Integer) Integer.valueOf(confirm_quantity.getEditText().getText().toString().trim());
                if (quantity_validasi <= 0){
                    Toast.makeText(MainActivity2.this, "belum memenuhi minimum transaksi 1 buah kriteria", Toast.LENGTH_SHORT).show();
                }
                else if(quantity_validasi >= 1){
                    Toast.makeText(MainActivity2.this, "transaksi diupdate", Toast.LENGTH_SHORT).show();
                    LocalDate temp_date = LocalDate.now();
                    DateTimeFormatter format_date = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

                    check_insertedData_Transaction(new trasaction(dataMedichineDetail.get(posisiDataMedical), quantity_validasi, (temp_date.format(format_date)), account_dataTemp_arrayList.get(tempPosisi), "TR".concat(String.valueOf(transaction_Plus+=1))));
                    for(int i=0; i<trasactionsArray_tempTransaction.size(); i++){
                        if(String.valueOf(trasactionsArray_tempTransaction.get(i).getDataPersonlitas().getUserID()).equalsIgnoreCase(String.valueOf(account_dataTemp_arrayList.get(tempPosisi).getUserID()))){
                            check_insertedData_Temp(trasactionsArray_tempTransaction.get(i));
                        }
                    }
                    confirm_quantityModel.setText("");
                }
            }
        });

        backHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_homeFragment = new Intent(MainActivity2.this, sectionPage.class);
                startActivity(back_homeFragment);
                finish();
            }
        });
    }
    public static void check_insertedData_Transaction(trasaction check){
        final Integer temp_countArray = trasactionsArray_tempTransaction.size();
        if(temp_countArray <= 0){
            trasactionsArray_tempTransaction.add(check);
        }
        else if (temp_countArray >= 1) {
            for (int i=0; i<temp_countArray; i++){
                if(!(trasactionsArray_tempTransaction.get(i).getTrsnsactionID().equals(check.getTrsnsactionID()))){
                    check_TransactionData_InputtedData = false;
                }
                else if (trasactionsArray_tempTransaction.get(i).getTrsnsactionID().equals(check.getTrsnsactionID())){
                    check_TransactionData_InputtedData = true;
                    break;
                }
            }
            if(check_TransactionData_InputtedData == false){
                trasactionsArray_tempTransaction.add(check);
                return;
            }
            else if(check_TransactionData_InputtedData == true){
                Log.i("Info Medichal Inserted Data", "Data Has Been Inserted Before");
                return;
            }
        }
    }

    public static void check_insertedData_Temp(trasaction check){
        final Integer temp_countArray = temp_transactionAccount.size();
        if(temp_countArray <= 0){
            temp_transactionAccount.add(check);
        }
        else if (temp_countArray >= 1) {
            for (int i=0; i<temp_countArray; i++){
                if(!(temp_transactionAccount.get(i).getTrsnsactionID().equals(check.getTrsnsactionID()))){
                    check_TempTransactionData_InputtedData = false;
                }
                else if (temp_transactionAccount.get(i).getTrsnsactionID().equals(check.getTrsnsactionID())){
                    check_TempTransactionData_InputtedData = true;
                    break;
                }
            }
            if(check_TempTransactionData_InputtedData == false){
                temp_transactionAccount.add(check);
                return;
            }
            else if(check_TempTransactionData_InputtedData == true){
                Log.i("Info Medichal Inserted Data", "Data Has Been Inserted Before");
                return;
            }
        }
    }
}