package com.example.myapplication;

public class medichine_detailData{
    private account_data data;
    private String medichine_name, medichine_manufactur, medichine_detail;
    private Integer image_medichine;
    private Integer madichine_price;

    public medichine_detailData(String medichine_name, String medichine_manufactur, Integer madichine_price, String medichine_detail, Integer image_medichine) {
        this.medichine_name = medichine_name;
        this.medichine_manufactur = medichine_manufactur;
        this.madichine_price = madichine_price;
        this.medichine_detail = medichine_detail;
        this.image_medichine = image_medichine;
    }

    public String getMedichine_name() {
        return medichine_name;
    }

    public void setMedichine_name(String medichine_name) {
        this.medichine_name = medichine_name;
    }

    public String getMedichine_manufactur() {
        return medichine_manufactur;
    }

    public void setMedichine_manufactur(String medichine_manufactur) {
        this.medichine_manufactur = medichine_manufactur;
    }

    public Integer getMadichine_price() {
        return madichine_price;
    }

    public void setMadichine_price(Integer madichine_price) {
        this.madichine_price = madichine_price;
    }

    public String getMedichine_detail() {
        return medichine_detail;
    }

    public void setMedichine_detail(String medichine_detail) {
        this.medichine_detail = medichine_detail;
    }

    public int getImage_medichine() {
        return image_medichine;
    }

    public void setImage_medichine(Integer image_medichine) {
        this.image_medichine = image_medichine;
    }
}
