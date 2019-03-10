package com.example.mohamedhassan.traininghub.Model_RoomTraining;

import java.io.Serializable;

public class WorkSpaceListData implements Serializable {

    int photo;
    String Name;
    String area;
    String start_time;
    String end_time;
    String Available;
    double Rating;

    public WorkSpaceListData(int photo, String name, String area, String start_time, String end_time, double rating) {
        this.photo = photo;
        this.Name = name;
        this.area = area;
        this.start_time = start_time;
        this.end_time = end_time;
        this.Rating = rating;
    }

    public WorkSpaceListData() {
    }

    /* public WorkSpaceListData(int photo, String name, String area, String start_time, String end_time, String available, double rating) {
        this.photo = photo;
        Name = name;
        this.area = area;
        this.start_time = start_time;
        this.end_time = end_time;
        Available = available;
        Rating = rating;
    }
*/



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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAvailable() {
        return Available;
    }

    public void setAvailable(String available) {
        Available = available;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }
}

