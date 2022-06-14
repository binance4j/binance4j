package com.binance4j.core.market;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of a candlestick bar for a symbol */
@Data
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CandlestickBar {
    /**
     * The candlestick open timestamp in milliseconds
     */
    private Long openTime;
    /**
     * The Open value
     */
    private BigDecimal open;
    /**
     * The High value
     */
    private BigDecimal high;
    /**
     * The Low value
     */
    private BigDecimal low;
    /**
     * The Close value
     */
    private BigDecimal close;
    /**
     * The traded volume in the interval
     */
    private BigDecimal volume;
    /**
     * The candlestick close timestamp in milliseconds
     */
    private Long closeTime;
    /**
     * The quote asset traded volume
     */
    private BigDecimal quoteAssetVolume;
    /**
     * The number of trades
     */
    private Long numberOfTrades;
    /**
     * Taker buy base asset volume
     */
    private BigDecimal takerBuyBaseAssetVolume;
    /**
     * Taker buy quote asset volume
     */
    private BigDecimal takerBuyQuoteAssetVolume;
    /**
     * Ignore
     */
    private BigDecimal ignore;

    /**
     * Constructor accepting a list of String acting like a line of data in a csv
     * file
     * 
     * @param input The String input
     */
    public CandlestickBar(List<String> input) {
        setOpenTime(Long.parseLong(input.get(0)));
        setOpen(new BigDecimal(input.get(1)));
        setHigh(new BigDecimal(input.get(2)));
        setLow(new BigDecimal(input.get(3)));
        setClose(new BigDecimal(input.get(4)));
        setVolume(new BigDecimal(input.get(5)));
        setCloseTime(Long.parseLong(input.get(6)));
        setQuoteAssetVolume(new BigDecimal(input.get(7)));
        setNumberOfTrades(Long.parseLong(input.get(8)));
        setTakerBuyBaseAssetVolume(new BigDecimal(input.get(9)));
        setTakerBuyQuoteAssetVolume(new BigDecimal(input.get(10)));
        setIgnore(new BigDecimal(input.get(11)));
    }
}
