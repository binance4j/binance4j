package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Margin endpoints. */
@RestController
@RequestMapping("api/v1/margin")
@Api(value = "Margin", tags = "Margin", produces = "application/json", description = "Margin endpoints")
public class MarginControllerTodo extends BaseController {

}