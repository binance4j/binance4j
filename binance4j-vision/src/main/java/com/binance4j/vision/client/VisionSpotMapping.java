package com.binance4j.vision.client;

import com.binance4j.core.client.RestMapping;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/** The API SPOT calls */
public interface VisionSpotMapping extends RestMapping {
	/** monthly klines url */
	String MONTHLY_KLINES_URL = "spot/monthly/klines/{symbol}/{candlestick_interval}/{symbol}-{candlestick_interval}-{year}-{month}.zip";
	/** daily klines url */
	String DAILY_KLINES_URL = "spot/daily/klines/{symbol}/{candlestick_interval}/{symbol}-{candlestick_interval}-{year}-{month}-{day}.zip";
	/** monthly trades url */
	String MONTHLY_TRADES_URL = "spot/monthly/trades/{symbol}/{symbol}-trades-{year}-{month}.zip";
	/** daily trades url */
	String DAILY_TRADES_URL = "spot/daily/trades/{symbol}/{symbol}-trades-{year}-{month}-{day}.zip";
	/** monthly aggtrades url */
	String MONTHLY_AGGTRADES_URL = "spot/monthly/aggTrades/{symbol}/{symbol}-aggTrades-{year}-{month}.zip";
	/** daily aggtrades url */
	String DAILY_AGGTRADES_URL = "spot/daily/aggTrades/{symbol}/{symbol}-aggTrades-{year}-{month}-{day}.zip";

	/**
	 * Mapping of the monthly candlestick data call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_KLINES_URL)
	Call<ResponseBody> getMonthlyKlines(@Path("symbol") String symbol,
			@Path("candlestick_interval") String candlestickInterval, @Path("year") String year,
			@Path("month") String month);

	/**
	 * Mapping of the monthly candlestick data cheksum call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_KLINES_URL + ".CHECKSUM")
	Call<ResponseBody> getMonthlyKlinesChecksum(@Path("symbol") String symbol,
			@Path("candlestick_interval") String candlestickInterval,
			@Path("year") String year, @Path("month") String month);

	/**
	 * Mapping of the daily candlestick data call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @param day                 Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_KLINES_URL)
	Call<ResponseBody> getDailyKlines(@Path("symbol") String symbol,
			@Path("candlestick_interval") String candlestickInterval, @Path("year") String year,
			@Path("month") String month, @Path("day") String day);

	/**
	 * Mapping of the daily candlestick data checksum call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @param day                 Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_KLINES_URL + ".CHECKSUM")
	Call<ResponseBody> getDailyKlinesChecksum(@Path("symbol") String symbol,
			@Path("candlestick_interval") String candlestickInterval,
			@Path("year") String year, @Path("month") String month, @Path("day") String day);

	// Trades

	/**
	 * Mapping of the monthly trades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_TRADES_URL)
	Call<ResponseBody> getMonthlyTrades(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month);

	/**
	 * Mapping of the monthly trades cheksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_TRADES_URL + ".CHECKSUM")
	Call<ResponseBody> getMonthlyTradesChecksum(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month);

	/**
	 * Mapping of the daily trades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_TRADES_URL)
	Call<ResponseBody> getDailyTrades(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month, @Path("day") String day);

	/**
	 * Mapping of the daily trades checksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_TRADES_URL + ".CHECKSUM")
	Call<ResponseBody> getDailyTradesChecksum(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month, @Path("day") String day);

	// AggTrades

	/**
	 * Mapping of the monthly aggTrades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_AGGTRADES_URL)
	Call<ResponseBody> getMonthlyAggTrades(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month);

	/**
	 * Mapping of the monthly aggTrades cheksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_AGGTRADES_URL + ".CHECKSUM")
	Call<ResponseBody> getMonthlyAggTradesChecksum(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month);

	/**
	 * Mapping of the daily aggTrades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_AGGTRADES_URL)
	Call<ResponseBody> getDailyAggTrades(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month, @Path("day") String day);

	/**
	 * Mapping of the daily aggTrades checksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_AGGTRADES_URL + ".CHECKSUM")
	Call<ResponseBody> getDailyAggTradesChecksum(@Path("symbol") String symbol, @Path("year") String year,
			@Path("month") String month,
			@Path("day") String day);
}
