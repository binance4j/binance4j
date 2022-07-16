package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.margin.dto.TransferRecordType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferHistoryParams extends IntervalParams {
	private String asset;
	private TransferRecordType type;
	private Long current;
	private Integer size;
	private Boolean archived;

	public TransferHistoryParams() {
		super(1);
	}
}