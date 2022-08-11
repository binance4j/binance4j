package com.binance4j.connectors;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.c2c.client.C2CClient;
import com.binance4j.convert.client.ConvertClient;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.market.client.MarketClient;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.pay.client.PayClient;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;
import com.binance4j.rebate.client.RebateClient;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.vision.client.VisionSpotClient;
import com.binance4j.wallet.client.WalletClient;

/** Wrapper for all Rest and Webscoket connectors. */
public class Connectors {
	/** Rest connectors wrapper. */
	RestConnectors rest;
	/** Websocket connectors wrapper. */
	WebsocketConnectors ws;

	/**
	 * @param key    API key.
	 * @param secret API secret.
	 */
	public Connectors(String key, String secret) {
		rest = new RestConnectors(key, secret);
		ws = new WebsocketConnectors();
	}

	// WS //

	/**
	 * @return The Websocket connectors.
	 */
	public WebsocketConnectors ws() {
		return ws;
	}

	// REST //

	/**
	 * @return The REST connectors.
	 */
	public RestConnectors rest() {
		return rest;
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link BLVTClient}.
	 */
	@Deprecated
	public BLVTClient blvtClient() {
		return blvt();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link FiatClient}.
	 */
	@Deprecated
	public C2CClient c2cClient() {
		return c2c();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link convertClient}.
	 */
	@Deprecated
	public ConvertClient convertClient() {
		return convert();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link FiatClient}.
	 */
	@Deprecated
	public FiatClient fiatClient() {
		return fiat();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link LoanClient}.
	 */
	@Deprecated
	public LoanClient loanClient() {
		return loan();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link MarginClient}.
	 */
	@Deprecated
	public MarginClient marginClient() {
		return margin();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link MarketClient}.
	 */
	@Deprecated
	public MarketClient marketClient() {
		return market();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link MiningClient}.
	 */
	@Deprecated
	public MiningClient miningClient() {
		return mining();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link NFTClient}.
	 */
	@Deprecated
	public NFTClient nftClient() {
		return nft();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link PayClient}.
	 */
	@Deprecated
	public PayClient payClient() {
		return pay();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link PortfolioMarginClient}.
	 */
	@Deprecated
	public PortfolioMarginClient portfoliomarginClient() {
		return portfolioMargin();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link RebateClient}.
	 */
	@Deprecated
	public RebateClient rebateClient() {
		return rebate();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link SavingsClient}.
	 */
	@Deprecated
	public SavingsClient savingsClient() {
		return savings();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link SpotClient}.
	 */
	@Deprecated
	public SpotClient spotClient() {
		return spot();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link StakingClient}.
	 */
	@Deprecated
	public StakingClient stakingClient() {
		return staking();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link VisionSpotClient}.
	 */
	@Deprecated
	public VisionSpotClient visionSpotClient() {
		return visionSpot();
	}

	/**
	 * @deprecated Will be removed in a next version.
	 * @return a lazy loaded Singleton of {@link WalletClient}.
	 */
	@Deprecated
	public WalletClient walletClient() {
		return wallet();
	}

	/**
	 * @deprecated use {@code rest().blvt()}
	 * @return a lazy loaded Singleton of {@link BLVTClient}.
	 */
	@Deprecated
	public BLVTClient blvt() {
		return rest().blvt();
	}

	/**
	 * @deprecated use {@code rest().c2c()}
	 * @return a lazy loaded Singleton of {@link FiatClient}.
	 */
	@Deprecated
	public C2CClient c2c() {
		return rest().c2c();
	}

	/**
	 * @deprecated use {@code rest().convert()}
	 * @return a lazy loaded Singleton of {@link convertClient}.
	 */
	@Deprecated
	public ConvertClient convert() {
		return rest().convert();
	}

	/**
	 * @deprecated use {@code rest().fiat()}
	 * @return a lazy loaded Singleton of {@link FiatClient}.
	 */
	@Deprecated
	public FiatClient fiat() {
		return rest().fiat();
	}

	/**
	 * @deprecated use {@code rest().loan()}
	 * @return a lazy loaded Singleton of {@link LoanClient}.
	 */
	@Deprecated
	public LoanClient loan() {
		return rest().loan();

	}

	/**
	 * @deprecated use {@code rest().margin()}
	 * @return a lazy loaded Singleton of {@link MarginClient}.
	 */
	@Deprecated
	public MarginClient margin() {
		return rest().margin();

	}

	/**
	 * @deprecated use {@code rest().market()}
	 * @return a lazy loaded Singleton of {@link MarketClient}.
	 */
	@Deprecated
	public MarketClient market() {
		return rest().market();

	}

	/**
	 * @deprecated use {@code rest().mining()}
	 * @return a lazy loaded Singleton of {@link MiningClient}.
	 */
	@Deprecated
	public MiningClient mining() {
		return rest().mining();

	}

	/**
	 * @deprecated use {@code rest().nft()}
	 * @return a lazy loaded Singleton of {@link NFTClient}.
	 */
	@Deprecated
	public NFTClient nft() {
		return rest().nft();

	}

	/**
	 * @deprecated use {@code rest().pay()}
	 * @return a lazy loaded Singleton of {@link PayClient}.
	 */
	@Deprecated
	public PayClient pay() {
		return rest().pay();
	}

	/**
	 * @deprecated use {@code rest().portfolioMargin()}
	 * @return a lazy loaded Singleton of {@link PortfolioMarginClient}.
	 */
	@Deprecated
	public PortfolioMarginClient portfolioMargin() {
		return rest().portfolioMargin();
	}

	/**
	 * @deprecated use {@code rest().rebate()}
	 * @return a lazy loaded Singleton of {@link RebateClient}.
	 */
	@Deprecated
	public RebateClient rebate() {
		return rest().rebate();
	}

	/**
	 * @deprecated use {@code rest().savings()}
	 * @return a lazy loaded Singleton of {@link SavingsClient}.
	 */
	@Deprecated
	public SavingsClient savings() {
		return rest().savings();

	}

	/**
	 * @deprecated use {@code rest().spot()}
	 * @return a lazy loaded Singleton of {@link SpotClient}.
	 */
	@Deprecated
	public SpotClient spot() {
		return rest().spot();

	}

	/**
	 * @deprecated use {@code rest().staking()}
	 * @return a lazy loaded Singleton of {@link StakingClient}.
	 */
	@Deprecated
	public StakingClient staking() {
		return rest().staking();

	}

	/**
	 * @deprecated use {@code rest().visionSpot()}
	 * @return a lazy loaded Singleton of {@link VisionSpotClient}.
	 */
	@Deprecated
	public VisionSpotClient visionSpot() {
		return rest().visionSpot();
	}

	/**
	 * @deprecated use {@code rest().wallet()}
	 * @return a lazy loaded Singleton of {@link WalletClient}.
	 */
	@Deprecated
	public WalletClient wallet() {
		return rest().wallet();
	}

	/**
	 * Updates the API keys.
	 * 
	 * @deprecated us {@code rest().updateKeys(String key, String secret)}
	 * @param key    New public key.
	 * @param secret New secret key.
	 */
	@Deprecated
	public void updateKeys(String key, String secret) {
		rest().updateKeys(key, secret);
	}

	/**
	 * @deprecated us {@code rest().key()}
	 * @return the key
	 */
	@Deprecated
	public String getKey() {
		return rest().getKey();
	}

	/**
	 * @deprecated us {@code rest().secret()}
	 * @return the secret
	 */
	@Deprecated
	public String getSecret() {
		return rest().getSecret();
	}

}