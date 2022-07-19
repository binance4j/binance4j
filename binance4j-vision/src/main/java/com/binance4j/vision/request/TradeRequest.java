package com.binance4j.vision.request;

import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.vision.dto.VisionTrade;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The trade request executor */
public class TradeRequest extends VisionRequest<VisionTrade> {

	/**
	 * @param call The API call.
	 */
	public TradeRequest(Call<ResponseBody> call) {
		super(call);
	}

	protected List<VisionTrade> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(VisionTrade.class, input);
	}
}