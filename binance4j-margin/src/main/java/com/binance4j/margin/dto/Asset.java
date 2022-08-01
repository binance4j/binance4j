package com.binance4j.margin.dto;

/**
 * An asset on the platform
 * 
 * @param assetFullName  The asset full name.
 * @param assetName      The asset name.
 * @param userMinBorrow  The user minimum borrow.
 * @param userMinRepay   The user minimum repay.
 * @param isBorrowable   Is it borrowable?
 * @param isMortgageable Is it mortgageable?
 */
public record Asset(String assetFullName, String assetName, String userMinBorrow, String userMinRepay, boolean isBorrowable, boolean isMortgageable) {
}