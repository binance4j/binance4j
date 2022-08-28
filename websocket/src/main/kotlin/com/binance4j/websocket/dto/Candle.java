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
var openTime:Long?=null,
@ApiModelProperty("Open value")
var open:String?=null,
@ApiModelProperty("High value")
var high:String?=null,
@ApiModelProperty("Low value")
var low:String?=null,
@ApiModelProperty("Close value")
var close:String?=null,
@ApiModelProperty("Traded volume in the interval")
var volume:String?=null,
@ApiModelProperty("Candlestick close timestamp in milliseconds")
var closeTime:Long?=null,
@ApiModelProperty("Quote asset traded volume")
var quoteAssetVolume:String?=null,
@ApiModelProperty("Number of trades")
var numberOfTrades:Long?=null,
@ApiModelProperty("Taker buy base asset volume")
var takerBuyBaseAssetVolume:String?=null,
@ApiModelProperty("Taker buy quote asset volume")
var takerBuyQuoteAssetVolume:String?=null,
@ApiModelProperty("Event type.")
var eventType:String?=null,
@ApiModelProperty("Timestamp in ms.")
var eventTime:Long?=null,
@ApiModelProperty("Trading pair.")
var symbol:String?=null,
@ApiModelProperty("Interval id.")
var intervalId:String?=null,
@ApiModelProperty("First trade id.")
var firstTradeId:Long?=null,
@ApiModelProperty("Last trade id.")
var lastTradeId:Long?=null,
@ApiModelProperty("Is it the last bar of the interval?")
var isBarFinal:Boolean?=null)
{
}