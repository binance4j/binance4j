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
 * [MiningClient.getHashrateResales] response.
 *
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Hash rate resale list wrapper")
data class HashrateResaleListResponse(
    @ApiModelProperty("Response code.")
    @JsonProperty("code")
    var code: Int,
    @ApiModelProperty("Response message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Response data.")
    @JsonProperty("data")
    var data: HashrateResaleListDetailData?
) {
    /**
     * Hash rate detail data.
     *
     * @property configDetails Config details.
     * @property totalNum      Total amount.
     * @property pageSize      Rows per page.
     */
    @ApiModel("Hash rate detail data.")
    data class HashrateResaleListDetailData(
        @ApiModelProperty("Config details.")
        @JsonProperty("configDetails")
        var configDetails: List<HashrateResaleListDetail>?,
        @ApiModelProperty("Total amount.")
        @JsonProperty("totalNum")
        var totalNum: Long,
        @ApiModelProperty("Rows per page.")
        @JsonProperty("pageSize")
        var pageSize: Long
    ) {
        /**
         * Hash rate resale list detail.
         *
         * @property configId       Mining ID.
         * @property poolUsername   Transfer out of subaccount.
         * @property toPoolUsername Transfer into subaccount.
         * @property algoName       Transfer algorithm.
         * @property hashRate       Transferred Hash rate quantity.
         * @property startDay       Start date.
         * @property endDay         End date.
         * @property status         Status：0 Processing，1：Cancelled，2：Terminated.
         */
        @ApiModel("Hash rate resale list detail.")
        data class HashrateResaleListDetail(
            @ApiModelProperty("Mining ID.")
            @JsonProperty("configId")
            var configId: Int,
            @ApiModelProperty("Transfer out of subaccount.")
            @JsonProperty("poolUsername")
            var poolUsername: String,
            @ApiModelProperty("Transfer into subaccount.")
            @JsonProperty("toPoolUsername")
            var toPoolUsername: String,
            @ApiModelProperty("Transfer algorithm.")
            @JsonProperty("algoName")
            var algoName: String,
            @ApiModelProperty("Transferred Hash rate quantity.")
            @JsonProperty("hashRate")
            var hashRate: Long,
            @ApiModelProperty("Start date.")
            @JsonProperty("startDay")
            var startDay: Long,
            @ApiModelProperty("End date.")
            @JsonProperty("endDay")
            var endDay: Long,
            @ApiModelProperty("Status：0 Processing，1：Cancelled，2：Terminated.")
            @JsonProperty("status")
            var status: Int
        )
    }
}