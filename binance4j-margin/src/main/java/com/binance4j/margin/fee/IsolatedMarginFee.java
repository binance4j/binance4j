package com.binance4j.margin.fee;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IsolatedMarginFee {
        private int vipLevel;
        private String symbol;
        private BigDecimal leverage;
        private List<IsolatedMarginFeeData> data;
}
