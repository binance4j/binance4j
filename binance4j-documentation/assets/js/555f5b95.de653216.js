"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[959],{1345:(e,t,n)=>{n.d(t,{ZP:()=>d});var a=n(814),l=n(5162),i=n(5488),r=n(7294);function s(e){return r.createElement(a.Z,{language:"java"},"try{\n    "+e.payload+" res = client."+e.method+".sync();\n}catch(ApiException e){ \n//...\n}")}function c(e){return r.createElement(a.Z,{language:"java"},"client."+e.method+".async(response->{\n//...\n});")}function o(e){const t=e.payload?e.payload+" response":"";return r.createElement(a.Z,{language:"java"},"client."+e.method+".async(new ApiCallback<"+(e.payload?e.payload:"Void")+">() {\n    @Override\n    public void onResponse("+t+") {\n        //...\n    }\n\n    @Override\n    public void onFailure(ApiException exception) {\n        //...\n    }\n});\n")}function d(e){return r.createElement(r.Fragment,null,r.createElement(i.Z,null,r.createElement(l.Z,{label:"Sync",value:"sync",default:!0},r.createElement(s,e)),r.createElement(l.Z,{label:"Async (lambda)",value:"async-lambda"},r.createElement(c,e)),r.createElement(l.Z,{label:"Async (ApiCallback)",value:"async-api-callback"},r.createElement(o,e))))}},6810:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>p,contentTitle:()=>o,default:()=>k,frontMatter:()=>c,metadata:()=>d,toc:()=>u});var a=n(7462),l=(n(7294),n(3905)),i=n(2328),r=n(9098),s=n(1345);const c={title:"Core",id:"Core"},o=void 0,d={unversionedId:"Core",id:"Core",title:"Core",description:"Description",source:"@site/docs/10-core.mdx",sourceDirName:".",slug:"/Core",permalink:"/binance4j/binance4j-documentation/docs/next/Core",draft:!1,editUrl:"https://github.com/binance4j/docs/10-core.mdx",tags:[],version:"current",sidebarPosition:10,frontMatter:{title:"Core",id:"Core"},sidebar:"tutorialSidebar",next:{title:"Connectors",permalink:"/binance4j/binance4j-documentation/docs/next/connectors"}},p={},u=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Rest client",id:"rest-client",level:2},{value:"Parameters",id:"parameters",level:2},{value:"Request",id:"request",level:2}],m={toc:u};function k(e){let{components:t,...n}=e;return(0,l.kt)("wrapper",(0,a.Z)({},m,n,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(r.Z,{artifact:"core",mdxType:"RepoBadges"}),(0,l.kt)("h2",{id:"description"},"Description"),(0,l.kt)("p",null,"Binance4j-core is the core module of the binance4j ecosystem."),(0,l.kt)("h2",{id:"installation"},"Installation"),(0,l.kt)(i.ZP,{repo:"core",mdxType:"ArtifactInstall"}),(0,l.kt)("h2",{id:"rest-client"},"Rest client"),(0,l.kt)("p",null,"Every REST client needs an ",(0,l.kt)("inlineCode",{parentName:"p"},"API key")," and a ",(0,l.kt)("inlineCode",{parentName:"p"},"secret key")," when instanciated."),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="Client new instance"',title:'"Client',new:!0,'instance"':!0},"MarketClient client = new MarketClient(key, secret);\n")),(0,l.kt)("h2",{id:"parameters"},"Parameters"),(0,l.kt)("p",null,"Most client requests require query parameters."),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="Get klines with MarketClient"',title:'"Get',klines:!0,with:!0,'MarketClient"':!0},'// ...\nKlinesParams params = new KlinesParams("BTCBUSD", "1m");\nRequest<List<Candle>> req = client.getKlines(params);\n')),(0,l.kt)("h2",{id:"request"},"Request"),(0,l.kt)("p",null,"The code above won't make call the API. It returns an instance of a ",(0,l.kt)("inlineCode",{parentName:"p"},"Request")," that can make a ",(0,l.kt)("inlineCode",{parentName:"p"},"synchronous")," or ",(0,l.kt)("inlineCode",{parentName:"p"},"asynchronous")," call."),(0,l.kt)(s.ZP,{payload:"List<Candle>",method:"getKlines(params)",mdxType:"Example"}))}k.isMDXComponent=!0}}]);