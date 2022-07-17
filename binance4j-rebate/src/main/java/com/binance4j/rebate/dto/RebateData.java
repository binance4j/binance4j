package com.binance4j.rebate.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public record RebateData(
		/** The current page. */
		int page,
		/** The total records. */
		int totalRecords,
		/** The total pages. */
		int totalPageNum,
		/** The rebates. */
		List<Rebate> data) {
}
