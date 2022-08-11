"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[1803],{2192:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>c,contentTitle:()=>m,default:()=>g,frontMatter:()=>o,metadata:()=>d,toc:()=>p});var i=a(7462),s=(a(7294),a(3905)),r=a(2328),l=a(9497),n=a(3389);const o={title:"Market"},m=void 0,d={unversionedId:"endpoints/market",id:"endpoints/market",title:"Market",description:"Installation",source:"@site/docs/30-endpoints/80-market.mdx",sourceDirName:"30-endpoints",slug:"/endpoints/market",permalink:"/binance4j/binance4j-documentation/docs/endpoints/market",draft:!1,editUrl:"https://github.com/binance4j/binance4j/docs/30-endpoints/80-market.mdx",tags:[],version:"current",sidebarPosition:80,frontMatter:{title:"Market"},sidebar:"tutorialSidebar",previous:{title:"Margin",permalink:"/binance4j/binance4j-documentation/docs/endpoints/margin"},next:{title:"Mining",permalink:"/binance4j/binance4j-documentation/docs/endpoints/mining"}},c={},p=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Features",id:"features",level:2},{value:"Test connectivity",id:"test-connectivity",level:3},{value:"Get server time",id:"get-server-time",level:3},{value:"Get exchange info",id:"get-exchange-info",level:3},{value:"Get a symbol&#39;s order book",id:"get-a-symbols-order-book",level:3},{value:"Get recent trades",id:"get-recent-trades",level:3},{value:"Get historical trades",id:"get-historical-trades",level:3},{value:"Get compressed/aggregate trades List",id:"get-compressedaggregate-trades-list",level:3},{value:"Get Klines / candles",id:"get-klines--candles",level:3},{value:"Get average price",id:"get-average-price",level:3},{value:"Get 24h ticker statistics",id:"get-24h-ticker-statistics",level:3},{value:"Get price ticker",id:"get-price-ticker",level:3},{value:"Get order book ticker",id:"get-order-book-ticker",level:3}],k={toc:p};function g(e){let{components:t,...a}=e;return(0,s.kt)("wrapper",(0,i.Z)({},k,a,{components:t,mdxType:"MDXLayout"}),(0,s.kt)(l.ZP,{artifact:"market",mdxType:"RepoBadges"}),(0,s.kt)("h2",{id:"installation"},"Installation"),(0,s.kt)(r.ZP,{repo:"market",mdxType:"ArtifactInstall"}),(0,s.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,s.kt)("pre",null,(0,s.kt)("code",{parentName:"pre",className:"language-java"},"MarketDataClient client = new MarketDataClient(key, secret);\n")),(0,s.kt)("h2",{id:"features"},"Features"),(0,s.kt)("h3",{id:"test-connectivity"},"Test connectivity"),(0,s.kt)("pre",null,(0,s.kt)("code",{parentName:"pre",className:"language-java"},"client.ping().sync();\n")),(0,s.kt)("h3",{id:"get-server-time"},"Get server time"),(0,s.kt)(n.ZP,{payload:"ServerTimeRespons",method:"getServerTime",items:[{}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-exchange-info"},"Get exchange info"),(0,s.kt)(n.ZP,{payload:"ExchangeInfo",method:"getExchangeInfo",items:[{label:"All symbols"},{label:"One symbol",params:"new ExchangeInfoParams(symbol)"},{label:"Multiple symbols",params:"new ExchangeInfoParams(symbols[])"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-a-symbols-order-book"},"Get a symbol's order book"),(0,s.kt)(n.ZP,{payload:"OrderBook",method:"getOrderBook",items:[{label:"One symbol",params:"new OrderBookParams(symbol)"},{label:"With limit (Enum)",params:"new OrderBookParams(symbol,OrderBookLimit.LIMIT_10)"},{label:"With limit (String)",params:'new OrderBookParams(symbol,"10")'}],mdxType:"Examples"}),(0,s.kt)("admonition",{type:"caution"},(0,s.kt)("p",{parentName:"admonition"},"The String value must match one of the ",(0,s.kt)("inlineCode",{parentName:"p"},"OrderBookLimit")," values or the request will fail")),(0,s.kt)("h3",{id:"get-recent-trades"},"Get recent trades"),(0,s.kt)(n.ZP,{payload:"List<Trade>",method:"getTrades",items:[{label:"One symbol",params:"new TradesParams(symbol)"},{label:"With limit",params:"new TradesParams(symbol,10)"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-historical-trades"},"Get historical trades"),(0,s.kt)(n.ZP,{payload:"List<Trade>",method:"getHistoricalTrades",items:[{params:"new TradesParams(symbol)"},{label:"With limit",params:"new TradesParams(symbol,10)"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-compressedaggregate-trades-list"},"Get compressed/aggregate trades List"),(0,s.kt)(n.ZP,{payload:"List<AggTrade>",method:"getAggTrades",items:[{params:"new AggTradeParams(symbol)"},{label:"Framed",params:"new AggTradeParams(symbol), new TimeFrame(startTime, endTime, limit)"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-klines--candles"},"Get Klines / candles"),(0,s.kt)(n.ZP,{payload:"List<Candle>",method:"getKlines",items:[{label:"Enum interval",params:"new KlinesParams(symbol, CandlestickInterval.ONE_MINUTE)"},{label:"String interval",params:'new KlinesParams(symbol, "1m")'}],mdxType:"Examples"}),(0,s.kt)("admonition",{type:"caution"},(0,s.kt)("p",{parentName:"admonition"},"The String interval must correspond to one of the ",(0,s.kt)("inlineCode",{parentName:"p"},"CandlestickInterval")," else the request will throw an ApiException")),(0,s.kt)("h3",{id:"get-average-price"},"Get average price"),(0,s.kt)(n.ZP,{payload:"AveragePrice",method:"getAveragePrice",items:[{params:"new AveragePriceParams(symbol)"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-24h-ticker-statistics"},"Get 24h ticker statistics"),(0,s.kt)(n.ZP,{payload:"TickerStatistics",method:"get24hTickerStatistics",items:[{label:"One symbol",params:"new TickerStatisticsParams(symbol)"}],mdxType:"Examples"}),(0,s.kt)(n.ZP,{payload:"List<TickersStatistics>",method:"get24hTickerStatistics",items:[{label:"All symbols"},{label:"Multiple symbols",params:"new TickerStatisticsParams(symbols[])"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-price-ticker"},"Get price ticker"),(0,s.kt)(n.ZP,{payload:"PriceTicker",method:"getTicker",items:[{label:"One symbol",params:"new PriceTickerParams(symbol)"}],mdxType:"Examples"}),(0,s.kt)(n.ZP,{payload:"List<PriceTicker>",method:"getTicker",items:[{label:"All symbols"},{label:"Multiple symbols",params:"new PriceTickersParams(symbols[])"}],mdxType:"Examples"}),(0,s.kt)("h3",{id:"get-order-book-ticker"},"Get order book ticker"),(0,s.kt)(n.ZP,{payload:"OrderBook",method:"getOrderBook",items:[{label:"Default",params:"new OrderBookParams(symbol)"},{label:"With limit (Enum)",params:"new OrderBookParams(symbol, OrderBookLimit.LIMIT_10)"},{label:"With limit (String)",params:'new OrderBookParams(symbol, "10")'}],mdxType:"Examples"}),(0,s.kt)("admonition",{type:"caution"},(0,s.kt)("p",{parentName:"admonition"},"The String value must match one of the ",(0,s.kt)("inlineCode",{parentName:"p"},"OrderBookLimit")," values or the request will fail")))}g.isMDXComponent=!0},2328:(e,t,a)=>{a.d(t,{ZP:()=>o});var i=a(7462),s=(a(7294),a(3905)),r=a(5884),l=a(8306);const n={toc:[]};function o(e){let{components:t,...a}=e;return(0,s.kt)("wrapper",(0,i.Z)({},n,a,{components:t,mdxType:"MDXLayout"}),(0,s.kt)(r.Z,{repo:a.repo,version:l.i,mdxType:"InstallationInstructions"}))}o.isMDXComponent=!0},9497:(e,t,a)=>{a.d(t,{ZP:()=>o});var i=a(7462),s=(a(7294),a(3905)),r=a(8267),l=a(8306);const n={toc:[]};function o(e){let{components:t,...a}=e;return(0,s.kt)("wrapper",(0,i.Z)({},n,a,{components:t,mdxType:"MDXLayout"}),(0,s.kt)(r.Z,{artifact:a.artifact,version:l.i,mdxType:"RepoBadges"}))}o.isMDXComponent=!0},8306:e=>{e.exports={i:"2.1.1"}}}]);