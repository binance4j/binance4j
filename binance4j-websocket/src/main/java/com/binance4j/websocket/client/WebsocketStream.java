package com.binance4j.websocket.client;

/** The websocket endpoints */
public enum WebsocketStream {
    /** The aggTrade endpoint */
    AGGTRADE("aggTrade"),
    /** The trade endpoint */
    TRADE("trade"),
    /** The kline endpoint */
    KLINE("kline"),
    /** The miniTicker endpoint */
    MINI_TICKER("miniTicker"),
    /** The arr endpoint */
    ALL_DATA("arr"),
    /** The ticker endpoint */
    TICKER("ticker"),
    /** The bookTicker endpoint */
    BOOK_TICKER("bookTicker");

    /**
     * The string reprsentation of the enum
     */
    private String value;

    /**
     * Constructor
     * 
     * @param value The string reprsentation of the enum
     */
    private WebsocketStream(String value) {
        this.value = value;
    }

    /**
     * The enum value
     * 
     * @return The string reprsentation of the enum
     */
    public String getValue() {
        return value;
    }
}
