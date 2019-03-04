package com.example.mohamedhassan.traininghub.Model_RoomTraining;

public class RoomDetails {

    int photoRoom,photoDrink,photoFood,photoMonitor,photoProjector,photoLabtop;
    String NameRoom;
    String Capisty;
    String NumberUser;
    String SalaryRoom;

    public RoomDetails(int photoRoom, int photoDrink, int photoFood, int photoMonitor, int photoProjector, int photoLabtop,
                       String nameRoom, String capisty, String numberUser, String salaryRoom) {
        this.photoRoom = photoRoom;
        this.photoDrink = photoDrink;
        this.photoFood = photoFood;
        this.photoMonitor = photoMonitor;
        this.photoProjector = photoProjector;
        this.photoLabtop = photoLabtop;
        NameRoom = nameRoom;
        Capisty = capisty;
        NumberUser = numberUser;
        SalaryRoom = salaryRoom;
    }
}
