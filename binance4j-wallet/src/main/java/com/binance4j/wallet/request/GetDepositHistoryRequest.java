package com.binance4j.wallet.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.DepositHistory;

import retrofit2.Call;

/** {@link WalletClient#getDepositHistory} request. */
@GetRequest(path = "/sapi/v1/capital/deposit/hisrec", signature = Signature.USER_DATA)
public class GetDepositHistoryRequest extends Request<List<DepositHistory>> {
	/**
	 * @param call the retrofit call
	 */
	public GetDepositHistoryRequest(Call<List<DepositHistory>> call) {
		super(call);
	}
}
