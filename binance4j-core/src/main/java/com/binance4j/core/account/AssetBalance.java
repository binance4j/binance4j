package com.binance4j.core.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An asset balance in a wallet.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetBalance {
    /**
     * The Asset symbol.
     */
    private String asset;
    /**
     * The available balance.
     */
    private BigDecimal free;
    /**
     * The balance locked by open orders.
     */
    private BigDecimal locked;
}