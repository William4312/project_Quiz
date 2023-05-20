package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;

public class registerPage extends AppCompatActivity {
    public static ArrayList<account_data> account_dataTemp_arrayList = new ArrayList<>();
    public Intent intent_action_mode;
    public static int userID_autoADD = -1;
    private TextInputLayout username, email, password, confirm_pass, phone;
    private TextInputEditText epass, econfirmpass, eusername, eEmail, ephoneNumber;
    private Button register, gotoLoginPage;
    boolean confirm_register = false, range_6_character = false, at_least_uppercase = false, at_least_number = false, at_least_symbol = false, no_space = false, at_least_lowercase = false, validation_pass = false, no_empty_pass= false;
    boolean no_empty_email = false, end_with_com = false, confirm_email = false;
    boolean no_empty_username = false, username_range5 = false, confirm_username;
    boolean non_empty_confirm_pass = false, equal_confirm_pass = false, confirm_ConfirmPass = false;
    boolean non_empty_phone_number = false, confirm_phoneNumber = false, min_length_phoneNumber = false;
    private static Boolean check_point = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone_number);
        confirm_pass = findViewById(R.id.confirm_password_account);
        register = findViewById(R.id.button_login);
        gotoLoginPage = findViewById(R.id.button_to_login);
        eEmail = findViewById(R.id.etEmail);
        eusername = findViewById(R.id.etUsername);
        epass = findViewById(R.id.etpassword);
        econfirmpass = findViewById(R.id.etConfirmPass);
        ephoneNumber = findViewById(R.id.etPhoneNumber);


        gotoLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registerPage.this, login.class));
            }
        });

        epass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password_codition = charSequence.toString();
                if(!password_codition.isEmpty()){
                    //Uppercase
                    no_empty_pass = true;
                    if(password_codition.length() >= 6){
                        range_6_character = true;
                    }
                    else{
                        range_6_character = false;
                        password.setHelperText("must have 6 charcater minimum");
                    }
                    if (password_codition.matches("(.*[A-Z].*)")) {
                        at_least_uppercase = true;
                    }
                    else{
                        at_least_uppercase = false;
                        password.setHelperText("Must have at least 1 Upper-case Character");
                    }
                    //Numeric
                    if (password_codition.matches("(.*[0-9].*)")) {
                        at_least_number = true;
                    } else{
                        at_least_number = false;
                        password.setHelperText("must be have at least 1 Numeric Character");
                    }
                    if (password_codition.matches("(.*[@,#,\\,$,%,^,&,+,=,!].*)")) {
                        at_least_symbol = true;
                    } else{
                        at_least_symbol = false;
                        password.setHelperText("must be have at least 1 Symbol");
                    }
                    if (password_codition.matches("(.*[a-z].*)")) {
                        at_least_lowercase = true;
                    } else{
                        at_least_lowercase = false;
                        password.setHelperText("must be have at leas 1 Lower-case Character");
                    }
                    if (password_codition.matches("(.*[^\\s].*)")) {
                        no_space = true;
                    } else{
                        no_space = false;
                        password.setHelperText("must be not have any space");
                    }
                }
                else{
                    no_empty_pass = false;
                    password.setHelperText("required");
                }
                if (no_empty_pass == true && range_6_character == true && at_least_uppercase == true && at_least_lowercase == true && at_least_symbol == true && no_space == true && at_least_number == true) {
                    validation_pass = true;
                    password.setHelperTextEnabled(false);
                }
                else {
                    validation_pass = false;
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        eEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email_codition = charSequence.toString();
                if(!email_codition.isEmpty()){
                    no_empty_email = true;
                    if(Patterns.EMAIL_ADDRESS.matcher(email_codition).matches()){
                        end_with_com = true;
                    }
                    else{
                        email.setError(null);
                        email.setHelperText("Must contain @ and .com");
                    }
                }
                else {
                    no_empty_email = false;
                    email.setHelperText("required");
                }
                if(no_empty_email == true && end_with_com == true){
                    confirm_email = true;
                    email.setHelperTextEnabled(false);
                }
                else {
                    confirm_email = false;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        eusername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String username_condition = charSequence.toString();
                if(!username_condition.isEmpty()){
                    no_empty_username = true;
                    if(username_condition.length() >= 5){
                        username_range5 = true;
                    }
                    else{
                        username_range5 = false;
                        username.setHelperText("Must have at least 5 character");
                    }
                }
                else {
                    no_empty_username = false;
                    username.setHelperText("required");
                }
                if(username_range5 == true && no_empty_username == true){
                    confirm_username = true;
                    username.setHelperTextEnabled(false);
                }
                else {
                    confirm_username = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ephoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String phone_number_codition = phone.getEditText().getText().toString().trim();
                if(!phone_number_codition.isEmpty()){
                    non_empty_phone_number = true;
                    if(phone_number_codition.length() == 12){
                        min_length_phoneNumber = true;
                    }
                    else {
                        min_length_phoneNumber = false;
                        phone.setHelperText("Must be 12 numeric");
                    }
                }
                else{
                    non_empty_phone_number = false;
                    phone.setHelperText("required");
                }
                if(non_empty_phone_number == true && min_length_phoneNumber == true){
                    confirm_phoneNumber = true;
                    phone.setHelperTextEnabled(false);
                }
                else {
                    confirm_phoneNumber = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        econfirmpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String confirm_pass_codition = charSequence.toString();
                String password_condition = password.getEditText().getText().toString().trim();
                if (!confirm_pass_codition.isEmpty()){
                    non_empty_confirm_pass = true;
                    if(confirm_pass_codition.equals(password_condition)){
                        equal_confirm_pass = true;
                    }
                    else{
                        equal_confirm_pass = false;
                        confirm_pass.setHelperText("Must be equal with the password");
                    }
                }
                else {
                    non_empty_confirm_pass = false;
                    confirm_pass.setHelperText("required");
                }
                if(non_empty_confirm_pass == true && equal_confirm_pass == true){
                    confirm_ConfirmPass = true;
                    confirm_pass.setHelperTextEnabled(false);
                }
                else{
                    confirm_ConfirmPass = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_person = username.getEditText().getText().toString(), phone_person = phone.getEditText().getText().toString().trim() , email_person = email.getEditText().getText().toString(), password_person = password.getEditText().getText().toString(), confirm_passeord = confirm_pass.getEditText().getText().toString();
                if (name_person.length() >= 0 && email_person.length() >= 0 && password_person.length() >= 0) {
                    if(validation_pass == true && confirm_email == true && confirm_username == true && confirm_ConfirmPass == true && confirm_phoneNumber == true){
                        confirm_register = true;
                    }
                    else if(!(validation_pass == true && confirm_email == true && confirm_username == true && confirm_ConfirmPass == true && confirm_phoneNumber == true)){
                        confirm_register = false;
                        Toast.makeText(registerPage.this, "there are still data input errors", Toast.LENGTH_LONG).show();
                    }
                    if (confirm_register == true) {
                        Toast.makeText(registerPage.this, "Registration sucessful", Toast.LENGTH_SHORT).show();
                        account_data temp_confrim = new account_data(name_person, email_person, phone_person, password_person, "USER".concat(String.valueOf(userID_autoADD+=1)));
                        check_insertedData_Account(temp_confrim);
                        Log.i("register posisi", "Register\nUser baru : " + "USER".concat(String.valueOf(userID_autoADD)) + "\nNama : "+ name_person +"\nEmail: "+email_person +"\nPass: "+password_person+"\n");
                        intent_action_mode = new Intent(registerPage.this, login.class);
                        startActivity(intent_action_mode);
                        finish();
                    }
                }
            }
        });
    }

    public static void check_insertedData_Account(account_data check){
        final Integer temp_countArray = account_dataTemp_arrayList.size();
        if(temp_countArray <= 0){
            account_dataTemp_arrayList.add(check);
        } else if (temp_countArray >= 1) {
            for (int i=0; i<temp_countArray; i++){
                if(!(account_dataTemp_arrayList.get(i).getUserID().equals(check.getUserID()))){
                    check_point = false;
                }
                else if (account_dataTemp_arrayList.get(i).getUserID().equals(check.getUserID())){
                    check_point = true;
                    break;
                }
            }
            if(check_point == false){
                account_dataTemp_arrayList.add(check);
                return;
            }
            else if(check_point == true){
                Log.i("Info Account Inserted Data", "Data Has Been Inserted Before");
                return;
            }
        }
    }
}