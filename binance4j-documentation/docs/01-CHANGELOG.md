---
title: Changelog
id: changelog
---

All notable changes to this project will be documented in this file.

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
