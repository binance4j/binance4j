package com.binance4j.wallet.transfer;

import com.binance4j.core.request.IntervalRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request to fetch User Universal Transfer History
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferHistoryRequest extends IntervalRequest {
	/**
	 * The User universal transfer type
	 */
	private WalletTransferType type;
	/**
	 * The offset
	 */
	private Integer current = 1;
	/**
	 * The result size
	 */
	private Integer size = 10;
	/**
	 * Must be sent when type are ISOLATEDMARGIN_MARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 */
	private String fromSymbol;
	/**
	 * Must be sent when type are MARGIN_ISOLATEDMARGIN and
	 * ISOLATEDMARGIN_ISOLATEDMARGIN
	 */
	private String toSymbol;

	/**
	 * Constructor
	 *
	 * @param type The transfer type
	 */
	public WalletTransferHistoryRequest(WalletTransferType type) {
		super(1);
		this.type = type;
	}

	/**
	 * Constructor
	 *
	 * @param type The transfer type
	 * @param size The result size
	 */
	public WalletTransferHistoryRequest(WalletTransferType type, int size) {
		this(type);
		this.size = size;
	}

	/**
	 * Constructor
	 *
	 * @param type    The transfer type
	 * @param size    The result size
	 * @param current The offest (starts at 1)
	 */
	public WalletTransferHistoryRequest(WalletTransferType type, int size, int current) {
		this(type, size);
		this.current = current;
	}

	/**
	 * Constructor
	 *
	 * @param fromSymbol The transfered symbol
	 * @param toSymbol   The converted symbol
	 */
	public WalletTransferHistoryRequest(WalletTransferType type, String fromSymbol, String toSymbol) {
		this(type);
		this.fromSymbol = fromSymbol;
		this.toSymbol = toSymbol;
	}

	/**
	 * Constructor
	 *
	 * @param fromSymbol The transfered symbol
	 * @param toSymbol   The converted symbol
	 * @param size       The result size
	 */
	public WalletTransferHistoryRequest(WalletTransferType type, String fromSymbol, String toSymbol, int size) {
		this(type, fromSymbol, toSymbol);
		this.size = size;
	}

	/**
	 * Constructor
	 *
	 * @param fromSymbol The transfered symbol
	 * @param toSymbol   The converted symbol
	 * @param size       The result size
	 * @param current    The offest (starts at 1)
	 */
	public WalletTransferHistoryRequest(WalletTransferType type, String fromSymbol, String toSymbol, int size,
	                                    int current) {
		this(type, fromSymbol, toSymbol, size);
		this.current = current;
	}
}
