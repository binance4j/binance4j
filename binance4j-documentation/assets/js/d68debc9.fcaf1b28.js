"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[3078],{523:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>p,contentTitle:()=>m,default:()=>k,frontMatter:()=>r,metadata:()=>d,toc:()=>c});var i=n(7462),a=(n(7294),n(3905)),o=n(2106),s=n(6251),l=n(3389);const r={title:"BLVT"},m=void 0,d={unversionedId:"endpoints/blvt",id:"version-2.x/endpoints/blvt",title:"BLVT",description:"Installation",source:"@site/versioned_docs/version-2.x/30-endpoints/20-blvt.mdx",sourceDirName:"30-endpoints",slug:"/endpoints/blvt",permalink:"/binance4j/binance4j-documentation/docs/2.x/endpoints/blvt",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-2.x/30-endpoints/20-blvt.mdx",tags:[],version:"2.x",sidebarPosition:20,frontMatter:{title:"BLVT"},sidebar:"tutorialSidebar",previous:{title:"Endpoints",permalink:"/binance4j/binance4j-documentation/docs/2.x/endpoints/"},next:{title:"C2C",permalink:"/binance4j/binance4j-documentation/docs/2.x/endpoints/c2c"}},p={},c=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Features",id:"features",level:2},{value:"Get token info",id:"get-token-info",level:3},{value:"Get subscriptions",id:"get-subscriptions",level:3},{value:"Get redemptions",id:"get-redemptions",level:3},{value:"Get user limit info",id:"get-user-limit-info",level:3},{value:"Redeem",id:"redeem",level:3},{value:"Subscribe",id:"subscribe",level:3}],u={toc:c};function k(e){let{components:t,...n}=e;return(0,a.kt)("wrapper",(0,i.Z)({},u,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)(s.ZP,{artifact:"blvt",mdxType:"RepoBadges"}),(0,a.kt)("h2",{id:"installation"},"Installation"),(0,a.kt)(o.ZP,{repo:"blvt",mdxType:"ArtifactInstall"}),(0,a.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java"},"BLVTClient client = new BLVTClient(key, secret);\n")),(0,a.kt)("h2",{id:"features"},"Features"),(0,a.kt)("h3",{id:"get-token-info"},"Get token info"),(0,a.kt)(l.ZP,{payload:"List<Token>",method:"getTokenInfo",items:[{label:"All tokens"},{label:"One token",params:"new TokenInfoParams(tokenName)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-subscriptions"},"Get subscriptions"),(0,a.kt)(l.ZP,{payload:"SubscriptionResponse",method:"getSubscriptions",items:[{label:"All tokens"},{label:"Specific token",params:"new TransactionRecordParams(tokenName)"},{label:"Framed results",params:"new TransactionRecordParams(tokenName), new TimeFrame(startTime,endTime,limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-redemptions"},"Get redemptions"),(0,a.kt)(l.ZP,{payload:"List<Redemption>",method:"getRedemptions",items:[{label:"All tokens"},{label:"Specific token",params:"new TransactionRecordParams(tokenName, subscriptionId)"},{label:"Framed results",params:"new TransactionRecordParams(tokenName, subscriptionId,new TimeFrame(startTime, endTime, limit))"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-user-limit-info"},"Get user limit info"),(0,a.kt)(l.ZP,{payload:"List<LimitInfo>",method:"getLimitInfo",items:[{label:"All tokens"},{label:"One token",params:"new LimitInfoParams(tokenName)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"redeem"},"Redeem"),(0,a.kt)(l.ZP,{payload:"RedemptionResponse",method:"redeem",items:[{label:"Default",params:"new RedemptionParams(tokenName, amount)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"subscribe"},"Subscribe"),(0,a.kt)(l.ZP,{payload:"SubscriptionResponse",method:"subscribe",items:[{label:"Default",params:"new SubscriptionParams(tokenName, cost)"}],mdxType:"Examples"}))}k.isMDXComponent=!0},2106:(e,t,n)=>{n.d(t,{ZP:()=>r});var i=n(7462),a=(n(7294),n(3905)),o=n(5884),s=n(6867);const l={toc:[]};function r(e){let{components:t,...n}=e;return(0,a.kt)("wrapper",(0,i.Z)({},l,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)(o.Z,{repo:n.repo,version:s.i,mdxType:"InstallationInstructions"}))}r.isMDXComponent=!0},6251:(e,t,n)=>{n.d(t,{ZP:()=>r});var i=n(7462),a=(n(7294),n(3905)),o=n(8267),s=n(6867);const l={toc:[]};function r(e){let{components:t,...n}=e;return(0,a.kt)("wrapper",(0,i.Z)({},l,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)(o.Z,{artifact:n.artifact,version:s.i,mdxType:"RepoBadges"}))}r.isMDXComponent=!0},6867:e=>{e.exports={i:"2.2.0"}}}]);