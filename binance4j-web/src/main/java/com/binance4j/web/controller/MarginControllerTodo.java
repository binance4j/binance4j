package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Margin endpoints. */
@RestController
@RequestMapping("api/v1/margin")
@Api(value = "Margin Controller", tags = "Margin Controller", produces = "application/json", description = "Margin endpoints")
public class MarginControllerTodo extends BaseController {

}