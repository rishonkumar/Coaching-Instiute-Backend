package com.CoachingInstitute.controller;

import com.CoachingInstitute.model.Student;
import com.CoachingInstitute.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ApiResponse;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<?> calculateFeesForStudent(Student student) {
        try {
            BigDecimal feesCalculated = studentService.calculateFeesForStudent(student);
            return ResponseEntity.ok(new ApiResponse("Success", feesCalculated));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
