package com.CoachingInstitute.repository;

import com.CoachingInstitute.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
