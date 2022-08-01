package com.binance4j.rebate.dto;

/**
 * A rebate
 * 
 * @param asset      The rebate asset.
 * @param type       The rebate type.
 * @param amount     The rebate amount.
 * @param updateTime The rebate update time.
 * @see RebateType
 */
public record Rebate(String asset, String type, String amount, long updateTime) {
}
