<!-- logo -->

<p align="center">
	<img src="./static/img/logo/logo-256_x_256.png" width="256" height="256" />
</p>

<h1 align="center">Binance4j</h1>

<!-- badges -->

<p align="center">
	<a href="https://opensource.org/licenses/MIT">
		<img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License: MIT"/>
	</a>
	<img src="https://upload.wikimedia.org/wikipedia/commons/7/75/Blue_JDK_1.8%2B_Shield_Badge.svg" alt="JDK" />
</p>

<!-- description -->

<h2 align="center">Java connectors and technical analysis for the Binance API</h2>

<h3 align="center">
	<a href="https://binance4j.github.io/binance4j/">
		Documentation
	</a>
</h3>
<!-- binance4j-market -->

<!-- title -->

<h1 align="center">
	binance4j-market
</h1>

<!-- logo -->

<p align="center">
	<img src="./static/img/repos/market.svg" width="128" height="128" />
</p>

<!-- badges -->

<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-market">
		<img src="https://img.shields.io/badge/javadoc-latest-informational"alt="Javadoc"/>
	</a>
</p>

<!-- description -->

<h2 align="center">
	Connector for the market endpoints.
</h2>

## Features

- Test the API connectivity
- Get the server time
- Get the exchange trading rules and symbols informations.
- Get symbols order book
- Get symbols best price/quantity on the order book
- Get recent/historical trades
- Get aggregate trades
- Get candlesticks
- Get symbols average/latest price
- Get symbols 24 hour rolling window price change statistics

## Installation

### Maven

```xml
<dependency>
	<groupId>com.binance4j</groupId>
	<artifactId>binance4j-market</artifactId>
	<version>1.7.3</version>
</dependency>
```

<!-- binance4j-nft -->

<!-- title -->
<h1 align="center">
	binance4j-nft
</h1>

<!-- logo -->
<p align="center">
	<img src="./static/img/repos/nft.svg" width="128" height="128" />
</p>

<!-- badges -->
<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-nft">
		<img src="https://img.shields.io/badge/javadoc-latest-informational" alt="Javadoc"/>
	</a>
</p>

<h2 align="center">
	Connector for the NFT endpoints
</h2>

## Features

- Get NFT Transaction History
- Get NFT Deposit History
- Get NFT Withdraw History
- Get NFT Asset

## Installation

### Maven

```xml
<dependency>
	<groupId>com.binance4j</groupId>
	<artifactId>binance4j-nft</artifactId>
	<version>1.7.3</version>
</dependency>
```

<!-- binance4j-spot -->

<!-- title -->
<h1 align="center">
	binance4j-spot
</h1>

<!-- logo -->
<p align="center">
	<img src="./static/img/repos/spot.svg" width="128" height="128" />
</p>

<!-- badges -->
<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-spot">
		<img src="https://img.shields.io/badge/javadoc-latest-informational" alt="Javadoc"/>
	</a>
</p>

<h2 align="center">
	Connector for the SPOT endpoints
</h2>

## Features

- Send orders
- Cancel orders
- Get orders status
- Get account informations
- Get past trades
- Get order count for API order rate limiting

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-spot</artifactId>
  <version>1.7.3</version>
</dependency>
```

<!-- binance4j-wallet -->

<!-- title -->
<h1 align="center">
	binance4j-wallet
</h1>

<!-- logo -->
<p align="center">
	<img src="./static/img/repos/wallet.svg" width="128" height="128" />
</p>

<!-- badges -->
<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-wallet">
		<img src="https://img.shields.io/badge/javadoc-latest-informational" alt="Javadoc"/>
	</a>
</p>

<h2 align="center">
	Connector for the wallet endpoints
</h2>

## Features

- Get the system status
- Get coins informations
- Get account daily snapshots
- Get account status
- Get API trading status
- Get API permissions
- Deposit/withdraw funds
- Get deposit/withdraw history
- Do a dust transfer
- Get dust transfer logs
- Get assets convertible into BNB
- Get asset dividend record
- Get asset details
- Get trade fees
- Transfer funds between account wallets
- Get transfer history
- Get funding wallet asset balance

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-wallet</artifactId>
  <version>1.7.3</version>
</dependency>
```

<!-- binance4j-websocket -->

<!-- title -->

<h1 align="center">
	binance4j-websocket
</h1>

<!-- logo -->

<p align="center">
	<img src="./static/img/repos/websocket.svg" width="128" height="128" />
</p>

<!-- badges -->

<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-websocket">
		<img src="https://img.shields.io/badge/javadoc-latest-informational"alt="Javadoc"/>
	</a>
</p>

<!-- description -->

<h2 align="center">
	Websocket connectors
</h2>

## Features

- Real time order book events
- Real time symbol tickers events
- Real time kline events
- Real time trades events
- Real time user data / balance events
- Auto ping and auto pong
- Auto reconnection on connection failure and disconnection by the server
- Auto call to keep alive listen key for user data stream

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-websocket</artifactId>
  <version>1.7.3</version>
</dependency>
```

<!-- binance4j-vision -->

<!-- title -->
<h1 align="center">
	binance4j-vision
</h1>

<!-- logo -->
<p align="center">
	<img src="./static/img/repos/vision.svg" width="128" height="128" />
</p>

<!-- badges -->
<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-vision">
		<img src="https://img.shields.io/badge/javadoc-latest-informational" alt="Javadoc"/>
	</a>
</p>

<h2 align="center">
	Connector for the public data endpoints
</h2>

## Features

### SPOT

- Get historical daily/monthly klines
- Get historical daily/monthly trades
- Get historical daily/monthly aggregate trades

### FUTURES

coming soon

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-vision</artifactId>
  <version>1.7.3</version>
</dependency>
```

<!-- binance4j-strategy -->

<!-- title -->
<h1 align="center">
	binance4j-strategy
</h1>

<!-- logo -->
<p align="center">
	<img src="./static/img/repos/strategy.svg" width="128" height="128" />
</p>

<!-- badges -->
<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-strategy">
		<img src="https://img.shields.io/badge/javadoc-latest-informational" alt="Javadoc"/>
	</a>
</p>

<h2 align="center">
	Technical analysis for the binance4j ecosystem
</h2>

## Features

- Create trading strategies
- Analyse strategy with ta4j
- Backtest strategy with external klines/bar series or Binance public klines with binance4j-vision
- Live trade on Binance streams with binance4j-websocket
- Live trade on multiple symbols

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-strategy</artifactId>
  <version>1.7.3</version>
</dependency>
```

<!-- binance4j-core -->

<!-- title -->

<h1 align="center">
	binance4j-core
</h1>

<!-- logo -->

<p align="center">
	<img src="./static/img/repos/core.svg" width="128" height="128" />
</p>

<!-- badges -->

<p align="center">
	<a href="https://binance4j.github.io/binance4j/binance4j-core">
		<img src="https://img.shields.io/badge/javadoc-latest-informational"alt="Javadoc"/>
	</a>
</p>

<!-- description -->

<h2 align="center">
	binance4j core module
</h2>

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-core</artifactId>
  <version>1.7.3</version>
</dependency>
```
