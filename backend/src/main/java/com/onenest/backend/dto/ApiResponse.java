package com.onenest.backend.dto;

public class ApiResponse {

    private String application;
    private String version;
    private String status;
    private String message;

    // Default Constructor
    public ApiResponse() {
    }

    // Parameterized Constructor
    public ApiResponse(String application, String version, String status, String message) {
        this.application = application;
        this.version = version;
        this.status = status;
        this.message = message;
    }

    // Getter for application
    public String getApplication() {
        return application;
    }

    // Setter for application
    public void setApplication(String application) {
        this.application = application;
    }

    // Getter for version
    public String getVersion() {
        return version;
    }

    // Setter for version
    public void setVersion(String version) {
        this.version = version;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }
}