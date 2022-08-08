package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Savings endpoints. */
@RestController
@RequestMapping("api/v1/savings")
@Api(value = "Savings", tags = "Savings", produces = "application/json", description = "Savings endpoints")
public class SavingsControllerTodo extends BaseController {

}