package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/spot")
@Api(value = "Spot Controller", tags = "Spot Controller", produces = "application/json", description = "Spot endpoints")
public class SpotControllerTodo extends BaseController {

}