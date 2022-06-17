"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[451],{2398:function(e,t,a){a.r(t),a.d(t,{assets:function(){return S},contentTitle:function(){return b},default:function(){return I},frontMatter:function(){return h},metadata:function(){return y},toc:function(){return v}});var n=a(7462),r=a(3366),i=(a(7294),a(3905)),s=a(112),l=a(9098),o=a(3738),c=a(8306),d=["components"],g={toc:[]};function p(e){var t=e.components,a=(0,r.Z)(e,d);return(0,i.kt)("wrapper",(0,n.Z)({},g,a,{components:t,mdxType:"MDXLayout"}),(0,i.kt)(o.Z,{artifact:"strategy",javadoc:"com/binance4j/strategy/"+a.javadoc,version:c.i,label:a.label,mdxType:"JavadocBadge"}))}p.isMDXComponent=!0;var u=a(5162),k=a(5488),m=["components"],h={title:"Strategy"},b=void 0,y={unversionedId:"Strategy",id:"Strategy",title:"Strategy",description:"Description",source:"@site/docs/10-Strategy.mdx",sourceDirName:".",slug:"/Strategy",permalink:"/binance4j/binance4j-documentation/docs/Strategy",draft:!1,editUrl:"https://github.com/binance4j/docs/10-Strategy.mdx",tags:[],version:"current",sidebarPosition:10,frontMatter:{title:"Strategy"},sidebar:"tutorialSidebar",previous:{title:"Websocket",permalink:"/binance4j/binance4j-documentation/docs/Websocket"}},S={},v=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Dependencies",id:"dependencies",level:2},{value:"Write a strategy",id:"write-a-strategy",level:2},{value:"Backtest a strategy",id:"backtest-a-strategy",level:2},{value:"Live trade",id:"live-trade",level:2},{value:"Watch multiple symbols",id:"watch-multiple-symbols",level:2},{value:"Get strategy position over a candlestick",id:"get-strategy-position-over-a-candlestick",level:2}],w={toc:v};function I(e){var t=e.components,a=(0,r.Z)(e,m);return(0,i.kt)("wrapper",(0,n.Z)({},w,a,{components:t,mdxType:"MDXLayout"}),(0,i.kt)(l.Z,{artifact:"strategy",version:c.i,mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"description"},"Description"),(0,i.kt)("p",null,"Binance4j-strategy adds technical analysis for the binance4j ecosystem."),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(s.Z,{repo:"strategy",version:c.i,mdxType:"InstallationInstructions"}),(0,i.kt)("h2",{id:"dependencies"},"Dependencies"),(0,i.kt)("ul",null,(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"Core"},"binance4j-core")," : The core of every binance4j artifact"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"Vision"},"binance4j-vision")," : Retrieve Binance public data"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"Websocket"},"binance4j-websocket")," : Real-time market streams"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://projectlombok.org/"},"Lombok")," : Prevent boilerplate code."),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://square.github.io/okhttp/"},"OkHttp")," : HTTP && Websocket clients"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://square.github.io/retrofit/"},"Retrofit")," : Map API endpoints with annotations."),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://github.com/FasterXML/jackson"},"Jackson")," : Payload deserialization"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://commons.apache.org/proper/commons-codec/"},"Apache Common Codecs")," : Encode/decode urls")),(0,i.kt)("h2",{id:"write-a-strategy"},"Write a strategy"),(0,i.kt)(p,{label:"BaseTradingStrategy",javadoc:"trading/BaseTradingStrategy.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Binance4j uses ",(0,i.kt)("a",{parentName:"p",href:"https://github.com/ta4j/ta4j"},"ta4j")," for technical analysis and backtesting."),(0,i.kt)("p",null,"To understand how indicators and rules work, read the library ",(0,i.kt)("a",{parentName:"p",href:"https://ta4j.github.io/ta4j-wiki/"},"documentation")),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"//Every Strategy must extend BaseTradingStrategy\npublic class TwoPeriodRSIStrategy extends BaseTradingStrategy {\n\n    //This is where we define the rule that will send a BUY signal\n    @Override\n    public Rule getEntry(BarSeries series) {\n        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);\n        SMAIndicator shortSma = new SMAIndicator(closePrice, 5);\n        SMAIndicator longSma = new SMAIndicator(closePrice, 200);\n\n        // We use a 2-period RSI indicator to identify buying\n        // or selling opportunities within the bigger trend.\n        RSIIndicator rsi = new RSIIndicator(closePrice, 2);\n\n        // Entry rule\n        // The long-term trend is up when a security is above its 200-period SMA.\n        return new OverIndicatorRule(shortSma, longSma) // Trend\n                .and(new CrossedDownIndicatorRule(rsi, 5)) // Signal 1\n                .and(new OverIndicatorRule(shortSma, closePrice)); // Signal 2\n    }\n\n    //This is where we define the rule that will send a SELL signal\n    @Override\n    public Rule getExit(BarSeries series) {\n        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);\n        SMAIndicator shortSma = new SMAIndicator(closePrice, 5);\n        SMAIndicator longSma = new SMAIndicator(closePrice, 200);\n\n        // We use a 2-period RSI indicator to identify buying\n        // or selling opportunities within the bigger trend.\n        RSIIndicator rsi = new RSIIndicator(closePrice, 2);\n\n        // Exit rule\n        // The long-term trend is down when a security is below its 200-period SMA.\n        return new UnderIndicatorRule(shortSma, longSma) // Trend\n                .and(new CrossedUpIndicatorRule(rsi, 95)) // Signal 1\n                .and(new UnderIndicatorRule(shortSma, closePrice)); // Signal 2\n\n    }\n}\n")),(0,i.kt)("h2",{id:"backtest-a-strategy"},"Backtest a strategy"),(0,i.kt)(p,{label:"BaseTradingStrategy",javadoc:"trading/BaseTradingStrategy.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(p,{label:"BackTestResult ",javadoc:"backtesting/BackTestResult.html",mdxType:"Badge"}),(0,i.kt)(k.Z,{mdxType:"Tabs"},(0,i.kt)(u.Z,{label:"Use an external candlestick",value:"external",mdxType:"TabItem"},(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'// Let\'s get some public data with the vision SpotClient\nList<CandlestickBar> bars = new SpotClient()\n        .getKlines("BNBBTC", CandlestickInterval.FIVE_MINUTES, "2022", "01")\n        .getData();\n\n//We instantiate the strategy\nTwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();\n\n//We run the backtest on the series\nBackTestResult result = strategy.backTest(bars, CandlestickInterval.FIVE_MINUTES);\n'))),(0,i.kt)(u.Z,{label:"Use binance-vision",value:"vision",mdxType:"TabItem"},(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'//We instantiate the strategy\nTwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();\n\n//Here we implicitly use binance4j-vision to download the data from binance servers\nBackTestResult result = strategy.backTest("BNBBTC", CandlestickInterval.FIVE_MINUTES, "2022", "01");\n')))),(0,i.kt)("h2",{id:"live-trade"},"Live trade"),(0,i.kt)(p,{label:"BaseTradingStrategy",javadoc:"trading/BaseTradingStrategy.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(p,{label:"StrategyCallback ",javadoc:"trading/StrategyCallback.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Live trading uses binance4j-websocket to get real-time klines data"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();\n\n//The stream callback\nStrategyCallback callback = new StrategyCallback();\n\n//Stream is closed\ncallback.onClosed(websocketCloseObject -> {\n    //...\n});\n\n//Stream is closing\ncallback.onClosing(WebsocketCloseObject -> {\n    //...\n});\n\n//Stream is open\ncallback.onOpen(response -> {\n    //...\n});\n\n//connection failed/reading data failed/ping failed\ncallback.onFailure(apiException -> {\n    //...\n});\n\n//BUY signal (only called on final bar of interval)\ncallback.onEnter(series -> {\n    //...\n});\n\n//SELL signal (only called on final bar of interval)\ncallback.onExit(series-> {\n    //...\n});\n\n//every tick\ncallback.onMessage(symbolBar -> {\n    //...\n});\n\n// We set the inner BarSeries size. Default is 500.\nstrategy.setMaximumBarCount(200);\n\n//We start live trading\nWebsocketClient wsClient = strategy.watch("BNBBTC", CandlestickInterval.ONE_MINUTE, callback);\n\n//We stop live trading\nstrategy.unwatch();\n')),(0,i.kt)("h2",{id:"watch-multiple-symbols"},"Watch multiple symbols"),(0,i.kt)("p",null,"A strategy can watch multiple symbols at the same time. Just use a string with symbols separated by a coma:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'WebsocketClient wsClient = strategy.watch("BNBBTC,BTCBUSD,SHIBBUSD", CandlestickInterval.ONE_MINUTE, callback);\n')),(0,i.kt)("p",null,"or with a collection:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'WebsocketClient wsClient = strategy.watch(List.of("BNBBTC","BTCBUSD","SHIBBUSD"), CandlestickInterval.ONE_MINUTE, callback);\n')),(0,i.kt)("p",null,"The strategy will create a ",(0,i.kt)("inlineCode",{parentName:"p"},"BarSeries")," instance for every symbol."),(0,i.kt)("p",null,"To know the symbol of the series returned by ",(0,i.kt)("inlineCode",{parentName:"p"},"onEnter")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"onExit"),", do as follow:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"callback.onEnter(series -> {\n    series.getName(); // returns the symbol\n});\n\ncallback.onExit(series-> {\n    series.getName(); // returns the symbol\n});\n")),(0,i.kt)("p",null,"To know the symbol of the bar returned by ",(0,i.kt)("inlineCode",{parentName:"p"},"onMessage"),", do as follow:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"//every tick\ncallback.onMessage(symbolBar -> {\n    symbolBar.getSymbol(); // returns the symbol\n});\n")),(0,i.kt)("h2",{id:"get-strategy-position-over-a-candlestick"},"Get strategy position over a candlestick"),(0,i.kt)("p",null,"The strategy can also give its trading position over the bars."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'// Let\'s get some public data with the vision SpotClient\nList<CandlestickBar> bars = new SpotClient()\n        .getKlines("BNBBTC", CandlestickInterval.FIVE_MINUTES, "2022", "01")\n        .getData();\n\n// We instantiate the strategy\nTwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();\n\n// Here we get the position of the strategy on the last bar of the series\nboolean shouldEnter = strategy.shouldEnter(bars, CandlestickInterval.FIVE_MINUTES);\nboolean shouldExit = strategy.shouldExit(bars, CandlestickInterval.FIVE_MINUTES);\n\n// Here we get the position of the strategy on the 6th bar of the series\nboolean shouldEnter = strategy.shouldEnter(bars, CandlestickInterval.FIVE_MINUTES, 5);\nboolean shouldExit = strategy.shouldExit(bars, CandlestickInterval.FIVE_MINUTES, 5);\n')),(0,i.kt)("p",null,"The ",(0,i.kt)("inlineCode",{parentName:"p"},"CandlestickBar")," list will be converted at every method call."),(0,i.kt)("p",null,"To prevent useless computation, you can convert the list into a ",(0,i.kt)("inlineCode",{parentName:"p"},"BarSeries")," before giving it to the methods."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'// Let\'s get some public data with the vision SpotClient\nList<CandlestickBar> bars = new SpotClient()\n        .getKlines("BNBBTC", CandlestickInterval.FIVE_MINUTES, "2022", "01")\n        .getData();\n\n// We convert the bars into a BarSeries\nBarSeries series = BarSeriesService.convert(bars, CandlestickInterval.FIVE_MINUTES);\n\n//We instantiate the strategy\nTwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();\n\n// Here we get the position of the strategy on the last bar of the series\nboolean shouldEnter = strategy.shouldEnter(series);\nboolean shouldExit = strategy.shouldExit(series);\n\n//Here we get the position of the strategy on the 6th bar of the series\nboolean shouldEnter = strategy.shouldEnter(series, 5);\nboolean shouldExit = strategy.shouldExit(series, 5);\n')))}I.isMDXComponent=!0}}]);