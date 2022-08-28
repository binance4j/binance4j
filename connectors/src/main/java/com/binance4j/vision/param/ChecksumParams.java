package com.binance4j.vision.param;

import java.util.Scanner;

import com.binance4j.core.Request;
import com.binance4j.core.callback.ApiAsyncCallback;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.vision.dto.VisionChecksum;

import okhttp3.ResponseBody;
import retrofit2.Call;

/** Vision data checksum request */
public class ChecksumParams extends Request<ResponseBody> {
	/**
	 * @param call API call.
	 */
	public ChecksumParams(Call<ResponseBody> call) {
		super(call);
	}

	/**
	 * Retrieves the checksum from the response body
	 *
	 * @param res Response body.
	 * @return The checksum wrapper.
	 */
	private VisionChecksum resToChecksum(ResponseBody res) {
		Scanner sc = new Scanner(res.byteStream());
		String[] data = { "" };
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			data = line.split("\\s+");
		}
		sc.close();
		return new VisionChecksum(data[0], data[1]);
	}

	/**
	 * @return The checksum.
	 * @throws ApiException Thrown if data fetching failed.
	 */
	public VisionChecksum getChecksum() throws ApiException {
		return resToChecksum(sync());
	}

	@Override
	public ResponseBody sync() throws ApiException {
		try {
			return super.sync();
		} catch (Exception e) {
			throw new NotFoundException();
		}
	}

	/**
	 * Downloads the zip file asynchronously
	 *
	 * @param callback Callback handling the deserialized data and the API response
	 *                 error.
	 */
	public void getChecksum(ApiAsyncCallback<VisionChecksum> callback) {
		async((res, e) -> callback.onResponse(resToChecksum(res), e));
	}
}
