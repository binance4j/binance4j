package com.binance4j.wallet.dust;

import com.binance4j.core.request.FramedRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Requests assets that can be converted into BNB
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class ConvertibleAssetRequest extends FramedRequest {
	/**
	 * Constructor
	 */
	public ConvertibleAssetRequest() {
		super(1);
	}

}
