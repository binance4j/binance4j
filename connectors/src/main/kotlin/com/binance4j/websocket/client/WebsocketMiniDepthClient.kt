/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.websocket.client

import com.binance4j.websocket.callback.WebsocketCallback
import com.binance4j.websocket.dto.DepthLevel
import com.binance4j.websocket.dto.DepthUpdateSpeed
import com.binance4j.websocket.dto.MiniDepth

/**
 * Websocket client handling top bids and asks events on one or many symbols ²
 * @param symbols  Symbols we want the data.
 * @param level    Order book size.
 * @param speed    Update speed.
 * @param callback Events handler.
 */
class WebsocketMiniDepthClient(
    symbols: String, level: DepthLevel, speed: DepthUpdateSpeed, callback: WebsocketCallback<MiniDepth>
) : BaseWebsocketClient<MiniDepth>(symbols, String.format("depth%s@%s", level.toString(), speed.toString()), MiniDepth::class.java, callback) {

    constructor(
        symbols: Iterable<CharSequence>, level: DepthLevel, speed: DepthUpdateSpeed, callback: WebsocketCallback<MiniDepth>
    ) : this(symbols.joinToString(","), level, speed, callback)
}