package com.binance4j.rebate.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RebateData {
    /** The current page. */
    private Integer page;
    /** The total records. */
    private Integer totalRecords;
    /** The total pages. */
    private Integer totalPageNum;
    /** The rebates. */
    private List<Rebate> data;
}
