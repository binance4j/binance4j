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
public abstract class VisionParams<T> extends Request<ResponseBody> {
    /**
     * @param call API call.
     */
    protected VisionParams(Call<ResponseBody> call) {
        super(call);
    }

    /**
     * Downloads the zip file synchronously
     *
     * @return The zip file.
     * @throws ApiException Thrown if data fetching failed
     */
    public ZipInputStream getZip() throws ApiException {
        try {
            return responseToZip(sync());
        } catch (ApiException e) {
            throw new NotFoundException();
        }
    }

    /**
     * Downloads the zip file asynchronously
     *
     * @param callback Callback handling the deserialized data and the API response
     *                 error.
     */
    public void getZip(ApiAsyncCallback<ZipInputStream> callback) {
        async((res, exc) -> callback.onResponse(responseToZip(res), exc));
    }

    /**
     * Downloads the zip file synchronously and returns the data in a csv style (2d
     * list)
     *
     * @return The deserialized data.
     * @throws ApiException Thrown if data fetching failed
     */
    public List<List<String>> getCSV() throws ApiException {
        return extractCSV(getZip());
    }

    /**
     * Downloads the zip file asynchronously and returns the data in a csv style (2d
     * list)
     *
     * @param callback Callback handling the deserialized data and the API response
     *                 error.
     */
    public void getCSV(ApiAsyncCallback<List<List<String>>> callback) {
        async(new ApiAsyncCallback<ResponseBody>() {
            @Override
            public void onResponse(ResponseBody res, ApiException e) {
                try {
                    callback.onResponse(extractCSV(responseToZip(res)), null);
                } catch (ApiException ex) {
                    callback.onResponse(null, ex);
                }
            }
        });
    }

    /**
     * Downloads the zip file synchronously and returns the data in the csv as a
     * list of objects
     *
     * @return The deserialized data.
     * @throws ApiException Thrown if data fetching failed
     */
    public List<T> getData() throws ApiException {
        return csvToObject(getCSV());
    }

    /**
     * Downloads the zip file asynchronously and returns the data in the csv as a
     * list of objects
     *
     * @param callback Callback handling the deserialized data and the API response
     *                 error.
     */
    public void getData(ApiAsyncCallback<List<T>> callback) {
        async(new ApiAsyncCallback<ResponseBody>() {
            @Override
            public void onResponse(ResponseBody res, ApiException e) {
                try {
                    callback.onResponse(csvToObject(extractCSV(responseToZip(res))), null);
                } catch (ApiException ex) {
                    callback.onResponse(null, ex);
                }
            }
        });
    }

    /**
     * Converts the responseBody into a zip stream
     *
     * @param res ResponseBody.
     * @return The zip stream.
     */
    protected ZipInputStream responseToZip(ResponseBody res) {
        return new ZipInputStream(res.byteStream());
    }

    /**
     * Extracts the csv from the zip
     *
     * @param zis Zip stream.
     * @return The data as a list of string arrays.
     * @throws ApiException Thrown if data fetching failed
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
     * @param clazz Object class
     * @param input Data as a list of string arrays.
     * @return The data as a list of objects.
     * @throws ApiException Thrown if data fetching failed
     */
    protected List<T> csvToObject(Class<T> clazz, List<List<String>> input) throws ApiException {
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
     * @param input Csv input.
     * @return A list of.
     * @throws ApiException Thrown if data fetching failed
     */
    protected abstract List<T> csvToObject(List<List<String>> input) throws ApiException;
}