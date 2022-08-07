package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/rebate")
@Api(value = "Rebate Controller", tags = "Rebate Controller", produces = "application/json", description = "Rebate endpoints")
public class RebateControllerTodo extends BaseController {

}