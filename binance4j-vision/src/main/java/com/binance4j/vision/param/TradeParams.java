package com.binance4j.vision.param;

import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.vision.dto.VisionTrade;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The trade request executor */
public class TradeParams extends VisionParams<VisionTrade> {
	/**
	 * @param call The API call.
	 */
	public TradeParams(Call<ResponseBody> call) {
		super(call);
	}

	protected List<VisionTrade> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(VisionTrade.class, input);
	}
}