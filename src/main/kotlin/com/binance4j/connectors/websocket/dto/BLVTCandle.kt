/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.websocket.dto

import com.binance4j.connectors.core.dto.CandlestickInterval
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Net asset value candle.
 *
 * @property startTime     Start time.
 * @property endTime       End time.
 * @property name          Name.
 * @property interval     Interval.
 * @property firstUpdate   First update.
 * @property lastUpdate    Last update.
 * @property open          Open.
 * @property close         Close.
 * @property high          High.
 * @property low           Low.
 * @property realLeverage  Real leverage.
 * @property updateNumbers Number of updates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Net asset value candle.")
data class BLVTCandle(
	@ApiModelProperty("Start time.")
	@JsonProperty("t")
	var startTime: Long,
	@ApiModelProperty("End time.")
	@JsonProperty("T")
	var endTime: Long,
	@ApiModelProperty("Name.")
	@JsonProperty("s")
	var name: String,
	@ApiModelProperty("Interval.")
	@JsonProperty("i")
	var interval: CandlestickInterval,
	@ApiModelProperty("First update.")
	@JsonProperty("f")
	var firstUpdate: Long,
	@ApiModelProperty("Last update.")
	@JsonProperty("L")
	var lastUpdate: Long,
	@ApiModelProperty("Open.")
	@JsonProperty("o")
	var open: String,
	@ApiModelProperty("Close.")
	@JsonProperty("c")
	var close: String,
	@ApiModelProperty("High.")
	@JsonProperty("h")
	var high: String,
	@ApiModelProperty("Low.")
	@JsonProperty("l")
	var low: String,
	@ApiModelProperty("Real leverage.")
	@JsonProperty("v")
	var realLeverage: String,
	@ApiModelProperty("Number of updates.")
	@JsonProperty("n")
	var updateNumbers: Long,
)
