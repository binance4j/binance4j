package com.binance4j.wallet.tradingstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiTradingStatusTriggerCondition {
    /**
     * Number of GTC orders
     */
    private Long GCR;
    /**
     * Number of FOK/IOC orders
     */
    private Long IFER;
    /**
     * Number of FOK/IOC orders
     */
    private Long UFR;
}
