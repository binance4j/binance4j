package com.binance4j.rebate.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Rebate data
 * 
 * @param page         The current page.
 * @param totalRecords The total records.
 * @param totalPageNum The total pages.
 * @param data         The rebates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
