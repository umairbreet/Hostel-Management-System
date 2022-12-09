package com.example.hostelmanagementsystem;

public class RoomModelClass {
    Integer id;
    String name;
    String email;
    String contact;
    String roomNo;

    public RoomModelClass(String name, String email, String contact, String roomNo)
    {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.roomNo = roomNo;
    }

    public RoomModelClass(Integer id, String name, String email, String contact, String roomNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.roomNo = roomNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}