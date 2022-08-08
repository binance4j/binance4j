package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Staking endpoints. */
@RestController
@RequestMapping("api/v1/staking")
@Api(value = "Staking", tags = "Staking", produces = "application/json", description = "Staking endpoints")
public class StakingControllerTodo extends BaseController {

}