package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.margin.dto.DustLogRecord.UserAssetDribblet;
import com.binance4j.margin.dto.DustLogRecord.UserAssetDribblet.UserAssetDribbletDetail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A record of asset conversions to BNB.
 * 
 * @property total              Result count.
 * @property userAssetDribblets Transfers.
 */
@ApiModel("A record of asset conversions to BNB.")
data class DustLogRecord(@ApiModelProperty("Result count.")
@JsonProperty("total") var total:int?=null,
@ApiModelProperty("Transfers.")
List<UserAssetDribblet> userAssetDribblets)
{
	/**
	 * @property operateTime              Operate time.
	 * @property totalTransferedAmount    Total transfered BNB amount for this
	 *                                 exchange.
	 * @property totalServiceChargeAmount Total service charge amount for this
	 *                                 exchange.
	 * @property transId                  Transaction id.
	 * @property userAssetDribbletDetails Transfer details.
	 */
	record UserAssetDribblet(@ApiModelProperty("Operate time.") @JsonProperty("operateTime ") var operateTime : Long? = null,
			@ApiModelProperty("Total transfered BNB amount for this exchange.") @JsonProperty("totalTransferedAmount ") var totalTransferedAmount : String? = null,
			@ApiModelProperty("Total service charge amount for this exchange.") @JsonProperty("totalServiceChargeAmount ") var totalServiceChargeAmount : String? = null,
			@ApiModelProperty("Transaction id.") @JsonProperty("transId ") var transId : Long? = null,
			@ApiModelProperty("Transfer details.") List<UserAssetDribbletDetail> userAssetDribbletDetails) {
		/**
		 * @property transId             Transaction id.
		 * @property serviceChargeAmount Fees.
		 * @property amount              Converted BNB amount.
		 * @property operateTime         Operate time in ms.
		 * @property transferedAmount    Asset amount.
		 * @property fromAsset           Asset transfered.
		 */
		record UserAssetDribbletDetail(@ApiModelProperty("Transaction id.") @JsonProperty("transId ") var transId : Long? = null,
				@ApiModelProperty("Fees.") @JsonProperty("serviceChargeAmount ") var serviceChargeAmount : String? = null,
				@ApiModelProperty("Converted BNB amount.") @JsonProperty("amount ") var amount : String? = null,
				@ApiModelProperty("Operate time in ms.") @JsonProperty("operateTime ") var operateTime : Long? = null,
				@ApiModelProperty("Asset amount.") @JsonProperty("transferedAmount ") var transferedAmount : String? = null,
				@ApiModelProperty("Asset transfered.") @JsonProperty("fromAsset ") var fromAsset : String? = null) {
		}
	}
}
