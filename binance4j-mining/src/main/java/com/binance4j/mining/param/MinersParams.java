package com.binance4j.mining.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.dto.MinerSort;
import com.binance4j.mining.dto.SortSequence;
import com.binance4j.mining.dto.WorkerStatus;

@Param(weight = 5)
public class MinersParams implements Params {
	/** Algorithm. */
	@Mandatory
	String algo;
	/** Mining account. */
	@Mandatory
	String userName;
	/** Page number. */
	long pageIndex;
	/** Sort sequence. */
	SortSequence sort;
	/** Miner sort. */
	MinerSort sortColumn;
	/** Miner status. */
	WorkerStatus workerStatus;

	/**
	 * Constructor.
	 * 
	 * @param algo     Algorithm.
	 * @param userName Mining account.
	 */
	public MinersParams(String algo, String userName) {
		this.algo = algo;
		this.userName = userName;
	}

	/**
	 * @return the algo
	 */
	public String getAlgo() {
		return algo;
	}

	/**
	 * @param algo the algo to set
	 */
	public void setAlgo(String algo) {
		this.algo = algo;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the pageIndex
	 */
	public long getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(long pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the sort
	 */
	public SortSequence getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(SortSequence sort) {
		this.sort = sort;
	}

	/**
	 * @return the sortColumn
	 */
	public MinerSort getSortColumn() {
		return sortColumn;
	}

	/**
	 * @param sortColumn the sortColumn to set
	 */
	public void setSortColumn(MinerSort sortColumn) {
		this.sortColumn = sortColumn;
	}

	/**
	 * @return the workerStatus
	 */
	public WorkerStatus getWorkerStatus() {
		return workerStatus;
	}

	/**
	 * @param workerStatus the workerStatus to set
	 */
	public void setWorkerStatus(WorkerStatus workerStatus) {
		this.workerStatus = workerStatus;
	}

}
