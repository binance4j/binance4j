package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Wallet endpoints. */
@RestController
@RequestMapping("api/v1/wallet")
@Api(value = "Wallet", tags = "Wallet", produces = "application/json", description = "Wallet endpoints")
public class WalletControllerTodo extends BaseController {

}