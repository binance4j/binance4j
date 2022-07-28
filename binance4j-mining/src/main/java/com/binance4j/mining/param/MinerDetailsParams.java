package com.binance4j.mining.param;

import com.binance4j.core.param.Params;

public class MinerDetailsParams extends Params {
	/** The algorithm. */
	String algo;
	/** The mining account. */
	String userName;
	/** The miner’s name. */
	String workerName;

	/**
	 * Constructor.
	 * 
	 * @param algo       The algorithm.
	 * @param userName   The mining account.
	 * @param workerName The miner’s name.
	 */
	public MinerDetailsParams(String algo, String userName, String workerName) {
		super(5);
		this.algo = algo;
		this.userName = userName;
		this.workerName = workerName;
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
	 * @return the workerName
	 */
	public String getWorkerName() {
		return workerName;
	}

	/**
	 * @param workerName the workerName to set
	 */
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

}
