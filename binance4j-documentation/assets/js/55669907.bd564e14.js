"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[917],{6028:(e,t,r)=>{r.d(t,{ZP:()=>m});var a=r(814),n=r(5162),l=r(5488),o=r(7294);const s=e=>e.client+" client = new "+e.client+"("+e.constructorParams.join(", ")+");\n\n",d=e=>e.requestType?e.requestType+" request = new "+e.requestType+"("+(e.requestParameters?e.requestParameters.join(", "):"")+");\n\n":"";function i(e){const t=e.responseType?e.responseType+" response = ":"";return o.createElement(a.Z,{language:"java"},""+s(e)+d(e)+"try{\n    "+t+"client."+e.method+"("+(e.requestType?"request":"")+").execute();\n}catch(ApiException e){ \n//...\n}\n")}function c(e){return o.createElement(a.Z,{language:"java"},""+s(e)+d(e)+"client."+e.method+"("+(e.requestType?"request":"")+").then(response->{\n  //...\n});\n")}function p(e){const t=e.responseType?e.responseType+" response":"";return o.createElement(a.Z,{language:"java"},""+s(e)+d(e)+"client."+e.method+"().then(new ApiCallback<"+(e.responseType?e.responseType:"Void")+">() {\n    @Override\n    public void onResponse("+t+") {\n        //...\n    }\n\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n});\n")}function m(e){return o.createElement(o.Fragment,null,o.createElement(l.Z,null,o.createElement(n.Z,{label:"Sync",value:"sync",default:!0},o.createElement(i,e)),o.createElement(n.Z,{label:"Async (lambda)",value:"async-lambda"},o.createElement(c,e)),o.createElement(n.Z,{label:"Async (ApiCallback)",value:"async-api-callback"},o.createElement(p,e))))}},1424:(e,t,r)=>{r.d(t,{Z:()=>i});var a=r(7294),n=r(4645);function l(e){let{path:t}=e;return a.createElement(n.Z,{label:"endpoint",message:t,color:"blueviolet"})}var o=r(3738);function s(e){let{weight:t}=e;return a.createElement(n.Z,{label:"weight",message:t,color:"blue"})}function d(e){let{signature:t}=e;return a.createElement(n.Z,{label:"signature",message:t,color:"red"})}function i(e){return a.createElement(a.Fragment,null,a.createElement(l,{path:e.path}),"\xa0",a.createElement(s,{weight:e.weight}),"\xa0",a.createElement(d,{signature:e.signature}),"\xa0",a.createElement(o.Z,{label:e.label,artifact:e.artifact,javadoc:e.javadoc,version:e.version}))}},9527:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>b,contentTitle:()=>h,default:()=>w,frontMatter:()=>g,metadata:()=>v,toc:()=>x});var a=r(7462),n=(r(7294),r(3905)),l=r(5162),o=r(5488),s=r(814),d=r(112),i=r(9098),c=r(6028),p=r(1424),m=r(509);const u={toc:[]};function O(e){let{components:t,...r}=e;return(0,n.kt)("wrapper",(0,a.Z)({},u,r,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(p.Z,{artifact:"spot",javadoc:"com/binance4j/spot/"+r.javadoc,version:m.i,weight:r.weight,signature:r.signature,path:r.path,label:r.label,mdxType:"Badge"}))}O.isMDXComponent=!0;var T=r(3738);const y={toc:[]};function C(e){let{components:t,...r}=e;return(0,n.kt)("wrapper",(0,a.Z)({},y,r,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(T.Z,{artifact:"spot",javadoc:"com/binance4j/spot/"+r.javadoc,version:m.i,label:r.label,mdxType:"JavadocBadge"}))}C.isMDXComponent=!0;var k=r(2194);const g={title:"Spot"},h=void 0,v={unversionedId:"Spot",id:"version-1.x/Spot",title:"Spot",description:"Description",source:"@site/versioned_docs/version-1.x/06-Spot.mdx",sourceDirName:".",slug:"/Spot",permalink:"/binance4j/binance4j-documentation/docs/Spot",draft:!1,editUrl:"https://github.com/binance4j/versioned_docs/version-1.x/06-Spot.mdx",tags:[],version:"1.x",sidebarPosition:6,frontMatter:{title:"Spot"},sidebar:"tutorialSidebar",previous:{title:"Wallet",permalink:"/binance4j/binance4j-documentation/docs/Wallet"},next:{title:"NFT",permalink:"/binance4j/binance4j-documentation/docs/NFT"}},b={},x=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Dependencies",id:"dependencies",level:2},{value:"Send an order",id:"send-an-order",level:2},{value:"NewOrder static methods",id:"neworder-static-methods",level:2},{value:"Test new order",id:"test-new-order",level:2},{value:"Cancel order",id:"cancel-order",level:2},{value:"Cancel all open orders",id:"cancel-all-open-orders",level:2},{value:"Get order status",id:"get-order-status",level:2},{value:"Get open orders",id:"get-open-orders",level:2},{value:"Get all orders",id:"get-all-orders",level:2},{value:"Send an OCO order",id:"send-an-oco-order",level:2},{value:"Cancel an OCO/order list",id:"cancel-an-ocoorder-list",level:2},{value:"Retrieve an OCO order",id:"retrieve-an-oco-order",level:2},{value:"Retrieve all OCO orders",id:"retrieve-all-oco-orders",level:2},{value:"Retrieve open OCO orders",id:"retrieve-open-oco-orders",level:2},{value:"Get SPOT account infos",id:"get-spot-account-infos",level:2},{value:"Get your trades for a symbol",id:"get-your-trades-for-a-symbol",level:2},{value:"Get order count",id:"get-order-count",level:2}],B={toc:x};function w(e){let{components:t,...r}=e;return(0,n.kt)("wrapper",(0,a.Z)({},B,r,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(i.Z,{artifact:"spot",version:m.i,mdxType:"RepoBadges"}),(0,n.kt)("h2",{id:"description"},"Description"),(0,n.kt)("p",null,"Binance4j-spot is a Java connector for the SPOT endpoints of the Binance REST API."),(0,n.kt)("h2",{id:"installation"},"Installation"),(0,n.kt)(d.Z,{repo:"spot",version:m.i,mdxType:"InstallationInstructions"}),(0,n.kt)("h2",{id:"dependencies"},"Dependencies"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"Core"},"binance4j-core")," : The core of every binance4j artifact"),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://projectlombok.org/"},"Lombok")," : Prevent boilerplate code."),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://square.github.io/okhttp/"},"OkHttp")," : HTTP && Websocket clients"),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://square.github.io/retrofit/"},"Retrofit")," : Map API endpoints with annotations."),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://github.com/FasterXML/jackson"},"Jackson")," : Payload deserialization"),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://commons.apache.org/proper/commons-codec/"},"Apache Common Codecs")," : Encode/decode urls")),(0,n.kt)("h2",{id:"send-an-order"},"Send an order"),(0,n.kt)(O,{label:"newOrder()",javadoc:"client/SpotClient.html#newOrder(com.binance4j.spot.order.NewOrder)",weight:"1 (IP) 1 (UID)",signature:"signed (HMAC SHA256)",path:"POST /api/v3/order",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"NewOrder",javadoc:"order/NewOrder.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(C,{label:"NewOrderResponse",javadoc:"order/NewOrderResponse.html",mdxType:"Badge"}),(0,n.kt)("p",null,"Sends a trade order for execution."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"newOrder",responseType:"NewOrderResponse",requestType:"NewOrder",requestParameters:['"BNBBTC"',"OrderType.MARKET","OrderSide.BUY",'new BigDecimal("100")'],mdxType:"Examples"}),(0,n.kt)("p",null,"Here we executed a MARKET order to buy 100 BNB with BTC"),(0,n.kt)("h2",{id:"neworder-static-methods"},"NewOrder static methods"),(0,n.kt)(C,{label:"NewOrder",javadoc:"order/NewOrder.html",mdxType:"Badge"}),(0,n.kt)("p",null,"The NewOrder class offers static methods to generate NewOrder instances."),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"market",label:"MARKET order",mdxType:"TabItem"},(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"buy",label:"Buy order",mdxType:"TabItem"},(0,n.kt)(s.Z,{language:"java",mdxType:"CodeBlock"},'NewOrder newOrder = NewOrder.buyMarket("BNBBTC", new BigDecimal(100));')),(0,n.kt)(l.Z,{value:"sell",label:"Sell order",mdxType:"TabItem"},(0,n.kt)(s.Z,{language:"java",mdxType:"CodeBlock"},'NewOrder newOrder = NewOrder.sellMarket("BNBBTC", new BigDecimal(100));')))),(0,n.kt)(l.Z,{value:"limit",label:"LIMIT order",mdxType:"TabItem"},(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"buy",label:"Buy order",mdxType:"TabItem"},(0,n.kt)(s.Z,{language:"java",mdxType:"CodeBlock"},'NewOrder newOrder = NewOrder.buyLimit("BNBBTC", new BigDecimal(100), new BigDecimal(0.01));')),(0,n.kt)(l.Z,{value:"sell",label:"Sell order",mdxType:"TabItem"},(0,n.kt)(s.Z,{language:"java",mdxType:"CodeBlock"},'NewOrder newOrder = NewOrder.sellLimit("BNBBTC", new BigDecimal(100), new BigDecimal(0.01));')))),(0,n.kt)(l.Z,{value:"quote",label:"QUOTE order",mdxType:"TabItem"},(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"buy",label:"Buy order",mdxType:"TabItem"},(0,n.kt)(s.Z,{language:"java",mdxType:"CodeBlock"},'NewOrder newOrder = NewOrder.buyQuote("BNBBTC", new BigDecimal(100));')),(0,n.kt)(l.Z,{value:"sell",label:"Sell order",mdxType:"TabItem"},(0,n.kt)(s.Z,{language:"java",mdxType:"CodeBlock"},'NewOrder newOrder = NewOrder.sellQuote("BNBBTC", new BigDecimal(100));'))))),(0,n.kt)("h2",{id:"test-new-order"},"Test new order"),(0,n.kt)(O,{label:"newOrderTest()",javadoc:"client/SpotClient.html#newOrderTest(com.binance4j.spot.order.NewOrder)",weight:"1 (IP) 1 (UID)",signature:"signed (HMAC SHA256)",path:"POST /api/v3/order",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"NewOrder",javadoc:"order/NewOrder.html",mdxType:"Badge"}),(0,n.kt)("p",null,"Tests the trade order without executing it. Works like the ",(0,n.kt)("inlineCode",{parentName:"p"},"newOrder")," method."),(0,n.kt)("p",null,"The request returns nothing but will throw an ApiException if it fails."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"newOrderTest",requestType:"NewOrder",requestParameters:['"BNBBTC"',"OrderType.MARKET","OrderSide.BUY",'new BigDecimal("100")'],mdxType:"Examples"}),(0,n.kt)("h2",{id:"cancel-order"},"Cancel order"),(0,n.kt)(O,{label:"cancelOrder()",javadoc:"client/SpotClient.html#cancelOrder(com.binance4j.core.order.cancelorder.CancelOrderRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"DELETE /api/v3/order",mdxType:"Badges"}),"\xa0",(0,n.kt)(k.ZP,{label:"CancelOrderRequest",javadoc:"order/CancelOrderRequest.html",mdxType:"CoreBadge"}),"\xa0",(0,n.kt)(k.ZP,{label:"CancelOrderResponse",javadoc:"order/CancelOrderResponse.html",mdxType:"CoreBadge"}),(0,n.kt)("p",null,"Cancels an active order."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"cancelOrder",requestType:"CancelOrderRequest",responseType:"CancelOrderResponse",requestParameters:['"BNBBTC"',"56935218L"],mdxType:"Examples"}),(0,n.kt)("p",null,"Here we canceled the order on BNB/BTC with the 56935218L id"),(0,n.kt)("h2",{id:"cancel-all-open-orders"},"Cancel all open orders"),(0,n.kt)(O,{label:"cancelOpenOrders()",javadoc:"client/SpotClient.html#cancelOpenOrders(com.binance4j.core.order.cancelorder.CancelOpenOrdersRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"DELETE /api/v3/openOrders",mdxType:"Badges"}),"\xa0",(0,n.kt)(k.ZP,{label:"CancelOpenOrdersRequest",javadoc:"order/CancelOpenOrdersRequest.html",mdxType:"CoreBadge"}),"\xa0",(0,n.kt)(k.ZP,{label:"CancelOrderResponse",javadoc:"order/CancelOrderResponse.html",mdxType:"CoreBadge"}),(0,n.kt)("p",null,"Cancels all active orders on a symbol.\nThis includes OCO orders."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"cancelOpenOrders",requestType:"CancelOpenOrdersRequest",responseType:"List<CancelOrderResponse>",requestParameters:['"BNBBTC"'],mdxType:"Examples"}),(0,n.kt)("p",null,"Here we canceled all open orders on ",(0,n.kt)("inlineCode",{parentName:"p"},"BNB/BTC")),(0,n.kt)("h2",{id:"get-order-status"},"Get order status"),(0,n.kt)(O,{label:"getOrderStatus()",javadoc:"client/SpotClient.html#getOrderStatus(com.binance4j.spot.status.OrderStatusRequest)",weight:"2 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/order",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"OrderStatusRequest",javadoc:"order/OrderStatusRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(k.ZP,{label:"OrderInfo",javadoc:"order/OrderInfo.html",mdxType:"CoreBadge"}),(0,n.kt)("p",null,"Check an order's status."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getOrderStatus",requestType:"OrderStatusRequest",responseType:"OrderInfo",requestParameters:['"BNBBTC"',"65293729L"],mdxType:"Examples"}),(0,n.kt)("p",null,"he we got the status of order on BNB/BTC with id 65293729"),(0,n.kt)("h2",{id:"get-open-orders"},"Get open orders"),(0,n.kt)(O,{label:"getOpenOrders()",javadoc:"client/SpotClient.html#getOpenOrders(com.binance4j.spot.status.OpenOrdersStatusRequest)",weight:"3 (one symbol) 40 (all symbols) (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/openOrders",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"OpenOrdersStatusRequest",javadoc:"order/OpenOrdersStatusRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(k.ZP,{label:"OrderInfo",javadoc:"order/OrderInfo.html",mdxType:"CoreBadge"}),(0,n.kt)("p",null,"Get all open orders on a symbol. Careful when accessing this with no symbol."),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"all",label:"All open orders",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getOpenOrders",responseType:"List<OrderInfo>",mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"one",label:"Specific pair",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getOpenOrders",requestType:"OpenOrdersStatusRequest",responseType:"List<OrderInfo>",requestParameters:['"BNBBTC"'],mdxType:"Examples"}))),(0,n.kt)("h2",{id:"get-all-orders"},"Get all orders"),(0,n.kt)(O,{label:"getAllOrders()",javadoc:"client/SpotClient.html#getAllOrders(com.binance4j.spot.status.AllOrdersRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/allOrders",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"AllOrdersRequest",javadoc:"order/AllOrdersRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(k.ZP,{label:"OrderInfo",javadoc:"order/OrderInfo.html",mdxType:"CoreBadge"}),(0,n.kt)("p",null,"Get all orders on a symbol."),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"last-500",label:"Get last 500 (default)",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAllOrders",requestType:"AllOrdersRequest",responseType:"List<OrderInfo>",requestParameters:['"BNBBTC"'],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"last-1000",label:"Get last 1000 orders (max)",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAllOrders",requestType:"AllOrdersRequest",responseType:"List<OrderInfo>",requestParameters:['"BNBBTC"',1e3],mdxType:"Examples"}))),(0,n.kt)("h2",{id:"send-an-oco-order"},"Send an OCO order"),(0,n.kt)(O,{label:"newOCO()",javadoc:"client/SpotClient.html#newOCO(com.binance4j.core.order.OCOOrder)",weight:"1 (IP) 2 (UID)",signature:"signed (HMAC SHA256)",path:"POST /api/v3/order/oco",mdxType:"Badges"}),"\xa0",(0,n.kt)(k.ZP,{label:"OCOOrder",javadoc:"order/OCOOrder.html",mdxType:"CoreBadge"}),"\xa0",(0,n.kt)(k.ZP,{label:"OCOResponse",javadoc:"order/OCOResponse.html",mdxType:"CoreBadge"}),(0,n.kt)("p",null,"An OCO order is made of two ",(0,n.kt)("inlineCode",{parentName:"p"},"LIMIT")," orders. The first to execute cancels the other."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"newOCO",requestType:"OCOOrder",responseType:"OCOResponse",requestParameters:['"BTCBUSD"',"OrderSide.BUY","new BigDecimal(1)","new BigDecimal(50000)","new BigDecimal(51000)"],mdxType:"Examples"}),(0,n.kt)("p",null,"Here we send an order to buy 1 BTC for 50000 BUSD or 51000 BUSD."),(0,n.kt)("h2",{id:"cancel-an-ocoorder-list"},"Cancel an OCO/order list"),(0,n.kt)(O,{label:"cancelOCO()",javadoc:"client/SpotClient.html#cancelOCO(com.binance4j.spot.oco.CancelOCORequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"DELETE /api/v3/orderList",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"CancelOCORequest",javadoc:"order/CancelOCORequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(k.ZP,{label:"OCOResponse",javadoc:"order/OCOResponse.html",mdxType:"CoreBadge"}),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"all",label:"All OCO",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"cancelOCO",requestType:"CancelOCORequest",responseType:"List<OCOResponse>",requestParameters:['"BNBBTC"'],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"order-list-id",label:"with order list id",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"cancelOCO",requestType:"OCOOrder",responseType:"List<OCOResponse>",requestParameters:['"BNBBTC"',"13789789L"],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"client-id",label:"With client order id",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"cancelOCO",requestType:"OCOOrder",responseType:"List<OCOResponse>",requestParameters:['"BNBBTC"','"C3wyj4WVEktd7u9aVBRXcN"'],mdxType:"Examples"}))),(0,n.kt)("admonition",{type:"note"},(0,n.kt)("p",{parentName:"admonition"},"Canceling an individual leg will cancel the entire OCO."),(0,n.kt)("p",{parentName:"admonition"},"If both ",(0,n.kt)("inlineCode",{parentName:"p"},"orderListId")," and ",(0,n.kt)("inlineCode",{parentName:"p"},"listClientOrderID")," are provided, ",(0,n.kt)("inlineCode",{parentName:"p"},"orderId")," takes precedence.")),(0,n.kt)("h2",{id:"retrieve-an-oco-order"},"Retrieve an OCO order"),(0,n.kt)(O,{label:"queryOCO()",javadoc:"client/SpotClient.html#queryOCO(com.binance4j.spot.oco.OCOInfoRequest)",weight:"2 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/orderList",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"OCOInfoRequest",javadoc:"order/OCOInfoRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(C,{label:"OCOInfo",javadoc:"order/OCOInfo.html",mdxType:"Badge"}),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"client-order-id",label:"With client order id",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"queryOCO",requestType:"OCOInfoRequest",responseType:"OCOInfo",requestParameters:['"C3wyj4WVEktd7u9aVBRXcN"'],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"order-list-id",label:"With order list id",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"queryOCO",requestType:"OCOInfoRequest",responseType:"OCOInfo",requestParameters:["13789789L"],mdxType:"Examples"}))),(0,n.kt)("h2",{id:"retrieve-all-oco-orders"},"Retrieve all OCO orders"),(0,n.kt)(O,{label:"getAllOCO()",javadoc:"client/SpotClient.html#getAllOCO(com.binance4j.spot.oco.AllOCOInfoRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/allOrderList",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"OpenOCORequest",javadoc:"order/OpenOCORequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(C,{label:"OCOInfo",javadoc:"order/OCOInfo.html",mdxType:"Badge"}),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"last-500",label:"last 500 OCO orders (default)",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAllOCO",responseType:"List<OCOInfo>",mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"last-1000",label:"last 1000 (max)",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAllOCO",requestType:"AllOCOInfoRequest",responseType:"List<OCOInfo>",requestParameters:["1000"],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"order-id",label:"With order id",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAllOCO",requestType:"AllOCOInfoRequest",responseType:"List<OCOInfo>",requestParameters:['"13789789L"'],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"order-id-limit",label:"With order id and limit",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAllOCO",requestType:"AllOCOInfoRequest",responseType:"List<OCOInfo>",requestParameters:['"13789789L"',666],mdxType:"Examples"}))),(0,n.kt)("h2",{id:"retrieve-open-oco-orders"},"Retrieve open OCO orders"),(0,n.kt)(O,{label:"getOpenOCO()",javadoc:"client/SpotClient.html#getOpenOCO(com.binance4j.spot.oco.AllOCOInfoRequest)",weight:"3 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/openOrderList",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"OpenOCORequest",javadoc:"order/OpenOCORequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(C,{label:"OCOInfo",javadoc:"order/OCOInfo.html",mdxType:"Badge"}),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getOpenOCO",responseType:"List<OCOInfo>",mdxType:"Examples"}),(0,n.kt)("h2",{id:"get-spot-account-infos"},"Get SPOT account infos"),(0,n.kt)(O,{label:"getAccount()",javadoc:"client/SpotClient.html#getAccount(com.binance4j.spot.account.AccountRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/account",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"AccountRequest",javadoc:"account/AccountRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(C,{label:"Account",javadoc:"account/Account.html",mdxType:"Badge"}),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getAccount",responseType:"Account",mdxType:"Examples"}),(0,n.kt)("h2",{id:"get-your-trades-for-a-symbol"},"Get your trades for a symbol"),(0,n.kt)(O,{label:"getMyTrades()",javadoc:"client/SpotClient.html#getMyTrades(com.binance4j.spot.trade.MyTradesRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/myTrades",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"MyTradesRequest",javadoc:"order/MyTradesRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(k.ZP,{label:"Trade",javadoc:"order/Trade.html",mdxType:"CoreBadge"}),(0,n.kt)(o.Z,{mdxType:"Tabs"},(0,n.kt)(l.Z,{value:"last-500",label:"Get last 500 (default)",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getMyTrades",requestType:"MyTradesRequest",responseType:"List<Trade>",requestParameters:['"BNBBTC"'],mdxType:"Examples"})),(0,n.kt)(l.Z,{value:"last-1000",label:"Get last 1000 orders (max)",mdxType:"TabItem"},(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getMyTrades",requestType:"MyTradesRequest",responseType:"List<Trade>",requestParameters:['"BNBBTC"',1e3],mdxType:"Examples"}))),(0,n.kt)("h2",{id:"get-order-count"},"Get order count"),(0,n.kt)(O,{label:"getOrderCount()",javadoc:"client/SpotClient.html#getOrderCount(com.binance4j.spot.order.OrderCountRequest)",weight:"20 (IP)",signature:"signed (HMAC SHA256)",path:"GET /api/v3/rateLimit/order",mdxType:"Badges"}),"\xa0",(0,n.kt)(C,{label:"OrderCountRequest",javadoc:"order/OrderCountRequest.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(C,{label:"OrderCount",javadoc:"order/OrderCount.html",mdxType:"Badge"}),(0,n.kt)("p",null,"Displays the user's current order count usage for all intervals. May be useful when rate limiting."),(0,n.kt)(c.ZP,{client:"SpotClient",constructorParams:["key","secret"],method:"getOrderCount",responseType:"List<OrderCount>",mdxType:"Examples"}))}w.isMDXComponent=!0},2194:(e,t,r)=>{r.d(t,{ZP:()=>d});var a=r(7462),n=(r(7294),r(3905)),l=r(3738),o=r(509);const s={toc:[]};function d(e){let{components:t,...r}=e;return(0,n.kt)("wrapper",(0,a.Z)({},s,r,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(l.Z,{artifact:"core",javadoc:"com/binance4j/core/"+r.javadoc,version:o.i,label:r.label,mdxType:"JavadocBadge"}))}d.isMDXComponent=!0},509:e=>{e.exports={i:"1.7.5"}}}]);