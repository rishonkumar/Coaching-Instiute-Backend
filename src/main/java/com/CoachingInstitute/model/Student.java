package com.CoachingInstitute.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String email;
    private String gradeId;
    private Boolean feesPaid;
    private BigDecimal totalFeesPaid;

    @ManyToMany
    private Set<Subjects> subjects = new HashSet<>();


}
