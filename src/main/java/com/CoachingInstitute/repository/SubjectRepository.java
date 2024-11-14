package com.CoachingInstitute.repository;

import com.CoachingInstitute.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SubjectRepository extends JpaRepository<Subjects,Long> {

    Optional<Subjects> findByName(String name);

    List<Subjects> findByNameIn(Set<String> names);

}
