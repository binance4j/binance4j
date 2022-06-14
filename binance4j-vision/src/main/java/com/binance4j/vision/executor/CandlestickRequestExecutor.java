package com.binance4j.vision.executor;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.util.List;

/**
 * The candlestick request executor
 */
public class CandlestickRequestExecutor extends VisionRequestExecutor<Candle> {
	/**
	 * Constructor
	 *
	 * @param call The API call
	 */
	public CandlestickRequestExecutor(Call<ResponseBody> call) {
		super(call);
	}

	protected List<Candle> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(Candle.class, input);
	}
}