package com.CoachingInstitute.service;

import com.CoachingInstitute.model.Grade;

public interface GradeService {

    Grade findByGradeName(String gradeName);
}
