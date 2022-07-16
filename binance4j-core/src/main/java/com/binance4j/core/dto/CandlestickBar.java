package com.binance4j.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/** The representation of a candle for a symbol. */
@Data
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CandlestickBar extends Candle {

    /**
     
     */
    public CandlestickBar() {
        super();
    }

    /**
     * accepting a list of String acting like a line of data in a csv file
     * 
     * @param input The String input
     */
    public CandlestickBar(List<String> input) {
        super(input);
    }
}
