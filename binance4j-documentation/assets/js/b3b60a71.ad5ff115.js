"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[8206],{6028:(e,t,a)=>{a.d(t,{ZP:()=>k});var n=a(814),l=a(5162),i=a(5488),o=a(7294);const s=e=>e.client+" client = new "+e.client+"("+e.constructorParams.join(", ")+");\n\n",r=e=>e.requestType?e.requestType+" request = new "+e.requestType+"("+(e.requestParameters?e.requestParameters.join(", "):"")+");\n\n":"";function c(e){const t=e.responseType?e.responseType+" response = ":"";return o.createElement(n.Z,{language:"java"},""+s(e)+r(e)+"try{\n    "+t+"client."+e.method+"("+(e.requestType?"request":"")+").execute();\n}catch(ApiException e){ \n//...\n}\n")}function d(e){return o.createElement(n.Z,{language:"java"},""+s(e)+r(e)+"client."+e.method+"("+(e.requestType?"request":"")+").then(response->{\n  //...\n});\n")}function m(e){const t=e.responseType?e.responseType+" response":"";return o.createElement(n.Z,{language:"java"},""+s(e)+r(e)+"client."+e.method+"().then(new ApiCallback<"+(e.responseType?e.responseType:"Void")+">() {\n    @Override\n    public void onResponse("+t+") {\n        //...\n    }\n\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n});\n")}function k(e){return o.createElement(o.Fragment,null,o.createElement(i.Z,null,o.createElement(l.Z,{label:"Sync",value:"sync",default:!0},o.createElement(c,e)),o.createElement(l.Z,{label:"Async (lambda)",value:"async-lambda"},o.createElement(d,e)),o.createElement(l.Z,{label:"Async (ApiCallback)",value:"async-api-callback"},o.createElement(m,e))))}},9098:(e,t,a)=>{a.d(t,{Z:()=>c});var n=a(7294),l=a(3738);function i(){return n.createElement("a",{href:"https://opensource.org/licenses/MIT"},n.createElement("img",{src:"https://img.shields.io/badge/License-MIT-yellow.svg",alt:"License: MIT"}))}function o(e){let{artifact:t}=e;return n.createElement("a",{href:"https://search.maven.org/search?q=com.binance4j.binance4j-"+t,target:"_blank"},n.createElement("img",{alt:"Maven Central",src:"https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-"+t+"/badge.svg"}))}function s(){return n.createElement("img",{src:"https://upload.wikimedia.org/wikipedia/commons/7/75/Blue_JDK_1.8%2B_Shield_Badge.svg"})}function r(e){let{artifact:t}=e;return n.createElement("a",{href:"https://s01.oss.sonatype.org/#nexus-search;quick~com.binance4j."+t},n.createElement("img",{alt:"Sonatype Nexus",src:"https://img.shields.io/nexus/r/com.binance4j/binance4j-"+t+"?server=https%3A%2F%2Fs01.oss.sonatype.org%2F"}))}function c(e){return n.createElement(n.Fragment,null,n.createElement(l.Z,{artifact:e.artifact,javadoc:"index.html",version:e.version}),"\xa0",n.createElement(o,{artifact:e.artifact}),"\xa0",n.createElement(r,{artifact:e.artifact}),"\xa0",n.createElement(s,null),"\xa0",n.createElement(i,null))}},1424:(e,t,a)=>{a.d(t,{Z:()=>c});var n=a(7294),l=a(4645);function i(e){let{path:t}=e;return n.createElement(l.Z,{label:"endpoint",message:t,color:"blueviolet"})}var o=a(3738);function s(e){let{weight:t}=e;return n.createElement(l.Z,{label:"weight",message:t,color:"blue"})}function r(e){let{signature:t}=e;return n.createElement(l.Z,{label:"signature",message:t,color:"red"})}function c(e){return n.createElement(n.Fragment,null,n.createElement(i,{path:e.path}),"\xa0",n.createElement(s,{weight:e.weight}),"\xa0",n.createElement(r,{signature:e.signature}),"\xa0",n.createElement(o.Z,{label:e.label,artifact:e.artifact,javadoc:e.javadoc,version:e.version}))}},9621:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>B,contentTitle:()=>T,default:()=>w,frontMatter:()=>v,metadata:()=>g,toc:()=>C});var n=a(7462),l=(a(7294),a(3905)),i=a(814),o=a(5162),s=a(5488),r=a(5884),c=a(9098),d=a(3738),m=a(1424),k=a(509);const p={toc:[]};function u(e){let{components:t,...a}=e;return(0,l.kt)("wrapper",(0,n.Z)({},p,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(m.Z,{artifact:"websocket",javadoc:"com/binance4j/websocket/"+a.javadoc,version:k.i,weight:a.weight,signature:a.signature,path:a.path,label:a.label,mdxType:"Badge"}))}u.isMDXComponent=!0;const b={toc:[]};function h(e){let{components:t,...a}=e;return(0,l.kt)("wrapper",(0,n.Z)({},b,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(d.Z,{artifact:"websocket",javadoc:"com/binance4j/websocket/"+a.javadoc,version:k.i,label:a.label,mdxType:"JavadocBadge"}))}h.isMDXComponent=!0;var y=a(6028);const v={title:"Websocket"},T=void 0,g={unversionedId:"Websocket",id:"version-1.x/Websocket",title:"Websocket",description:"Description",source:"@site/versioned_docs/version-1.x/09-Websocket.mdx",sourceDirName:".",slug:"/Websocket",permalink:"/binance4j/binance4j-documentation/docs/1.x/Websocket",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-1.x/09-Websocket.mdx",tags:[],version:"1.x",sidebarPosition:9,frontMatter:{title:"Websocket"},sidebar:"tutorialSidebar",previous:{title:"Vision",permalink:"/binance4j/binance4j-documentation/docs/1.x/Vision"},next:{title:"Strategy",permalink:"/binance4j/binance4j-documentation/docs/1.x/Strategy"}},B={},C=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Dependencies",id:"dependencies",level:2},{value:"How does it work?",id:"how-does-it-work",level:2},{value:"Event handlers",id:"event-handlers",level:3},{value:"Open/Close the stream",id:"openclose-the-stream",level:3},{value:"Stream lifespan",id:"stream-lifespan",level:3},{value:"Ping the server",id:"ping-the-server",level:4},{value:"Ping the server back",id:"ping-the-server-back",level:4},{value:"Reconnect after a disconnection",id:"reconnect-after-a-disconnection",level:4},{value:"Reconnect after a connection failure",id:"reconnect-after-a-connection-failure",level:4},{value:"Reconnect after no response for some time",id:"reconnect-after-no-response-for-some-time",level:4},{value:"Available Websocket clients",id:"available-websocket-clients",level:2},{value:"Individual Symbol Ticker Streams",id:"individual-symbol-ticker-streams",level:3},{value:"Individual Symbol Mini Ticker Stream",id:"individual-symbol-mini-ticker-stream",level:3},{value:"All Market Tickers Stream",id:"all-market-tickers-stream",level:3},{value:"All Market Mini Tickers Stream",id:"all-market-mini-tickers-stream",level:3},{value:"Individual Symbol Book Ticker Streams",id:"individual-symbol-book-ticker-streams",level:3},{value:"All Book Tickers Stream",id:"all-book-tickers-stream",level:3},{value:"Kline/Candlestick Streams",id:"klinecandlestick-streams",level:3},{value:"Diff. Depth Stream",id:"diff-depth-stream",level:3},{value:"Partial Book Depth Streams",id:"partial-book-depth-streams",level:3},{value:"Trade Streams",id:"trade-streams",level:3},{value:"Aggregate Trade Streams",id:"aggregate-trade-streams",level:3},{value:"User Data Streams",id:"user-data-streams",level:3},{value:"Keep the User data Stream open",id:"keep-the-user-data-stream-open",level:3},{value:"User data endpoints",id:"user-data-endpoints",level:2},{value:"Start user data stream",id:"start-user-data-stream",level:3},{value:"Keep alive user data stream",id:"keep-alive-user-data-stream",level:3},{value:"Close out a user data stream",id:"close-out-a-user-data-stream",level:3}],f={toc:C};function w(e){let{components:t,...a}=e;return(0,l.kt)("wrapper",(0,n.Z)({},f,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(c.Z,{artifact:"websocket",version:k.i,mdxType:"RepoBadges"}),(0,l.kt)("h2",{id:"description"},"Description"),(0,l.kt)("p",null,"Binance4j-websocket is a set of Java connectors for the Binance Websocket API."),(0,l.kt)("h2",{id:"installation"},"Installation"),(0,l.kt)(r.Z,{repo:"websocket",version:k.i,mdxType:"InstallationInstructions"}),(0,l.kt)("h2",{id:"dependencies"},"Dependencies"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"Core"},"binance4j-core")," : The core of every binance4j artifact"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://projectlombok.org/"},"Lombok")," : Prevent boilerplate code."),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://square.github.io/okhttp/"},"OkHttp")," : HTTP && Websocket clients"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://square.github.io/retrofit/"},"Retrofit")," : Map API endpoints with annotations."),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://github.com/FasterXML/jackson"},"Jackson")," : Payload deserialization"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://commons.apache.org/proper/commons-codec/"},"Apache Common Codecs")," : Encode/decode urls"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://reactivex.io/intro.html"},"RxJava")," : asynchronous and event-based programs by using observable sequences.")),(0,l.kt)("h2",{id:"how-does-it-work"},"How does it work?"),(0,l.kt)(d.Z,{artifact:"websocket",javadoc:"com/binance4j/websocket/client/WebsocketClient.html",version:k.i,mdxType:"JavadocBadge"}),(0,l.kt)("p",null,"The goal of a websocket client is to receive real time data from the Binance API through a persistent, bi-directional stream.\nThis can be market or user/balance data. Every client share the same methods as they inherit from the ",(0,l.kt)("inlineCode",{parentName:"p"},"WebsocketClient")," class."),(0,l.kt)("h3",{id:"event-handlers"},"Event handlers"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"//The connection with the server is opened.\nclient.onOpen(response -> {\n    // ...\n});\n\n//The connection with the server is closing.\nclient.onClosing(cb -> {\n    // ...\n});\n\n//The connection with the server is closed.\nclient.onClosed(cb -> {\n    // ...\n});\n\n//Connection failed, deserialization failed, the server has not sent data for a long time (timeout)\nclient.onFailure(cb -> {\n    // ...\n});\n\n//The server pushed data\nclient.onMessage(cb -> {\n    // ...\n});\n")),(0,l.kt)("h3",{id:"openclose-the-stream"},"Open/Close the stream"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"//When the connection will open, the `onOpen` handler will be called.\nclient.open();\n\n//Before closing, the `onClosing` handler will be called, then `onClosed` once the connection is closed.\nclient.close();\n")),(0,l.kt)("h3",{id:"stream-lifespan"},"Stream lifespan"),(0,l.kt)("p",null,"From Binance documentation:"),(0,l.kt)("blockquote",null,(0,l.kt)("p",{parentName:"blockquote"},"A single connection to stream.binance.com is only valid for 24 hours; expect to be disconnected at the 24 hour mark.")),(0,l.kt)("blockquote",null,(0,l.kt)("p",{parentName:"blockquote"},"The websocket server will send a ping frame every 3 minutes.\nIf the websocket server does not receive a pong frame back from the connection within a 10 minute period, the connection will be disconnected.\nUnsolicited pong frames are allowed.")),(0,l.kt)("h4",{id:"ping-the-server"},"Ping the server"),(0,l.kt)("p",null,"Websocket clients automatically ping the server every 3 minutes. You don't need to do anything! But if you want to change that interval, just call:"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"client.setPingInterval(java.time.Duration)\n")),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"The stream must be closed or this won't work. If you need to change this interval, close and reopen the stream.")),(0,l.kt)("h4",{id:"ping-the-server-back"},"Ping the server back"),(0,l.kt)("p",null,"Again, websocket clients automatically pings back. You don't need to do anything!"),(0,l.kt)("h4",{id:"reconnect-after-a-disconnection"},"Reconnect after a disconnection"),(0,l.kt)("p",null,"Every websocket client is by default configured to automatically reconnect if the stream is closed by the server. If you don't like this behaviour, just call:"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"client.setKeepAlive(false);\n")),(0,l.kt)("p",null,"Next time the client is disconnected, it won't try to reconnect."),(0,l.kt)("h4",{id:"reconnect-after-a-connection-failure"},"Reconnect after a connection failure"),(0,l.kt)("p",null,"Every websocket client is by default configured to automatically reconnect after a connection failure. If you don't like this behaviour, just call:"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"client.retryOnConnectionFailure(false);\n")),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"The stream must be closed or this won't work. If you need to change this interval, close and reopen the stream.")),(0,l.kt)("h4",{id:"reconnect-after-no-response-for-some-time"},"Reconnect after no response for some time"),(0,l.kt)("p",null,"It can happen that after some time, the server stops sending data to the client. Every websocket client is by default configured to automatically disconnect and reconnect after a not receiving data for some time (3 minutes by default). To change this interval call:"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"client.setNoResponseTimeout(time.Duration);\n")),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"The stream must be closed or this won't work. If you need to change this interval, close and reopen the stream.")),(0,l.kt)("p",null,"Since Binance recommends a 30 minutes interval, i wouldn't recommend to change this value."),(0,l.kt)("h2",{id:"available-websocket-clients"},"Available Websocket clients"),(0,l.kt)("h3",{id:"individual-symbol-ticker-streams"},"Individual Symbol Ticker Streams"),(0,l.kt)(h,{label:"WebsocketTickerClient",javadoc:"client/WebsocketTickerClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"TickerPayload",javadoc:"payload/TickerPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"Handles 24hr rolling window ticker statistics for a single symbol."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTickerClient client = new WebsocketTickerClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTickerClient client = new WebsocketTickerClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTickerClient client = new WebsocketTickerClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,l.kt)("h3",{id:"individual-symbol-mini-ticker-stream"},"Individual Symbol Mini Ticker Stream"),(0,l.kt)(h,{label:"WebsocketMiniTickerClient",javadoc:"client/WebsocketMiniTickerClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"MiniTickerPayload",javadoc:"payload/MiniTickerPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"24hr rolling window mini-ticker statistics."),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniTickerClient client = new WebsocketMiniTickerClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniTickerClient client = new WebsocketMiniTickerClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniTickerClient client = new WebsocketMiniTickerClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("h3",{id:"all-market-tickers-stream"},"All Market Tickers Stream"),(0,l.kt)(h,{label:"WebsocketAllMiniTickersClient",javadoc:"client/WebsocketAllMiniTickersClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"TickerPayload",javadoc:"payload/TickerPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"24hr rolling window ticker statistics for all symbols that changed."),(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},"WebsocketAllTickersClient client = new WebsocketAllTickersClient();"),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,l.kt)("h3",{id:"all-market-mini-tickers-stream"},"All Market Mini Tickers Stream"),(0,l.kt)(h,{label:"WebsocketAllMiniTickersClient",javadoc:"client/WebsocketAllMiniTickersClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"MiniTickerPayload",javadoc:"payload/MiniTickerPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"24hr rolling window mini-ticker statistics for all symbols that changed."),(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},"WebsocketAllMiniTickersClient client = new WebsocketAllMiniTickersClient();"),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"These are NOT the statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.")),(0,l.kt)("h3",{id:"individual-symbol-book-ticker-streams"},"Individual Symbol Book Ticker Streams"),(0,l.kt)(h,{label:"WebsocketBookTickerClient",javadoc:"client/WebsocketBookTickerClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"BookTickerPayload",javadoc:"payload/BookTickerPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"Pushes any update to the best bid or ask's price or quantity in real-time for a specified symbol."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketBookTickerClient client = new WebsocketBookTickerClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketBookTickerClient client = new WebsocketBookTickerClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketBookTickerClient client = new WebsocketBookTickerClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("h3",{id:"all-book-tickers-stream"},"All Book Tickers Stream"),(0,l.kt)(h,{label:"WebsocketAllBookTickersClient",javadoc:"client/WebsocketAllBookTickersClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"BookTickerPayload",javadoc:"payload/BookTickerPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"Pushes any update to the best bid or ask's price or quantity in real-time for all symbols."),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"WebsocketAllBookTickersClient client = new WebsocketAllBookTickersClient();\n")),(0,l.kt)("h3",{id:"klinecandlestick-streams"},"Kline/Candlestick Streams"),(0,l.kt)(h,{label:"WebsocketCandlestickClient",javadoc:"client/WebsocketCandlestickClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"CandlestickBarPayload",javadoc:"payload/CandlestickBarPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"The Kline/Candlestick Stream push updates to the current klines/candlestick every second."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketCandlestickClient client = new WebsocketCandlestickClient("BNBBTC", CandlestickInterval.FIVE_MINUTE);')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketCandlestickClient client = new WebsocketCandlestickClient("BNBBTC, BNBBUSD", CandlestickInterval.FIVE_MINUTE);')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketCandlestickClient client = new WebsocketCandlestickClient(List.of("BNBBTC", "BNBBUSD", CandlestickInterval.FIVE_MINUTE));'))),(0,l.kt)("h3",{id:"diff-depth-stream"},"Diff. Depth Stream"),(0,l.kt)(h,{label:"WebsocketDepthClient",javadoc:"client/WebsocketDepthClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"DepthPayload",javadoc:"payload/DepthPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"Order book price and quantity depth updates used to locally manage an order book."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketDepthClient client = new WebsocketDepthClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketDepthClient client = new WebsocketDepthClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketDepthClient client = new WebsocketDepthClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("h3",{id:"partial-book-depth-streams"},"Partial Book Depth Streams"),(0,l.kt)(h,{label:"WebsocketMiniDepthClient",javadoc:"client/WebsocketMiniDepthClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"MiniDepthPayload",javadoc:"payload/MiniDepthPayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"Top bids and asks, Valid are 5, 10, or 20."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniDepthClient client = new WebsocketMiniDepthClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniDepthClient client = new WebsocketMiniDepthClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketMiniDepthClient client = new WebsocketMiniDepthClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("h3",{id:"trade-streams"},"Trade Streams"),(0,l.kt)(h,{label:"WebsocketTradeClient",javadoc:"client/WebsocketTradeClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"TradePayload",javadoc:"payload/TradePayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"The Trade Streams push raw trade information; each trade has a unique buyer and seller."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTradeClient client = new WebsocketTradeClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTradeClient client = new WebsocketTradeClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketTradeClient client = new WebsocketTradeClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("h3",{id:"aggregate-trade-streams"},"Aggregate Trade Streams"),(0,l.kt)(h,{label:"WebsocketAggTradeClient",javadoc:"client/WebsocketAggTradeClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"AggTradePayload",javadoc:"payload/AggTradePayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"The Aggregate Trade Streams push trade information that is aggregated for a single taker order."),(0,l.kt)(s.Z,{mdxType:"Tabs"},(0,l.kt)(o.Z,{label:"One symbol",value:"one-symbol",default:!0,mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketAggTradeClient client = new WebsocketAggTradeClient("BNBBTC");')),(0,l.kt)(o.Z,{label:"Multiple symbols (String)",value:"multiple-symbols-string",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketAggTradeClient client = new WebsocketAggTradeClient("BNBBTC, BNBBUSD");')),(0,l.kt)(o.Z,{label:"Multiple symbols (List)",value:"multiple-symbols-list",mdxType:"TabItem"},(0,l.kt)(i.Z,{language:"java",mdxType:"CodeBlock"},'WebsocketAggTradeClient client = new WebsocketAggTradeClient(List.of("BNBBTC", "BNBBUSD"));'))),(0,l.kt)("h3",{id:"user-data-streams"},"User Data Streams"),(0,l.kt)(h,{label:"WebsocketUserDataClient",javadoc:"client/WebsocketUserDataClient.html",mdxType:"Badge"}),"\xa0",(0,l.kt)(h,{label:"UserDataUpdatePayload",javadoc:"payload/UserDataUpdatePayload.html",mdxType:"Badge"}),(0,l.kt)("p",null,"The User Data Streams push account, balance and order update infos."),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"// Instantiate a UserDataClient\nUserDataClient userDataClient = new UserDataClient(key,secret);\n\n// instantiate the ws client\nWebsocketUserDataClient client = new WebsocketUserDataClient(userDataClient);\n")),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"Account Update : outboundAccountPosition is sent any time an account balance has changed and contains the assets that were possibly changed by the event that generated the balance change.")),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"Balance Update: Balance Update occurs during the following:"),(0,l.kt)("ul",{parentName:"li"},(0,l.kt)("li",{parentName:"ul"},"Deposits or withdrawals from the account"),(0,l.kt)("li",{parentName:"ul"},"Transfer of funds between accounts (e.g. Spot to Margin)"))),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"Order Update: Orders are updated with the executionReport event. Check the ",(0,l.kt)("a",{parentName:"p",href:"https://binance-docs.github.io/apidocs/spot/en/#public-api-definitions"},"Public API Definitions")," and below for relevant enum definitions. Execution types:"),(0,l.kt)("ul",{parentName:"li"},(0,l.kt)("li",{parentName:"ul"},"NEW - The order has been accepted into the engine."),(0,l.kt)("li",{parentName:"ul"},"CANCELED - The order has been canceled by the user."),(0,l.kt)("li",{parentName:"ul"},"REPLACED (currently unused)"),(0,l.kt)("li",{parentName:"ul"},"REJECTED - The order has been rejected and was not processed. (This is never pushed into the User Data Stream)"),(0,l.kt)("li",{parentName:"ul"},"TRADE - Part of the order or all of the order's quantity has filled."),(0,l.kt)("li",{parentName:"ul"},"EXPIRED - The order was canceled according to the order type's rules (e.g. LIMIT FOK orders with no fill, LIMIT IOC or MARKET orders that partially fill) or by the exchange, (e.g. orders canceled during liquidation, orders canceled during maintenance)")))),(0,l.kt)("h3",{id:"keep-the-user-data-stream-open"},"Keep the User data Stream open"),(0,l.kt)("p",null,"From Binance documentation:"),(0,l.kt)("blockquote",null,(0,l.kt)("p",{parentName:"blockquote"},"The stream will close after 60 minutes unless a keepalive is sent.\nIt's recommended to send a ping about every 30 minutes.")),(0,l.kt)("p",null,"The WebsocketUserDataClient constructor takes a ",(0,l.kt)("inlineCode",{parentName:"p"},"UserDataCLient")," instance as parameter. In this way, it will automatically ask a listen key to the API and extends its lifespan by pinging the server every 30 minutes."),(0,l.kt)("p",null,"The interval can be changed by calling:"),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java"},"client.setKeepAliveInterval(java.time.Duration);\n")),(0,l.kt)("admonition",{type:"caution"},(0,l.kt)("p",{parentName:"admonition"},"The stream must be closed or this won't work. If you need to change this interval, close and reopen the stream.")),(0,l.kt)("p",null,"Since Binance recommends a 30 minutes interval, i wouldn't recommend to change this value."),(0,l.kt)("h2",{id:"user-data-endpoints"},"User data endpoints"),(0,l.kt)("h3",{id:"start-user-data-stream"},"Start user data stream"),(0,l.kt)(u,{label:"startUserDataStream()",version:k.i,artifact:"websocket",javadoc:"client/UserDataClient.html#startUserDataStream()",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"POST /api/v3/userDataStream",mdxType:"Badges"}),(0,l.kt)("p",null,"Returns a listen key to open a user data websocket stream."),(0,l.kt)(y.ZP,{client:"UserDataClient",constructorParams:["key","secret"],method:"startUserDataStream",responseType:"ListenKey",mdxType:"Examples"}),(0,l.kt)("admonition",{type:"note"},(0,l.kt)("p",{parentName:"admonition"},"The stream will close after 60 minutes unless a keepalive is sent."),(0,l.kt)("p",{parentName:"admonition"},"If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.")),(0,l.kt)("h3",{id:"keep-alive-user-data-stream"},"Keep alive user data stream"),(0,l.kt)(u,{label:"keepAliveUserDataStream()",version:k.i,artifact:"websocket",javadoc:"client/UserDataClient.html#keepAliveUserDataStream(java.lang.String)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"PUT /api/v3/userDataStream",mdxType:"Badges"}),(0,l.kt)("p",null,"Keepalive a user data stream to prevent a time out."),(0,l.kt)(y.ZP,{client:"UserDataClient",constructorParams:["key","secret"],method:"keepAliveUserDataStream",requestType:"String",requestParameters:["/** listenKey */"],mdxType:"Examples"}),(0,l.kt)("admonition",{type:"note"},(0,l.kt)("p",{parentName:"admonition"},"User data streams will close after 60 minutes."),(0,l.kt)("p",{parentName:"admonition"},"It's recommended to send a ping about every 30 minutes.")),(0,l.kt)("h3",{id:"close-out-a-user-data-stream"},"Close out a user data stream"),(0,l.kt)(u,{label:"closeUserDataStream()",version:k.i,artifact:"websocket",javadoc:"client/UserDataClient.html#closeUserDataStream(java.lang.String)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"DELETE /api/v3/userDataStream",mdxType:"Badges"}),(0,l.kt)(y.ZP,{client:"UserDataClient",constructorParams:["key","secret"],method:"loseUserDataStream",requestType:"String",requestParameters:["/** listenKey */"],mdxType:"Examples"}))}w.isMDXComponent=!0},509:e=>{e.exports={i:"1.7.5"}}}]);