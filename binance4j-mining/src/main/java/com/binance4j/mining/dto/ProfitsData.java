package com.binance4j.mining.dto;

import java.util.List;

/**
 * Workers data.
 * 
 * @param accountProfits profits datas.
 * @param totalNum       Total amount.
 * @param pageSize       Rows per page.
 */
public record ProfitsData(List<Profit> accountProfits, long totalNum, long pageSize) {
}