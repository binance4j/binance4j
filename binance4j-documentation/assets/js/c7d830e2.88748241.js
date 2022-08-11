"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[829],{4699:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>p,contentTitle:()=>c,default:()=>k,frontMatter:()=>l,metadata:()=>d,toc:()=>u});var a=n(7462),o=(n(7294),n(3905)),i=n(2328),r=n(9497),s=n(3389);const l={title:"Core"},c=void 0,d={unversionedId:"core/index",id:"core/index",title:"Core",description:"Description",source:"@site/docs/10-core/index.mdx",sourceDirName:"10-core",slug:"/core/",permalink:"/binance4j/binance4j-documentation/docs/core/",draft:!1,editUrl:"https://github.com/binance4j/binance4j/docs/10-core/index.mdx",tags:[],version:"current",frontMatter:{title:"Core"},sidebar:"tutorialSidebar",previous:{title:"Changelog",permalink:"/binance4j/binance4j-documentation/docs/changelog"},next:{title:"Connectors",permalink:"/binance4j/binance4j-documentation/docs/connectors/"}},p={},u=[{value:"Description",id:"description",level:2},{value:"Installation",id:"installation",level:2},{value:"Rest client",id:"rest-client",level:2},{value:"Request",id:"request",level:2},{value:"Handling exceptions",id:"handling-exceptions",level:2},{value:"Params and Payload types",id:"params-and-payload-types",level:2}],m={toc:u};function k(e){let{components:t,...n}=e;return(0,o.kt)("wrapper",(0,a.Z)({},m,n,{components:t,mdxType:"MDXLayout"}),(0,o.kt)(r.ZP,{artifact:"core",mdxType:"RepoBadges"}),(0,o.kt)("h2",{id:"description"},"Description"),(0,o.kt)("p",null,"Binance4j-core is the core module of the binance4j ecosystem."),(0,o.kt)("h2",{id:"installation"},"Installation"),(0,o.kt)(i.ZP,{repo:"core",mdxType:"ArtifactInstall"}),(0,o.kt)("h2",{id:"rest-client"},"Rest client"),(0,o.kt)("p",null,"Every REST client needs an ",(0,o.kt)("inlineCode",{parentName:"p"},"API key")," and a ",(0,o.kt)("inlineCode",{parentName:"p"},"secret key")," when instanciated."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="Client new instance"',title:'"Client',new:!0,'instance"':!0},"MarketClient client = new MarketClient(key, secret);\n")),(0,o.kt)("h2",{id:"request"},"Request"),(0,o.kt)("p",null,"The code above won't call the API. It returns an instance of a ",(0,o.kt)("inlineCode",{parentName:"p"},"Request")," that can make a ",(0,o.kt)("inlineCode",{parentName:"p"},"synchronous")," or ",(0,o.kt)("inlineCode",{parentName:"p"},"asynchronous")," call."),(0,o.kt)(s.ZP,{payload:"List<Candle>",method:"getKlines",items:[{params:"params"}],mdxType:"Examples"}),(0,o.kt)("h2",{id:"handling-exceptions"},"Handling exceptions"),(0,o.kt)("p",null,"As you can see in the example above, all exceptions are handled with ",(0,o.kt)("inlineCode",{parentName:"p"},"ApiException"),". Synchronous calls will throw an ",(0,o.kt)("inlineCode",{parentName:"p"},"ApiException")," and asynchronous calls will pass the exception as the second parameter."),(0,o.kt)("h2",{id:"params-and-payload-types"},"Params and Payload types"),(0,o.kt)("p",null,"Every request param and payload are ",(0,o.kt)("inlineCode",{parentName:"p"},"Records"),". Records are immutable objects introduced in JDK 14. This is a major update compared to v1 where values could be modified. It should be considered bad practice to modify data sent by the API. Using Record helped reduce boilerplate code and get ride of third party ",(0,o.kt)("inlineCode",{parentName:"p"},"Lombok"),"."))}k.isMDXComponent=!0},2328:(e,t,n)=>{n.d(t,{ZP:()=>l});var a=n(7462),o=(n(7294),n(3905)),i=n(5884),r=n(8306);const s={toc:[]};function l(e){let{components:t,...n}=e;return(0,o.kt)("wrapper",(0,a.Z)({},s,n,{components:t,mdxType:"MDXLayout"}),(0,o.kt)(i.Z,{repo:n.repo,version:r.i,mdxType:"InstallationInstructions"}))}l.isMDXComponent=!0},9497:(e,t,n)=>{n.d(t,{ZP:()=>l});var a=n(7462),o=(n(7294),n(3905)),i=n(8267),r=n(8306);const s={toc:[]};function l(e){let{components:t,...n}=e;return(0,o.kt)("wrapper",(0,a.Z)({},s,n,{components:t,mdxType:"MDXLayout"}),(0,o.kt)(i.Z,{artifact:n.artifact,version:r.i,mdxType:"RepoBadges"}))}l.isMDXComponent=!0},8306:e=>{e.exports={i:"2.1.1"}}}]);