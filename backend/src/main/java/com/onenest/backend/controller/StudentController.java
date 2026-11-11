package com.onenest.backend.controller;

import com.onenest.backend.dto.StudentLoginRequest;
import com.onenest.backend.dto.StudentLoginResponse;
import com.onenest.backend.dto.StudentRegistrationRequest;
import com.onenest.backend.dto.StudentResponse;
import com.onenest.backend.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<StudentResponse> registerStudent(
            @Valid @RequestBody StudentRegistrationRequest request) {

        StudentResponse response = studentService.registerStudent(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<StudentLoginResponse> loginStudent(
            @Valid @RequestBody StudentLoginRequest request) {

        StudentLoginResponse response = studentService.loginStudent(request);

        return ResponseEntity.ok(response);
    }@GetMapping("/profile")
    public ResponseEntity<String> getStudentProfile() {

        return ResponseEntity.ok(
                "Welcome! You are an authenticated OneNest student."
        );
    }
}