package com.onenest.backend.dto;

public class StudentResponse {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String rollNumber;
    private String hostelBlock;
    private String roomNumber;

    public StudentResponse() {
    }

    public StudentResponse(Long id, String fullName, String email,
                           String phone, String rollNumber,
                           String hostelBlock, String roomNumber) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.rollNumber = rollNumber;
        this.hostelBlock = hostelBlock;
        this.roomNumber = roomNumber;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getHostelBlock() {
        return hostelBlock;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}