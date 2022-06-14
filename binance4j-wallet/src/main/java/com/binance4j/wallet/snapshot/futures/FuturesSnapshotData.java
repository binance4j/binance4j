package com.binance4j.wallet.snapshot.futures;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The account snapshot data */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesSnapshotData {
    /**
     * The assets balances
     */
    List<FuturesSnapshotDataAssets> assets;
    /**
     * ???
     */
    List<FuturesAccountSnapshotPosition> position;
}