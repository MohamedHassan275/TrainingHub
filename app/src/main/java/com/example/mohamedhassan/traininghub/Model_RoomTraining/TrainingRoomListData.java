package com.example.mohamedhassan.traininghub.Model_RoomTraining;

public class TrainingRoomListData {

    int photo,rate,photo_GetRooms;
    String name;
    String location;
    String phone;
    String valable;
    String ratingBarTrainingRoom;
    String date;


    public TrainingRoomListData(int photo, int rate, String name, String location, String phone, String valable, String ratingBarTrainingRoom, String date) {
        this.photo = photo;
        this.rate = rate;
        this.photo_GetRooms = photo_GetRooms;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.valable = valable;
        this.ratingBarTrainingRoom = ratingBarTrainingRoom;
        this.date = date;
    }

    public int getPhoto() {
        return photo;
    }

    public int getRate() {
        return rate;
    }

    public int getPhoto_GetRooms() {
        return photo_GetRooms;
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

    public String getRatingBarTrainingRoom() {
        return ratingBarTrainingRoom;
    }

    public String getDate() {
        return date;
    }
}
