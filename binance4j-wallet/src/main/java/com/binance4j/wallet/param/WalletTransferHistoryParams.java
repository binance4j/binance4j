package com.binance4j.wallet.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.wallet.dto.WalletTransferType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to fetch User Universal Transfer History */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferHistoryParams extends IntervalParams {
	/** The User universal transfer type. */
	private WalletTransferType type;
	/** The offset. */
	private Integer current = 1;
	/** The result size. */
	private Integer size = 10;
	/** Must be sent when type are ISOLATEDMARGIN_MARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN */
	private String fromSymbol;
	/** Must be sent when type are MARGIN_ISOLATEDMARGIN and ISOLATEDMARGIN_ISOLATEDMARGIN */
	private String toSymbol;

	/**
	 * @param type The transfer type.
	 */
	public WalletTransferHistoryParams(WalletTransferType type) {
		super(1);
		this.type = type;
	}

	/**
	 * @param type The transfer type.
	 * @param size The result size.
	 */
	public WalletTransferHistoryParams(WalletTransferType type, int size) {
		this(type);
		this.size = size;
	}

	/**
	 * @param type    The transfer type.
	 * @param size    The result size.
	 * @param current The offest (starts at 1).
	 */
	public WalletTransferHistoryParams(WalletTransferType type, int size, int current) {
		this(type, size);
		this.current = current;
	}

	/**
	 * @param type       The transfer type.
	 * @param fromSymbol The transfered symbol.
	 * @param toSymbol   The converted symbol.
	 */
	public WalletTransferHistoryParams(WalletTransferType type, String fromSymbol, String toSymbol) {
		this(type);
		this.fromSymbol = fromSymbol;
		this.toSymbol = toSymbol;
	}

	/**
	 * @param fromSymbol The transfered symbol.
	 * @param toSymbol   The converted symbol.
	 * @param type       The transfer type.
	 * @param size       The result size.
	 */
	public WalletTransferHistoryParams(WalletTransferType type, String fromSymbol, String toSymbol, int size) {
		this(type, fromSymbol, toSymbol);
		this.size = size;
	}

	/**
	 * @param type       The transfer type.
	 * @param fromSymbol The transfered symbol.
	 * @param toSymbol   The converted symbol.
	 * @param size       The result size.
	 * @param current    The offest (starts at 1).
	 */
	public WalletTransferHistoryParams(WalletTransferType type, String fromSymbol, String toSymbol, int size, int current) {
		this(type, fromSymbol, toSymbol, size);
		this.current = current;
	}
}
