package com.CoachingInstitute.service;

import com.CoachingInstitute.Enums.Subject;
import com.CoachingInstitute.model.Student;

import java.math.BigDecimal;

public interface StudentService {

    int getTotalStudentByGrade();

    int getTotalStudentBySubject();


    BigDecimal calculateFeesForStudent(Student student);

    void updateFeesStatus(Student student);
}
