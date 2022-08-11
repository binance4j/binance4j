package com.binance4j.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.vision.dto.VisionTrade;
import com.binance4j.vision.param.ChecksumParams;
import com.binance4j.web.annotation.JsonGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Vision endpoints. */
@RestController
@RequestMapping("api/v1/vision")
@Api(value = "Vision", tags = "Vision", produces = "application/json", description = "Vision endpoints")
public class VisionController extends BaseController {

	// AggTrade

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's aggregated trades (daily).
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "aggtrades/{symbol}/{year}/{month}/{day}.json")
	@ApiOperation(value = "Get symbol's aggregated trades (daily).")

	public List<AggTrade> getAggTradesDailyJson(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException {
		return connectors.rest().visionSpot().getAggTrades(symbol, year, month, day).getData();
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return Get symbol's aggregated trades (monthly).
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "aggtrades/{symbol}/{year}/{month}.json")
	@ApiOperation(value = "Get symbol's aggregated trades (monthly).")
	public List<AggTrade> getAggTradesMonthlyJson(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException {
		return connectors.rest().visionSpot().getAggTrades(symbol, year, month).getData();
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's aggregated trades in a zip format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "aggtrades/{symbol}/{year}/{month}/{day}.zip", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's aggregated trades (daily).")

	public ResponseEntity<byte[]> getAggTradesDailyZip(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return ZisToZosResponse(connectors.rest().visionSpot().getAggTrades(symbol, year, month, day).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return Get symbol's aggregated trades in a zip format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "aggtrades/{symbol}/{year}/{month}.zip", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's aggregated trades (monthly).")

	public ResponseEntity<byte[]> getAggTradesMonthlyZip(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return ZisToZosResponse(connectors.rest().visionSpot().getAggTrades(symbol, year, month).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's aggregated trades in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "aggtrades/{symbol}/{year}/{month}/{day}.csv", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's aggregated trades (daily).")

	public ResponseEntity<byte[]> getAggTradesDailyCsv(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return zisToCsvResponse(connectors.rest().visionSpot().getAggTrades(symbol, year, month, day).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return Get symbol's aggregated trades in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "aggtrades/{symbol}/{year}/{month}.csv", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's aggregated trades (monthly).")

	public ResponseEntity<byte[]> getAggTradesMonthlyCsv(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return zisToCsvResponse(connectors.rest().visionSpot().getAggTrades(symbol, year, month).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's aggregated trades file checksum (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@JsonGetMapping(path = "aggtrades/{symbol}/{year}/{month}/{day}.checksum")
	@ApiOperation(value = "Get symbol's aggregated trades file checksum (daily).")

	public ChecksumParams getAggTradesDailyChecksum(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return connectors.rest().visionSpot().getAggTradesChecksum(symbol, year, month, day);
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return Get symbol's aggregated trades file checksum (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@JsonGetMapping(path = "aggtrades/{symbol}/{year}/{month}.checksum")
	@ApiOperation(value = "Get symbol's aggregated trades file checksum (monthly).")

	public ChecksumParams getAggTradesMonthlyChecksum(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return connectors.rest().visionSpot().getAggTradesChecksum(symbol, year, month);
	}

	// Trade

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's trades (daily).
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "trades/{symbol}/{year}/{month}/{day}.json")

	@ApiOperation(value = "Get symbol's trades (daily).")
	public List<VisionTrade> getTradesDailyJson(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException {
		return connectors.rest().visionSpot().getTrades(symbol, year, month, day).getData();
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return Get symbol's trades (monthly).
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "trades/{symbol}/{year}/{month}.json")
	@ApiOperation(value = "Get symbol's trades (monthly).")

	public List<VisionTrade> getTradesMonthlyJson(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException {
		return connectors.rest().visionSpot().getTrades(symbol, year, month).getData();
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's trades in a zip format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "trades/{symbol}/{year}/{month}/{day}.zip", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's  trades (daily).")

	public ResponseEntity<byte[]> getTradesDailyZip(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return ZisToZosResponse(connectors.rest().visionSpot().getTrades(symbol, year, month, day).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return Get symbol's trades in a zip format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "trades/{symbol}/{year}/{month}.zip", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's  trades (monthly).")

	public ResponseEntity<byte[]> getTradesMonthlyZip(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return ZisToZosResponse(connectors.rest().visionSpot().getTrades(symbol, year, month).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's trades in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "trades/{symbol}/{year}/{month}/{day}.csv", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's trades (daily).")

	public ResponseEntity<byte[]> getTradesDailyCsv(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return zisToCsvResponse(connectors.rest().visionSpot().getTrades(symbol, year, month, day).getZip());
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param interval The candlestick interval.
	 * @return Get symbol's trades in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "trades/{symbol}/{year}/{month}.csv", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's trades (monthly).")

	public ResponseEntity<byte[]> getTradesMonthlyCsv(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return zisToCsvResponse(connectors.rest().visionSpot().getTrades(symbol, year, month).getZip());
	}

	/**
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return Get symbol's trades in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@JsonGetMapping(path = "trades/{symbol}/{year}/{month}/{day}.checksum")
	@ApiOperation(value = "Get symbol's trades file checksum (daily).")

	public ChecksumParams getTradesDailyChecksum(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return connectors.rest().visionSpot().getTradesChecksum(symbol, year, month, day);
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param interval The candlestick interval.
	 * @return Get symbol's trades in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@JsonGetMapping(path = "trades/{symbol}/{year}/{month}.checksum")
	@ApiOperation(value = "Get symbol's trades file checksum (monthly).")

	public ChecksumParams getTradesMonthlyChecksum(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return connectors.rest().visionSpot().getTradesChecksum(symbol, year, month);
	}

	// Klines

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param day      Day.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines (daily).
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "klines/{symbol}/{interval}/{year}/{month}/{day}.json")
	@ApiOperation(value = "Get symbol's klines (daily).")

	public List<Candle> getKlinesDailyJson(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.", allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException {
		return connectors.rest().visionSpot()
				.getKlines(symbol, CandlestickInterval.fromValue(interval), year, month, day)
				.getData();
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines (monthly).
	 * @throws ApiException
	 */
	@JsonGetMapping(path = "klines/{symbol}/{interval}/{year}/{month}.json")
	@ApiOperation(value = "Get symbol's klines (monthly).")

	public List<Candle> getKlinesMonthlyJson(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.", allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException {
		return connectors.rest().visionSpot().getKlines(symbol, CandlestickInterval.fromValue(interval), year, month)
				.getData();
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param day      Day.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines in a zip format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "klines/{symbol}/{interval}/{year}/{month}/{day}.zip", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's  klines (daily).")

	public ResponseEntity<byte[]> getKlinesDailyZip(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.", allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return ZisToZosResponse(connectors.rest().visionSpot()
				.getKlines(symbol, CandlestickInterval.fromValue(interval), year, month, day).getZip());
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines in a zip format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "klines/{symbol}/{interval}/{year}/{month}.zip", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's  klines (monthly).")

	public ResponseEntity<byte[]> getKlinesMonthlyZip(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.", allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return ZisToZosResponse(connectors.rest().visionSpot()
				.getKlines(symbol, CandlestickInterval.fromValue(interval), year, month).getZip());
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param day      Day.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "klines/{symbol}/{interval}/{year}/{month}/{day}.csv", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's klines (daily).")

	public ResponseEntity<byte[]> getKlinesDailyCsv(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.", allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return zisToCsvResponse(connectors.rest().visionSpot()
				.getKlines(symbol, CandlestickInterval.fromValue(interval), year, month, day).getZip());
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines file checksum (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@GetMapping(path = "klines/{symbol}/{interval}/{year}/{month}.csv", produces = "application/octet-stream")
	@ApiOperation(value = "Get symbol's klines file checksum (monthly).")

	public ResponseEntity<byte[]> getKlinesMonthlyCsv(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return zisToCsvResponse(connectors.rest().visionSpot()
				.getKlines(symbol, CandlestickInterval.fromValue(interval), year, month).getZip());
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param day      Day.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines file checksum (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@JsonGetMapping(path = "klines/{symbol}/{interval}/{year}/{month}/{day}.checksum")
	@ApiOperation(value = "Get symbol's klines file checksum (daily).")

	public ChecksumParams getKlinesDailyChecksum(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.", allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month,
			@PathVariable(value = "day", required = false) @ApiParam(example = "01", value = "Day.") String day)
			throws ApiException, IOException {
		return connectors.rest().visionSpot().getKlinesChecksum(symbol, CandlestickInterval.fromValue(interval), year,
				month,
				day);
	}

	/**
	 * @param symbol   Trading pair.
	 * @param year     Year.
	 * @param month    Month.
	 * @param interval The candlestick interval.
	 * @return Get symbol's klines in a csv format (daily).
	 * @throws ApiException
	 * @throws IOException
	 */
	@JsonGetMapping(path = "klines/{symbol}/{interval}/{year}/{month}.checksum")
	@ApiOperation(value = "Get symbol's klines (monthly).")

	public ChecksumParams getKlinesMonthlyChecksum(
			@PathVariable(value = "symbol", required = true) @ApiParam(example = "BNBBTC", value = "Symbol.") String symbol,
			@PathVariable(value = "interval", required = true) @ApiParam(example = "5m", value = "Interval.") String interval,
			@PathVariable(value = "year", required = true) @ApiParam(example = "2022", value = "Year.") String year,
			@PathVariable(value = "month", required = true) @ApiParam(example = "01", value = "Month.") String month)
			throws ApiException, IOException {
		return connectors.rest().visionSpot().getKlinesChecksum(symbol, CandlestickInterval.fromValue(interval), year,
				month);
	}

	// Methods

	/**
	 * Converts the given {@link ZipInputStream} into a {@link ZipOutputStream} then
	 * wraps its bytes into a
	 * {@link ResponseEntity}.
	 * 
	 * @param zis The {@link ZipInputStream}
	 * @return A {@link ResponseEntity<byte[]>} containing the zip bytes.
	 * @throws IOException
	 */
	private ResponseEntity<byte[]> ZisToZosResponse(ZipInputStream zis) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		ZipEntry ze;

		var builder = ContentDisposition.builder("inline");

		while ((ze = zis.getNextEntry()) != null) {
			zos.putNextEntry(ze);
			builder.filename(ze.getName().replace("csv", "zip"));
			zos.write(zis.readAllBytes());
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(builder.build());

		zos.closeEntry();
		zos.close();

		return ResponseEntity.ok().headers(headers).contentLength(baos.size())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(baos.toByteArray());
	}

	/**
	 * Get the csv in the {@link ZipInputStream} then wraps its bytes into a
	 * {@link ResponseEntity}.
	 * 
	 * @param zis The {@link ZipInputStream}
	 * @return A {@link ResponseEntity<byte[]>} containing the zip bytes.
	 * @throws IOException
	 */
	private ResponseEntity<byte[]> zisToCsvResponse(ZipInputStream zis) throws IOException {
		var ze = zis.getNextEntry();

		ContentDisposition contentDisposition = ContentDisposition.builder("inline").filename(ze.getName()).build();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(contentDisposition);

		return ResponseEntity.ok().headers(headers).contentLength(ze.getSize())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(zis.readAllBytes());
	}
}