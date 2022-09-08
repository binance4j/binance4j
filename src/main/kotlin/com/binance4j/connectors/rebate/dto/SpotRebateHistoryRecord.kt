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

package com.binance4j.connectors.rebate.dto

import com.binance4j.connectors.rebate.client.RebateClient
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * [RebateClient.getSpotRebateHistoryRecords] response.
 *
 * @property status Status.
 * @property type   Type.
 * @property code   Code.
 * @property data   Data.
 */
@ApiModel("Rebate history record")
data class SpotRebateHistoryRecord(
    @ApiModelProperty("Status.")
    @JsonProperty("status")
    var status: String,
    @ApiModelProperty("Type.")
    @JsonProperty("type")
    var type: String,
    @ApiModelProperty("Code.")
    @JsonProperty("code")
    var code: String,
    @ApiModelProperty("Data.")
    @JsonProperty("data")
    var data: RebateData?
) {
    /**
     * Rebate data.
     *
     * @property page         Current page.
     * @property totalRecords Total records.
     * @property totalPageNum Total pages.
     * @property data         Rebates.
     */
    @ApiModel("Rebate data.")
    data class RebateData(
        @ApiModelProperty("Current page.")
        @JsonProperty("page")
        var page: Int,
        @ApiModelProperty("Total records.")
        @JsonProperty("totalRecords")
        var totalRecords: Int,
        @ApiModelProperty("Total pages.")
        @JsonProperty("totalPageNum")
        var totalPageNum: Int,
        @ApiModelProperty("Rebates.")
        @JsonProperty("data")
        var data: List<Rebate>?
    ) {
        /**
         * A rebate.
         *
         * @property asset      Rebate asset.
         * @property type       Rebate type.
         * @property amount     Rebate amount.
         * @property updateTime Rebate update time.
         */
        @ApiModel("A rebate.")
        data class Rebate(
            @ApiModelProperty("Rebate asset.")
            @JsonProperty("asset")
            var asset: String,
            @ApiModelProperty("Rebate type.")
            @JsonProperty("type")
            var type: String,
            @ApiModelProperty("Rebate amount.")
            @JsonProperty("amount")
            var amount: String,
            @ApiModelProperty("Rebate update time.")
            @JsonProperty("updateTime")
            var updateTime: Long,
        )
    }
}