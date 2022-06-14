package com.binance4j.core.exception;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** The Error codes sent by the Binance API */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public enum ApiErrorCode {
    /**
     * Client was unable to deserialize the server response
     */
    DESERIALIZATION_FAILURE(-2000),
    /**
     * <ul>
     * <li>An unknown error occurred while processing the request.</li>
     * <li>An unknown error occurred while processing the request.[%s]</li>
     * </ul>
     */
    UNKNOWN(-1000),
    /**
     * <ul>
     * <li>Internal error;</li>
     * <li>unable to process your request.</li>
     * <li>Please try again.</li>
     * </ul>
     */
    DISCONNECTED(-1001),
    /**
     * You are not authorized to execute this request.
     */
    UNAUTHORIZED(-1002),
    /**
     * <ul>
     * <li>Too many requests queued.</li>
     * <li>Too much request weight used; please use the websocket for live
     * updates to avoid polling the API.</li>
     * <li>Too much request weight used; current limit is %s request weight per
     * %s %s.
     * Please use the websocket for live updates to avoid polling the API.</li>
     * <li>Way too much request weight used; IP banned until %s. Please use the
     * websocket for live updates to avoid bans.</li>
     * </ul>
     */
    TOO_MANY_REQUESTS(-1003),
    /**
     * Server is busy, please wait and try again.
     */
    SERVER_BUSY(-1004),
    /**
     * An unexpected response was received from the message bus. Execution
     * status unknown.
     */
    UNEXPECTED_RESP(-1006),
    /**
     * Timeout waiting for response from backend server. Send status
     * unknown; execution status unknown.
     */
    TIMEOUT(-1007),
    /** CANCEL_REJECTED */
    STATUS_IS_NOT_TRADING(-1013),
    /**
     * Unsupported order combination.
     */
    UNKNOWN_ORDER_COMPOSITION(-1014),
    /**
     * <ul>
     * <li>Too many new orders.</li>
     * <li>Too many new orders; current limit is %s orders per %s.</li>
     * </ul>
     */
    TOO_MANY_ORDERS(-1015),
    /** This service is no longer available. */
    SERVICE_SHUTTING_DOWN(-1016),
    /** This operation is not supported. */
    UNSUPPORTED_OPERATION(-1020),
    /**
     * <ul>
     * <li>Timestamp for this request is outside of the recvWindow.
     * <li>Timestamp for this request was 1000ms ahead of the server's time.
     * </ul>
     */
    INVALID_TIMESTAMP(-1021),
    /**
     * Signature for this request is not valid.
     */
    INVALID_SIGNATURE(-1022),
    /**
     * This replaces error code -1999
     */
    NOT_FOUND_AUTHENTICATED_OR_AUTHORIZED(-1099),
    /**
     * <ul>
     * <li>Illegal characters found in a parameter.
     * <li>Illegal characters found in a parameter. %s
     * <li>Illegal characters found in parameter %s; legal range is %s.
     * </ul>
     */
    ILLEGAL_CHARS(-1100),
    /**
     * <ul>
     * <li>Too many parameters sent for this endpoint.
     * <li>Too many parameters; expected %s and received %s.
     * <li>Duplicate values for a parameter detected.
     * </ul>
     */
    TOO_MANY_PARAMETERS(-1101),
    /**
     * <ul>
     * <li>A mandatory parameter was not sent, was empty/null, or malformed.
     * <li>Mandatory parameter %s was not sent, was empty/null, or malformed.
     * <li>Param %s or %s must be sent, but both were empty/null!
     * </ul>
     */
    MANDATORY_PARAM_EMPTY_OR_MALFORMED(-1102),
    /**
     * An unknown parameter was sent.
     */
    UNKNOWN_PARAM(-1103),
    /**
     * <ul>
     * <li>Not all sent parameters were read.
     * <li>Not all sent parameters were read; read %s parameter(s) but was sent
     * %s.
     * </ul>
     */
    UNREAD_PARAMETERS(-1104),
    /**
     * <ul>
     * <li>A parameter was empty.
     * <li>Parameter %s was empty.
     * </ul>
     */
    PARAM_EMPTY(-1105),
    /**
     * <ul>
     * <li>A parameter was sent when not required.
     * <li>Parameter %s sent when not required.
     * </ul>
     */
    PARAM_NOT_REQUIRED(-1106),
    /**
     * Precision is over the maximum defined for this asset.
     */
    BAD_PRECISION(-1111),
    /**
     * No orders on book for symbol.
     */
    NO_DEPTH(-1112),
    /**
     * TimeInForce parameter sent when not required.
     */
    TIF_NOT_REQUIRED(-1114),
    /**
     * Invalid timeInForce.
     */
    INVALID_TIF(-1115),
    /**
     * Invalid orderType.
     */
    INVALID_ORDER_TYPE(-1116),
    /**
     * Invalid side.
     */
    INVALID_SIDE(-1117),
    /**
     * New client order ID was empty.
     */
    EMPTY_NEW_CL_ORD_ID(-1118),
    /**
     * Original client order ID was empty.
     */
    EMPTY_ORG_CL_ORD_ID(-1119),
    /**
     * Invalid interval.
     */
    BAD_INTERVAL(-1120),
    /**
     * Invalid symbol.
     */
    BAD_SYMBOL(-1121),
    /**
     * This listenKey does not exist.
     */
    INVALID_LISTEN_KEY(-1125),
    /**
     * <ul>
     * <li>Lookup interval is too big.
     * <li>More than %s hours between startTime and endTime.
     * </ul>
     */
    MORE_THAN_XX_HOURS(-1127),
    /**
     * Combination of optional parameters invalid.
     */
    OPTIONAL_PARAMS_BAD_COMBO(-1128),
    /**
     * Invalid data sent for a parameter.
     */
    INVALID_PARAMETER(-1130),
    /**
     * <ul>
     * <li>Data sent for parameter %s is not valid.
     * <li>recvWindow must be less than 60000.
     * </ul>
     */
    BAD_RECV_WINDOW(-1131),
    /**
     * NEW_ORDER_REJECTED
     */
    NEW_ORDER_REJECTED(-2010),
    /**
     * CANCEL_REJECTED
     */
    CANCEL_REJECTED(-2011),
    /**
     * Order does not exist.
     */
    NO_SUCH_ORDER(-2013),
    /**
     * API-key format invalid.
     */
    BAD_API_KEY_FMT(-2014),
    /**
     * Invalid API-key, IP, or permissions for action.
     */
    REJECTED_MBX_KEY(-2015),
    /**
     * No trading window could be found for the symbol. Try ticker/24hrs
     * instead.
     */
    NO_TRADING_WINDOW(-2016),
    /**
     * Internal server error.
     */
    INNER_FAILURE(-3000),
    /**
     * Please enable 2FA first.
     */
    NEED_ENABLE_2FA(-3001),
    /**
     * We don't have this asset.
     */
    ASSET_DEFICIENCY(-3002),
    /**
     * Margin account does not exist.
     */
    NO_OPENED_MARGIN_ACCOUNT(-3003),
    /**
     * Trade not allowed.
     */
    TRADE_NOT_ALLOWED(-3004),
    /**
     * Transferring out not allowed.
     */
    TRANSFER_OUT_NOT_ALLOWED(-3005),
    /**
     * Your borrow amount has exceed maximum borrow amount.
     */
    EXCEED_MAX_BORROWABLE(-3006),
    /**
     * You have pending transaction, please try again later.
     */
    HAS_PENDING_TRANSACTION(-3007),
    /**
     * Borrow not allowed.
     */
    BORROW_NOT_ALLOWED(-3008),
    /**
     * This asset are not allowed to transfer into margin account
     * currently.
     */
    ASSET_NOT_MORTGAGEABLE(-3009),
    /**
     * Repay not allowed.
     */
    REPAY_NOT_ALLOWED(-3010),
    /**
     * Your input date is invalid.
     */
    BAD_DATE_RANGE(-3011),
    /**
     * Borrow is banned for this asset.
     */
    ASSET_ADMIN_BAN_BORROW(-3012),
    /**
     * Borrow amount less than minimum borrow amount.
     */
    LT_MIN_BORROWABLE(-3013),
    /**
     * Borrow is banned for this account.
     */
    ACCOUNT_BAN_BORROW(-3014),
    /**
     * Repay amount exceeds borrow amount.
     */
    REPAY_EXCEED_LIABILITY(-3015),
    /**
     * Repay amount less than minimum repay amount.
     */
    LT_MIN_REPAY(-3016),
    /**
     * This asset are not allowed to transfer into margin account
     * currently.
     */
    ASSET_ADMIN_BAN_MORTGAGE(-3017),
    /**
     * Transferring in has been banned for this account.
     */
    ACCOUNT_BAN_MORTGAGE(-3018),
    /**
     * Transferring out has been banned for this account.
     */
    ACCOUNT_BAN_ROLLOUT(-3019),
    /**
     * Transfer out amount exceeds max amount.
     */
    EXCEED_MAX_ROLLOUT(-3020),
    /**
     * Margin account are not allowed to trade this trading pair.
     */
    PAIR_ADMIN_BAN_TRADE(-3021),
    /**
     * You account's trading is banned.
     */
    ACCOUNT_BAN_TRADE(-3022),
    /**
     * You can't transfer out/place order under current margin level.
     */
    WARNING_MARGIN_LEVEL(-3023),
    /**
     * The unpaid debt is too small after this repayment.
     */
    FEW_LIABILITY_LEFT(-3024),
    /**
     * Your input date is invalid.
     */
    INVALID_EFFECTIVE_TIME(-3025),
    /**
     * Your input param is invalid.
     */
    VALIDATION_FAILED(-3026),
    /**
     * Not a valid margin asset.
     */
    NOT_VALID_MARGIN_ASSET(-3027),
    /**
     * Not a valid margin pair.
     */
    NOT_VALID_MARGIN_PAIR(-3028),
    /**
     * Transfer failed.
     */
    TRANSFER_FAILED(-3029),
    /**
     * This account is not allowed to repay.
     */
    ACCOUNT_BAN_REPAY(-3036),
    /**
     * PNL is clearing. Wait a second.
     */
    PNL_CLEARING(-3037),
    /**
     * Listen key not found.
     */
    LISTEN_KEY_NOT_FOUND(-3038),
    /**
     * Balance is not enough
     */
    BALANCE_NOT_CLEARED(-3041),
    /**
     * PriceIndex not available for this margin pair.
     */
    PRICE_INDEX_NOT_FOUND(-3042),
    /**
     * Transferring in not allowed.
     */
    TRANSFER_IN_NOT_ALLOWED(-3043),
    /**
     * System busy.
     */
    SYSTEM_BUSY(-3044),
    /**
     * The system doesn't have enough asset now.
     */
    SYSTEM(-3045),
    /**
     * This function is only available for invited users.
     */
    NOT_WHITELIST_USER(-3999),
    /**
     * Invalid operation.
     */
    CAPITAL_INVALID(-4001),
    /**
     * Invalid get.
     */
    CAPITAL_IG(-4002),
    /**
     * Your input email is invalid.
     */
    CAPITAL_IEV(-4003),
    /**
     * You don't login or auth.
     */
    CAPITAL_UA(-4004),
    /**
     * Too many new requests.
     */
    CAPAITAL_TOO_MANY_REQUEST(-4005),
    /**
     * Support main account only.
     */
    CAPITAL_ONLY_SUPPORT_PRIMARY_ACCOUNT(-4006),
    /**
     * Address validation is not passed.
     */
    CAPITAL_ADDRESS_VERIFICATION_NOT_PASS(-4007),
    /**
     * Address tag validation is not passed.
     */
    CAPITAL_ADDRESS_TAG_VERIFICATION_NOT_PASS(-4008),
    /**
     * White list mail has been confirmed.
     */
    CAPITAL_WHITELIST_EMAIL_CONFIRM(-4010),
    /**
     * White list mail is invalid.
     */
    CAPITAL_WHITELIST_EMAIL_EXPIRED(-4011),
    /**
     * White list is not opened.
     */
    CAPITAL_WHITELIST_CLOSE(-4012),
    /**
     * 2FA is not opened.
     */
    CAPITAL_WITHDRAW_2FA_VERIFY(-4013),
    /**
     * Withdraw is not allowed within 2 min login.
     */
    CAPITAL_WITHDRAW_LOGIN_DELAY(-4014),
    /**
     * Withdraw is limited.
     */
    CAPITAL_WITHDRAW_RESTRICTED_MINUTE(-4015),
    /**
     * Within 24 hours after password modification, withdrawal is
     * prohibited.
     */
    CAPITAL_WITHDRAW_RESTRICTED_PASSWORD(-4016),
    /**
     * Within 24 hours after the release of 2FA, withdrawal is prohibited.
     */
    CAPITAL_WITHDRAW_RESTRICTED_UNBIND_2FA(-4017),
    /**
     * We don't have this asset.
     */
    CAPITAL_WITHDRAW_ASSET_NOT_EXIST(-4018),
    /**
     * Current asset is not open for withdrawal.
     */
    CAPITAL_WITHDRAW_ASSET_PROHIBIT(-4019),
    /**
     * Asset withdrawal must be an %s multiple of %s.
     */
    CAPITAL_WITHDRAW_AMOUNT_MULTIPLE(-4021),
    /**
     * Not less than the minimum pick-up quantity %s.
     */
    CAPITAL_WITHDRAW_MIN_AMOUNT(-4022),
    /**
     * Within 24 hours, the withdrawal exceeds the maximum amount.
     */
    CAPITAL_WITHDRAW_MAX_AMOUNT(-4023),
    /**
     * You don't have this asset.
     */
    CAPITAL_WITHDRAW_USER_NO_ASSET(-4024),
    /**
     * The number of hold asset is less than zero.
     */
    CAPITAL_WITHDRAW_USER_ASSET_LESS_THAN_ZERO(-4025),
    /**
     * You have insufficient balance.
     */
    CAPITAL_WITHDRAW_USER_ASSET_NOT_ENOUGH(-4026),
    /**
     * Failed to obtain tranId.
     */
    CAPITAL_WITHDRAW_GET_TRAN_ID_FAILURE(-4027),
    /**
     * The amount of withdrawal must be greater than the Commission.
     */
    CAPITAL_WITHDRAW_MORE_THAN_FEE(-4028),
    /**
     * The withdrawal record does not exist.
     */
    CAPITAL_WITHDRAW_NOT_EXIST(-4029),
    /**
     * Confirmation of successful asset withdrawal.
     */
    CAPITAL_WITHDRAW_CONFIRM_SUCCESS(-4030),
    /**
     * Cancellation failed.
     */
    CAPITAL_WITHDRAW_CANCEL_FAILURE(-4031),
    /**
     * Withdraw verification exception.
     */
    CAPITAL_WITHDRAW_CHECKSUM_VERIFY_FAILURE(-4032),
    /**
     * Illegal address.
     */
    CAPITAL_WITHDRAW_ILLEGAL_ADDRESS(-4033),
    /**
     * The address is suspected of fake.
     */
    CAPITAL_WITHDRAW_ADDRESS_CHEAT(-4034),
    /**
     * This address is not on the whitelist. Please join and try again.
     */
    CAPITAL_WITHDRAW_NOT_WHITE_ADDRESS(-4035),
    /**
     * The new address needs to be withdrawn in {0} hours.
     */
    CAPITAL_WITHDRAW_NEW_ADDRESS(-4036),
    /**
     * Re-sending Mail failed.
     */
    CAPITAL_WITHDRAW_RESEND_EMAIL_FAIL(-4037),
    /**
     * Please try again in 5 minutes.
     */
    CAPITAL_WITHDRAW_RESEND_EMAIL_TIME_OUT(-4038),
    /**
     * The user does not exist.
     */
    CAPITAL_USER_EMPTY(-4039),
    /**
     * This address not charged.
     */
    CAPITAL_NO_CHARGE(-4040),
    /**
     * Please try again in one minute.
     */
    CAPITAL_MINUTE_TOO_SMALL(-4041),
    /**
     * This asset cannot get deposit address again.
     */
    CAPITAL_CHARGE_NOT_RESET(-4042),
    /**
     * More than 100 recharge addresses were used in 24 hours.
     */
    CAPITAL_ADDRESS_TOO_MUCH(-4043),
    /**
     * This is a blacklist country.
     */
    CAPITAL_BLACKLIST_COUNTRY_GET_ADDRESS(-4044),
    /**
     * Failure to acquire assets.
     */
    CAPITAL_GET_ASSET_ERROR(-4045),
    /**
     * Agreement not confirmed.
     */
    CAPITAL_AGREEMENT_NOT_CONFIRMED(-4046),
    /**
     * Time interval must be within 0days(-90)
     */
    CAPITAL_DATE_INTERVAL_LIMIT(-4047),
    /**
     * Don't allow transfer to micro assets.
     */
    ASSET_DRIBBLET_CONVERT_SWITCH_OFF(-5001),
    /**
     * You have insufficient balance.
     */
    ASSET_ASSET_NOT_ENOUGH(-5002),
    /**
     * You don't have this asset.
     */
    ASSET_USER_HAVE_NO_ASSET(-5003),
    /**
     * The residual balances have exceeded 0.001BTC, Please re-choose.
     * The residual balances of %s have exceeded 0.001BTC, Please
     * re-choose.
     */
    USER_OUT_OF_TRANSFER_FLOAT(-5004),
    /**
     * The residual balances of the BTC is too low
     * The residual balances of %s is too low, Please re-choose.
     */
    USER_ASSET_AMOUNT_IS_TOO_LOW(-5005),
    /**
     * Only transfer once in 24 hours.
     */
    USER_CAN_NOT_REQUEST_IN_24_HOURS(-5006),
    /**
     * Quantity must be greater than zero.
     */
    AMOUNT_OVER_ZERO(-5007),
    /**
     * Insufficient amount of returnable assets.
     */
    ASSET_WITHDRAW_WITHDRAWING_NOT_ENOUGH(-5008),
    /**
     * Product does not exist.
     */
    PRODUCT_NOT_EXIST(-5009),
    /**
     * Asset transfer fail.
     */
    TRANSFER_FAIL(-5010),
    /**
     * future account not exists.
     */
    FUTURE_ACCT_NOT_EXIST(-5011),
    /**
     * Asset transfer is in pending.
     */
    TRANSFER_PENDING(-5012),
    /**
     * This parent sub have no relation
     */
    PARENT_SUB_HAVE_NO_RELATION(-5021),
    /**
     * future account or sub relation not exists.
     */
    FUTURE_ACCT_OR_SUBRELATION_NOT_EXIST(-5012),
    /**
     * Daily product not exists.
     */
    DAILY_PRODUCT_NOT_EXIST(-6001),
    /**
     * Product not exist or you don't have permission
     */
    DAILY_PRODUCT_NOT_ACCESSIBLE(-6003),
    /**
     * Product not in purchase status
     */
    DAILY_PRODUCT_NOT_PURCHASABLE(-6004),
    /**
     * Smaller than min purchase limit
     */
    DAILY_LOWER_THAN_MIN_PURCHASE_LIMIT(-6005),
    /**
     * Redeem amount error
     */
    DAILY_REDEEM_AMOUNT_ERROR(-6006),
    /**
     * Not in redeem time
     */
    DAILY_REDEEM_TIME_ERROR(-6007),
    /**
     * Product not in redeem status
     */
    DAILY_PRODUCT_NOT_REDEEMABLE(-6008),
    /**
     * Request frequency too high
     */
    REQUEST_FREQUENCY_TOO_HIGH(-6009),
    /**
     * Exceeding the maximum num allowed to purchase per user
     */
    EXCEEDED_USER_PURCHASE_LIMIT(-6011),
    /**
     * Balance not enough
     */
    BALANCE_NOT_ENOUGH(-6012),
    /**
     * Purchasing failed
     */
    PURCHASING_FAILED(-6013),
    /**
     * Exceed up-limit allowed to purchased
     */
    UPDATE_FAILED(-6014),
    /**
     * Empty request body
     */
    EMPTY_REQUEST_BODY(-6015),
    /**
     * Parameter err
     */
    PARAMS_ERR(-6016),
    /**
     * Not in whitelist
     */
    NOT_IN_WHITELIST(-6017),
    /**
     * Asset not enough
     */
    ASSET_NOT_ENOUGH(-6018),
    /**
     * Need confirm
     */
    PENDING(-6019),
    /**
     * Project not exists
     */
    PROJECT_NOT_EXISTS(-6020),
    /**
     * Date range is not supported.
     */
    FUTURES_BAD_DATE_RANGE(-7001),
    /**
     * Data request type is not supported.
     */
    FUTURES_BAD_TYPE(-7002),
    /**
     * price is too high, too low, and/or not following the tick size rule
     * for the symbol.
     */
    PRICE_FILTER(-9001),
    /**
     * price is X% too high or X% too low from the average weighted price
     * over the last Y minutes.
     */
    PERCENT_PRICE(-9002),
    /**
     * quantity is too high, too low, and/or not following the step size
     * rule for the symbol.
     */
    LOT_SIZE(-9003),
    /**
     * price * quantity is too low to be a valid order for the symbol.
     */
    MIN_NOTIONAL(-9004),
    /**
     * ICEBERG order would break into too many parts; icebergQty is too
     * small.
     */
    ICEBERG_PARTS(-9005),
    /**
     * MARKET order's quantity is too high, too low, and/or not following
     * the step size rule for the symbol.
     */
    MARKET_LOT_SIZE(-9006),
    /**
     * The account's position has reached the maximum defined limit. This
     * is composed of the sum of the balance of the base asset, and the sum
     * of the quantity of all open BUYorders.
     */
    MAX_POSITION(-9007),
    /**
     * Account has too many open orders on the symbol.
     */
    MAX_NUM_ORDERS(-9008),
    /**
     * Account has too many open stop loss and/or take profit orders on the
     * symbol.
     */
    MAX_NUM_ALGO_ORDERS(-9009),
    /**
     * Account has too many open iceberg orders on the symbol.
     */
    MAX_NUM_ICEBERG_ORDERS(-9010),
    /**
     * Account has too many open orders on the exchange.
     */
    EXCHANGE_MAX_NUM_ORDERS(-9011),
    /**
     * Account has too many open stop loss and/or take profit orders on the
     * exchange.
     */
    EXCHANGE_MAX_NUM_ALGO_ORDERS(-9012),
    /**
     * Repay amount should not be larger than liability.
     */
    REPAY_CHECK_BEYOND_LIABILITY(-10017),
    /**
     * Redeption of the token is forbiden now
     */
    BLVT_FORBID_REDEEM(-13000),
    /**
     * Exceeds individual 24h redemption limit of the token
     */
    BLVT_EXCEED_DAILY_LIMIT(-13001),
    /**
     * Exceeds total 24h redemption limit of the token
     */
    BLVT_EXCEED_TOKEN_DAILY_LIMIT(-13002),
    /**
     * Subscription of the token is forbiden now
     */
    BLVT_FORBID_PURCHASE(-13003),
    /**
     * Exceeds individual 24h subscription limit of the token
     */
    BLVT_EXCEED_DAILY_PURCHASE_LIMIT(-13004),
    /**
     * Exceeds total 24h subscription limit of the token
     */
    BLVT_EXCEED_TOKEN_DAILY_PURCHASE_LIMIT(-13005),
    /**
     * Subscription amount is too small
     */
    BLVT_PURCHASE_LESS_MIN_AMOUNT(-13006),
    /**
     * The Agreement is not signed
     */
    BLVT_PURCHASE_AGREEMENT_NOT_SIGN(-13007),
    /**
     * More than 1 request in 3 seconds
     */
    SWAP_TOO_MANY_REQUESTS(-12014),
    /**
     * This token is not currently supported, please re-enter
     */
    TOKEN_NOT_SUPPORTED(-450001),
    /**
     * Amount cannot be 0, please re-enter
     * The amount is too small, please re-enter
     */
    WRONG_AMOUNT(-450005),
    /**
     * The total amount of codes you created has exceeded the 24-hour
     * limit, please try again after UTC 0
     */
    CODES_EXPIRED(-450017),
    /**
     * Too many codes created in 24 hours, please try again after UTC 0
     */
    TOO_MANY_CODES(-450018),
    /**
     * Too many invalid verify attempts, please try later
     */
    TOO_MANY_INVALID_VERIFY_ATTEMPTS(-450020),
    /**
     * Too many invalid redeem attempts in 24 hours, please try again after
     * UTC 0
     */
    TOO_MANY_INVALID_REDEEM_ATTEMPTS(-450022);

    /** The error code */
    @Getter
    private final int value;

    /**
     * the enum corresponding to the integer if present
     */
    public static ApiErrorCode valueOf(int value) {
        return Arrays.stream(values()).filter(e -> e.getValue() == value).findFirst().orElse(ApiErrorCode.UNKNOWN);
    }
}