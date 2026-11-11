package com.onenest.backend.service;

import com.onenest.backend.exception.InvalidCredentialsException;
import com.onenest.backend.dto.StudentLoginRequest;
import com.onenest.backend.dto.StudentLoginResponse;
import com.onenest.backend.dto.StudentRegistrationRequest;
import com.onenest.backend.dto.StudentResponse;
import com.onenest.backend.entity.Student;
import com.onenest.backend.exception.DuplicateResourceException;
import com.onenest.backend.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public StudentService(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public StudentResponse registerStudent(StudentRegistrationRequest request) {

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already registered");
        }

        if (studentRepository.existsByRollNumber(request.getRollNumber())) {
            throw new DuplicateResourceException("Roll number already registered");
        }

        Student student = new Student();

        student.setFullName(request.getFullName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setRollNumber(request.getRollNumber());
        student.setHostelBlock(request.getHostelBlock());
        student.setRoomNumber(request.getRoomNumber());

        student.setPassword(passwordEncoder.encode(request.getPassword()));

        Student savedStudent = studentRepository.save(student);

        return new StudentResponse(
                savedStudent.getId(),
                savedStudent.getFullName(),
                savedStudent.getEmail(),
                savedStudent.getPhone(),
                savedStudent.getRollNumber(),
                savedStudent.getHostelBlock(),
                savedStudent.getRoomNumber()
        );
    }

    public StudentLoginResponse loginStudent(StudentLoginRequest request) {

        Student student = studentRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid email or password")
                );

        if (!passwordEncoder.matches(
                request.getPassword(),
                student.getPassword())) {

            throw new InvalidCredentialsException("Invalid email or password");
        }

        String token = jwtService.generateToken(student.getEmail());

        return new StudentLoginResponse(
                student.getId(),
                student.getFullName(),
                student.getEmail(),
                token,
                "Login successful"
        );
    }
}