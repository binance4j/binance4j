package com.binance4j.wallet.withdraw;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to fetch the user withdraw history
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WithdrawHistoryParams extends IntervalParams {
	/** The coin we want the history */
	private String coin;
	/** The withdraw order id to fetch */
	private String withdrawOrderId;
	/** The status to look for */
	private Integer status;
	/** The offset */
	private Integer offset;

	/** Default:1000, Max:1000 */
	private Integer limit = 1000;

	/**
	 
	 */
	public WithdrawHistoryParams() {
		super(1);
	}

	/**
	 *
	 * 
	 * @param coin The coin we need deposit history
	 */
	public WithdrawHistoryParams(String coin) {
		this();
		this.coin = coin;
	}

	/**
	 *
	 * 
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success)
	 */
	public WithdrawHistoryParams(int status) {
		this();
		this.status = status;
	}

	/**
	 *
	 * 
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw, 1:success)
	 */
	public WithdrawHistoryParams(WithdrawStatus status) {
		this();
		this.status = status.getValue();
	}

	/**
	 *
	 * 
	 * @param coin   The coin we need deposit history
	 * @param status The coin status (EMAIL_SENT(0), CANCELLED(1), AWAITING_APPROVAL(2), REJECTED(3), PROCESSING(4),
	 *               FAILURE(5), COMPLETED(6);
	 */
	public WithdrawHistoryParams(String coin, int status) {
		this(coin);
		this.status = status;
	}

	/**
	 *
	 * 
	 * @param coin   The coin we need deposit history
	 * @param status The coin status
	 */
	public WithdrawHistoryParams(String coin, WithdrawStatus status) {
		this(coin, status.getValue());
	}

	/**
	 *
	 * 
	 * @param status The withdraw status
	 */
	public void setStatus(WithdrawStatus status) {
		this.status = status.getValue();
	}
}
