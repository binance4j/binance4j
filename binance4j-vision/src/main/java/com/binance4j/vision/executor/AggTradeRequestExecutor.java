package com.binance4j.vision.executor;

import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.AggTrade;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The aggregated trade request executor */
public class AggTradeRequestExecutor extends VisionRequestExecutor<AggTrade> {

	/**
	 *
	 * 
	 * @param call The API call
	 */
	public AggTradeRequestExecutor(Call<ResponseBody> call) {
		super(call);
	}

	protected List<AggTrade> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(AggTrade.class, input);
	}
}