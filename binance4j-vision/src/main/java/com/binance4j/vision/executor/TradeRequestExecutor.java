package com.binance4j.vision.executor;

import com.binance4j.core.exception.ApiException;
import com.binance4j.vision.spot.VisionTrade;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.util.List;

/**
 * The trade request executor
 */
public class TradeRequestExecutor extends VisionRequestExecutor<VisionTrade> {

	/**
	 * Constructor
	 *
	 * @param call The API call
	 */
	public TradeRequestExecutor(Call<ResponseBody> call) {
		super(call);
	}

	protected List<VisionTrade> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(VisionTrade.class, input);
	}
}