package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.ApiPermissions;

import retrofit2.Call;

/** {@link WalletClient#getApiPermissions} request. */
@PostRequest(path = "/sapi/v1/account/apiRestrictions", signature = Signature.USER_DATA)
public class GetApiPermissionsRequest extends Request<ApiPermissions> {
	/**
	 * @param call the retrofit call
	 */
	public GetApiPermissionsRequest(Call<ApiPermissions> call) {
		super(call);
	}
}
