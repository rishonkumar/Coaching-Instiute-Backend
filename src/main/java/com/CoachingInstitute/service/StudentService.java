package com.CoachingInstitute.service;

import com.CoachingInstitute.Enums.Subject;
import com.CoachingInstitute.dto.StudentDto;
import com.CoachingInstitute.model.Grade;
import com.CoachingInstitute.model.Student;

import java.math.BigDecimal;

public interface StudentService {

    int getTotalStudentByGrade(Grade grade);
    int getTotalStudentBySubject();


    BigDecimal calculateFeesForStudent(Student student);

    void updateFeesStatus(Student student);
}
