package com.CoachingInstitute.controller;

import com.CoachingInstitute.model.Grade;
import com.CoachingInstitute.model.Student;
import com.CoachingInstitute.response.ApiResponse;
import com.CoachingInstitute.service.GradeService;
import com.CoachingInstitute.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final StudentService studentService;

    private final GradeService gradeService;

    @GetMapping("/get-fees")
    public ResponseEntity<?> calculateFeesForStudent(@RequestBody Student student) {
        try {
            BigDecimal feesCalculated = studentService.calculateFeesForStudent(student);
            return ResponseEntity.ok(new ApiResponse("Success", feesCalculated));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update-fees-status")
    public ResponseEntity<?> updateFeesStatus(@RequestBody Student student) {
        try {
            studentService.updateFeesStatus(student);
            return ResponseEntity.ok(new ApiResponse("Success", "Fees status updated successfully."));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("countByGrade")
    public int getStudentByGrade(@RequestParam String gradeName) {
        Grade grade = gradeService.findByGradeName(gradeName);

        return studentService.getTotalStudentByGrade(grade);
    }

}
