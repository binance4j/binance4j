/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.vision.param;

import com.binance4j.core.Request;
import com.binance4j.core.callback.ApiAsyncCallback;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.vision.dto.VisionChecksum;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.util.Scanner;

/**
 * Vision data checksum request
 */
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
        String[] data = {""};
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
