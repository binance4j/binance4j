"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[6233],{1553:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>p,contentTitle:()=>d,default:()=>y,frontMatter:()=>i,metadata:()=>m,toc:()=>c});var n=a(7462),r=(a(7294),a(3905)),s=a(2328),o=a(9497),l=a(3389);const i={title:"Spot endpoints"},d=void 0,m={unversionedId:"spot",id:"version-2.x/spot",title:"Spot endpoints",description:"Installation",source:"@site/versioned_docs/version-2.x/150-spot.mdx",sourceDirName:".",slug:"/spot",permalink:"/binance4j/binance4j-documentation/docs/spot",draft:!1,editUrl:"https://github.com/binance4j/versioned_docs/version-2.x/150-spot.mdx",tags:[],version:"2.x",sidebarPosition:150,frontMatter:{title:"Spot endpoints"},sidebar:"tutorialSidebar",previous:{title:"Savings endpoint",permalink:"/binance4j/binance4j-documentation/docs/savings"},next:{title:"Staking endpoints",permalink:"/binance4j/binance4j-documentation/docs/staking"}},p={},c=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Testnet client instantiation",id:"testnet-client-instantiation",level:2},{value:"Validate a new order without sending it into the matching engine",id:"validate-a-new-order-without-sending-it-into-the-matching-engine",level:3},{value:"Send in a new order",id:"send-in-a-new-order",level:3},{value:"Get open orders",id:"get-open-orders",level:3},{value:"Cancel open orders",id:"cancel-open-orders",level:3},{value:"Check an order&#39;s status",id:"check-an-orders-status",level:3},{value:"Cancel an active order",id:"cancel-an-active-order",level:3},{value:"Displays the user&#39;s current order count usage for all intervals with default request",id:"displays-the-users-current-order-count-usage-for-all-intervals-with-default-request",level:3},{value:"Get current account information",id:"get-current-account-information",level:3},{value:"Get all orders on a symbol",id:"get-all-orders-on-a-symbol",level:3},{value:"Get trades for a specific account and symbol.",id:"get-trades-for-a-specific-account-and-symbol",level:3},{value:"Send in an OCO order",id:"send-in-an-oco-order",level:3},{value:"Cancel an entire order list",id:"cancel-an-entire-order-list",level:3},{value:"Retrieves all OCO",id:"retrieves-all-oco",level:3}],u={toc:c};function y(e){let{components:t,...a}=e;return(0,r.kt)("wrapper",(0,n.Z)({},u,a,{components:t,mdxType:"MDXLayout"}),(0,r.kt)(o.ZP,{artifact:"spot",mdxType:"RepoBadges"}),(0,r.kt)("h2",{id:"installation"},"Installation"),(0,r.kt)(s.ZP,{repo:"spot",mdxType:"ArtifactInstall"}),(0,r.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-java"},"SpotClient client = new SpotClient(key, secret);\n")),(0,r.kt)("h2",{id:"testnet-client-instantiation"},"Testnet client instantiation"),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-java"},"TestnetSpotClient client = new TestnetSpotClient(testnetKey, testnetSecret);\n")),(0,r.kt)("p",null,"##Examples"),(0,r.kt)("h3",{id:"validate-a-new-order-without-sending-it-into-the-matching-engine"},"Validate a new order without sending it into the matching engine"),(0,r.kt)(l.ZP,{payload:"Void",method:"newOrderTest",items:[{params:"NewOrderParams.buy(symbol, amount)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"send-in-a-new-order"},"Send in a new order"),(0,r.kt)(l.ZP,{payload:"NewOrderResponse",method:"newOrder",items:[{label:"Market purchase",params:"NewOrderParams.buy(symbol, amount)"},{label:"Market sale",params:"NewOrderParams.sell(symbol, amount)"},{label:"Limit purchase",params:"NewOrderParams.buy(symbol, amount, price)"},{label:"Limit sale",params:"NewOrderParams.sell(symbol, amount, price)"},{label:"Market purchase with quote asset",params:"NewOrderParams.buyQuote(symbol, amount)"},{label:"Market sale with quote asset",params:"NewOrderParams.sellQuote(symbol, amount)"}],mdxType:"Examples"}),(0,r.kt)("admonition",{type:"note"},(0,r.kt)("p",{parentName:"admonition"},(0,r.kt)("inlineCode",{parentName:"p"},"buyQuote")," and ",(0,r.kt)("inlineCode",{parentName:"p"},"sellQuote")," let you buy the base asset by providing the quote asset amount.")),(0,r.kt)("h3",{id:"get-open-orders"},"Get open orders"),(0,r.kt)(l.ZP,{payload:"List<OrderInfo>",method:"getOpenOrders",items:[{}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"cancel-open-orders"},"Cancel open orders"),(0,r.kt)(l.ZP,{payload:"List<CancelOrderResponse>",method:"cancelOpenOrders",items:[{params:"new CancelOpenOrdersParams(symbol)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"check-an-orders-status"},"Check an order's status"),(0,r.kt)(l.ZP,{payload:"OrderInfo",method:"getOrderStatus",items:[{params:"new OrderStatusParams(symbol, orderId)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"cancel-an-active-order"},"Cancel an active order"),(0,r.kt)(l.ZP,{payload:"CancelOrderResponse",method:"cancelOrder",items:[{params:"new CancelOrderParams(symbol, orderId)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"displays-the-users-current-order-count-usage-for-all-intervals-with-default-request"},"Displays the user's current order count usage for all intervals with default request"),(0,r.kt)(l.ZP,{payload:"List<OrderCount>",method:"getOrderCount",items:[{}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"get-current-account-information"},"Get current account information"),(0,r.kt)(l.ZP,{payload:"Account",method:"getAccount",items:[{}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"get-all-orders-on-a-symbol"},"Get all orders on a symbol"),(0,r.kt)(l.ZP,{payload:"List<OrderInfo>",method:"getAllOrders",items:[{label:"By symbol",params:"new AllOrdersParams(symbol)"},{label:"By symbol and order id",params:"new AllOrdersParams(symbol, orderId)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"get-trades-for-a-specific-account-and-symbol"},"Get trades for a specific account and symbol."),(0,r.kt)(l.ZP,{payload:"List<Trade>",method:"getTrades",items:[{label:"From id",params:"new TradesParams(fromId, symbol)"},{label:"By symbol and order id",params:"new TradesParams(symbol, orderId)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"send-in-an-oco-order"},"Send in an OCO order"),(0,r.kt)(l.ZP,{payload:"OCOResponse",method:"newOCO",items:[{label:"Stop loss limit order",params:"NewOCOOrderParams(symbol, side, quantity, price, stopPrice, stopLimitPrice, stopLimitTimeInForce)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"cancel-an-entire-order-list"},"Cancel an entire order list"),(0,r.kt)(l.ZP,{payload:"OCOResponse",method:"cancelOCO",items:[{label:"By order id",params:"new CancelOCOParams(symbol, orderListId)"},{label:"By client order id",params:"new CancelOCOParams(symbol, listClientOrderId)"}],mdxType:"Examples"}),(0,r.kt)("h3",{id:"retrieves-all-oco"},"Retrieves all OCO"),(0,r.kt)(l.ZP,{payload:"List<OCOInfo>",method:"getAllOCO",items:[{},{label:"By order id",params:"new AllOCOInfoParams(orderId)"},{label:"Framed",params:"new AllOCOInfoParams(new TimeFrame(startTime, endTime, limit))"}],mdxType:"Examples"}))}y.isMDXComponent=!0}}]);