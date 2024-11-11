package com.CoachingInstitute.repository;

import com.CoachingInstitute.model.Grade;
import com.CoachingInstitute.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //method to count students by Grade
    @Query("SELECT COUNT(s) FROM Student s WHERE s.grade = :grade")
    int countStudentsByGrade(@Param("grade") Grade grade);
}
