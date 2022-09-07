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
 * [MiningClient.getAccounts] response.
 *
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Accounts list wrapper")
data class AccountListResponse(
    @ApiModelProperty("Response code.")
    @JsonProperty("code")
    var code: Int,
    @ApiModelProperty("Response message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Response data.")
    @JsonProperty("data")
    var data: List<AccountData>
) {
    /**
     * Account data.
     *
     * @property type     Type of daily hash rate.
     * @property userName Mining account.
     * @property list     List.
     */
    @ApiModel("Account data.")
    data class AccountData(
        @ApiModelProperty("Type of daily hash rate.")
        @JsonProperty("type")
        var type: String,
        @ApiModelProperty("Mining account.")
        @JsonProperty("userName")
        var userName: String?,
        @ApiModelProperty("List.")
        @JsonProperty("list")
        var list: List<AccountList>?
    ) {
        /**
         * Account statistics.
         *
         * @property time     Time in ms.
         * @property hashrate Hashrate.
         * @property reject   Reject rate.
         */
        @ApiModel("Account statistics.")
        data class AccountList(
            @ApiModelProperty("Time in ms.")
            @JsonProperty("time")
            var time: Long,
            @ApiModelProperty("Hashrate.")
            @JsonProperty("hashrate")
            var hashrate: String,
            @ApiModelProperty("Reject rate.")
            @JsonProperty("reject")
            var reject: String
        )
    }

}