package com.example.mohamedhassan.traininghub.TrainingRoomActivity;

public class VendorRoomData {

    int photo,image_traininge_room_department,image_traininge_room_department2,image_traininge_room_department3;
    String Name;
    String Capcity;
    String Price;
    String valable;

    public VendorRoomData(int photo, int image_traininge_room_department, int image_traininge_room_department2, int image_traininge_room_department3, String name, String capcity, String price, String valable) {
        this.photo = photo;
        this.image_traininge_room_department = image_traininge_room_department;
        this.image_traininge_room_department2 = image_traininge_room_department2;
        this.image_traininge_room_department3 = image_traininge_room_department3;
        Name = name;
        Capcity = capcity;
        Price = price;
        this.valable = valable;
    }

    public int getPhoto() {
        return photo;
    }

    public int getImage_traininge_room_department() {
        return image_traininge_room_department;
    }

    public int getImage_traininge_room_department2() {
        return image_traininge_room_department2;
    }

    public int getImage_traininge_room_department3() {
        return image_traininge_room_department3;
    }

    public String getName() {
        return Name;
    }

    public String getCapcity() {
        return Capcity;
    }

    public String getPrice() {
        return Price;
    }

    public String getValable() {
        return valable;
    }
}
