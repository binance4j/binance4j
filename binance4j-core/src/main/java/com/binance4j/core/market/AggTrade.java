package com.binance4j.core.market;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of an aggregated trade */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class AggTrade {
    /**
     * The trade id
     */
    @JsonProperty("a")
    private Long tradeId;
    /**
     * The first trade id
     */
    @JsonProperty("f")
    private Long firstTradeId;
    /**
     * The last trade id
     */
    @JsonProperty("l")
    private Long lastTradeId;
    /**
     * The timestamp
     */
    @JsonProperty("T")
    private Long time;
    /**
     * The price
     */
    @JsonProperty("p")
    private BigDecimal price;
    /**
     * The quantity
     */
    @JsonProperty("q")
    private BigDecimal quantity;

    /**
     * Was it a buyer maker
     */
    @JsonProperty("m")
    private Boolean isBuyerMaker;
    /**
     * Was it the best price match?
     */
    @JsonProperty("M")
    private Boolean isBestMatch;

    public AggTrade(List<String> input) {
        setTradeId(Long.parseLong(input.get(0)));
        setPrice(new BigDecimal(input.get(1)));
        setQuantity(new BigDecimal(input.get(2)));
        setFirstTradeId(Long.parseLong(input.get(3)));
        setLastTradeId(Long.parseLong(input.get(4)));
        setTime(Long.parseLong(input.get(5)));
        setIsBuyerMaker(Boolean.parseBoolean(input.get(6)));
        setIsBestMatch(Boolean.parseBoolean(input.get(7)));
    }
}
