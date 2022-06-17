"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[270],{6028:function(e,t,a){a.d(t,{ZP:function(){return m}});var s=a(3066),n=a(5162),i=a(5488),l=a(7294),r=function(e){return e.client+" client = new "+e.client+"("+e.constructorParams.join(", ")+");\n\n"},o=function(e){return e.requestType?e.requestType+" request = new "+e.requestType+"("+(e.requestParameters?e.requestParameters.join(", "):"")+");\n\n":""};function d(e){var t=e.responseType?e.responseType+" response = ":"";return l.createElement(s.Z,{language:"java"},""+r(e)+o(e)+"try{\n    "+t+"client."+e.method+"("+(e.requestType?"request":"")+").execute();\n}catch(ApiException e){ \n//...\n}\n")}function p(e){return l.createElement(s.Z,{language:"java"},""+r(e)+o(e)+"client."+e.method+"("+(e.requestType?"request":"")+").then(response->{\n  //...\n});\n")}function c(e){var t=e.responseType?e.responseType+" response":"";return l.createElement(s.Z,{language:"java"},""+r(e)+o(e)+"client."+e.method+"().then(new ApiCallback<"+(e.responseType?e.responseType:"Void")+">() {\n    @Override\n    public void onResponse("+t+") {\n        //...\n    }\n\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n});\n")}function m(e){return l.createElement(l.Fragment,null,l.createElement(i.Z,null,l.createElement(n.Z,{label:"Sync",value:"sync",default:!0},l.createElement(d,e)),l.createElement(n.Z,{label:"Async (lambda)",value:"async-lambda"},l.createElement(p,e)),l.createElement(n.Z,{label:"Async (ApiCallback)",value:"async-api-callback"},l.createElement(c,e))))}},1424:function(e,t,a){a.d(t,{Z:function(){return d}});var s=a(7294),n=a(4645);function i(e){var t=e.path;return s.createElement(n.Z,{label:"endpoint",message:t,color:"blueviolet"})}var l=a(3738);function r(e){var t=e.weight;return s.createElement(n.Z,{label:"weight",message:t,color:"blue"})}function o(e){var t=e.signature;return s.createElement(n.Z,{label:"signature",message:t,color:"red"})}function d(e){return s.createElement(s.Fragment,null,s.createElement(i,{path:e.path}),"\xa0",s.createElement(r,{weight:e.weight}),"\xa0",s.createElement(o,{signature:e.signature}),"\xa0",s.createElement(l.Z,{label:e.label,artifact:e.artifact,javadoc:e.javadoc,version:e.version}))}},1547:function(e,t,a){a.r(t),a.d(t,{assets:function(){return A},contentTitle:function(){return f},default:function(){return W},frontMatter:function(){return b},metadata:function(){return x},toc:function(){return P}});var s=a(7462),n=a(3366),i=(a(7294),a(3905)),l=a(5162),r=a(5488),o=a(112),d=a(9098),p=a(6028),c=a(1424),m=a(8306),u=["components"],h={toc:[]};function y(e){var t=e.components,a=(0,n.Z)(e,u);return(0,i.kt)("wrapper",(0,s.Z)({},h,a,{components:t,mdxType:"MDXLayout"}),(0,i.kt)(c.Z,{artifact:"wallet",javadoc:"com/binance4j/wallet/"+a.javadoc,version:m.i,weight:a.weight,signature:a.signature,path:a.path,label:a.label,mdxType:"Badge"}))}y.isMDXComponent=!0;var T=a(3738),g=["components"],k={toc:[]};function v(e){var t=e.components,a=(0,n.Z)(e,g);return(0,i.kt)("wrapper",(0,s.Z)({},k,a,{components:t,mdxType:"MDXLayout"}),(0,i.kt)(T.Z,{artifact:"wallet",javadoc:"com/binance4j/wallet/"+a.javadoc,version:m.i,label:a.label,mdxType:"JavadocBadge"}))}v.isMDXComponent=!0;var w=["components"],b={title:"Wallet"},f=void 0,x={unversionedId:"Wallet",id:"Wallet",title:"Wallet",description:"Description",source:"@site/docs/05-Wallet.mdx",sourceDirName:".",slug:"/Wallet",permalink:"/binance4j/binance4j-documentation/docs/Wallet",draft:!1,editUrl:"https://github.com/binance4j/docs/05-Wallet.mdx",tags:[],version:"current",sidebarPosition:5,frontMatter:{title:"Wallet"},sidebar:"tutorialSidebar",previous:{title:"Market",permalink:"/binance4j/binance4j-documentation/docs/Market"},next:{title:"Spot",permalink:"/binance4j/binance4j-documentation/docs/Spot"}},A={},P=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Dependencies",id:"dependencies",level:2},{value:"Get system status",id:"get-system-status",level:2},{value:"Get all coins info",id:"get-all-coins-info",level:2},{value:"Get Account snapshot",id:"get-account-snapshot",level:2},{value:"Enable fast withdraw switch",id:"enable-fast-withdraw-switch",level:2},{value:"Disable fast withdraw switch",id:"disable-fast-withdraw-switch",level:2},{value:"Withdraw",id:"withdraw",level:2},{value:"Get deposit history",id:"get-deposit-history",level:2},{value:"Get withdraw history",id:"get-withdraw-history",level:2},{value:"Get deposit address",id:"get-deposit-address",level:2},{value:"Get account status",id:"get-account-status",level:2},{value:"Get API trading status",id:"get-api-trading-status",level:2},{value:"Get dust log",id:"get-dust-log",level:2},{value:"Do a dust transfer",id:"do-a-dust-transfer",level:2},{value:"Get asset dividend record",id:"get-asset-dividend-record",level:2},{value:"Get asset detail",id:"get-asset-detail",level:2},{value:"Get trade fee",id:"get-trade-fee",level:2},{value:"Make a universal transfer",id:"make-a-universal-transfer",level:2},{value:"Get transfer history",id:"get-transfer-history",level:2},{value:"Get funding asset",id:"get-funding-asset",level:2},{value:"Get API permissions",id:"get-api-permissions",level:2}],C={toc:P};function W(e){var t,a=e.components,c=(0,n.Z)(e,w);return(0,i.kt)("wrapper",(0,s.Z)({},C,c,{components:a,mdxType:"MDXLayout"}),(0,i.kt)(d.Z,{artifact:"wallet",version:m.i,mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"description"},"Description"),(0,i.kt)("p",null,"Binance4j-wallet is a Java connector for the wallet enpoints of the Binance REST API."),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(o.Z,{repo:"wallet",version:m.i,mdxType:"InstallationInstructions"}),(0,i.kt)("h2",{id:"dependencies"},"Dependencies"),(0,i.kt)("ul",null,(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"Core"},"binance4j-core")," : The core of every binance4j artifact"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://projectlombok.org/"},"Lombok")," : Prevent boilerplate code."),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://square.github.io/okhttp/"},"OkHttp")," : HTTP && Websocket clients"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://square.github.io/retrofit/"},"Retrofit")," : Map API endpoints with annotations."),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://github.com/FasterXML/jackson"},"Jackson")," : Payload deserialization"),(0,i.kt)("li",{parentName:"ul"},(0,i.kt)("a",{parentName:"li",href:"https://commons.apache.org/proper/commons-codec/"},"Apache Common Codecs")," : Encode/decode urls")),(0,i.kt)("h2",{id:"get-system-status"},"Get system status"),(0,i.kt)(y,{label:"getSystemStatus()",javadoc:"client/WalletClient.html#getSystemStatus()",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/system/status",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"SystemStatus",javadoc:"systemstatus/SystemStatus.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"SystemStatusRequest",javadoc:"systemstatus/SystemStatusRequest.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getSystemStatus",responseType:"SystemStatus",mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-all-coins-info"},"Get all coins info"),(0,i.kt)(y,{label:"getAllCoinsInfo()",javadoc:"client/WalletClient.html#getAllCoinsInfo()",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/capital/config/getall",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"CoinInformation",javadoc:"coinsinfo/CoinInformation.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"CoinInformationRequest",javadoc:"coinsinfo/CoinInformationRequest.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAllCoinsInfo",responseType:"List<CoinInformation>",mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-account-snapshot"},"Get Account snapshot"),(0,i.kt)(y,{label:"getSpotAccountSnapshot()",javadoc:"client/WalletClient.html#getSpotAccountSnapshot(com.binance4j.wallet.snapshot.AccountSnapshotRequest)",weight:"2400 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/accountSnapshot",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"AccountSnapshotRequest",javadoc:"snapshot/AccountSnapshotRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"FuturesAccountSnapshotResponse",javadoc:"snapshot/futures/FuturesAccountSnapshotResponse.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"MarginAccountSnapshotResponse",javadoc:"snapshot/margin/MarginAccountSnapshotResponse.html",mdxType:"Badge"}),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"spot",label:"SPOT",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getSpotAccountSnapshot",responseType:"SpotAccountSnapshotResponse",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"margin",label:"MARGIN",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getMarginAccountSnapshot",responseType:"MarginAccountSnapshotResponse",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"futures",label:"FUTURES",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getFuturesAccountSnapshot",responseType:"FuturesAccountSnapshotResponse",mdxType:"Examples"}))),(0,i.kt)("h2",{id:"enable-fast-withdraw-switch"},"Enable fast withdraw switch"),(0,i.kt)(y,{label:"enableFastWithdrawSwitch()",javadoc:"client/WalletClient.html#enableFastWithdrawSwitch(com.binance4j.wallet.withdraw.FastWithdrawSwitchRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"POST /sapi/v1/account/enableFastWithdrawSwitch",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"FastWithdrawSwitchRequest",javadoc:"withdraw/FastWithdrawSwitchRequest.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Enables fast withdraw switch under your account."),(0,i.kt)("p",null,"You need to enable ",(0,i.kt)("inlineCode",{parentName:"p"},"trade")," option for the api key which requests this endpoint."),(0,i.kt)("p",null,"When Fast Withdraw Switch is on, transferring funds to a Binance account will be done instantly."),(0,i.kt)("p",null,"There is no on-chain transaction, no transaction ID and no withdrawal fee."),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"enableFastWithdrawSwitch",mdxType:"Examples"}),(0,i.kt)("h2",{id:"disable-fast-withdraw-switch"},"Disable fast withdraw switch"),(0,i.kt)(y,{label:"disableFastWithdrawSwitch()",javadoc:"client/WalletClient.html#disableFastWithdrawSwitch(com.binance4j.wallet.withdraw.FastWithdrawSwitchRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"POST /sapi/v1/account/disableFastWithdrawSwitch",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"FastWithdrawSwitchRequest",javadoc:"withdraw/FastWithdrawSwitchRequest.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Disables fast withdraw switch under your account."),(0,i.kt)("p",null,"You need to enable ",(0,i.kt)("inlineCode",{parentName:"p"},"trade")," option for the api key which requests this endpoint."),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"disableFastWithdrawSwitch",mdxType:"Examples"}),(0,i.kt)("h2",{id:"withdraw"},"Withdraw"),(0,i.kt)(y,{label:"withdraw()",javadoc:"client/WalletClient.html#withdraw(com.binance4j.wallet.withdraw.WithdrawRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"POST /sapi/v1/capital/withdraw/apply",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"WithdrawRequest",javadoc:"withdraw/WithdrawRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"WithdrawResult",javadoc:"withdraw/WithdrawResult.html",mdxType:"Badge"}),(0,i.kt)("p",null,"If network not send, return with default network of the coin."),(0,i.kt)("p",null,"You can get ",(0,i.kt)("inlineCode",{parentName:"p"},"network")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"isDefault")," in networkList of a coin in the response of ",(0,i.kt)("a",{parentName:"p",href:"#get-all-coins-info"},"getAllCoinsInfo")),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"withdraw",responseType:"WithdrawResult",requestType:"WithdrawRequest",requestParameters:["new BigDecimal(1)",'"BTC"','"0x00000000000000"'],mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-deposit-history"},"Get deposit history"),(0,i.kt)(y,{label:"getDepositHistory()",javadoc:"client/WalletClient.html#getDepositHistory()",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/capital/deposit/hisrec",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"DepositHistoryRequest",javadoc:"deposit/DepositHistoryRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"DepositHistory",javadoc:"deposit/DepositHistory.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Fetches the deposit history of one or multiple coins."),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"all",label:"All coins",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDepositHistory",responseType:"List<DepositHistory>",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"one",label:"Specific coin",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDepositHistory",responseType:"List<DepositHistory>",requestType:"DepositHistoryRequest",requestParameters:['"BTC"'],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"status-enum",label:"By status (DepositStatus)",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDepositHistory",responseType:"List<DepositHistory>",requestType:"DepositHistoryRequest",requestParameters:["DepositStatus.SUCCESS"],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"status-int",label:"By status (int)",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDepositHistory",responseType:"List<DepositHistory>",requestType:"DepositHistoryRequest",requestParameters:["1"],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"coin-status",label:"By coin and status ",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDepositHistory",responseType:"List<DepositHistory>",requestType:"DepositHistoryRequest",requestParameters:['"BTC"',"DepositStatus.SUCCESS"],mdxType:"Examples"}))),(0,i.kt)("div",{className:"admonition admonition-note alert alert--secondary"},(0,i.kt)("div",{parentName:"div",className:"admonition-heading"},(0,i.kt)("h5",{parentName:"div"},(0,i.kt)("span",{parentName:"h5",className:"admonition-icon"},(0,i.kt)("svg",{parentName:"span",xmlns:"http://www.w3.org/2000/svg",width:"14",height:"16",viewBox:"0 0 14 16"},(0,i.kt)("path",{parentName:"svg",fillRule:"evenodd",d:"M6.3 5.69a.942.942 0 0 1-.28-.7c0-.28.09-.52.28-.7.19-.18.42-.28.7-.28.28 0 .52.09.7.28.18.19.28.42.28.7 0 .28-.09.52-.28.7a1 1 0 0 1-.7.3c-.28 0-.52-.11-.7-.3zM8 7.99c-.02-.25-.11-.48-.31-.69-.2-.19-.42-.3-.69-.31H6c-.27.02-.48.13-.69.31-.2.2-.3.44-.31.69h1v3c.02.27.11.5.31.69.2.2.42.31.69.31h1c.27 0 .48-.11.69-.31.2-.19.3-.42.31-.69H8V7.98v.01zM7 2.3c-3.14 0-5.7 2.54-5.7 5.68 0 3.14 2.56 5.7 5.7 5.7s5.7-2.55 5.7-5.7c0-3.15-2.56-5.69-5.7-5.69v.01zM7 .98c3.86 0 7 3.14 7 7s-3.14 7-7 7-7-3.12-7-7 3.14-7 7-7z"}))),"note")),(0,i.kt)("div",{parentName:"div",className:"admonition-content"},(0,i.kt)("p",{parentName:"div"},"Please notice the default ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," to make sure that time interval is within 0-90\ndays."),(0,i.kt)("p",{parentName:"div"},"If both ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," are sent, time between ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," must be\nless than 90 days."))),(0,i.kt)("h2",{id:"get-withdraw-history"},"Get withdraw history"),(0,i.kt)(y,{label:"getWithdrawHistory()",javadoc:"client/WalletClient.html#getWithdrawHistory(com.binance4j.wallet.withdraw.WithdrawHistoryRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/capital/withdraw/history",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"WithdrawHistoryRequest",javadoc:"withdraw/WithdrawHistoryRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"WithdrawHistory",javadoc:"withdraw/WithdrawHistory.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Fetches the withdraw history of one or multiple coins."),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"all",label:"All coins",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getWithdrawHistory",responseType:"List<WithdrawHistory>",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"one",label:"Specific coin",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getWithdrawHistory",responseType:"List<WithdrawHistory>",requestType:"WithdrawHistoryRequest",requestParameters:['"BTC"'],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"status-enum",label:"By status (WithdrawStatus)",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getWithdrawHistory",responseType:"List<WithdrawHistory>",requestType:"WithdrawHistoryRequest",requestParameters:["WithdrawStatus.SUCCESS"],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"status-int",label:"By status (int)",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getWithdrawHistory",responseType:"List<WithdrawHistory>",requestType:"WithdrawHistoryRequest",requestParameters:["6"],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"coin-status",label:"By coin and status ",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getWithdrawHistory",responseType:"List<WithdrawHistory>",requestType:"WithdrawHistoryRequest",requestParameters:['"BTC"',"WithdrawStatus.COMPLETED"],mdxType:"Examples"}))),(0,i.kt)("div",{className:"admonition admonition-note alert alert--secondary"},(0,i.kt)("div",{parentName:"div",className:"admonition-heading"},(0,i.kt)("h5",{parentName:"div"},(0,i.kt)("span",{parentName:"h5",className:"admonition-icon"},(0,i.kt)("svg",{parentName:"span",xmlns:"http://www.w3.org/2000/svg",width:"14",height:"16",viewBox:"0 0 14 16"},(0,i.kt)("path",{parentName:"svg",fillRule:"evenodd",d:"M6.3 5.69a.942.942 0 0 1-.28-.7c0-.28.09-.52.28-.7.19-.18.42-.28.7-.28.28 0 .52.09.7.28.18.19.28.42.28.7 0 .28-.09.52-.28.7a1 1 0 0 1-.7.3c-.28 0-.52-.11-.7-.3zM8 7.99c-.02-.25-.11-.48-.31-.69-.2-.19-.42-.3-.69-.31H6c-.27.02-.48.13-.69.31-.2.2-.3.44-.31.69h1v3c.02.27.11.5.31.69.2.2.42.31.69.31h1c.27 0 .48-.11.69-.31.2-.19.3-.42.31-.69H8V7.98v.01zM7 2.3c-3.14 0-5.7 2.54-5.7 5.68 0 3.14 2.56 5.7 5.7 5.7s5.7-2.55 5.7-5.7c0-3.15-2.56-5.69-5.7-5.69v.01zM7 .98c3.86 0 7 3.14 7 7s-3.14 7-7 7-7-3.12-7-7 3.14-7 7-7z"}))),"note")),(0,i.kt)("div",{parentName:"div",className:"admonition-content"},(0,i.kt)("p",{parentName:"div"},"Network may not be in the response for old withdraw."),(0,i.kt)("p",{parentName:"div"},"Please notice the default ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," to make sure that time interval is within 0-90 days."),(0,i.kt)("p",{parentName:"div"},"If both ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," are sent, time between startTime and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," must be less than 90 days."),(0,i.kt)("p",{parentName:"div"},"If ",(0,i.kt)("inlineCode",{parentName:"p"},"withdrawOrderId")," is sent, time between ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," must be less than 7 days."),(0,i.kt)("p",{parentName:"div"},"If ",(0,i.kt)("inlineCode",{parentName:"p"},"withdrawOrderId")," is sent, ",(0,i.kt)("inlineCode",{parentName:"p"},"startTime")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"endTime")," are not sent, will return last 7 days records by default."))),(0,i.kt)("h2",{id:"get-deposit-address"},"Get deposit address"),(0,i.kt)(y,{label:"getDepositAddress()",javadoc:"client/WalletClient.html#getDepositAddress(com.binance4j.wallet.deposit.DepositAddressRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/capital/deposit/address",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"DepositAddressRequest",javadoc:"deposit/DepositAddressRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"DepositAddress",javadoc:"deposit/DepositAddress.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDepositAddress",responseType:"DepositAddress",requestType:"WithdrawRequesDepositAddressRequest",requestParameters:['"BNB"'],mdxType:"Examples"}),(0,i.kt)("div",{className:"admonition admonition-note alert alert--secondary"},(0,i.kt)("div",{parentName:"div",className:"admonition-heading"},(0,i.kt)("h5",{parentName:"div"},(0,i.kt)("span",{parentName:"h5",className:"admonition-icon"},(0,i.kt)("svg",{parentName:"span",xmlns:"http://www.w3.org/2000/svg",width:"14",height:"16",viewBox:"0 0 14 16"},(0,i.kt)("path",{parentName:"svg",fillRule:"evenodd",d:"M6.3 5.69a.942.942 0 0 1-.28-.7c0-.28.09-.52.28-.7.19-.18.42-.28.7-.28.28 0 .52.09.7.28.18.19.28.42.28.7 0 .28-.09.52-.28.7a1 1 0 0 1-.7.3c-.28 0-.52-.11-.7-.3zM8 7.99c-.02-.25-.11-.48-.31-.69-.2-.19-.42-.3-.69-.31H6c-.27.02-.48.13-.69.31-.2.2-.3.44-.31.69h1v3c.02.27.11.5.31.69.2.2.42.31.69.31h1c.27 0 .48-.11.69-.31.2-.19.3-.42.31-.69H8V7.98v.01zM7 2.3c-3.14 0-5.7 2.54-5.7 5.68 0 3.14 2.56 5.7 5.7 5.7s5.7-2.55 5.7-5.7c0-3.15-2.56-5.69-5.7-5.69v.01zM7 .98c3.86 0 7 3.14 7 7s-3.14 7-7 7-7-3.12-7-7 3.14-7 7-7z"}))),"note")),(0,i.kt)("div",{parentName:"div",className:"admonition-content"},(0,i.kt)("p",{parentName:"div"},"You can get ",(0,i.kt)("inlineCode",{parentName:"p"},"network")," and ",(0,i.kt)("inlineCode",{parentName:"p"},"isDefault")," in ",(0,i.kt)("inlineCode",{parentName:"p"},"networkList")," in the response of ",(0,i.kt)("inlineCode",{parentName:"p"},"getAllCoinsInfo")),(0,i.kt)("p",{parentName:"div"},"If ",(0,i.kt)("inlineCode",{parentName:"p"},"network")," is not sent, return with default network of the coin."))),(0,i.kt)("h2",{id:"get-account-status"},"Get account status"),(0,i.kt)(y,{label:"getAccountstatus()",javadoc:"client/WalletClient.html#getAccountstatus(com.binance4j.wallet.accountstatus.AccountStatusRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/account/status",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"AccountStatusRequest",javadoc:"accountstatus/AccountStatusRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"AccountStatus",javadoc:"accountstatus/AccountStatus.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAccountstatus",responseType:"AccountStatus",mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-api-trading-status"},"Get API trading status"),(0,i.kt)(y,{label:"getApiTradingStatus()",javadoc:"client/WalletClient.html#getApiTradingStatus(com.binance4j.wallet.tradingstatus.ApiTradingStatusRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/account/apiTradingStatus",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"ApiTradingStatusRequest",javadoc:"tradingstatus/ApiTradingStatusRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"ApiTradingStatus",javadoc:"tradingstatus/ApiTradingStatus.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getApiTradingStatus",responseType:"ApiTradingStatus",mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-dust-log"},"Get dust log"),(0,i.kt)(y,{label:"getDustLog()",javadoc:"client/WalletClient.html#getDustLog(com.binance4j.wallet.dust.DustLogRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/asset/dribblet",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"DustLogRequest",javadoc:"dust/DustLogRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"DustLog",javadoc:"dust/DustLog.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getDustLog",responseType:"DustLog",mdxType:"Examples"}),(0,i.kt)("h2",{id:"do-a-dust-transfer"},"Do a dust transfer"),(0,i.kt)(y,{label:"dustTransfert()",javadoc:"client/WalletClient.html#dustTransfert(com.binance4j.wallet.dust.DustTransferRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"POST /sapi/v1/asset/dust",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"DustTransferRequest",javadoc:"dust/DustTransferRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"DustTransferResponse",javadoc:"dust/DustTransferResponse.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"dustTransfert",responseType:"DustTransferResponse",requestType:"DustTransferRequest",requestParameters:['List.of("BTC","SHIB","DOGE")'],mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-asset-dividend-record"},"Get asset dividend record"),(0,i.kt)(y,{label:"getAssetDividendRecord()",javadoc:"client/WalletClient.html#getAssetDividendRecord(com.binance4j.wallet.assetdividendrecord.AssetDividendRecordRequest)",weight:"10 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/asset/assetDividend",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"AssetDividendRecordRequest",javadoc:"assetdividendrecord/AssetDividendRecordRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"AssetDividendRecord",javadoc:"assetdividendrecord/AssetDividendRecord.html",mdxType:"Badge"}),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"last-20",label:"Last 20 (default)",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAssetDividendRecord",responseType:"AssetDividendRecord",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"one-coin-last-20",label:"Specific coin last 20",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAssetDividendRecord",responseType:"AssetDividendRecord",requestType:"AssetDividendRecordRequest",requestParameters:['"BTC"'],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"last-500",label:"Last 500 records",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAssetDividendRecord",responseType:"AssetDividendRecord",requestType:"AssetDividendRecordRequest",requestParameters:['"BTC"',500],mdxType:"Examples"}))),(0,i.kt)("h2",{id:"get-asset-detail"},"Get asset detail"),(0,i.kt)(y,{label:"getAssetDetail()",javadoc:"client/WalletClient.html#getAssetDetail(com.binance4j.wallet.assetdetail.AssetDetailRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/asset/assetDetail",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"AssetDetailRequest",javadoc:"assetdetail/AssetDetailRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"AssetDetail",javadoc:"assetdetail/AssetDetail.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Get the details of all assets supported by Binance"),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"all",label:"All assets",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAssetDetail",responseType:"Map<String, AssetDetail>",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"one",label:"One asset",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getAssetDetail",responseType:"Map<String, AssetDetail>",requestType:"AssetDetailRequest",requestParameters:['"BTC"'],mdxType:"Examples"}))),(0,i.kt)("h2",{id:"get-trade-fee"},"Get trade fee"),(0,i.kt)(y,{label:"getTradeFee()",javadoc:"client/WalletClient.html#getTradeFee(com.binance4j.wallet.tradefee.TradeFeeRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/asset/tradeFee",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"TradeFeeRequest",javadoc:"tradefee/TradeFeeRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"TradeFee",javadoc:"tradefee/TradeFee.html",mdxType:"Badge"}),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"all",label:"All pairs",mdxType:"TabItem"},(0,i.kt)(p.ZP,((t={client:"WalletClient",constructorParams:["key","secret"]}).client="WalletClient",t.method="getTradeFee",t.responseType="List<TradeFee>",t.mdxType="Examples",t))),(0,i.kt)(l.Z,{value:"one",label:"One pair",mdxType:"TabItem"},(0,i.kt)(p.ZP,{constructorParams:["key","secret"],method:"getTradeFee",responseType:"List<TradeFee>",requestType:"TradeFeeRequest",requestParameters:['"BNBBTC"'],mdxType:"Examples"}))),(0,i.kt)("h2",{id:"make-a-universal-transfer"},"Make a universal transfer"),(0,i.kt)(y,{label:"transfer()",javadoc:"client/WalletClient.html#transfer(com.binance4j.wallet.transfer.WalletTransferRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"POST /sapi/v1/asset/transfer",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"WalletTransferRequest",javadoc:"transfer/WalletTransferRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"WalletTransferResponse",javadoc:"transfer/WalletTransferResponse.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"transfer",responseType:"WalletTransferResponse",requestType:"WalletTransferRequest",requestParameters:['new BigDecimal("100")','"BNB"',"WalletTransferType.MAIN_MARGIN"],mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-transfer-history"},"Get transfer history"),(0,i.kt)(y,{label:"getTransferHistory()",javadoc:"client/WalletClient.html#getTransferHistory(com.binance4j.wallet.transfer.WalletTransferHistoryRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/asset/transfer",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"WalletTransferHistoryRequest",javadoc:"transfer/WalletTransferHistoryRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"WalletTransferHistory",javadoc:"transfer/WalletTransferHistory.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getTransferHistory",responseType:"WalletTransferHistory",requestType:"WalletTransferHistoryRequest",requestParameters:["WalletTransferType.MAIN_MARGIN"],mdxType:"Examples"}),(0,i.kt)("h2",{id:"get-funding-asset"},"Get funding asset"),(0,i.kt)(y,{label:"getFundingAsset()",javadoc:"client/WalletClient.html#getFundingAsset()",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"POST /sapi/v1/asset/get-funding-asset",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"FundingAssetRequest",javadoc:"funding/FundingAssetRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"FundingAsset",javadoc:"funding/FundingAsset.html",mdxType:"Badge"}),(0,i.kt)("p",null,"Fetches the funding wallet asset balance"),(0,i.kt)("p",null,"Currently supports querying the following business assets\uff1aBinance Pay, Binance Card, Binance Gift Card, Stock Token"),(0,i.kt)(r.Z,{mdxType:"Tabs"},(0,i.kt)(l.Z,{value:"all",label:"All balances",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getFundingAsset",responseType:"List<FundingAsset>",mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"one",label:"Specific",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getFundingAsset",responseType:"List<FundingAsset>",requestType:"FundingAssetRequest",requestParameters:['"BNB"'],mdxType:"Examples"})),(0,i.kt)(l.Z,{value:"btc-valuation",label:"SAdd BTC valuation",mdxType:"TabItem"},(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getFundingAsset",responseType:"List<FundingAsset>",requestType:"FundingAssetRequest",requestParameters:['"BNB"',!0],mdxType:"Examples"}))),(0,i.kt)("h2",{id:"get-api-permissions"},"Get API permissions"),(0,i.kt)(y,{label:"getApiPermissions()",javadoc:"client/WalletClient.html#getApiPermissions(com.binance4j.wallet.permissions.ApiPermissionsRequest)",weight:"1 (IP)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/account/apiRestrictions",mdxType:"Badges"}),"\xa0",(0,i.kt)(v,{label:"ApiPermissionsRequest",javadoc:"permissions/ApiPermissionsRequest.html",mdxType:"Badge"}),"\xa0",(0,i.kt)(v,{label:"ApiPermissions",javadoc:"permissions/ApiPermissions.html",mdxType:"Badge"}),(0,i.kt)(p.ZP,{client:"WalletClient",constructorParams:["key","secret"],method:"getApiPermissions",responseType:"ApiPermissions",mdxType:"Examples"}))}W.isMDXComponent=!0}}]);