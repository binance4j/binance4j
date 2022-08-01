package com.binance4j.margin.dto;

import java.util.Optional;

/**
 * An executed trade history item.
 * 
 * @param status         The loan status.
 * @param principal      The borrowed quantity.
 * @param isolatedSymbol The isolated symbol. Will not be returned for crossed margin.
 * @param asset          The related asset.
 * @param timestamp      The loan timestamp in ms.
 * @param txId           The transaction id.
 * @see LoanStatus
 */
public record Loan(String status, String principal, Optional<String> isolatedSymbol, String asset, long timestamp, long txId) {
}