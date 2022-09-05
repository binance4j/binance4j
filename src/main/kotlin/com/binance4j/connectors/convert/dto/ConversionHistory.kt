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

package com.binance4j.connectors.convert.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Conversions history.
 *
 * @property list Conversions.
 * @property startTime Start time in ms.
 * @property endTime End time in ms.
 * @property limit Results limit.
 * @property moreData Is there more data?
 */
@ApiModel("Conversions history.")
data class ConversionHistory(
	@ApiModelProperty("The conversions.")
	@JsonProperty("list")
	var list: List<Conversion>,
	@ApiModelProperty("Start time in ms.")
	@JsonProperty("startTime")
	var startTime: Long,
	@ApiModelProperty("End time in ms.")
	@JsonProperty("endTime")
	var endTime: Long,
	@ApiModelProperty("Results limit.")
	@JsonProperty("limit")
	var limit: Int,
	@ApiModelProperty("Is there more data?")
	@JsonProperty("moreData")
	var moreData: Boolean
)