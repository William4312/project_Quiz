package com.example.myapplication;

import static com.example.myapplication.registerPage.account_dataTemp_arrayList;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public class login extends AppCompatActivity {
    private TextInputLayout email, password;
    private Button signIn, goToRegister;
    public static Integer tempPosisi = 0;
//    public static ArrayList<account_data> account_datatest = new ArrayList<account_data>();
    public static String userAccountID, usernameAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.button_login);
        goToRegister = findViewById(R.id.button_to_register);

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, registerPage.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer save_positionData = 0;
                String email_person, password_person;
                email_person = email.getEditText().getText().toString().trim();
                password_person = password.getEditText().getText().toString().trim();
                for(int i=0; i < account_dataTemp_arrayList.size(); i++){
                    String check_email_database, check_password_database;
                    boolean email_match, password_match;
                    check_email_database = (String) account_dataTemp_arrayList.get(i).getEmail();
                    check_password_database = (String) account_dataTemp_arrayList.get(i).getPassword();
                    email_match = check_email_database.contentEquals(email_person);
                    password_match = check_password_database.contentEquals(password_person);
                    Log.i("data masuk", "email dan pass : " + account_dataTemp_arrayList.get(i).getUserID() + " " + account_dataTemp_arrayList.get(i).getName() + " posisi array: " + i);
                    if( email_match == true && password_match == true ){
                        save_positionData = i;
                        Log.i("data", "Sign In email: " + check_email_database + " pass: " + check_password_database + " Code posisi data: ".concat(String.valueOf(i)));
                        Toast.makeText(login.this, "Sign In Completed", Toast.LENGTH_SHORT).show();
                        Intent go_to_HomePage = new Intent(login.this, sectionPage.class);
                        startActivity(go_to_HomePage);
                        finish();
                    }
                    if(email_match == false && password_match == true){
                        Toast.makeText(login.this, "Check Email Back", Toast.LENGTH_SHORT).show();
                    }
                    if(email_match == true && password_match == false){
                        Toast.makeText(login.this, "Check Password Back", Toast.LENGTH_SHORT).show();
                    }
                }
                tempPosisi = save_positionData;
                Log.i("posisi Data", "posisi temp: "+ tempPosisi + account_dataTemp_arrayList.get(tempPosisi).getUserID());
            }
        });
    }
}