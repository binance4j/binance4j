package com.binance4j.mining.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

@Param(weight = 5)
public class MinerDetailsParams implements Params {
	/** The algorithm. */

	@Mandatory
	String algo;
	/** The mining account. */

	@Mandatory
	String userName;
	/** The miner’s name. */

	@Mandatory
	String workerName;

	/**
	 * @param algo       The algorithm.
	 * @param userName   The mining account.
	 * @param workerName The miner’s name.
	 */
	public MinerDetailsParams(String algo, String userName, String workerName) {
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
