package com.CoachingInstitute.repository;

import com.CoachingInstitute.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
