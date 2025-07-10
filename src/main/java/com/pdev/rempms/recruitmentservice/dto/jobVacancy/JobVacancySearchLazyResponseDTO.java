package com.pdev.rempms.recruitmentservice.dto.jobVacancy;

import com.pdev.rempms.recruitmentservice.dto.employer.EmployerDTO;
import com.pdev.rempms.recruitmentservice.dto.jobPosition.JobPositionResponseDTO;
import com.pdev.rempms.recruitmentservice.model.employer.Employer;
import com.pdev.rempms.recruitmentservice.model.jobPosition.JobPosition;
import com.pdev.rempms.recruitmentservice.model.vacancyHasCandidates.VacancyHasCandidates;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class JobVacancySearchLazyResponseDTO {
    private Integer id;
    private String description;
    private LocalDate closingDate;
    private Boolean govtJob;
    private Boolean walksInInterview;
    private Boolean partTime;
    private Boolean active;
    private String posterUrl;
    private String posterName;
    private String refNo;
    private EmployerDTO employer;
    private JobPositionResponseDTO jobPosition;
}
