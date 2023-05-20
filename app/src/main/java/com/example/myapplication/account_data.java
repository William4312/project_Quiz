package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class account_data implements Parcelable {
    private String name, email, phoneNumber, password, userID;

    public account_data(String name, String email, String phoneNumber, String password, String userID) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userID = userID;
    }

    protected account_data(Parcel in) {
        name = in.readString();
        email = in.readString();
        phoneNumber = in.readString();
        password = in.readString();
        userID = in.readString();
    }


    public static final Creator<account_data> CREATOR = new Creator<account_data>() {
        @Override
        public account_data createFromParcel(Parcel in) {
            return new account_data(in);
        }

        @Override
        public account_data[] newArray(int size) {
            return new account_data[size];
        }
    };

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel employee_data, int position_data) {
        employee_data.writeString(name);
        employee_data.writeString(email);
        employee_data.writeString(phoneNumber);
        employee_data.writeString(password);
        employee_data.writeString(userID);
    }
}
