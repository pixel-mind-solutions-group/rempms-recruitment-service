package com.pdev.rempms.recruitmentservice.dto.jobVacancy;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobVacancyRequest {
    private Integer id;
    private String description;
    private LocalDate closingDate;
    private Boolean govtJob;
    private Boolean walksInInterview;
    private Boolean partTime;
    private String posterUrl;
    private Integer employerId;
    private Integer jobPositionId;
    private String jobVacancyRefNo;
    private String keyWord;
    private Boolean isOpen;
}
