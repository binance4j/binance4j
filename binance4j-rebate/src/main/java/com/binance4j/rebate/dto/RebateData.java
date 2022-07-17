package com.binance4j.rebate.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public record RebateData(
		/** The current page. */
		Integer page,
		/** The total records. */
		Integer totalRecords,
		/** The total pages. */
		Integer totalPageNum,
		/** The rebates. */
		List<Rebate> data) {
}
