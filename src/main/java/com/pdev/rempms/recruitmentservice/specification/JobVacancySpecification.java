package com.pdev.rempms.recruitmentservice.specification;

import com.pdev.rempms.recruitmentservice.dto.jobVacancy.JobVacancyRequest;
import com.pdev.rempms.recruitmentservice.model.jobVacancy.JobVacancy;
import com.pdev.rempms.recruitmentservice.util.CommonValidation;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maleeshasa
 * @Date 2025-07-10
 */
public class JobVacancySpecification {

    public static Specification<JobVacancy> getSpecs(JobVacancyRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getGovtJob() != null) {
                predicates.add(cb.equal(root.get("govtJob"), request.getGovtJob()));
            }

            if (request.getWalksInInterview() != null) {
                predicates.add(cb.equal(root.get("walksInInterview"), request.getWalksInInterview()));
            }

            if (request.getPartTime() != null) {
                predicates.add(cb.equal(root.get("partTime"), request.getPartTime()));
            }

            if (!CommonValidation.stringNullValidation(request.getJobVacancyRefNo())) {
                predicates.add(cb.equal(root.get("refNo"), request.getJobVacancyRefNo()));
            }

            if (request.getIsOpen() != null) {
                LocalDate currentDate = LocalDate.now();
                if (request.getIsOpen()) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("closingDate"), currentDate));
                } else {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("closingDate"), currentDate));
                }
            }

            if (!CommonValidation.stringNullValidation(request.getKeyWord())) {
                String keyword = "%" + request.getKeyWord().toLowerCase() + "%";

                Predicate descriptionLike = cb.like(cb.lower(root.get("description")), keyword);
                Predicate employerLike = cb.like(cb.lower(root.get("employer").get("employerName")), keyword);
                Predicate jobPositionLike = cb.like(cb.lower(root.get("jobPosition").get("position")), keyword);
                Predicate posterNameLike = cb.like(cb.lower(root.get("posterName")), keyword);

                predicates.add(cb.or(descriptionLike, employerLike, jobPositionLike, posterNameLike));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
