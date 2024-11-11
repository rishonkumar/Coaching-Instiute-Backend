package com.CoachingInstitute.service.impl;

import com.CoachingInstitute.model.Grade;
import com.CoachingInstitute.repository.GradeRepository;
import com.CoachingInstitute.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Override
    public Grade findByGradeName(String gradeName) {
        return gradeRepository.findByGradeName(gradeName);
    }
}
