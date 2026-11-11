package com.onenest.backend.repository;

import com.onenest.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    boolean existsByRollNumber(String rollNumber);

    Optional<Student> findByEmail(String email);
}