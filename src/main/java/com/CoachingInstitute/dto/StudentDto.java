package com.CoachingInstitute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
public class StudentDto {
    private Long studentId;
    private String studentName;
    private String email;
    private Set<String> subjects;  // List of subject names
    private BigDecimal totalFeesPaid;
}
