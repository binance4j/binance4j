package com.binance4j.blvt.client;

import com.binance4j.blvt.param.LimitInfoParams;
import com.binance4j.blvt.param.RedemptionParams;
import com.binance4j.blvt.param.SubscriptionParams;
import com.binance4j.blvt.param.TokenInfoParams;
import com.binance4j.blvt.param.TransactionRecordParams;
import com.binance4j.blvt.request.GetLimitInfoRequest;
import com.binance4j.blvt.request.GetRedemptionsRequest;
import com.binance4j.blvt.request.GetSubscriptionsRequest;
import com.binance4j.blvt.request.GetTokenInfoRequest;
import com.binance4j.blvt.request.RedeemRequest;
import com.binance4j.blvt.request.SubscribeRequest;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;

/**
 * Api client for the BLVT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints">Documentation</a>
 */
public class BLVTClient extends RestClient<BLVTMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public BLVTClient(String key, String secret) {
		super(BLVTMapping.class, key, secret);
	}

	/**
	 * Get BLVT Info.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTokenInfoRequest getTokenInfo(TokenInfoParams params) {
		return new GetTokenInfoRequest(service.getTokenInfo(params.toMap()));
	}

	/**
	 * Get BLVT Info.
	 *
	 * @return The request to execute.
	 */
	public GetTokenInfoRequest getTokenInfo() {
		return new GetTokenInfoRequest(service.getTokenInfo(new TokenInfoParams(null).toMap()));
	}

	/**
	 * Subscribe BLVT.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public SubscribeRequest subscribe(SubscriptionParams params) {
		return new SubscribeRequest(service.subscribe(params.toMap()));
	}

	/**
	 * Get subscription record.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time search params.
	 * @return The request to execute.
	 */
	public GetSubscriptionsRequest getSubscriptions(TransactionRecordParams params, TimeFrame timeFrame) {
		return new GetSubscriptionsRequest(service.getSubscriptions(Params.merge(params, timeFrame)));
	}

	/**
	 * Get subscription record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetSubscriptionsRequest getSubscriptions(TransactionRecordParams params) {
		return new GetSubscriptionsRequest(service.getSubscriptions(params.toMap()));
	}

	/**
	 * Get subscription record.
	 * 
	 * @return The request to execute.
	 */
	public GetSubscriptionsRequest getSubscriptions() {
		return new GetSubscriptionsRequest(service.getSubscriptions(new TransactionRecordParams(null, null).toMap()));
	}

	/**
	 * Redeem BLVT.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public RedeemRequest redeem(RedemptionParams params) {
		return new RedeemRequest(service.redeem(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time search params.
	 * @return The request to execute.
	 */
	public GetRedemptionsRequest getRedemptions(TransactionRecordParams params, TimeFrame timeFrame) {
		return new GetRedemptionsRequest(service.getRedemptions(Params.merge(params, timeFrame)));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetRedemptionsRequest getRedemptions(TransactionRecordParams params) {
		return new GetRedemptionsRequest(service.getRedemptions(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @return The request to execute.
	 */
	public GetRedemptionsRequest getRedemptions() {
		return new GetRedemptionsRequest(service.getRedemptions(new TransactionRecordParams(null, null).toMap()));
	}

	/**
	 * Get user limit info.
	 * 
	 * @param params Request params.
	 * @return The request to LimitInfo
	 */
	public GetLimitInfoRequest getLimitInfo(LimitInfoParams params) {
		return new GetLimitInfoRequest(service.getLimitInfo(params.toMap()));
	}

	/**
	 * Get user limit info.
	 * 
	 * @return The request to LimitInfo
	 */
	public GetLimitInfoRequest getLimitInfo() {
		return new GetLimitInfoRequest(service.getLimitInfo(new LimitInfoParams(null).toMap()));
	}
}
