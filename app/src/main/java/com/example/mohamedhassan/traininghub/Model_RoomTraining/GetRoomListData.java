package com.example.mohamedhassan.traininghub.Model_RoomTraining;

public class GetRoomListData {

    int PhotoDepartment1,PhotoDepartment2,PhotoDepartment3;
    String Name;
    String Price;
    String Capcity;

    public GetRoomListData(int photoDepartment1, int photoDepartment2, int photoDepartment3, String name, String price, String capcity) {
        PhotoDepartment1 = photoDepartment1;
        PhotoDepartment2 = photoDepartment2;
        PhotoDepartment3 = photoDepartment3;
        Name = name;
        Price = price;
        Capcity = capcity;
    }

    public int getPhotoDepartment1() {
        return PhotoDepartment1;
    }

    public int getPhotoDepartment2() {
        return PhotoDepartment2;
    }

    public int getPhotoDepartment3() {
        return PhotoDepartment3;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getCapcity() {
        return Capcity;
    }
}
