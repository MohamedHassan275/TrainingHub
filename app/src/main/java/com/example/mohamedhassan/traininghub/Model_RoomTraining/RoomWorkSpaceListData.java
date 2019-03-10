package com.example.mohamedhassan.traininghub.Model_RoomTraining;

public class RoomWorkSpaceListData {

    String NameRoomWorkSpace;
    String CapistyRoomWorkSpace;
    String SalaryRoomWorkSpace;

    public RoomWorkSpaceListData(String nameRoom, String capisty, String salaryRoom) {

        NameRoomWorkSpace = nameRoom;
        CapistyRoomWorkSpace = capisty;
        SalaryRoomWorkSpace = salaryRoom;
    }

    public RoomWorkSpaceListData() {
    }

    public String getNameRoomWorkSpace() {
        return NameRoomWorkSpace;
    }

    public void setNameRoomWorkSpace(String nameRoomWorkSpace) {
        NameRoomWorkSpace = nameRoomWorkSpace;
    }

    public String getCapistyRoomWorkSpace() {
        return CapistyRoomWorkSpace;
    }

    public void setCapistyRoomWorkSpace(String capistyRoomWorkSpace) {
        CapistyRoomWorkSpace = capistyRoomWorkSpace;
    }

    public String getSalaryRoomWorkSpace() {
        return SalaryRoomWorkSpace;
    }

    public void setSalaryRoomWorkSpace(String salaryRoomWorkSpace) {
        SalaryRoomWorkSpace = salaryRoomWorkSpace;
    }
}
