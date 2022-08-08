package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/** Controller for NFT endpoints. */
@RestController
@RequestMapping("api/v1/nft")
@Api(value = "NFT", tags = "NFT", produces = "application/json", description = "NFT endpoints")
public class NFTControllerTodo extends BaseController {

}