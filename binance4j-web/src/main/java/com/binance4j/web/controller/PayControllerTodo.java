package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/pay")
@Api(value = "Pay Controller", tags = "Pay Controller", produces = "application/json", description = "Pay endpoints")
public class PayControllerTodo extends BaseController {

}