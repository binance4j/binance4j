package com.binance4j.mining.dto;

import java.util.List;

/**
 * Hashrate detail data.
 * 
 * @param configDetails Config details.
 * @param totalNum      Total amount.
 * @param pageSize      Rows per page.
 */
public record HashrateResaleListDetailData(List<HashrateResaleListDetail> configDetails, long totalNum, long pageSize) {
}