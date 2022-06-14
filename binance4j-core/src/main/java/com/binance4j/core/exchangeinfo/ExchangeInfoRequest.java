package com.binance4j.core.exchangeinfo;

import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to retrieve the exchange trading rules and symbol information
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExchangeInfoRequest extends Request {
    /**
     * The symbols we want info about
     */
    private String symbols;

    /** Default Constructor */
    public ExchangeInfoRequest() {
        super(10);
    }

    /**
     * Constructor
     * 
     * @param symbols The trading pair list
     */
    public ExchangeInfoRequest(List<String> symbols) {
        this();
        this.symbols = "[" + symbols.stream().map(s -> String.format("\"%s\"", s)).collect(Collectors.joining(","))
                + "]";
    }

    /**
     * Constructor
     * 
     * @param symbol The trading pair
     */
    public ExchangeInfoRequest(String symbol) {
        this(List.of(symbol));
    }
}