"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[4360],{7213:(t,e,n)=>{n.r(e),n.d(e,{assets:()=>m,contentTitle:()=>l,default:()=>u,frontMatter:()=>d,metadata:()=>p,toc:()=>c});var i=n(7462),a=(n(7294),n(3905)),s=n(2328),o=n(9497),r=n(3389);const d={title:"NFT"},l=void 0,p={unversionedId:"endpoints/nft",id:"endpoints/nft",title:"NFT",description:"Installation",source:"@site/docs/30-endpoints/100-nft.mdx",sourceDirName:"30-endpoints",slug:"/endpoints/nft",permalink:"/binance4j/binance4j-documentation/docs/endpoints/nft",draft:!1,editUrl:"https://github.com/binance4j/binance4j/docs/30-endpoints/100-nft.mdx",tags:[],version:"current",sidebarPosition:100,frontMatter:{title:"NFT"},sidebar:"tutorialSidebar",previous:{title:"Mining",permalink:"/binance4j/binance4j-documentation/docs/endpoints/mining"},next:{title:"Pay",permalink:"/binance4j/binance4j-documentation/docs/endpoints/pay"}},m={},c=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Get NFT Transaction History",id:"get-nft-transaction-history",level:3},{value:"Get NFT deposit History",id:"get-nft-deposit-history",level:3},{value:"Get NFT withdraw History",id:"get-nft-withdraw-history",level:3},{value:"Get NFT assets",id:"get-nft-assets",level:3}],y={toc:c};function u(t){let{components:e,...n}=t;return(0,a.kt)("wrapper",(0,i.Z)({},y,n,{components:e,mdxType:"MDXLayout"}),(0,a.kt)(o.ZP,{artifact:"nft",mdxType:"RepoBadges"}),(0,a.kt)("h2",{id:"installation"},"Installation"),(0,a.kt)(s.ZP,{repo:"nft",mdxType:"ArtifactInstall"}),(0,a.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java"},"PortfolioMarginClient client = new PortfolioMarginClient(key, secret);\n")),(0,a.kt)("h3",{id:"get-nft-transaction-history"},"Get NFT Transaction History"),(0,a.kt)(r.ZP,{payload:"TransactionHistory",method:"getTransactions",items:[{params:"new TransactionHistoryParams(orderType)"},{label:"Paginated",params:"new TransactionHistoryParams(orderType), new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-nft-deposit-history"},"Get NFT deposit History"),(0,a.kt)(r.ZP,{payload:"DepositHistory",method:"getDeposits",items:[{},{label:"Paginated",params:"new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-nft-withdraw-history"},"Get NFT withdraw History"),(0,a.kt)(r.ZP,{payload:"WithdrawHistory",method:"getWithdraws",items:[{},{label:"Paginated",params:"new FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,a.kt)("h3",{id:"get-nft-assets"},"Get NFT assets"),(0,a.kt)(r.ZP,{payload:"WithdrawHistory",method:"getAssets",items:[{},{label:"Paginated",params:"Paging(page, limit)"}],mdxType:"Examples"}))}u.isMDXComponent=!0},2328:(t,e,n)=>{n.d(e,{ZP:()=>d});var i=n(7462),a=(n(7294),n(3905)),s=n(5884),o=n(8306);const r={toc:[]};function d(t){let{components:e,...n}=t;return(0,a.kt)("wrapper",(0,i.Z)({},r,n,{components:e,mdxType:"MDXLayout"}),(0,a.kt)(s.Z,{repo:n.repo,version:o.i,mdxType:"InstallationInstructions"}))}d.isMDXComponent=!0},9497:(t,e,n)=>{n.d(e,{ZP:()=>d});var i=n(7462),a=(n(7294),n(3905)),s=n(8267),o=n(8306);const r={toc:[]};function d(t){let{components:e,...n}=t;return(0,a.kt)("wrapper",(0,i.Z)({},r,n,{components:e,mdxType:"MDXLayout"}),(0,a.kt)(s.Z,{artifact:n.artifact,version:o.i,mdxType:"RepoBadges"}))}d.isMDXComponent=!0},8306:t=>{t.exports={i:"2.1.1"}}}]);