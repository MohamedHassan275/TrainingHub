package com.example.mohamedhassan.traininghub.TrainingRoomActivity;

public class RoomTrainingData {


    int photo;
    String Name;
    String phone;
    String city;
    String valable;
    String Rate;
    String Region;
   // String Address;
    String Details;
    String NubmerRooms;

    public RoomTrainingData(int photo, String name, String phone,
                            String city, String valable, String rate, String region, String address, String details, String nubmerRooms) {
        this.photo = photo;
        Name = name;
        this.phone = phone;
        this.city = city;
        this.valable = valable;
        Rate = rate;
        Region = region;
      //  Address = address;
        Details = details;
        NubmerRooms = nubmerRooms;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getValable() {
        return valable;
    }

    public String getRate() {
        return Rate;
    }

    public String getRegion() {
        return Region;
    }

   /* public String getAddress() {
        return Address;
    }*/

    public String getDetails() {
        return Details;
    }

    public String getNubmerRooms() {
        return NubmerRooms;
    }
}
