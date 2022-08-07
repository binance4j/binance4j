package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/market")
@Api(value = "Market Controller", tags = "Market Controller", produces = "application/json", description = "Market endpoints")
public class MarketControllerTodo extends BaseController {

}