package com.binance4j.mining.dto;

import java.util.List;

/**
 * Account data
 * 
 * @param type     Type of daily hashrate.
 * @param userName Mining account.
 * @param list     List.
 */
public record AccountData(String type, String userName, List<AccountList> list) {
}
