package com.example.mohamedhassan.traininghub.Model_RoomTraining;

import java.io.Serializable;

public class RoomTrainingDetailsModel implements Serializable {

    int photo;
    String Name;
    String phone;
    String city;
    String area;
    String Address;
    String start_time;
    String end_time;
    String NubmerRooms;
    String Available;
    double Rating;
    String current_lng;
    String current_lat;
    String Details;

    public RoomTrainingDetailsModel(int photo, String name, String area, String start_time, String end_time, String available, double rating) {
        this.photo = photo;
        Name = name;
        this.area = area;
        this.start_time = start_time;
        this.end_time = end_time;
        Available = available;
        Rating = rating;
    }

    public RoomTrainingDetailsModel(int photo, String name, String phone, String city, String area, String address, String start_time, String end_time, String nubmerRooms, String valable, double rating, String current_lng, String current_lat, String details) {
        this.photo = photo;
        Name = name;
        this.phone = phone;
        this.city = city;
        this.area = area;
        Address = address;
        this.start_time = start_time;
        this.end_time = end_time;
        NubmerRooms = nubmerRooms;
        this.Available = valable;
        Rating = rating;
        this.current_lng = current_lng;
        this.current_lat = current_lat;
        Details = details;
    }

    public RoomTrainingDetailsModel() {

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

    public String getArea() {
        return area;
    }

    public String getAddress() {
        return Address;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getNubmerRooms() {
        return NubmerRooms;
    }

    public String getAvailable() {
        return Available;
    }

    public double getRating() {
        return Rating;
    }

    public String getCurrent_lng() {
        return current_lng;
    }

    public String getCurrent_lat() {
        return current_lat;
    }

    public String getDetails() {
        return Details;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setNubmerRooms(String nubmerRooms) {
        NubmerRooms = nubmerRooms;
    }

    public void setAvailable(String available) {
        this.Available = available;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public void setCurrent_lng(String current_lng) {
        this.current_lng = current_lng;
    }

    public void setCurrent_lat(String current_lat) {
        this.current_lat = current_lat;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
