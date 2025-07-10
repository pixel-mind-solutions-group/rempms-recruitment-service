package com.pdev.rempms.recruitmentservice.controller.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author maleeshasa
 * @Date 2025-07-10
 */
@Getter
@Setter
public class PageResponse {
    private Integer totalPages;
    private Integer currentPage;
    private Long totalElements;
    private Object dataList;
}
