"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[3246],{4756:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>m,contentTitle:()=>d,default:()=>v,frontMatter:()=>k,metadata:()=>u,toc:()=>p});var l=a(7462),n=(a(7294),a(3905)),i=a(5162),s=a(5488),o=a(814),r=(a(5884),a(9519)),c=a(3389);const k={title:"Websocket streams"},d=void 0,u={unversionedId:"endpoints/websocket",id:"version-2.3.0/endpoints/websocket",title:"Websocket streams",description:"Description",source:"@site/versioned_docs/version-2.3.0/30-endpoints/200-websocket.mdx",sourceDirName:"30-endpoints",slug:"/endpoints/websocket",permalink:"/binance4j/binance4j-documentation/docs/2.3.0/endpoints/websocket",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-2.3.0/30-endpoints/200-websocket.mdx",tags:[],version:"2.3.0",sidebarPosition:200,frontMatter:{title:"Websocket streams"},sidebar:"tutorialSidebar",previous:{title:"Wallet",permalink:"/binance4j/binance4j-documentation/docs/2.3.0/endpoints/wallet"}},m={},p=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Event Callback",id:"event-callback",level:2},{value:"Configuration",id:"configuration",level:2},{value:"Available Websocket clients",id:"available-websocket-clients",level:2},{value:"Individual Symbol Ticker Streams",id:"individual-symbol-ticker-streams",level:3},{value:"24hr rolling window mini-ticker statistics.",id:"24hr-rolling-window-mini-ticker-statistics",level:3},{value:"All Market Tickers Stream",id:"all-market-tickers-stream",level:3},{value:"All Market Mini Tickers Stream",id:"all-market-mini-tickers-stream",level:3},{value:"Individual Symbol Book Ticker Streams",id:"individual-symbol-book-ticker-streams",level:3},{value:"All Book Tickers Stream",id:"all-book-tickers-stream",level:3},{value:"Kline/Candlestick Streams",id:"klinecandlestick-streams",level:3},{value:"Diff. Depth Stream",id:"diff-depth-stream",level:3},{value:"Partial Book Depth Streams",id:"partial-book-depth-streams",level:3},{value:"Trade Streams",id:"trade-streams",level:3},{value:"Aggregate Trade Streams",id:"aggregate-trade-streams",level:3},{value:"User Data Streams",id:"user-data-streams",level:3},{value:"User data endpoints",id:"user-data-endpoints",level:2},{value:"Start user data stream",id:"start-user-data-stream",level:3},{value:"Keep alive user data stream",id:"keep-alive-user-data-stream",level:3},{value:"Close out a user data stream",id:"close-out-a-user-data-stream",level:3}],b=(h="ArtifactInstall",function(e){return console.warn("Component "+h+" was not imported, exported, or provided by MDXProvider as global scope"),(0,n.kt)("div",e)});var h;const T={toc:p};function v(e){let{components:t,...a}=e;return(0,n.kt)("wrapper",(0,l.Z)({},T,a,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(r.ZP,{artifact:"websocket",mdxType:"RepoBadges"}),(0,n.kt)("h2",{id:"description"},"Description"),(0,n.kt)("p",null,"Binance4j-websocket is a set of Java connectors for the Binance Websocket API."),(0,n.kt)("h2",{id:"installation"},"Installation"),(0,n.kt)(b,{repo:"websocket",mdxType:"ArtifactInstall"}),(0,n.kt)("h2",{id:"event-callback"},"Event Callback"),(0,n.kt)("p",null,(0,n.kt)("inlineCode",{parentName:"p"},"WebsocketCallback")," is a generic functional interface every ",(0,n.kt)("inlineCode",{parentName:"p"},"WebsocketClient")," receives at instantiation that will handle the stream events."),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-java"},'WebsocketCallback<Candle> callback =  new WebsocketCallback<>{\n    // Data received from the server\n    @Override\n    public void onMessage(Object response) {\n        //...\n    }\n\n    // Stream is open\n    @Override\n    public void onOpen(Response response) {\n        //...\n    }\n\n    // Stream issue\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n\n    // Stream is closing\n    @Override\n    public void onClosing(WebsocketCloseObject websocketCloseObject) {\n        //...\n    }\n\n    // Stream is closed\n    @Override\n    public void onClosed(WebsocketCloseObject websocketCloseObject) {\n        //...\n    }\n\n};\n\n//Client instantiation\nWebsocketCandlestickClient client = new WebsocketCandlestickClient("BTCBUSD", CandlestickInterval.FIVE_MINUTE, callback);\n//open stream\nclient.open();\n//close stream\nclient.close();\n')),(0,n.kt)("h2",{id:"configuration"},"Configuration"),(0,n.kt)("p",null,"Every ",(0,n.kt)("inlineCode",{parentName:"p"},"WebsocketClient")," possess a ",(0,n.kt)("inlineCode",{parentName:"p"},"WebsocketClientConfiguration")," accessible through:"),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-java"},"client.getConfiguration();\n")),(0,n.kt)("table",null,(0,n.kt)("caption",null,(0,n.kt)("h3",null,"Available parameters")),(0,n.kt)("thead",null,(0,n.kt)("tr",null,(0,n.kt)("th",null,"Parameter"),(0,n.kt)("th",null,"Type"),(0,n.kt)("th",null,"Description"),(0,n.kt)("th",null,"Default"))),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"baseUrl"),(0,n.kt)("th",null,"String"),(0,n.kt)("th",null,"The stream base url"),(0,n.kt)("th",null,"wss://stream.binance.com:9443/ws")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"pingInterval"),(0,n.kt)("th",null,"Duration"),(0,n.kt)("th",null,"The interval the client will send a ping"),(0,n.kt)("th",null,"3m")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"keepAlive"),(0,n.kt)("th",null,"Boolean"),(0,n.kt)("th",null,"Reconnect if stream is closed by server"),(0,n.kt)("th",null,"true")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"maxReconnections"),(0,n.kt)("th",null,"Integer"),(0,n.kt)("th",null,"The number of time the client tries to reconnect"),(0,n.kt)("th",null,"5")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"reconnectionInterval"),(0,n.kt)("th",null,"Duration"),(0,n.kt)("th",null,"The reconnection interval"),(0,n.kt)("th",null,"10s")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"noResponseTimeout"),(0,n.kt)("th",null,"Duration"),(0,n.kt)("th",null,"The time the client waits for a server response before triggering a timeout"),(0,n.kt)("th",null,"3m")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"noResponseTimeoutMarginError"),(0,n.kt)("th",null,"Duration"),(0,n.kt)("th",null,"Margin error added to ",(0,n.kt)("code",null,"WebsocketCandleStickClient")," ",(0,n.kt)("code",null,"noResponseTimeout"),"'s configuration"),(0,n.kt)("th",null,"5s")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"disconnectionTimeout"),(0,n.kt)("th",null,"Duration"),(0,n.kt)("th",null,"Time after which the client disconnects if stuck in closing state"),(0,n.kt)("th",null,"5s")),(0,n.kt)("tr",{class:"fw-400"},(0,n.kt)("th",null,"closeAfter"),(0,n.kt)("th",null,"Duration"),(0,n.kt)("th",null,"Time after which the client will disconnect. If ",(0,n.kt)("code",null,"keepAlive")," is true, will automatically reconnect. Bypasses server unwanted disconnections."),(0,n.kt)("th",null,"1d"))),(0,n.kt)("h2",{id:"available-websocket-clients"},"Available Websocket clients"),(0,n.kt)("h3",{id:"individual-symbol-ticker-streams"},"Individual Symbol Ticker Streams"),(0,n.kt)("p",null,"Handles 24hr rolling window ticker statistics for a single symbol."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTickerClient client = new WebsocketTickerClient("BNBBTC", callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTickerClient client = new WebsocketTickerClient(List.of("BNBBTC", "BNBBUSD"), callback);'))),(0,n.kt)("admonition",{type:"caution"},(0,n.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,n.kt)("h3",{id:"24hr-rolling-window-mini-ticker-statistics"},"24hr rolling window mini-ticker statistics."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniTickerClient client = new WebsocketMiniTickerClient("BNBBTC", callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniTickerClient client = new WebsocketMiniTickerClient(List.of("BNBBTC", "BNBBUSD"), callback);'))),(0,n.kt)("admonition",{type:"caution"},(0,n.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,n.kt)("h3",{id:"all-market-tickers-stream"},"All Market Tickers Stream"),(0,n.kt)("p",null,"24hr rolling window ticker statistics for all symbols that changed."),(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},"WebsocketAllTickersClient client = new WebsocketAllTickersClient(callback);"),(0,n.kt)("admonition",{type:"caution"},(0,n.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,n.kt)("h3",{id:"all-market-mini-tickers-stream"},"All Market Mini Tickers Stream"),(0,n.kt)("p",null,"24hr rolling window mini-ticker statistics for all symbols that changed."),(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},"WebsocketAllMiniTickersClient client = new WebsocketAllMiniTickersClient(callback);"),(0,n.kt)("admonition",{type:"caution"},(0,n.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,n.kt)("h3",{id:"individual-symbol-book-ticker-streams"},"Individual Symbol Book Ticker Streams"),(0,n.kt)("p",null,"Pushes any update to the best bid or ask's price or quantity in real-time for a specified symbol."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketBookTickerClient client = new WebsocketBookTickerClient("BNBBTC", callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketBookTickerClient client = new WebsocketBookTickerClient(List.of("BNBBTC", "BNBBUSD"), callback);'))),(0,n.kt)("h3",{id:"all-book-tickers-stream"},"All Book Tickers Stream"),(0,n.kt)("p",null,"Pushes any update to the best bid or ask's price or quantity in real-time for all symbols."),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-java"},"WebsocketAllBookTickersClient client = new WebsocketAllBookTickersClient(callback);\n")),(0,n.kt)("h3",{id:"klinecandlestick-streams"},"Kline/Candlestick Streams"),(0,n.kt)("p",null,"The Kline/Candlestick Stream push updates to the current klines/candlestick every second."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketCandlestickClient client = new WebsocketCandlestickClient("BNBBTC", CandlestickInterval.FIVE_MINUTE, callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketCandlestickClient client = new WebsocketCandlestickClient(List.of("BNBBTC", "BNBBUSD", CandlestickInterval.FIVE_MINUTE), callback);'))),(0,n.kt)("h3",{id:"diff-depth-stream"},"Diff. Depth Stream"),(0,n.kt)("p",null,"Order book price and quantity depth updates used to locally manage an order book."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketDepthClient client = new WebsocketDepthClient("BNBBTC", DepthUpdateSpeed.MS_1000, callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketDepthClient client = new WebsocketDepthClient(List.of("BNBBTC", "BNBBUSD"), DepthUpdateSpeed.MS_1000, callback);'))),(0,n.kt)("h3",{id:"partial-book-depth-streams"},"Partial Book Depth Streams"),(0,n.kt)("p",null,"Top bids and asks."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniDepthClient client = new WebsocketMiniDepthClient("BNBBTC", DepthLevel.LEVEL_5, DepthUpdateSpeed.MS_1000, callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniDepthClient client = new WebsocketMiniDepthClient(List.of("BNBBTC", "BNBBUSD"), DepthLevel.LEVEL_5, DepthUpdateSpeed.MS_1000, callback);'))),(0,n.kt)("h3",{id:"trade-streams"},"Trade Streams"),(0,n.kt)("p",null,"The Trade Streams push raw trade information; each trade has a unique buyer and seller."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTradeClient client = new WebsocketTradeClient("BNBBTC", callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTradeClient client = new WebsocketTradeClient(List.of("BNBBTC", "BNBBUSD"), callback);'))),(0,n.kt)("h3",{id:"aggregate-trade-streams"},"Aggregate Trade Streams"),(0,n.kt)("p",null,"The Aggregate Trade Streams push trade information that is aggregated for a single taker order."),(0,n.kt)(s.Z,{mdxType:"Tabs"},(0,n.kt)(i.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketAggTradeClient client = new WebsocketAggTradeClient("BNBBTC", callback);')),(0,n.kt)(i.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,n.kt)(o.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketAggTradeClient client = new WebsocketAggTradeClient(List.of("BNBBTC", "BNBBUSD"), callback);'))),(0,n.kt)("h3",{id:"user-data-streams"},"User Data Streams"),(0,n.kt)("p",null,"The User Data Streams push account, balance and order update infos."),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-java"},"// Instantiate a UserDataClient\nUserDataClient userDataClient = new UserDataClient(key,secret);\n\n// instantiate the ws client\nWebsocketUserDataClient client = new WebsocketUserDataClient(userDataClient, callback);\n")),(0,n.kt)("admonition",{type:"note"},(0,n.kt)("p",{parentName:"admonition"},"The client will automatically keep alive the listen key every 30 minutes as advised by Binance.")),(0,n.kt)("p",null,"The client handles thoses events:"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("p",{parentName:"li"},"Account Update : outboundAccountPosition is sent any time an account balance has changed and contains the assets that were possibly changed by the event that generated the balance change.")),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("p",{parentName:"li"},"Balance Update: Balance Update occurs during the following:"),(0,n.kt)("ul",{parentName:"li"},(0,n.kt)("li",{parentName:"ul"},"Deposits or withdrawals from the account"),(0,n.kt)("li",{parentName:"ul"},"Transfer of funds between accounts (e.g. Spot to Margin)"))),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("p",{parentName:"li"},"Order Update: Orders are updated with the executionReport event. Check the ",(0,n.kt)("a",{parentName:"p",href:"https://binance-docs.github.io/apidocs/spot/en/#public-api-definitions"},"Public API Definitions")," and below for relevant enum definitions. Execution types:"),(0,n.kt)("ul",{parentName:"li"},(0,n.kt)("li",{parentName:"ul"},"NEW - The order has been accepted into the engine."),(0,n.kt)("li",{parentName:"ul"},"CANCELED - The order has been canceled by the user."),(0,n.kt)("li",{parentName:"ul"},"REPLACED (currently unused)"),(0,n.kt)("li",{parentName:"ul"},"REJECTED - The order has been rejected and was not processed. (This is never pushed into the User Data Stream)"),(0,n.kt)("li",{parentName:"ul"},"TRADE - Part of the order or all of the order's quantity has filled."),(0,n.kt)("li",{parentName:"ul"},"EXPIRED - The order was canceled according to the order type's rules (e.g. LIMIT FOK orders with no fill, LIMIT IOC or MARKET orders that partially fill) or by the exchange, (e.g. orders canceled during liquidation, orders canceled during maintenance)")))),(0,n.kt)("h2",{id:"user-data-endpoints"},"User data endpoints"),(0,n.kt)("h3",{id:"start-user-data-stream"},"Start user data stream"),(0,n.kt)("p",null,"Returns a listen key to open a user data websocket stream."),(0,n.kt)(c.ZP,{payload:"ListenKey",method:"startUserDataStream",items:[{}],mdxType:"Examples"}),(0,n.kt)("admonition",{type:"note"},(0,n.kt)("p",{parentName:"admonition"},"The stream will close after 60 minutes unless a keepalive is sent."),(0,n.kt)("p",{parentName:"admonition"},"If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes."),(0,n.kt)("p",{parentName:"admonition"},"If you're using ",(0,n.kt)("inlineCode",{parentName:"p"},"WebsocketUserDataClient"),", this is done automatically.")),(0,n.kt)("h3",{id:"keep-alive-user-data-stream"},"Keep alive user data stream"),(0,n.kt)("p",null,"Keepalive a user data stream to prevent a time out."),(0,n.kt)(c.ZP,{payload:"Void",method:"keepAliveUserDataStream",items:[{params:"listenKey"}],mdxType:"Examples"}),(0,n.kt)("admonition",{type:"note"},(0,n.kt)("p",{parentName:"admonition"},"User data streams will close after 60 minutes."),(0,n.kt)("p",{parentName:"admonition"},"It's recommended to send a ping about every 30 minutes."),(0,n.kt)("p",{parentName:"admonition"},"If you're using ",(0,n.kt)("inlineCode",{parentName:"p"},"WebsocketUserDataClient"),", this is done automatically.")),(0,n.kt)("h3",{id:"close-out-a-user-data-stream"},"Close out a user data stream"),(0,n.kt)(c.ZP,{payload:"Void",method:"closeUserDataStream",items:[{params:"listenKey"}],mdxType:"Examples"}))}v.isMDXComponent=!0},9519:(e,t,a)=>{a.d(t,{ZP:()=>r});var l=a(7462),n=(a(7294),a(3905)),i=a(8267),s=a(7691);const o={toc:[]};function r(e){let{components:t,...a}=e;return(0,n.kt)("wrapper",(0,l.Z)({},o,a,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(i.Z,{artifact:a.artifact,version:s.i,mdxType:"RepoBadges"}))}r.isMDXComponent=!0},7691:e=>{e.exports={i:"2.3.0"}}}]);