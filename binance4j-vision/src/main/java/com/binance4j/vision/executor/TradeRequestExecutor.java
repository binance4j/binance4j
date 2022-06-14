package com.binance4j.vision.executor;

import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.vision.spot.Trade;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * The trade request executor
 */
public class TradeRequestExecutor extends VisionRequestExecutor<Trade> {

    public TradeRequestExecutor(List<Call<ResponseBody>> call) {
        super(call);
    }

    public TradeRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    protected List<Trade> csvToObject(List<List<String>> input) throws ApiException {
        return csvToObject(Trade.class, input);
    }
}