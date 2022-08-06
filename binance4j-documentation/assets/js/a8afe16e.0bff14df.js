"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[7544],{1345:(e,t,n)=>{n(814),n(5162),n(5488),n(7294)},9338:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>d,contentTitle:()=>o,default:()=>v,frontMatter:()=>l,metadata:()=>c,toc:()=>g});var a=n(7462),i=(n(7294),n(3905)),r=(n(5162),n(5488),n(814),n(112),n(3057)),s=(n(1345),n(8306));const l={title:"Trading strategies"},o=void 0,c={unversionedId:"strategy",id:"strategy",title:"Trading strategies",description:"Description",source:"@site/docs/210-strategy.mdx",sourceDirName:".",slug:"/strategy",permalink:"/binance4j/binance4j-documentation/docs/next/strategy",draft:!1,editUrl:"https://github.com/binance4j/docs/210-strategy.mdx",tags:[],version:"current",sidebarPosition:210,frontMatter:{title:"Trading strategies"},sidebar:"tutorialSidebar",previous:{title:"Websocket streams",permalink:"/binance4j/binance4j-documentation/docs/next/websocket"}},d={},g=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"What is a trading strategy?",id:"what-is-a-trading-strategy",level:2},{value:"Creating a trading strategy",id:"creating-a-trading-strategy",level:2},{value:"Backtesting a strategy",id:"backtesting-a-strategy",level:2},{value:"With existing data",id:"with-existing-data",level:3},{value:"With inner vision client",id:"with-inner-vision-client",level:3},{value:"Get the strategy position other a BarSeries",id:"get-the-strategy-position-other-a-barseries",level:2},{value:"Live trading",id:"live-trading",level:2}],u=(p="ArtifactInstall",function(e){return console.warn("Component "+p+" was not imported, exported, or provided by MDXProvider as global scope"),(0,i.kt)("div",e)});var p;const h={toc:g};function v(e){let{components:t,...n}=e;return(0,i.kt)("wrapper",(0,a.Z)({},h,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)(r.ZP,{artifact:"strategy",version:s.i,mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"description"},"Description"),(0,i.kt)("p",null,"Binance4j-strategy adds technical analysis for the binance4j ecosystem thanks to ",(0,i.kt)("a",{parentName:"p",href:"https://github.com/ta4j/ta4j"},"ta4j")," indicators and rules."),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(u,{repo:"strategy",version:s.i,mdxType:"ArtifactInstall"}),(0,i.kt)("h2",{id:"what-is-a-trading-strategy"},"What is a trading strategy?"),(0,i.kt)("p",null,"A trading strategy is a class containing two methods receiveing a BarSeries as an input and returning a trading Rule as an output, the first will send a BUY signal and the other a SELL signal."),(0,i.kt)("p",null,"Every trading strategy must implement the ",(0,i.kt)("inlineCode",{parentName:"p"},"TradingStrategy")," interface. This is the signature of the interface:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"public interface TradingStrategy {\n    // The BUY signal\n    Rule entry(BarSeries series);\n\n    // The SELL signal\n    Rule exit(BarSeries series);\n}\n")),(0,i.kt)("admonition",{type:"note"},(0,i.kt)("p",{parentName:"admonition"},"Binance4j-strategy uses ",(0,i.kt)("a",{parentName:"p",href:"https://github.com/ta4j/ta4j"},"ta4j")," for technical analysis, don't hesitate to read their documentation to understand what are indicators and rules.")),(0,i.kt)("h2",{id:"creating-a-trading-strategy"},"Creating a trading strategy"),(0,i.kt)("p",null,"Here is a trading strategy using the two period RSI indicator:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"public class TwoPeriodRSIStrategy implements TradingStrategy {\n    @Override\n    public Rule entry(BarSeries series) {\n        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);\n        SMAIndicator shortSma = new SMAIndicator(closePrice, 5);\n        SMAIndicator longSma = new SMAIndicator(closePrice, 200);\n        // We use a 2-period RSI indicator to identify buying\n        // or selling opportunities within the bigger trend.\n        RSIIndicator rsi = new RSIIndicator(closePrice, 2); // Entry rule\n        // The long-term trend is up when a security is above its 200-period SMA.\n        return new OverIndicatorRule(shortSma, longSma) // Trend\n                .and(new CrossedDownIndicatorRule(rsi, 5)) // Signal 1\n                .and(new OverIndicatorRule(shortSma, closePrice)); // Signal 2\n    }\n\n    @Override\n    public Rule exit(BarSeries series) {\n        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);\n        SMAIndicator shortSma = new SMAIndicator(closePrice, 5);\n        SMAIndicator longSma = new SMAIndicator(closePrice, 200); // We use a 2-period RSI indicator to identify buying\n        // or selling opportunities within the bigger trend.\n        RSIIndicator rsi = new RSIIndicator(closePrice, 2); // Exit rule\n        // The long-term trend is down when a security is below its 200-period SMA.\n        return new UnderIndicatorRule(shortSma, longSma) // Trend\n                .and(new CrossedUpIndicatorRule(rsi, 95)) // Signal 1\n                .and(new UnderIndicatorRule(shortSma, closePrice)); // Signal 2\n    }\n}\n")),(0,i.kt)("h2",{id:"backtesting-a-strategy"},"Backtesting a strategy"),(0,i.kt)("p",null,"Binance4j can backtest a trading strategy in many ways."),(0,i.kt)("h3",{id:"with-existing-data"},"With existing data"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'// Here we get historical klines data from the public data API.\nList<Candle> bars = new VisionSpotClient().getKlines("BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022", "01").getData();\n\n// let\'s give it to the BackTestService. CandlestickInterval must match.\nBackTestResult result = BackTestService.backTest(strategy, bars, CandlestickInterval.FIVE_MINUTES);\n\n// we can also use a ta4j Barseries instance. Let\'s convert the existing candles\nBarSeries series = BarSeriesService.convert(bars,CandlestickInterval.FIVE_MINUTES);\n\nBackTestResult result = BackTestService.backTest(strategy, series);\n')),(0,i.kt)("h3",{id:"with-inner-vision-client"},"With inner vision client"),(0,i.kt)("p",null,"The service can automatically use an instance of a VisionSpotClient to collect public data from the Binance API."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'// The service will automatically use an instance of a VisionClient to get the data from the API\nBackTestResult result = BackTestService.backTest(strategy, "BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022", "01");\n')),(0,i.kt)("h2",{id:"get-the-strategy-position-other-a-barseries"},"Get the strategy position other a BarSeries"),(0,i.kt)("p",null,"The PositionService service can give us the position of our strategy over a BarSeries instance."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"//The service will tell us if the strategy sends a BUY signal over the given index on the BarSeries\nboolean shouldEnter = PositionService.shouldEnter(strategy, series, index);\n\n//The service will tell us if the strategy sends a SELL signal over the given index on the BarSeries\nboolean shouldExit = PositionService.shouldExit(strategy, series, index);\n\n//The service will tell us if the strategy sends a BUY signal over the last Bar in the BarSeries\nboolean shouldEnter = PositionService.shouldEnter(strategy, series);\n\n//The service will tell us if the strategy sends a SELL signal over the last Bar in the BarSeries\nboolean shouldExit = PositionService.shouldExit(strategy, series);\n")),(0,i.kt)("h2",{id:"live-trading"},"Live trading"),(0,i.kt)("p",null,"In order to handle your strategy signals, you need to implement a ",(0,i.kt)("inlineCode",{parentName:"p"},"StrategyCallback"),"."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"public class MyStrategyCallback implements StrategyCallback {\n\n    public MyStrategyCallback() {\n        //...\n    }\n\n    // Handle BUY signal\n    @Override\n    public void onEnter(BarSeries series) {\n        //...\n    }\n\n    // Handle SELL signal\n    @Override\n    public void onExit(BarSeries series) {\n        //...\n    }\n\n    // server sent data\n    @Override\n    public void onMessage(SymbolBar symbolBar) {\n        //...\n    }\n\n    // Stream is open\n    @Override\n    public void onOpen(Response response) {\n        //...\n    }\n\n    // Stream is closing\n    @Override\n    public void onClosing(WebsocketCloseObject closeObject) {\n        //...\n    }\n\n    // Stream is closed\n    @Override\n    public void onClosed(WebsocketCloseObject closeObject) {\n        //...\n    }\n\n    // Something went wrong\n    @Override\n    public void onFailure(ApiException apiException) {\n        //...\n    }\n}\n\n")),(0,i.kt)("p",null,"Let's instantiate and run a service."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},'//we will use the previous strategy\nWatchService service = new WatchService(strategy, myStrategyCallback);\nservice.watch("BTCBUSD", CandlestickInterval.FIVE_MINUTE);\n')),(0,i.kt)("p",null,"When done, stop the service:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"service.unwatch();\n")))}v.isMDXComponent=!0}}]);