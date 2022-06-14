package com.binance4j.vision.executor;

import java.util.List;
import java.util.Scanner;

import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.vision.spot.Checksum;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ChecksumRequestExecutor extends RequestExecutor<ResponseBody> {
    /**
     * The default constructor
     * 
     * @param call The retrofit call
     */
    public ChecksumRequestExecutor(List<Call<ResponseBody>> call) {
        super(call);
    }

    public ChecksumRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    /**
     * Retrieves the checksum from the response body
     * 
     * @param res The response body
     * @return The checksum wrapper
     */
    private Checksum resToChecksum(ResponseBody res) {
        Scanner sc = new Scanner(res.byteStream());
        String[] data = { "" };
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            data = line.split("\\s+");
        }
        sc.close();
        return new Checksum(data[0], data[1]);
    }

    public Checksum getChecksum() throws ApiException {
        return resToChecksum(execute());
    }

    @Override
    public ResponseBody execute() throws ApiException {
        try {
            return super.execute();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    /**
     * Downloads the zip file asynchronously
     * 
     * @param callback The callback handling the deserialized data and the API
     *                 response error
     */
    public void getChecksum(ApiCallback<Checksum> callback) {
        then(new ApiCallback<ResponseBody>() {
            @Override
            public void onFailure(ApiException exception) {
                callback.onFailure(exception);
            }

            @Override
            public void onResponse(ResponseBody res) {
                callback.onResponse(resToChecksum(res));
            }
        });
    }
}
