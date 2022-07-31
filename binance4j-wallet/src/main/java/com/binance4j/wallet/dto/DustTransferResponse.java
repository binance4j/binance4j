package com.binance4j.wallet.dto;

import java.util.List;

/**
 * The dust transfer (asset to BNB) response.
 * 
 * @param totalServiceCharge The fees.
 * @param totalTransfered    The volume converted into BNB after fees.
 * @param transferResult     Detailed transfer result asset by asset.
 */
public record DustTransferResponse(String totalServiceCharge, String totalTransfered, List<DustTransferResult> transferResult) {
}