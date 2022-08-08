"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[3173],{5652:(t,e,n)=>{n.r(e),n.d(e,{assets:()=>m,contentTitle:()=>l,default:()=>g,frontMatter:()=>d,metadata:()=>p,toc:()=>c});var i=n(7462),a=(n(7294),n(3905)),s=n(2106),o=n(6251),r=n(3389);const d={title:"NFT endpoints."},l=void 0,p={unversionedId:"nft",id:"version-2.x/nft",title:"NFT endpoints.",description:"Installation",source:"@site/versioned_docs/version-2.x/100-nft.mdx",sourceDirName:".",slug:"/nft",permalink:"/binance4j/binance4j-documentation/docs/nft",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-2.x/100-nft.mdx",tags:[],version:"2.x",sidebarPosition:100,frontMatter:{title:"NFT endpoints."},sidebar:"tutorialSidebar",previous:{title:"Mining endpoints",permalink:"/binance4j/binance4j-documentation/docs/mining"},next:{title:"Pay endpoints",permalink:"/binance4j/binance4j-documentation/docs/pay"}},m={},c=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Get NFT Transaction History",id:"get-nft-transaction-history",level:3},{value:"Get NFT deposit History",id:"get-nft-deposit-history",level:3},{value:"Get NFT withdraw History",id:"get-nft-withdraw-history",level:3},{value:"Get NFT assets",id:"get-nft-assets",level:3}],y={toc:c};function g(t){let{components:e,...n}=t;return(0,a.kt)("wrapper",(0,i.Z)({},y,n,{components:e,mdxType:"MDXLayout"}),(0,a.kt)(o.ZP,{artifact:"nft",mdxType:"RepoBadges"}),(0,a.kt)("h2",{id:"installation"},"Installation"),(0,a.kt)(s.ZP,{repo:"nft",mdxType:"ArtifactInstall"}),(0,a.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java"},"PortfolioMarginClient client = new PortfolioMarginClient(key, secret);\n")),(0,a.kt)("h3",{id:"get-nft-transaction-history"},"Get NFT Transaction History"),(0,a.kt)(r.ZP,{payload:"TransactionHistory",method:"getTransactions",items:[{params:"new TransactionHistoryParams(orderType)"},{label:"Paginated",params:"new TransactionHistoryParams(orderType), new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-nft-deposit-history"},"Get NFT deposit History"),(0,a.kt)(r.ZP,{payload:"DepositHistory",method:"getDeposits",items:[{},{label:"Paginated",params:"new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-nft-withdraw-history"},"Get NFT withdraw History"),(0,a.kt)(r.ZP,{payload:"WithdrawHistory",method:"getWithdraws",items:[{},{label:"Paginated",params:"new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-nft-assets"},"Get NFT assets"),(0,a.kt)(r.ZP,{payload:"WithdrawHistory",method:"getAssets",items:[{},{label:"Paginated",params:"Paging(page, limit)"}],mdxType:"Examples"}))}g.isMDXComponent=!0},2106:(t,e,n)=>{n.d(e,{ZP:()=>d});var i=n(7462),a=(n(7294),n(3905)),s=n(112),o=n(6867);const r={toc:[]};function d(t){let{components:e,...n}=t;return(0,a.kt)("wrapper",(0,i.Z)({},r,n,{components:e,mdxType:"MDXLayout"}),(0,a.kt)(s.Z,{repo:n.repo,version:o.i,mdxType:"InstallationInstructions"}))}d.isMDXComponent=!0},6251:(t,e,n)=>{n.d(e,{ZP:()=>d});var i=n(7462),a=(n(7294),n(3905)),s=n(8267),o=n(6867);const r={toc:[]};function d(t){let{components:e,...n}=t;return(0,a.kt)("wrapper",(0,i.Z)({},r,n,{components:e,mdxType:"MDXLayout"}),(0,a.kt)(s.Z,{artifact:n.artifact,version:o.i,mdxType:"RepoBadges"}))}d.isMDXComponent=!0},6867:t=>{t.exports={i:"2.0.5"}}}]);