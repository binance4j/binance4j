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

package com.binance4j.connectors.mining.dto

import com.binance4j.connectors.mining.client.MiningClient
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Workers data wrapper. [MiningClient.getMiners] response.
 *
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Workers data wrapper.")
data class WorkersResponse(
    @ApiModelProperty("Response code.")
    @JsonProperty("code")
    var code: Int,
    @ApiModelProperty("Response message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Response data.")
    @JsonProperty("data")
    var data: WorkersData?
) {
    /**
     * Workers data.
     *
     * @property workerDatas Workers data.
     * @property totalNum    Total amount.
     * @property pageSize    Rows per page.
     */
    @ApiModel("Workers data.")
    data class WorkersData(
        @ApiModelProperty("Workers data.")
        @JsonProperty("workerDatas")
        var workerDatas: List<Worker>?,
        @ApiModelProperty("Total amount.")
        @JsonProperty("totalNum")
        var totalNum: Long,
        @ApiModelProperty("Rows per page.")
        @JsonProperty("pageSize")
        var pageSize: Long
    ) {
        /**
         * A miner/worker data.
         *
         * @property workerId      Miner id.
         * @property workerName    Miner's name'.
         * @property status        Status：1 valid,2 invalid, 3 no longer valid.
         * @property hashRate      Real-time rate.
         * @property dayHashRate   24H Hash rate.
         * @property rejectRate    Real-time Rejection Rate.
         * @property lastShareTime Last submission time.
         */
        @ApiModel("A miner/worker data.")
        data class Worker(
            @ApiModelProperty("Miner id.")
            @JsonProperty("workerId")
            var workerId: String,
            @ApiModelProperty("Miner's name'.")
            @JsonProperty("workerName")
            var workerName: String,
            @ApiModelProperty("Status：1 valid,2 invalid, 3 no longer valid.")
            @JsonProperty("status")
            var status: Long,
            @ApiModelProperty("Real-time rate.")
            @JsonProperty("hashRate")
            var hashRate: Long,
            @ApiModelProperty("24H Hashrate.")
            @JsonProperty("dayHashRate")
            var dayHashRate: Long,
            @ApiModelProperty("Real-time Rejection Rate.")
            @JsonProperty("rejectRate")
            var rejectRate: Long,
            @ApiModelProperty("Last submission time.")
            @JsonProperty("lastShareTime")
            var lastShareTime: Long
        )
    }
}