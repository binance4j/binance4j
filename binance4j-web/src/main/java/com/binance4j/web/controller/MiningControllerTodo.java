package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Mining endpoints. */
@RestController
@RequestMapping("api/v1/mining")
@Api(value = "Mining Controller", tags = "Mining Controller", produces = "application/json", description = "Mining endpoints")
public class MiningControllerTodo extends BaseController {

}