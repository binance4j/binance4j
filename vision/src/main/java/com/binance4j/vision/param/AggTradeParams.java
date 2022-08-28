package com.binance4j.vision.param;

import java.util.List;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.exception.ApiException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** The aggregated trade request executor */
@Param
public class AggTradeParams extends VisionParams<AggTrade> {
	/**
	 * @param call API call.
	 */
	public AggTradeParams(Call<ResponseBody> call) {
		super(call);
	}

	protected List<AggTrade> csvToObject(List<List<String>> input) throws ApiException {
		return csvToObject(AggTrade.class, input);
	}
}