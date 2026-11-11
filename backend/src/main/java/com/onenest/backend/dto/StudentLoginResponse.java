package com.onenest.backend.dto;

public class StudentLoginResponse {

    private Long id;
    private String fullName;
    private String email;
    private String token;
    private String message;

    public StudentLoginResponse() {}

    public StudentLoginResponse(
            Long id,
            String fullName,
            String email,
            String token,
            String message) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.token = token;
        this.message = message;
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

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}