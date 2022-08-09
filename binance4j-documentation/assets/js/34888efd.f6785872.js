"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[1319],{9372:(e,t,a)=>{a.d(t,{Z:()=>n});var s=a(7294),l=a(4645);function n(e){return s.createElement("a",{href:e.to,target:"_blank"},s.createElement(l.Z,{color:e.color,label:e.label,message:e.message}))}},9713:(e,t,a)=>{a.d(t,{ZP:()=>p});var s=a(814),l=a(5162),n=a(5488),m=a(7294);const i=e=>e.client+" client = new "+e.client+"("+(e.constructorParams?e.constructorParams.join(", "):"")+");\n\n";function o(e){const t=e.responseType?e.responseType+" response = ":"";return m.createElement(s.Z,{language:"java"},i(e)+"try{\n    "+t+"client."+e.method+"("+e.requestParameters.join(", ")+")."+e.format+"();\n}catch(ApiException e){ \n//...\n}\n")}function r(e){return m.createElement(s.Z,{language:"java"},i(e)+"client."+e.method+"("+e.requestParameters.join(", ")+")."+e.format+"((res, exception)->{\n    if(exception == null){\n        //...\n    } else{\n        //...\n    }\n});\n")}function p(e){return m.createElement(m.Fragment,null,m.createElement(n.Z,null,m.createElement(l.Z,{label:"sync",value:"sync",default:!0},m.createElement(o,e)),m.createElement(l.Z,{label:"async",value:"async-lambda"},m.createElement(r,e))))}},688:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>T,contentTitle:()=>d,default:()=>k,frontMatter:()=>p,metadata:()=>y,toc:()=>c});var s=a(7462),l=(a(7294),a(3905)),n=a(5162),m=a(5488),i=a(2106),o=a(6251),r=(a(9372),a(3738),a(9713));a(6867);const p={title:"Public data endpoints"},d=void 0,y={unversionedId:"vision",id:"version-2.x/vision",title:"Public data endpoints",description:"Installation",source:"@site/versioned_docs/version-2.x/180-vision.mdx",sourceDirName:".",slug:"/vision",permalink:"/binance4j/binance4j-documentation/docs/vision",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-2.x/180-vision.mdx",tags:[],version:"2.x",sidebarPosition:180,frontMatter:{title:"Public data endpoints"},sidebar:"tutorialSidebar",previous:{title:"Staking endpoints",permalink:"/binance4j/binance4j-documentation/docs/staking"},next:{title:"Wallet endpoints",permalink:"/binance4j/binance4j-documentation/docs/wallet"}},T={},c=[{value:"Installation",id:"installation",level:2},{value:"SPOT endpoints",id:"spot-endpoints",level:2},{value:"Get klines",id:"get-klines",level:3},{value:"Get trades",id:"get-trades",level:3},{value:"Get aggregate trades",id:"get-aggregate-trades",level:3}],u={toc:c};function k(e){let{components:t,...a}=e;return(0,l.kt)("wrapper",(0,s.Z)({},u,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(o.ZP,{artifact:"vision",mdxType:"RepoBadges"}),(0,l.kt)("h2",{id:"installation"},"Installation"),(0,l.kt)(i.ZP,{repo:"vision",mdxType:"ArtifactInstall"}),(0,l.kt)("h2",{id:"spot-endpoints"},"SPOT endpoints"),(0,l.kt)("h3",{id:"get-klines"},"Get klines"),(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"zip",label:"Zipped",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlines",responseType:"ZipInputStream",format:"getZip",requestParameters:["symbol","CandlestickInterval","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlines",responseType:"ZipInputStream",format:"getZip",requestParameters:["symbol","CandlestickInterval","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"csv",label:"In a 2d list format",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlines",responseType:"List<List<String>>",format:"getCSV",requestParameters:["symbol","CandlestickInterval","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlines",responseType:"List<List<String>>",format:"getCSV",requestParameters:["symbol","CandlestickInterval","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"deserialized",label:"Deserialized",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlines",responseType:"List<CandlestickBar>",format:"getData",requestParameters:["symbol","CandlestickInterval","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlines",responseType:"List<CandlestickBar>",format:"getData",requestParameters:["symbol","CandlestickInterval","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"checksum",label:"Get Checksum",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlinesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:["symbol","CandlestickInterval","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getKlinesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:["symbol","CandlestickInterval","year","month","day"],mdxType:"Examples"}))))),(0,l.kt)("h3",{id:"get-trades"},"Get trades"),(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"zip",label:"Zipped",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:["symbol","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"csv",label:"In a 2d list format",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:["symbol","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"deserialized",label:"Deserialized",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTrades",responseType:"List<Trade>",format:"getData",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTrades",responseType:"List<Trade>",format:"getData",requestParameters:["symbol","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"checksum",label:"Get Checksum",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:["symbol","year","month","day"],mdxType:"Examples"}))))),(0,l.kt)("h3",{id:"get-aggregate-trades"},"Get aggregate trades"),(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"zip",label:"Zipped",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTrades",responseType:"ZipInputStream",format:"getZip",requestParameters:["symbol","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"csv",label:"In a 2d list format",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTrades",responseType:"List<List<String>>",format:"getCSV",requestParameters:["symbol","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"deserialized",label:"Deserialized",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTrades",responseType:"List<AggTrade>",format:"getData",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTrades",responseType:"List<AggTrade>",format:"getData",requestParameters:["symbol","year","month","day"],mdxType:"Examples"})))),(0,l.kt)(n.Z,{value:"checksum",label:"Get Checksum",mdxType:"TabItem"},(0,l.kt)(m.Z,{mdxType:"Tabs"},(0,l.kt)(n.Z,{value:"monthly",label:"Monthly",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:["symbol","year","month"],mdxType:"Examples"})),(0,l.kt)(n.Z,{value:"daily",label:"Daily",mdxType:"TabItem"},(0,l.kt)(r.ZP,{client:"VisionSpotClient",method:"getAggTradesChecksum",responseType:"Checksum",format:"getChecksum",requestParameters:["symbol","year","month","day"],mdxType:"Examples"}))))))}k.isMDXComponent=!0},2106:(e,t,a)=>{a.d(t,{ZP:()=>o});var s=a(7462),l=(a(7294),a(3905)),n=a(112),m=a(6867);const i={toc:[]};function o(e){let{components:t,...a}=e;return(0,l.kt)("wrapper",(0,s.Z)({},i,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(n.Z,{repo:a.repo,version:m.i,mdxType:"InstallationInstructions"}))}o.isMDXComponent=!0},6251:(e,t,a)=>{a.d(t,{ZP:()=>o});var s=a(7462),l=(a(7294),a(3905)),n=a(8267),m=a(6867);const i={toc:[]};function o(e){let{components:t,...a}=e;return(0,l.kt)("wrapper",(0,s.Z)({},i,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(n.Z,{artifact:a.artifact,version:m.i,mdxType:"RepoBadges"}))}o.isMDXComponent=!0},6867:e=>{e.exports={i:"2.1.1"}}}]);