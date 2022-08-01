package com.binance4j.mining.dto;

import java.util.List;

/**
 * Account profits data.
 * 
 * @param accountProfits Profits datas.
 * @param totalNum       Total amount.
 * @param pageSize       Rows per page.
 */
public record AccountProfitsData(List<AccountProfit> accountProfits, long totalNum, long pageSize) {
}