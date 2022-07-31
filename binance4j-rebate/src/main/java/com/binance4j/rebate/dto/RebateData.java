package com.binance4j.rebate.dto;

import java.util.List;

/**
 * Rebate data
 * 
 * @param page         The current page.
 * @param totalRecords The total records.
 * @param totalPageNum The total pages.
 * @param data         The rebates.
 */
public record RebateData(int page, int totalRecords, int totalPageNum, List<Rebate> data) {
}
