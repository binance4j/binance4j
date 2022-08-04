"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[605],{3947:(e,t,a)=>{a.d(t,{ZP:()=>d});var l=a(814),n=a(5162),s=a(5488),i=a(7294);const r=e=>e.client+" client = new "+e.client+"("+(e.constructorParams?e.constructorParams.join(", "):"")+");\n\n";function o(e){const t=e.responseType?e.responseType+" response = ":"";return i.createElement(l.Z,{language:"java"},r(e)+"try{\n    "+t+"client."+e.method+"("+e.requestParameters.join(", ")+")."+e.format+"();\n}catch(ApiException e){ \n//...\n}\n")}function m(e){return i.createElement(l.Z,{language:"java"},r(e)+"client."+e.method+"("+e.requestParameters.join(", ")+")."+e.format+"(response->{\n  //...\n});\n")}function p(e){const t=e.responseType?e.responseType+" response":"";return i.createElement(l.Z,{language:"java"},r(e)+"client."+e.method+"("+e.requestParameters.join(", ")+")."+e.format+"(new ApiCallback<"+(e.responseType?e.responseType:"Void")+">() {\n    @Override\n    public void onResponse("+t+") {\n        //...\n    }\n\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n});\n")}function d(e){return i.createElement(i.Fragment,null,i.createElement(s.Z,null,i.createElement(n.Z,{label:"Synchronous request",value:"sync",default:!0},i.createElement(o,e)),i.createElement(n.Z,{label:"Asynchronous request with lambda",value:"async-lambda"},i.createElement(m,e)),i.createElement(n.Z,{label:"Asynchronous request with ApiCallback",value:"async-api-callback"},i.createElement(p,e))))}},9372:(e,t,a)=>{a.d(t,{Z:()=>s});var l=a(7294),n=a(4645);function s(e){return l.createElement("a",{href:e.to,target:"_blank"},l.createElement(n.Z,{color:e.color,label:e.label,message:e.message}))}},825:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>h,contentTitle:()=>b,default:()=>v,frontMatter:()=>k,metadata:()=>g,toc:()=>x});var l=a(7462),n=(a(7294),a(3905)),s=a(5162),i=a(5488),r=a(112),o=a(9098),m=a(9372),p=a(3738),d=a(3947),c=a(509);const T={toc:[]};function u(e){let{components:t,...a}=e;return(0,n.kt)("wrapper",(0,l.Z)({},T,a,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(p.Z,{artifact:"vision",javadoc:"com/binance4j/vision/"+a.javadoc,version:c.i,label:a.label,mdxType:"JavadocBadge"}))}u.isMDXComponent=!0;var y=a(2194);const k={title:"Vision"},b=void 0,g={unversionedId:"Vision",id:"version-1.x/Vision",title:"Vision",description:"Description",source:"@site/versioned_docs/version-1.x/08-Vision.mdx",sourceDirName:".",slug:"/Vision",permalink:"/binance4j/binance4j-documentation/docs/Vision",draft:!1,editUrl:"https://github.com/binance4j/versioned_docs/version-1.x/08-Vision.mdx",tags:[],version:"1.x",sidebarPosition:8,frontMatter:{title:"Vision"},sidebar:"tutorialSidebar",previous:{title:"NFT",permalink:"/binance4j/binance4j-documentation/docs/NFT"},next:{title:"Websocket",permalink:"/binance4j/binance4j-documentation/docs/Websocket"}},h={},x=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Dependencies",id:"dependencies",level:2},{value:"SPOT endpoints",id:"spot-endpoints",level:2},{value:"Get klines",id:"get-klines",level:3},{value:"Get trades",id:"get-trades",level:3},{value:"Get aggregate trades",id:"get-aggregate-trades",level:3}],Z={toc:x};function v(e){let{components:t,...a}=e;return(0,n.kt)("wrapper",(0,l.Z)({},Z,a,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(o.Z,{artifact:"vision",version:c.i,mdxType:"RepoBadges"}),(0,n.kt)("h2",{id:"description"},"Description"),(0,n.kt)("p",null,"Binance4j-vision is a Java connector for the public data endpoints of the Binance REST API."),(0,n.kt)("h2",{id:"installation"},"Installation"),(0,n.kt)("h2",{id:"dependencies"},"Dependencies"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"Core"},"binance4j-core")," : The core of every binance4j artifact"),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://projectlombok.org/"},"Lombok")," : Prevent boilerplate code."),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://square.github.io/okhttp/"},"OkHttp")," : HTTP && Websocket clients"),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://square.github.io/retrofit/"},"Retrofit")," : Map API endpoints with annotations."),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://github.com/FasterXML/jackson"},"Jackson")," : Payload deserialization"),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("a",{parentName:"li",href:"https://commons.apache.org/proper/commons-codec/"},"Apache Common Codecs")," : Encode/decode urls")),(0,n.kt)(r.Z,{repo:"vision",version:c.i,mdxType:"InstallationInstructions"}),(0,n.kt)("h2",{id:"spot-endpoints"},"SPOT endpoints"),(0,n.kt)("h3",{id:"get-klines"},"Get klines"),(0,n.kt)(u,{label:"SpotClient",javadoc:"spot/SpotClient.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(y.ZP,{label:"CandlestickBar",javadoc:"market/CandlestickBar.html",mdxType:"CoreBadge"}),"\xa0",(0,n.kt)(m.Z,{label:"Binance doc",message:"klines",color:"gold",to:"https://github.com/binance/binance-public-data#klines",mdxType:"LinkBadge"}),(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"zip",label:"Zipped",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlines",responseType:"ZipInputStream",format:"getZip",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlines",responseType:"ZipInputStream",format:"getZip",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"csv",label:"In a CSV format / 2D List",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlines",responseType:"List<List<String>>",format:"getCSV",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlines",responseType:"List<List<String>>",format:"getCSV",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"deserialized",label:"Deserialized",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlines",responseType:"List<CandlestickBar>",format:"getData",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlines",responseType:"List<CandlestickBar>",format:"getData",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"checksum",label:"Get Checksum",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlinesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getKlinesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:['"BNBBTC"',"CandlestickInterval.FIVE_MINUTE",'"2022"','"01"','"25"'],mdxType:"Examples"}))))),(0,n.kt)("h3",{id:"get-trades"},"Get trades"),(0,n.kt)(u,{label:"SpotClient",javadoc:"spot/SpotClient.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(u,{label:"Trade",javadoc:"spot/Trade.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(m.Z,{label:"Binance doc",message:"trades",color:"gold",to:"https://github.com/binance/binance-public-data#trades",mdxType:"LinkBadge"}),(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"zip",label:"Zipped",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"csv",label:"In a CSV format / 2D List",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"deserialized",label:"Deserialized",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTrades",responseType:"List<Trade>",format:"getData",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTrades",responseType:"List<Trade>",format:"getData",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"checksum",label:"Get Checksum",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"}))))),(0,n.kt)("h3",{id:"get-aggregate-trades"},"Get aggregate trades"),(0,n.kt)(u,{label:"SpotClient",javadoc:"spot/SpotClient.html",mdxType:"Badge"}),"\xa0",(0,n.kt)(y.ZP,{label:"AggTrade",javadoc:"market/trade.html",mdxType:"CoreBadge"}),"\xa0",(0,n.kt)(m.Z,{label:"Binance doc",message:"aggtrades",color:"gold",to:"https://github.com/binance/binance-public-data#aggtrades",mdxType:"LinkBadge"}),(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"zip",label:"Zipped",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"csv",label:"In a CSV format / 2D List",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"deserialized",label:"Deserialized",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTrades",responseType:"AggTrade",format:"getData",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTrades",responseType:"AggTrade",format:"getData",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"})))),(0,n.kt)(s.Z,{value:"checksum",label:"Get Checksum",mdxType:"TabItem"},(0,n.kt)(i.Z,{mdxType:"Tabs"},(0,n.kt)(s.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:['"BNBBTC"','"2022"','"01"'],mdxType:"Examples"})),(0,n.kt)(s.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,n.kt)(d.ZP,{client:"SpotClient",method:"getAggTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:['"BNBBTC"','"2022"','"01"','"25"'],mdxType:"Examples"}))))))}v.isMDXComponent=!0},2194:(e,t,a)=>{a.d(t,{ZP:()=>o});var l=a(7462),n=(a(7294),a(3905)),s=a(3738),i=a(509);const r={toc:[]};function o(e){let{components:t,...a}=e;return(0,n.kt)("wrapper",(0,l.Z)({},r,a,{components:t,mdxType:"MDXLayout"}),(0,n.kt)(s.Z,{artifact:"core",javadoc:"com/binance4j/core/"+a.javadoc,version:i.i,label:a.label,mdxType:"JavadocBadge"}))}o.isMDXComponent=!0},509:e=>{e.exports={i:"1.7.5"}}}]);