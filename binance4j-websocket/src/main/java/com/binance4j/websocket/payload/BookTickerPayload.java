package com.binance4j.websocket.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or
 * ask's price or quantity in real-time for a specified symbol.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTickerPayload {
    /**
     * The update id
     */
    @JsonProperty("u")
    private Long updateId;
    /**
     * The trading pair
     */
    @JsonProperty("s")
    private String symbol;
    /**
     * The bid price
     */
    @JsonProperty("b")
    private String bidPrice;
    /**
     * The bid quantity
     */
    @JsonProperty("B")
    private String bidQuantity;
    /**
     * The ask price
     */
    @JsonProperty("a")
    private String askPrice;
    /**
     * The ask quantity
     */
    @JsonProperty("A")
    private String askQuantity;
}