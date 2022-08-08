package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for Vision endpoints. */
@RestController
@RequestMapping("api/v1/vision")
@Api(value = "Vision", tags = "Vision", produces = "application/json", description = "Vision endpoints")
public class VisionControllerTodo extends BaseController {

}