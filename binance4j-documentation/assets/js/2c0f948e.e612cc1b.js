"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[5128],{6028:(e,t,a)=>{a.d(t,{ZP:()=>m});var n=a(814),s=a(5162),i=a(5488),r=a(7294);const o=e=>e.client+" client = new "+e.client+"("+e.constructorParams.join(", ")+");\n\n",c=e=>e.requestType?e.requestType+" request = new "+e.requestType+"("+(e.requestParameters?e.requestParameters.join(", "):"")+");\n\n":"";function l(e){const t=e.responseType?e.responseType+" response = ":"";return r.createElement(n.Z,{language:"java"},""+o(e)+c(e)+"try{\n    "+t+"client."+e.method+"("+(e.requestType?"request":"")+").execute();\n}catch(ApiException e){ \n//...\n}\n")}function p(e){return r.createElement(n.Z,{language:"java"},""+o(e)+c(e)+"client."+e.method+"("+(e.requestType?"request":"")+").then(response->{\n  //...\n});\n")}function d(e){const t=e.responseType?e.responseType+" response":"";return r.createElement(n.Z,{language:"java"},""+o(e)+c(e)+"client."+e.method+"().then(new ApiCallback<"+(e.responseType?e.responseType:"Void")+">() {\n    @Override\n    public void onResponse("+t+") {\n        //...\n    }\n\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n});\n")}function m(e){return r.createElement(r.Fragment,null,r.createElement(i.Z,null,r.createElement(s.Z,{label:"Sync",value:"sync",default:!0},r.createElement(l,e)),r.createElement(s.Z,{label:"Async (lambda)",value:"async-lambda"},r.createElement(p,e)),r.createElement(s.Z,{label:"Async (ApiCallback)",value:"async-api-callback"},r.createElement(d,e))))}},9098:(e,t,a)=>{a.d(t,{Z:()=>l});var n=a(7294),s=a(3738);function i(){return n.createElement("a",{href:"https://opensource.org/licenses/MIT"},n.createElement("img",{src:"https://img.shields.io/badge/License-MIT-yellow.svg",alt:"License: MIT"}))}function r(e){let{artifact:t}=e;return n.createElement("a",{href:"https://search.maven.org/search?q=com.binance4j.binance4j-"+t,target:"_blank"},n.createElement("img",{alt:"Maven Central",src:"https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-"+t+"/badge.svg"}))}function o(){return n.createElement("img",{src:"https://upload.wikimedia.org/wikipedia/commons/7/75/Blue_JDK_1.8%2B_Shield_Badge.svg"})}function c(e){let{artifact:t}=e;return n.createElement("a",{href:"https://s01.oss.sonatype.org/#nexus-search;quick~com.binance4j."+t},n.createElement("img",{alt:"Sonatype Nexus",src:"https://img.shields.io/nexus/r/com.binance4j/binance4j-"+t+"?server=https%3A%2F%2Fs01.oss.sonatype.org%2F"}))}function l(e){return n.createElement(n.Fragment,null,n.createElement(s.Z,{artifact:e.artifact,javadoc:"index.html",version:e.version}),"\xa0",n.createElement(r,{artifact:e.artifact}),"\xa0",n.createElement(c,{artifact:e.artifact}),"\xa0",n.createElement(o,null),"\xa0",n.createElement(i,null))}},1424:(e,t,a)=>{a.d(t,{Z:()=>l});var n=a(7294),s=a(4645);function i(e){let{path:t}=e;return n.createElement(s.Z,{label:"endpoint",message:t,color:"blueviolet"})}var r=a(3738);function o(e){let{weight:t}=e;return n.createElement(s.Z,{label:"weight",message:t,color:"blue"})}function c(e){let{signature:t}=e;return n.createElement(s.Z,{label:"signature",message:t,color:"red"})}function l(e){return n.createElement(n.Fragment,null,n.createElement(i,{path:e.path}),"\xa0",n.createElement(o,{weight:e.weight}),"\xa0",n.createElement(c,{signature:e.signature}),"\xa0",n.createElement(r.Z,{label:e.label,artifact:e.artifact,javadoc:e.javadoc,version:e.version}))}},5090:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>v,contentTitle:()=>g,default:()=>f,frontMatter:()=>T,metadata:()=>y,toc:()=>b});var n=a(7462),s=(a(7294),a(3905)),i=a(112),r=a(9098),o=a(6028),c=a(1424),l=a(509);const p={toc:[]};function d(e){let{components:t,...a}=e;return(0,s.kt)("wrapper",(0,n.Z)({},p,a,{components:t,mdxType:"MDXLayout"}),(0,s.kt)(c.Z,{artifact:"nft",javadoc:"com/binance4j/nft/"+a.javadoc,version:l.i,weight:a.weight,signature:a.signature,path:a.path,label:a.label,mdxType:"Badge"}))}d.isMDXComponent=!0;var m=a(3738);const u={toc:[]};function h(e){let{components:t,...a}=e;return(0,s.kt)("wrapper",(0,n.Z)({},u,a,{components:t,mdxType:"MDXLayout"}),(0,s.kt)(m.Z,{artifact:"nft",javadoc:"com/binance4j/nft/"+a.javadoc,version:l.i,label:a.label,mdxType:"JavadocBadge"}))}h.isMDXComponent=!0;const T={title:"NFT"},g=void 0,y={unversionedId:"NFT",id:"version-1.x/NFT",title:"NFT",description:"Description",source:"@site/versioned_docs/version-1.x/07-NFT.mdx",sourceDirName:".",slug:"/NFT",permalink:"/binance4j/binance4j-documentation/docs/1.x/NFT",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-1.x/07-NFT.mdx",tags:[],version:"1.x",sidebarPosition:7,frontMatter:{title:"NFT"},sidebar:"tutorialSidebar",previous:{title:"Spot",permalink:"/binance4j/binance4j-documentation/docs/1.x/Spot"},next:{title:"Vision",permalink:"/binance4j/binance4j-documentation/docs/1.x/Vision"}},v={},b=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Dependencies",id:"dependencies",level:2},{value:"Get transaction history",id:"get-transaction-history",level:2},{value:"Get deposit history",id:"get-deposit-history",level:2},{value:"Get withdraw history",id:"get-withdraw-history",level:2},{value:"Get NFT assets",id:"get-nft-assets",level:2}],k={toc:b};function f(e){let{components:t,...a}=e;return(0,s.kt)("wrapper",(0,n.Z)({},k,a,{components:t,mdxType:"MDXLayout"}),(0,s.kt)(r.Z,{artifact:"nft",version:l.i,mdxType:"RepoBadges"}),(0,s.kt)("h2",{id:"description"},"Description"),(0,s.kt)("p",null,"Binance4j-nft is a Java connector for the NFT endpoints of the Binance REST API."),(0,s.kt)("h2",{id:"installation"},"Installation"),(0,s.kt)(i.Z,{repo:"nft",version:l.i,mdxType:"InstallationInstructions"}),(0,s.kt)("h2",{id:"dependencies"},"Dependencies"),(0,s.kt)("ul",null,(0,s.kt)("li",{parentName:"ul"},(0,s.kt)("a",{parentName:"li",href:"Core"},"binance4j-core")," : The core of every binance4j artifact"),(0,s.kt)("li",{parentName:"ul"},(0,s.kt)("a",{parentName:"li",href:"https://projectlombok.org/"},"Lombok")," : Prevent boilerplate code."),(0,s.kt)("li",{parentName:"ul"},(0,s.kt)("a",{parentName:"li",href:"https://square.github.io/okhttp/"},"OkHttp")," : HTTP && Websocket clients"),(0,s.kt)("li",{parentName:"ul"},(0,s.kt)("a",{parentName:"li",href:"https://square.github.io/retrofit/"},"Retrofit")," : Map API endpoints with annotations."),(0,s.kt)("li",{parentName:"ul"},(0,s.kt)("a",{parentName:"li",href:"https://github.com/FasterXML/jackson"},"Jackson")," : Payload deserialization"),(0,s.kt)("li",{parentName:"ul"},(0,s.kt)("a",{parentName:"li",href:"https://commons.apache.org/proper/commons-codec/"},"Apache Common Codecs")," : Encode/decode urls")),(0,s.kt)("h2",{id:"get-transaction-history"},"Get transaction history"),(0,s.kt)(d,{label:"getTransactions()",javadoc:"client/NFTClient.html#getTransactions(com.binance4j.nft.transaction.NFTTransactionHistoryRequest)",weight:"3000 (UID)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/nft/history/transactions",mdxType:"Badges"}),"\xa0",(0,s.kt)(h,{label:"NFTTransactionHistoryRequest",javadoc:"transaction/NFTTransactionHistoryRequest.html",mdxType:"Badge"}),"\xa0",(0,s.kt)(h,{label:"NFTTransactionHistory",javadoc:"transaction/NFTTransactionHistory.html",mdxType:"Badge"}),(0,s.kt)(o.ZP,{client:"NFTClient",constructorParams:["key","secret"],method:"getTransactions",responseType:"NFTTransactionHistory",requestType:"NFTTransactionHistoryRequest",requestParameters:["NFTOrderType.PURCHASE_ORDER"],mdxType:"Examples"}),(0,s.kt)("h2",{id:"get-deposit-history"},"Get deposit history"),(0,s.kt)(d,{label:"getDeposits()",javadoc:"client/NFTClient.html#getDeposits(com.binance4j.nft.deposit.NFTDepositHistoryRequest)",weight:"3000 (UID)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/nft/history/deposit",mdxType:"Badges"}),"\xa0",(0,s.kt)(h,{label:"NFTDepositHistoryRequest",javadoc:"deposit/NFTDepositHistoryRequest.html",mdxType:"Badge"}),"\xa0",(0,s.kt)(h,{label:"NFTDepositHistory",javadoc:"deposit/NFTDepositHistory.html",mdxType:"Badge"}),(0,s.kt)(o.ZP,{client:"NFTClient",constructorParams:["key","secret"],method:"getDeposits",responseType:"NFTDepositHistory",mdxType:"Examples"}),(0,s.kt)("h2",{id:"get-withdraw-history"},"Get withdraw history"),(0,s.kt)(d,{label:"getWithdraws()",javadoc:"client/NFTClient.html#getWithdraws(com.binance4j.nft.withdraw.NFTWithdrawRequest)",weight:"3000 (UID)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/nft/history/withdraw",mdxType:"Badges"}),"\xa0",(0,s.kt)(h,{label:"NFTWithdrawRequest",javadoc:"withdraw/NFTWithdrawRequest.html",mdxType:"Badge"}),"\xa0",(0,s.kt)(h,{label:"NFTWithdrawHistory",javadoc:"withdraw/NFTWithdrawHistory.html",mdxType:"Badge"}),(0,s.kt)(o.ZP,{client:"NFTClient",constructorParams:["key","secret"],method:"getWithdraws",responseType:"NFTWithdrawHistory",mdxType:"Examples"}),(0,s.kt)("h2",{id:"get-nft-assets"},"Get NFT assets"),(0,s.kt)(d,{label:"getAssets()",javadoc:"client/NFTClient.html#getAssets(com.binance4j.nft.asset.NFTAssetRequest)",weight:"3000 (UID)",signature:"signed (HMAC SHA256)",path:"GET /sapi/v1/nft/user/getAsset",mdxType:"Badges"}),"\xa0",(0,s.kt)(h,{label:"NFTAssetRequest",javadoc:"asset/NFTAssetRequest.html",mdxType:"Badge"}),"\xa0",(0,s.kt)(h,{label:"NFTAssetHistory",javadoc:"asset/NFTAssetHistory.html",mdxType:"Badge"}),(0,s.kt)(o.ZP,{client:"NFTClient",constructorParams:["key","secret"],method:"getAssets",responseType:"NFTAssetHistory",mdxType:"Examples"}))}f.isMDXComponent=!0},509:e=>{e.exports={i:"1.7.5"}}}]);