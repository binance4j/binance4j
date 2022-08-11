"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[9672],{7136:(t,e,n)=>{n.r(e),n.d(e,{assets:()=>c,contentTitle:()=>d,default:()=>y,frontMatter:()=>l,metadata:()=>p,toc:()=>m});var a=n(7462),i=(n(7294),n(3905)),s=n(2106),o=n(6251),r=n(3389);const l={title:"Fiat"},d=void 0,p={unversionedId:"endpoints/fiat",id:"version-2.x/endpoints/fiat",title:"Fiat",description:"Installation",source:"@site/versioned_docs/version-2.x/30-endpoints/50-fiat.mdx",sourceDirName:"30-endpoints",slug:"/endpoints/fiat",permalink:"/binance4j/binance4j-documentation/docs/endpoints/fiat",draft:!1,editUrl:"https://github.com/binance4j/binance4j/versioned_docs/version-2.x/30-endpoints/50-fiat.mdx",tags:[],version:"2.x",sidebarPosition:50,frontMatter:{title:"Fiat"},sidebar:"tutorialSidebar",previous:{title:"Convert",permalink:"/binance4j/binance4j-documentation/docs/endpoints/convert"},next:{title:"Loan",permalink:"/binance4j/binance4j-documentation/docs/endpoints/loan"}},c={},m=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Features",id:"features",level:2},{value:"Get payments",id:"get-payments",level:3},{value:"Get Transactions",id:"get-transactions",level:3}],u={toc:m};function y(t){let{components:e,...n}=t;return(0,i.kt)("wrapper",(0,a.Z)({},u,n,{components:e,mdxType:"MDXLayout"}),(0,i.kt)(o.ZP,{artifact:"fiat",mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(s.ZP,{repo:"fiat",mdxType:"ArtifactInstall"}),(0,i.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"FiatClient client = new FiatClient(key, secret);\n")),(0,i.kt)("h2",{id:"features"},"Features"),(0,i.kt)("h3",{id:"get-payments"},"Get payments"),(0,i.kt)(r.ZP,{payload:"PaymentHistory",method:"getPayments",items:[{label:"Sales",params:"new PaymentParams(PaymentType.SELL)"},{label:"Purchases (paginated)",params:'new PaymentParams("BUY"), new FramedPaging(startTime, endTime, page, limit)'}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-transactions"},"Get Transactions"),(0,i.kt)(r.ZP,{payload:"TransactionHistory",method:"getTransactions",items:[{label:"Withdraws",params:"new TransactionParams(TransactionType.WITHDRAW)"},{label:"Deposits (paginated)",params:'new TransactionParams("DEPOSIT"), new FramedPaging(startTime, endTime, page, limit)'}],mdxType:"Examples"}))}y.isMDXComponent=!0},2106:(t,e,n)=>{n.d(e,{ZP:()=>l});var a=n(7462),i=(n(7294),n(3905)),s=n(5884),o=n(6867);const r={toc:[]};function l(t){let{components:e,...n}=t;return(0,i.kt)("wrapper",(0,a.Z)({},r,n,{components:e,mdxType:"MDXLayout"}),(0,i.kt)(s.Z,{repo:n.repo,version:o.i,mdxType:"InstallationInstructions"}))}l.isMDXComponent=!0},6251:(t,e,n)=>{n.d(e,{ZP:()=>l});var a=n(7462),i=(n(7294),n(3905)),s=n(8267),o=n(6867);const r={toc:[]};function l(t){let{components:e,...n}=t;return(0,i.kt)("wrapper",(0,a.Z)({},r,n,{components:e,mdxType:"MDXLayout"}),(0,i.kt)(s.Z,{artifact:n.artifact,version:o.i,mdxType:"RepoBadges"}))}l.isMDXComponent=!0},6867:t=>{t.exports={i:"2.2.0"}}}]);