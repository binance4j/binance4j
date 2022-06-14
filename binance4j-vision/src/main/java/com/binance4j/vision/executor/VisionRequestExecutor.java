package com.binance4j.vision.executor;

import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.core.request.RequestExecutor;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

/**
 * Base executor implementation for the public data enpoint
 */
public abstract class VisionRequestExecutor<T> extends RequestExecutor<ResponseBody> {

	/**
	 * Constructor
	 *
	 * @param call The API call
	 */
	protected VisionRequestExecutor(Call<ResponseBody> call) {
		super(call);
	}

	/**
	 * Downloads the zip file synchronously
	 *
	 * @return The zip file
	 */
	public ZipInputStream getZip() throws ApiException {
		try {
			return responseToZip(execute());
		} catch (ApiException e) {
			throw new NotFoundException();
		}
	}

	/**
	 * Downloads the zip file asynchronously
	 *
	 * @param callback The callback handling the deserialized data and the API
	 *                 response error
	 */
	public void getZip(ApiCallback<ZipInputStream> callback) {
		then(new ApiCallback<ResponseBody>() {
			@Override
			public void onFailure(ApiException exception) {
				callback.onFailure(exception);
			}

			@Override
			public void onResponse(ResponseBody res) {
				callback.onResponse(responseToZip(res));

			}
		});
	}

	/**
	 * Downloads the zip file synchronously and returns the data in a csv style (2d
	 * list)
	 *
	 * @return The deserialized data
	 */
	public List<List<String>> getCSV() throws ApiException {
		return extractCSV(getZip());
	}

	/**
	 * Downloads the zip file asynchronously and returns the data in a csv style
	 * (2d list)
	 *
	 * @param callback The callback handling the deserialized data and
	 *                 the API response error
	 */
	public void getCSV(ApiCallback<List<List<String>>> callback) {
		then(new ApiCallback<ResponseBody>() {
			@Override
			public void onResponse(ResponseBody res) {
				try {
					callback.onResponse(extractCSV(responseToZip(res)));
				} catch (ApiException e) {
					onFailure(e);
				}
			}

			@Override
			public void onFailure(ApiException exception) {
				callback.onFailure(exception);
			}
		});
	}

	/**
	 * Downloads the zip file synchronously and returns the data in the csv as a
	 * list of objects
	 *
	 * @return The deserialized data
	 */
	public List<T> getData() throws ApiException {
		return csvToObject(getCSV());
	}

	/**
	 * Downloads the zip file asynchronously and returns the data in the csv as a
	 * list of objects
	 *
	 * @param callback The callback handling the deserialized data and
	 *                 the API response error
	 */
	public void getData(ApiCallback<List<T>> callback) {
		then(new ApiCallback<ResponseBody>() {

			@Override
			public void onResponse(ResponseBody res) {
				try {
					callback.onResponse(csvToObject(extractCSV(responseToZip(res))));
				} catch (ApiException e) {
					onFailure(e);
				}
			}

			@Override
			public void onFailure(ApiException exception) {
				callback.onFailure(exception);
			}
		});
	}

	/**
	 * Converts the responseBody into a zip stream
	 *
	 * @param res The responseBody
	 * @return The zip stream
	 */
	protected ZipInputStream responseToZip(ResponseBody res) {
		return new ZipInputStream(res.byteStream());
	}

	/**
	 * Extracts the csv from the zip
	 *
	 * @param zis the zip stream
	 * @return The data as a list of string arrays
	 */
	protected List<List<String>> extractCSV(ZipInputStream zis) throws ApiException {
		try {
			List<List<String>> data = new ArrayList<>();
			Scanner sc = new Scanner(zis);

			zis.getNextEntry();

			while (sc.hasNextLine()) {
				data.add(Arrays.asList(sc.nextLine().split(",")));
			}

			sc.close();
			return data;
		} catch (IOException e) {
			throw new ApiException(-400, e.getMessage());
		}
	}

	/**
	 * Converts the csv into a list of the desired type
	 *
	 * @param input The data as a list of string arrays
	 * @return The data as a list of objects
	 */
	protected List<T> csvToObject(Class<T> clazz,
	                              List<List<String>> input) throws ApiException {
		List<T> obj = new ArrayList<>();
		for (List<String> csv : input) {
			try {
				// The class must have a constructor that accepts a 2d list
				obj.add(clazz.getConstructor(List.class).newInstance(csv));
			} catch (Exception e) {
				throw new ApiException(-300, e.getMessage());
			}
		}
		return obj;
	}

	/**
	 * The child class method to convert the csv list into a list of the generic
	 * type
	 *
	 * @param input The csv input
	 * @return A list of
	 */
	protected abstract List<T> csvToObject(List<List<String>> input) throws ApiException;
}