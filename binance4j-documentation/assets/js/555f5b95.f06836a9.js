"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[9959],{6810:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>p,contentTitle:()=>d,default:()=>k,frontMatter:()=>s,metadata:()=>c,toc:()=>u});var a=n(7462),i=(n(7294),n(3905)),o=n(2328),l=n(3057),r=n(3389);const s={title:"Core",id:"Core"},d=void 0,c={unversionedId:"Core",id:"Core",title:"Core",description:"Description",source:"@site/docs/10-core.mdx",sourceDirName:".",slug:"/Core",permalink:"/binance4j/binance4j-documentation/docs/next/Core",draft:!1,editUrl:"https://github.com/binance4j/docs/10-core.mdx",tags:[],version:"current",sidebarPosition:10,frontMatter:{title:"Core",id:"Core"},sidebar:"tutorialSidebar",next:{title:"Connectors",permalink:"/binance4j/binance4j-documentation/docs/next/connectors"}},p={},u=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Rest client",id:"rest-client",level:2},{value:"Request",id:"request",level:2},{value:"Handling exceptions",id:"handling-exceptions",level:2},{value:"Params and Payload types",id:"params-and-payload-types",level:2}],m={toc:u};function k(e){let{components:t,...n}=e;return(0,i.kt)("wrapper",(0,a.Z)({},m,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)(l.ZP,{artifact:"core",mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"description"},"Description"),(0,i.kt)("p",null,"Binance4j-core is the core module of the binance4j ecosystem."),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(o.ZP,{repo:"core",mdxType:"ArtifactInstall"}),(0,i.kt)("h2",{id:"rest-client"},"Rest client"),(0,i.kt)("p",null,"Every REST client needs an ",(0,i.kt)("inlineCode",{parentName:"p"},"API key")," and a ",(0,i.kt)("inlineCode",{parentName:"p"},"secret key")," when instanciated."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="Client new instance"',title:'"Client',new:!0,'instance"':!0},"MarketClient client = new MarketClient(key, secret);\n")),(0,i.kt)("h2",{id:"request"},"Request"),(0,i.kt)("p",null,"The code above won't call the API. It returns an instance of a ",(0,i.kt)("inlineCode",{parentName:"p"},"Request")," that can make a ",(0,i.kt)("inlineCode",{parentName:"p"},"synchronous")," or ",(0,i.kt)("inlineCode",{parentName:"p"},"asynchronous")," call."),(0,i.kt)(r.ZP,{payload:"List<Candle>",method:"getKlines",items:[{params:"params"}],mdxType:"Examples"}),(0,i.kt)("h2",{id:"handling-exceptions"},"Handling exceptions"),(0,i.kt)("p",null,"As you can see in the example above, all exceptions are handled with ",(0,i.kt)("inlineCode",{parentName:"p"},"ApiException"),". Synchronous calls will throw an ",(0,i.kt)("inlineCode",{parentName:"p"},"ApiException")," and asynchronous calls will pass the exception to the ",(0,i.kt)("inlineCode",{parentName:"p"},"onFailure")," method of the ",(0,i.kt)("inlineCode",{parentName:"p"},"ApiCallback"),". Using a lambda in an async callback doesn't permir to handle such exception."),(0,i.kt)("h2",{id:"params-and-payload-types"},"Params and Payload types"),(0,i.kt)("p",null,"Every request param and payload are ",(0,i.kt)("inlineCode",{parentName:"p"},"Records"),". Records are immutable objects introduced in JDK 14. This is a major update compared to v1 where values could be modified. It should be considered bad practice to modify data sent by the API. Using Record helped reduce boilerplate code and get ride of third party ",(0,i.kt)("inlineCode",{parentName:"p"},"Lombok"),"."))}k.isMDXComponent=!0}}]);