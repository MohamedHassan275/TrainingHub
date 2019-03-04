package com.example.mohamedhassan.traininghub.Model_RoomTraining;

public class TrainingRoomListData {

    int photo,rate;
    String name;
    String location;
    String phone;
    String valable;
    String ratingBar_vendor;
    String date_vendor;


    public TrainingRoomListData(int photo, int rate, String name, String location, String phone, String valable, String ratingBar_vendor, String date_vendor) {
        this.photo = photo;
        this.rate = rate;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.valable = valable;
        this.ratingBar_vendor = ratingBar_vendor;
        this.date_vendor = date_vendor;
    }


    public int getPhoto() {
        return photo;
    }

    public int getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getValable() {
        return valable;
    }

    public String getRatingBar_vendor() {
        return ratingBar_vendor;
    }

    public String getDate_vendor() {
        return date_vendor;
    }
}
