"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[5277],{5126:(e,a,t)=>{t.r(a),t.d(a,{assets:()=>d,contentTitle:()=>o,default:()=>h,frontMatter:()=>r,metadata:()=>m,toc:()=>c});var s=t(7462),i=(t(7294),t(3905)),n=(t(2328),t(3057)),l=t(3389);const r={title:"Mining endpoints"},o=void 0,m={unversionedId:"mining",id:"mining",title:"Mining endpoints",description:"Installation",source:"@site/docs/90-mining.mdx",sourceDirName:".",slug:"/mining",permalink:"/binance4j/binance4j-documentation/docs/next/mining",draft:!1,editUrl:"https://github.com/binance4j/docs/90-mining.mdx",tags:[],version:"current",sidebarPosition:90,frontMatter:{title:"Mining endpoints"},sidebar:"tutorialSidebar",previous:{title:"Market endpoints",permalink:"/binance4j/binance4j-documentation/docs/next/market"},next:{title:"NFT endpoints.",permalink:"/binance4j/binance4j-documentation/docs/next/nft"}},d={},c=[{value:"Installation",id:"installation",level:2},{value:"Features",id:"features",level:2},{value:"Get accounts",id:"get-accounts",level:3},{value:"Get algorithms",id:"get-algorithms",level:3},{value:"Get coins",id:"get-coins",level:3},{value:"Get statistics",id:"get-statistics",level:3},{value:"Resell hasrate",id:"resell-hasrate",level:3},{value:"Cancel hashrate resale configuration",id:"cancel-hashrate-resale-configuration",level:3},{value:"Get earnings list",id:"get-earnings-list",level:3},{value:"Get extra bonus list.",id:"get-extra-bonus-list",level:3},{value:"Get mining account earning",id:"get-mining-account-earning",level:3},{value:"Get hashrate resale list",id:"get-hashrate-resale-list",level:3},{value:"Get hashrate resale detail",id:"get-hashrate-resale-detail",level:3},{value:"Get miners list",id:"get-miners-list",level:3},{value:"Get miners details list",id:"get-miners-details-list",level:3}],p=(g="InstallationInstructions",function(e){return console.warn("Component "+g+" was not imported, exported, or provided by MDXProvider as global scope"),(0,i.kt)("div",e)});var g;const u={toc:c};function h(e){let{components:a,...t}=e;return(0,i.kt)("wrapper",(0,s.Z)({},u,t,{components:a,mdxType:"MDXLayout"}),(0,i.kt)(n.ZP,{artifact:"mining",mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(p,{repo:"mining",mdxType:"InstallationInstructions"}),(0,i.kt)("h2",{id:"features"},"Features"),(0,i.kt)("h3",{id:"get-accounts"},"Get accounts"),(0,i.kt)(l.ZP,{payload:"AccountListResponse",method:"getAccounts",items:[{params:"new AccountListParams(algo, userName)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-algorithms"},"Get algorithms"),(0,i.kt)(l.ZP,{payload:"AlgorithmsResponse",method:"getAlgorithms",items:[{}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-coins"},"Get coins"),(0,i.kt)(l.ZP,{payload:"CoinsResponse",method:"getCoins",items:[{}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-statistics"},"Get statistics"),(0,i.kt)(l.ZP,{payload:"StatisticsResponse",method:"getStatistics",items:[{params:"new StatisticsParams(aldo, userName)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"resell-hasrate"},"Resell hasrate"),(0,i.kt)(l.ZP,{payload:"HashrateResaleResponse",method:"resellHashrate",items:[{params:"new HashrateResaleParams(userName, algo, startTime, endTime, userName, hashrate)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"cancel-hashrate-resale-configuration"},"Cancel hashrate resale configuration"),(0,i.kt)(l.ZP,{payload:"HashrateResaleCancellationResponse",method:"cancelHashrateResaleConfiguration",items:[{params:"new HashrateResaleCancellationParams(configId, userName)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-earnings-list"},"Get earnings list"),(0,i.kt)(l.ZP,{payload:"ProfitResponse",method:"getProfits",items:[{params:"new ProfitsParams(sha256, userName), new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-extra-bonus-list"},"Get extra bonus list."),(0,i.kt)(l.ZP,{payload:"OtherProfitsResponse",method:"getOtherProfits",items:[{params:"new ProfitsParams(sha256, userName), new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-mining-account-earning"},"Get mining account earning"),(0,i.kt)(l.ZP,{payload:"AccountProfitsResponse",method:"getAccountProfits",items:[{label:"Default",params:"new AccountProfitsParams(algo, userName)"},{label:"Paginated",params:"new AccountProfitsParams(algo, userName), new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-hashrate-resale-list"},"Get hashrate resale list"),(0,i.kt)(l.ZP,{payload:"HashrateResaleListResponse",method:"getHashrateResales",items:[{label:"Default"},{label:"Framed",params:"new TimeFrame(startTime, endTime, limit)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-hashrate-resale-detail"},"Get hashrate resale detail"),(0,i.kt)(l.ZP,{payload:"HashrateResaleDetailResponse",method:"getHashrateResalesDetails",items:[{label:"Default",params:"new HashrateResaleDetailParam(configId, userName)"},{label:"Framed",params:"new HashrateResaleDetailParam(configId, userName),new TimeFrame(startTime, endTime, limit)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-miners-list"},"Get miners list"),(0,i.kt)(l.ZP,{payload:"WorkersResponse",method:"getMiners",items:[{label:"Default",params:"new MinersParams(algo, userName)"}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-miners-details-list"},"Get miners details list"),(0,i.kt)(l.ZP,{payload:"MinerDetailsResponse",method:"getMinersDetails",items:[{label:"Default",params:"new MinerDetailsParams(algo, userName, workerName)"}],mdxType:"Examples"}))}h.isMDXComponent=!0}}]);