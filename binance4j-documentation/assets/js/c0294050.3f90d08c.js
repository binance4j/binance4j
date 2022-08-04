"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[7289],{542:(t,e,a)=>{a.r(e),a.d(e,{assets:()=>p,contentTitle:()=>d,default:()=>y,frontMatter:()=>r,metadata:()=>m,toc:()=>c});var n=a(7462),i=(a(7294),a(3905)),s=a(2328),o=a(9497),l=a(3389);const r={title:"Fiat endpoints"},d=void 0,m={unversionedId:"fiat",id:"fiat",title:"Fiat endpoints",description:"Installation",source:"@site/docs/50-fiat.mdx",sourceDirName:".",slug:"/fiat",permalink:"/binance4j/binance4j-documentation/docs/next/fiat",draft:!1,editUrl:"https://github.com/binance4j/docs/50-fiat.mdx",tags:[],version:"current",sidebarPosition:50,frontMatter:{title:"Fiat endpoints"},sidebar:"tutorialSidebar",previous:{title:"Convert endpoints",permalink:"/binance4j/binance4j-documentation/docs/next/convert"},next:{title:"Loan endpoints",permalink:"/binance4j/binance4j-documentation/docs/next/loan"}},p={},c=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Examples",id:"examples",level:2},{value:"Get payments",id:"get-payments",level:3},{value:"Get Transactions",id:"get-transactions",level:3}],u={toc:c};function y(t){let{components:e,...a}=t;return(0,i.kt)("wrapper",(0,n.Z)({},u,a,{components:e,mdxType:"MDXLayout"}),(0,i.kt)(o.ZP,{artifact:"fiat",mdxType:"RepoBadges"}),(0,i.kt)("h2",{id:"installation"},"Installation"),(0,i.kt)(s.ZP,{repo:"fiat",mdxType:"ArtifactInstall"}),(0,i.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-java"},"FiatClient client = new FiatClient(key, secret);\n")),(0,i.kt)("h2",{id:"examples"},"Examples"),(0,i.kt)("h3",{id:"get-payments"},"Get payments"),(0,i.kt)(l.ZP,{payload:"PaymentHistory",method:"getPayments",items:[{label:"Sales",params:"new PaymentParams(PaymentType.SELL)"},{label:"Purchases (paginated)",params:'new PaymentParams("BUY"), new FramedPaging(startTime, endTime, page, limit)'}],mdxType:"Examples"}),(0,i.kt)("h3",{id:"get-transactions"},"Get Transactions"),(0,i.kt)(l.ZP,{payload:"TransactionHistory",method:"getTransactions",items:[{label:"Withdraws",params:"new TransactionParams(TransactionType.WITHDRAW)"},{label:"Deposits (paginated)",params:'new TransactionParams("DEPOSIT"), new FramedPaging(startTime, endTime, page, limit)'}],mdxType:"Examples"}))}y.isMDXComponent=!0}}]);