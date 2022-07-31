package com.binance4j.mining.dto;

import java.util.List;

/**
 * Workers data.
 * 
 * @param otherProfits Profits datas.
 * @param totalNum     Total amount.
 * @param pageSize     Rows per page.
 */
public record OtherProfitsData(List<OtherProfit> otherProfits, long totalNum, long pageSize) {
}