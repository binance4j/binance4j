package com.binance4j.wallet.snapshot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * A daily account snapshot
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Snapshot {
    /**
     * The snapshot type ("spot/margin/futures")
     */
    private String type;
    /**
     * The snapshot update timestamp
     */
    private Long updateTime;
}