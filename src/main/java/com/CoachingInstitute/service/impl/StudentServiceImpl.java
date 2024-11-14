package com.CoachingInstitute.service.impl;

import com.CoachingInstitute.dto.StudentDto;
import com.CoachingInstitute.model.Grade;
import com.CoachingInstitute.model.Student;
import com.CoachingInstitute.model.Subjects;
import com.CoachingInstitute.repository.StudentRepository;
import com.CoachingInstitute.repository.SubjectRepository;
import com.CoachingInstitute.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;

    @Override
    public int getTotalStudentByGrade(Grade grade) {
        return studentRepository.countStudentsByGrade(grade);
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
            //save the updated student in entity
            studentRepository.save(student);
            return totalFeesPaid;
        }
        return null;
    }

    /*
    Set true or false if fees are paid!!
     */
    @Override
    public void updateFeesStatus(Student student) {
        BigDecimal totalFeesCalculated = calculateFeesForStudent(student);
        if (totalFeesCalculated != null) {
            student.setFeesPaid(student.getTotalFeesPaid().compareTo(totalFeesCalculated) >= 0);
            studentRepository.save(student);
        }
    }

    @Override
    public boolean chooseSubjectForStudents(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getStudentId()).orElseThrow(
                () -> new RuntimeException("Student not found")
        );

        Set<Subjects> chooseSubjects = new HashSet<>();
        for (String subjectName : studentDto.getSubjects()) {
            Subjects subject = subjectRepository.findByName(subjectName).orElseThrow(() -> new RuntimeException("Subject not found"));
            chooseSubjects.add(subject);
        }
        student.setSubjects(chooseSubjects);
        //calculate the fees as well

        BigDecimal totalFeesPaid = BigDecimal.valueOf(chooseSubjects.size() * 1000);
        student.setTotalFeesPaid(totalFeesPaid);
        studentRepository.save(student);

        return true;
    }

    @Override
    public Student registerStudent(StudentDto studentDto) {

        if(studentRepository.existsByEmail(studentDto.getEmail())) {
            throw new RuntimeException("Student with this email already exists");
        }
        Student newStudent = new Student();

        newStudent.setId(studentDto.getStudentId());
        newStudent.setName(studentDto.getStudentName());
        newStudent.setEmail(studentDto.getEmail());

        if(studentDto.getSubjects() != null && !studentDto.getSubjects().isEmpty()) {
            Set<Subjects> subjects = new HashSet<>(subjectRepository.findByNameIn(studentDto.getSubjects()));
            newStudent.setSubjects(subjects);
        }


        return studentRepository.save(newStudent);
    }

}