package com.CoachingInstitute.repository;

import com.CoachingInstitute.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subjects,Long> {

    Optional<Subjects> findByName(String name);
}
