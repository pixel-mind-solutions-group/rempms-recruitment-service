package com.pdev.rempms.recruitmentservice.repository.jobVacancy;

import com.pdev.rempms.recruitmentservice.model.jobPosition.JobPosition;
import com.pdev.rempms.recruitmentservice.model.jobVacancy.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobVacancyRepository extends JpaRepository<JobVacancy, Integer>, JpaSpecificationExecutor<JobVacancy> {

    List<JobVacancy> findByActive(boolean active);

    Optional<JobVacancy> findTopByOrderByIdDesc();

    List<JobVacancy> findByJobPosition(JobPosition jobPosition);

}
