package com.binance4j.vision.executor;

import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The candlestick request executor */
public class CandlestickRequestExecutor extends VisionRequestExecutor<Candle> {
	/**
	 *
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