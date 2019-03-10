package com.example.mohamedhassan.traininghub.Model_RoomTraining;

public class RoomDetailsListData  {

    int photo;
    String Name;
    String Capcity;
    String Price;

    public RoomDetailsListData(int photo, String name, String capcity, String price) {
        this.photo = photo;
        Name = name;
        Capcity = capcity;
        Price = price;
    }

    public RoomDetailsListData() {
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapcity() {
        return Capcity;
    }

    public void setCapcity(String capcity) {
        Capcity = capcity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
