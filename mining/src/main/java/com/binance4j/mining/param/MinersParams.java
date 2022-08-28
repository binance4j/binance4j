package com.binance4j.mining.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.MinerSorting;
import com.binance4j.mining.dto.SortSequence;
import com.binance4j.mining.dto.WorkerStatus;

/**
 * [MiningClient.getMiners] params.
 * 
 * @param algo         Algorithm.
 * @param userName     Mining account.
 * @param pageIndex    Page number.
 * @param sort         Sort sequence.
 * @param sortColumn   Miner sort.
 * @param workerStatus Miner status.
 */
@Param
data class MinersParams(
String algo, String userName,
Integer pageIndex, String sort,
String sortColumn,
		String workerStatus):Params
{

	/**
	 * @param algo         Algorithm.
	 * @param userName     Mining account.
	 * @param pageIndex    Page number.
	 * @param sort         Sort sequence.
	 * @param sortColumn   Miner sort.
	 * @param workerStatus Miner status.
	 */
	public MinersParams(String algo, String userName, Integer pageIndex, SortSequence sort, MinerSorting sortColumn,
			WorkerStatus workerStatus) {
		this(algo, userName, pageIndex, sort.toString(), sortColumn.toString(), workerStatus.toString());
	}

	/**
	 * Creates an instance of {@link MinersParams}.
	 * 
	 * @param algo     Algorithm.
	 * @param userName Mining account.
	 */
	public MinersParams(String algo, String userName) {
		this(algo, userName, null, (String) null, (String) null, (String) null);
	}
}