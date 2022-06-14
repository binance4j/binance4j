---
title: Changelog
id: changelog
---

# Change Log

All notable changes to this project will be documented in this file.

## [1.7.3] - 2022-05-26

### Fixed

- binance4j-websocket
  - PATCH : Corrected UserDataUpdatePayloadType deserialization.

## [1.7.2] - 2022-05-26

### Changed

- binance4j-nft
  - MINOR : Moved packages mistakenly put in the client package (asset, deposit, transaction and withdraw).

## [1.7.1] - 2022-05-26

### Added

- binance4j-market
  - MINOR : Added MarketDataClient constructor with implicit testnet to false.

### Changed

- binance4j-core
  - MINOR : Request#receivingWindow renamed to recvWindow to match API requirements.

## [1.7.0] - 2022-05-25

### Added

- binance4j-strategy
  - MINOR : Created SymbolBar class inheriting from Bar with the name of the symbol attached to it.
  - MINOR : Strategy#watch method can now receive a list of symbols as parameter.

### Changed

- binance4j-strategy
  - MINOR : WebsocketCallback#onMessage handler passes SymbolBar instead of Bar in order to know the symbol of the bar when watching multiple pairs.

### Fixed

- binance4j-strategy
  - PATCH : BaseTradingStrategy was sharing the same BarSeries when watching multiple symbols. Now they have their own.

## [1.6.0] - 2022-05-25

### Added

- binance4j-websocket
  - Added static websocketPort field in WebsocketClient.

### Changed

- binance4j-core
  - MINOR : Deleted CoreConfiguration and moved global parameters to corresponding classes.
- binance4j-spot
  - MINOR : Classes in status and cancelorder package moved to order package.

## [1.5.0] - 2022-05-24

### Changed

- binance4j-core
  - MINOR : Classes in cancelorder package moved to order package.

## [1.4.6] - 2022-05-24

### Changed

- binance4j-market
  - MINOR : TickerPrice renamed to PriceTicker.
- binance4j-wallet
  - MINOR : FuturesSnapshot renamed to FuturesAccountSnapshot.
- binance4j-websocket
  - MINOR : WebSocketClient renamed to WebsocketClient.

## [1.4.5] - 2022-05-24

### Added

- binance4j-core
  - MINOR : Added DESERIALIZATION_FAILURE value to ApiErrorCode enum.

### Changed

- binance4j-websocket
  - PATCH : WebsocketClient now triggers onFailure when payload deserialization fails instead of printing Exception.

## [1.4.4] - 2022-05-23

### Added

- binance4j-wallet
  - MINOR : Added constructors to DepositHistoryRequest.
  - MINOR : Added constructors to WithdrawHistoryRequest.

## [1.4.3] - 2022-05-21

### Added

- binance4j-core
  - RestClient no longer pings the server.
- binance4j-websocket
  - MINOR : WebsocketClient automatically reconnects if connection is lost by default.
  - MINOR : WebsocketClient times out after a certain amount of time without response. Coupled with auto reconnection, streams should always be on.
  - MINOR : WebsocketCandlestickClient automatically sets noResponseTimeout according to defined CandlestickInterval.
  - MINOR : UserDataWebsocketClient automatically extends listenKey lifespan every 30 minutes by default.

### Changed

- binance4j-core
  - MINOR : PingInterval removed from CoreConfiguration.
- binance4j-spot
  - MINOR : Removed user data endpoints.
- binance4j-strategy
  - MINOR : DurationService moved to binance4j-websocket.

## [1.4.2] - 2022-05-20

### Fixed

- binance4j-strategy
  - PATCH : Added a BarSeries max size to prevent memory overload

## [1.4.0] - 2022-05-20

### Added

- binance4j-strategy
  - MINOR : Added analyse on CandleStickBar lists
  - MINOR : Added convertions on BarSeriesService
- binance4j-websocket
  - MINOR : Created UserDataClient taking SpotClient user data methods to prevent artifact dependency.
  - MINOR : Added keepAlive and keepAliveKey methods

### Changed

- binance4j-spot
  - MINOR : Deprecated SpotClient user data methods and moved to binance4j-websocket