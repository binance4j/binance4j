package com.binance4j.vision.request;

import java.util.List;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.exception.ApiException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The aggregated trade request executor */
public class AggTradeRequest extends VisionRequest<AggTrade> {

	/**
	 *
	 * 
	 * @param call The API call
	 */
	public AggTradeRequest(Call<ResponseBody> call) {
		super(call);
	}

	protected List<AggTrade> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(AggTrade.class, input);
	}
}