package com.example.myapplication;

import java.time.LocalDate;

public class trasaction {
    private medichine_detailData detailMedical;
    private account_data dataPersonlitas;
    private Integer Quantity;
    private String trsnsactionID;
    private String dateTransaction;

    public trasaction(medichine_detailData detailMedical, Integer Quantity, String dateTransaction, account_data dataPersonlitas, String trsnsactionID) {
        this.Quantity = Quantity;
        this.dateTransaction = dateTransaction;
        this.detailMedical = detailMedical;
        this.dataPersonlitas = dataPersonlitas;
        this.trsnsactionID = trsnsactionID;
    }

    public String getTrsnsactionID() {
        return trsnsactionID;
    }

    public void setTrsnsactionID(String trsnsactionID) {
        this.trsnsactionID = trsnsactionID;
    }

    public medichine_detailData getDetailMedical() {
        return detailMedical;
    }

    public void setDetailMedical(medichine_detailData detailMedical) {
        this.detailMedical = detailMedical;
    }

    public account_data getDataPersonlitas() {
        return dataPersonlitas;
    }

    public void setDataPersonlitas(account_data dataPersonlitas) {
        this.dataPersonlitas = dataPersonlitas;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
