package com.CoachingInstitute.dto;

import com.CoachingInstitute.model.Grade;
import com.CoachingInstitute.model.Subjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String lastName;
    private String email;
    private String gradeId;
    private Boolean feesPaid;
    private BigDecimal totalFeesPaid;
    private Set<Subjects> subjects = new HashSet<>();
    private Grade grade;

}
