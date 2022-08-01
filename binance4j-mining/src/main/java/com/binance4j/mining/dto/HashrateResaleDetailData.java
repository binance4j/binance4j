package com.binance4j.mining.dto;

import java.util.List;

/**
 * Hashrate detail data.
 * 
 * @param profitTransferDetails Details.
 * @param totalNum              Total amount.
 * @param pageSize              Rows per page.
 */
public record HashrateResaleDetailData(List<HashrateResaleDetail> profitTransferDetails, long totalNum, long pageSize) {
}