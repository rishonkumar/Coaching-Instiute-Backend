package com.CoachingInstitute.service.impl;

import com.CoachingInstitute.model.Student;
import com.CoachingInstitute.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Override
    public int getTotalStudentByGrade() {
        return 0;
    }

    @Override
    public int getTotalStudentBySubject() {
        return 0;
    }


    /*
    Set fees collected to true and to check how many fees collected
    it should be based on subject basis right for now lets keep 1000 for each subject

    My thought process is to get the number of subject he choosed
    so total subject * 1000
     */

    @Override
    public BigDecimal calculateFeesForStudent(Student student) {
        Long studentId = student.getId();
        if (studentId != null) {
            int numberOfSubjects = student.getSubjects().size();
            BigDecimal feesPerSubject = new BigDecimal(1000);
            BigDecimal totalFeesPaid = feesPerSubject.multiply(BigDecimal.valueOf(numberOfSubjects));
            student.setTotalFeesPaid(totalFeesPaid);
            return totalFeesPaid;
        }
        return null;
    }

    @Override
    public void updateFeesStatus(Student student) {
        BigDecimal totalFeesPaid = calculateFeesForStudent(student);
        student.setFeesPaid(student.getTotalFeesPaid().compareTo(totalFeesPaid) >= 0);
    }

}
