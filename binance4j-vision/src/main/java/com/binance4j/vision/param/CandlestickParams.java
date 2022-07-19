package com.binance4j.vision.param;

import java.util.List;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.exception.ApiException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The candlestick request executor */
public class CandlestickParams extends VisionParams<Candle> {
	/**
	 * @param call The API call.
	 */
	public CandlestickParams(Call<ResponseBody> call) {
		super(call);
	}

	protected List<Candle> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(Candle.class, input);
	}
}