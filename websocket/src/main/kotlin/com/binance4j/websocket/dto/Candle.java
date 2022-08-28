package com.binance4j.websocket.dto;

import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Kline/candle for a symbol.
 * 
 * @property openTime                 Candlestick open timestamp in milliseconds
 * @property open                     Open value
 * @property high                     High value
 * @property low                      Low value
 * @property close                    Close value
 * @property volume                   Traded volume in the interval
 * @property closeTime                Candlestick close timestamp in milliseconds
 * @property quoteAssetVolume         Quote asset traded volume
 * @property numberOfTrades           Number of trades
 * @property takerBuyBaseAssetVolume  Taker buy base asset volume
 * @property takerBuyQuoteAssetVolume Taker buy quote asset volume
 * @property eventType                Event type.
 * @property eventTime                Timestamp in ms.
 * @property symbol                   Trading pair.
 * @property intervalId               Interval id.
 * @property firstTradeId             First trade id.
 * @property lastTradeId              Last trade id.
 * @property isBarFinal               Is it the last bar of the interval?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
@ApiModel("Kline/candle for a symbol.")
data class Candle(
@ApiModelProperty("Candlestick open timestamp in milliseconds")
@JsonProperty("openTime") var openTime:Long?=null,
@ApiModelProperty("Open value")
@JsonProperty("open") var open:String?=null,
@ApiModelProperty("High value")
@JsonProperty("high") var high:String?=null,
@ApiModelProperty("Low value")
@JsonProperty("low") var low:String?=null,
@ApiModelProperty("Close value")
@JsonProperty("close") var close:String?=null,
@ApiModelProperty("Traded volume in the interval")
@JsonProperty("volume") var volume:String?=null,
@ApiModelProperty("Candlestick close timestamp in milliseconds")
@JsonProperty("closeTime") var closeTime:Long?=null,
@ApiModelProperty("Quote asset traded volume")
@JsonProperty("quoteAssetVolume") var quoteAssetVolume:String?=null,
@ApiModelProperty("Number of trades")
@JsonProperty("numberOfTrades") var numberOfTrades:Long?=null,
@ApiModelProperty("Taker buy base asset volume")
@JsonProperty("takerBuyBaseAssetVolume") var takerBuyBaseAssetVolume:String?=null,
@ApiModelProperty("Taker buy quote asset volume")
@JsonProperty("takerBuyQuoteAssetVolume") var takerBuyQuoteAssetVolume:String?=null,
@ApiModelProperty("Event type.")
@JsonProperty("eventType") var eventType:String?=null,
@ApiModelProperty("Timestamp in ms.")
@JsonProperty("eventTime") var eventTime:Long?=null,
@ApiModelProperty("Trading pair.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Interval id.")
@JsonProperty("intervalId") var intervalId:String?=null,
@ApiModelProperty("First trade id.")
@JsonProperty("firstTradeId") var firstTradeId:Long?=null,
@ApiModelProperty("Last trade id.")
@JsonProperty("lastTradeId") var lastTradeId:Long?=null,
@ApiModelProperty("Is it the last bar of the interval?")
@JsonProperty("isBarFinal") var isBarFinal:Boolean?=null)
{
}