---
title: Changelog
id: changelog
---

All notable changes to this project will be documented in this file.

## [2.4.0] - 2022-08-18

### Changed

- binance4j-margin:
  - Deprecated NewOrderParams in `newOrder` and `newOrderTest`.

### Added

- binance4j-margin :
  - Added specific Order Params to `newOrder` and `newOrderTest`:
    - LimitOrder
    - MarketOrder
    - MarketQuoteOrder
    - StopLossOrder
    - StopLossLimitOrder
    - TakeProfitOrder
    - TakeProfitLimitOrder
    - LimitMakerOrder

## Fixed

- binance4j-margin:
  - Corrected missing property isIsolated in orders.

## [2.3.0] - 2022-08-16

### Added

- all :
  - API calls are now rate limited by default.

## [2.2.0] - 2022-08-11

### Added

- all:
  - Every API call returns its own Specific `Request` containing method, weight and signature info.
- core:
  - Added `FullApiAsyncCallback` containing Headers in response.
- connectors:
  - Added Websocket connectors to `Connectors`

### Changed

- connectors:
  - Seperated REST and Websocket connectors in two seperated classes: `RestConnectors` and `WebsocketConnectors`.
  - Deprecated direct access to REST clients in `Connectors` class.

## [2.1.1] - 2022-08-09

### Fixed

- binance4j-vision:
  - corrected async calls as defined in 2.1.0

## [2.1.0] - 2022-08-09

### Changed

- binance4j-spot:
  - Deprecated NewOrderParams in `newOrder` and `newOrderTest`.

- binance4j-core:
  - Deprecated `async(ApiCallback)`.

### Added

- binance4j-core:
  - Added `async(ApiAsyncCallback)`. Potential ApiException is passed as second parameter of lambda, making it easier to write than with functional interface.

- binance4j-spot:
  - Added specific Order Params to `newOrder` and `newOrderTest`:
    - LimitOrder
    - MarketOrder
    - MarketQuoteOrder
    - StopLossOrder
    - StopLossLimitOrder
    - TakeProfitOrder
    - TakeProfitLimitOrder
    - LimitMakerOrder

## [2.0.6] - 2022-08-09

### Fixed

- binance4j-core:
  - Fixed `params.ToMap()` issue.

### Changed

- binance4j-mining:
  - Changed TimeFrame for Paging in `getHashrateResales` && `getHashrateResalesDetails`
- binance4j-connectors:
  - `portfoliomarginClient()` becomes`portfolioMarginClient()`

## [2.0.5] - 2022-08-07

### Added

- all
  - Fixed constructors with enums
  - added missing properties in DTOs.

## [2.0.4] - 2022-08-07

### Added

- connectors
  - Added binance4j-convert
  - Added shortened client getters

### Changed

- convert
  - Deprecated getters with `Client` suffix

## [2.0.3] - 2022-08-07

### Added

- all
  - Added Swagger annotations to payloads

## [2.0.2] - 2022-08-06

### Changed

- all
  - Removed empty constructors in payloads
