package com.binance4j.vision.executor;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.AggTrade;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.util.List;

/**
 * The aggregated trade request executor
 */
public class AggTradeRequestExecutor extends VisionRequestExecutor<AggTrade> {

	/**
	 * Constructor
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