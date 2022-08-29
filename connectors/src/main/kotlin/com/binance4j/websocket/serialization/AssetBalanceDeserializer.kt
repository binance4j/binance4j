package com.binance4j.websocket.serialization

import com.binance4j.core.dto.AssetBalance
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.io.IOException

/** [AssetBalance] deserializer  */
class AssetBalanceDeserializer : JsonDeserializer<AssetBalance>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): AssetBalance {
        val n = jp.codec.readTree<JsonNode>(jp)
        return AssetBalance(n["a"].asText(), n["f"].asText(), n["l"].asText())
    }
}