package com.binance4j.blvt.client

import com.binance4j.blvt.dto.*
import com.binance4j.blvt.param.*
import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.core.param.Params
import com.binance4j.core.param.TimeFrame


/**
 * Api client for the BLVT endpoints.
 * @param key    API public key.
 * @param secret API secret key.
 *
 * [Binance doc](https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints)
 */
class BLVTClient(key: String, secret: String) : RestClient<BLVTMapping>(BLVTMapping::class.java, key, secret) {
    /**
     * Get BLVT Info.
     * @param params Request params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTokenInfo(params: TokenInfoParams? = TokenInfoParams()): Request<List<Token>> = Request(service.getTokenInfo(Params.merge(params)))

    /**
     * Get subscription record.
     * @param params    Request params.
     * @param timeFrame Time search params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getSubscriptions(params: TransactionRecordParams? = TransactionRecordParams(), timeFrame: TimeFrame? = null): Request<List<Subscription>> =
        Request(service.getSubscriptions(Params.merge(params, timeFrame)))

    /**
     * Get redemption record.
     * @param params    Request params.
     * @param timeFrame Time search params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getRedemptions(params: TransactionRecordParams? = TransactionRecordParams(), timeFrame: TimeFrame? = null): Request<List<Redemption>> =
        Request(service.getRedemptions(Params.merge(params, timeFrame)))

    /**
     * Get user limit info.
     * @param params Request params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getLimitInfo(params: LimitInfoParams? = LimitInfoParams()): Request<List<LimitInfo>> = Request(service.getLimitInfo(Params.merge(params)))


    /**
     * Subscribe BLVT.
     * @param params Request params.
     * @return The request to execute.
     */
    fun subscribe(params: SubscriptionParams): Request<SubscriptionResponse> = Request(service.subscribe(params.toMap()))


    /**
     * Redeem BLVT.
     * @param params Request params.
     * @return The request to execute.
     */
    fun redeem(params: RedemptionParams): Request<RedemptionResponse> = Request(service.redeem(params.toMap()))
}