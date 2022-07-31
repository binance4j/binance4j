package com.binance4j.mining.dto;

import java.util.List;

/**
 * Workers data.
 * 
 * @param workerDatas Workers datas.
 * @param totalNum    Total amount.
 * @param pageSize    Rows per page.
 */
public record WorkersData(List<Worker> workerDatas, long totalNum, long pageSize) {
}