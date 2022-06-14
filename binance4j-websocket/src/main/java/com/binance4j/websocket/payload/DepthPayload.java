package com.binance4j.websocket.payload;

import java.util.List;

import com.binance4j.core.market.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** The symbol order book */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthPayload {
        /**
         * @return The event type
         * 
         */
        @JsonProperty("e")
        private String eventType;
        /**
         * @return The timestamp
         * 
         */
        @JsonProperty("E")
        private Long eventTime;
        /**
         * @return The trading pair
         * 
         */
        @JsonProperty("s")
        private String symbol;
        /**
         * @return first update id
         * 
         */
        @JsonProperty("U")
        private Long firstUpdateId;
        /**
         * @return last update id
         * 
         */
        @JsonProperty("u")
        private Long finalUpdateId;
        /**
         * @return The offers
         * 
         */
        @JsonProperty("b")
        private List<OrderBookEntry> bids;
        /**
         * @return The demands
         * 
         */
        @JsonProperty("a")
        private List<OrderBookEntry> asks;
}