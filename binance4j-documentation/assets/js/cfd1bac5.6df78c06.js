"use strict";(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[9259],{7342:(t,e,a)=>{a.r(e),a.d(e,{assets:()=>u,contentTitle:()=>l,default:()=>m,frontMatter:()=>r,metadata:()=>p,toc:()=>c});var i=a(7462),o=(a(7294),a(3905)),n=a(2328),s=a(9497),d=a(3389);const r={title:"Staking endpoints"},l=void 0,p={unversionedId:"staking",id:"version-2.x/staking",title:"Staking endpoints",description:"Installation",source:"@site/versioned_docs/version-2.x/160-staking.mdx",sourceDirName:".",slug:"/staking",permalink:"/binance4j/binance4j-documentation/docs/staking",draft:!1,editUrl:"https://github.com/binance4j/versioned_docs/version-2.x/160-staking.mdx",tags:[],version:"2.x",sidebarPosition:160,frontMatter:{title:"Staking endpoints"},sidebar:"tutorialSidebar",previous:{title:"Spot endpoints",permalink:"/binance4j/binance4j-documentation/docs/spot"},next:{title:"Public data endpoints",permalink:"/binance4j/binance4j-documentation/docs/vision"}},u={},c=[{value:"Installation",id:"installation",level:2},{value:"Client instantiation",id:"client-instantiation",level:2},{value:"Features",id:"features",level:2},{value:"Get staking history",id:"get-staking-history",level:3},{value:"Get personal left quota of Staking product",id:"get-personal-left-quota-of-staking-product",level:3},{value:"Get Staking product position.",id:"get-staking-product-position",level:3},{value:"Purchase Staking product",id:"purchase-staking-product",level:3},{value:"Redeem Staking product",id:"redeem-staking-product",level:3},{value:"Set auto staking on Locked Staking or Locked DeFi Staking",id:"set-auto-staking-on-locked-staking-or-locked-defi-staking",level:3}],k={toc:c};function m(t){let{components:e,...a}=t;return(0,o.kt)("wrapper",(0,i.Z)({},k,a,{components:e,mdxType:"MDXLayout"}),(0,o.kt)(s.ZP,{artifact:"staking",mdxType:"RepoBadges"}),(0,o.kt)("h2",{id:"installation"},"Installation"),(0,o.kt)(n.ZP,{repo:"staking",mdxType:"ArtifactInstall"}),(0,o.kt)("h2",{id:"client-instantiation"},"Client instantiation"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},"StakingClient client = new StakingClient(key, secret);\n")),(0,o.kt)("h2",{id:"features"},"Features"),(0,o.kt)("h3",{id:"get-staking-history"},"Get staking history"),(0,o.kt)(d.ZP,{payload:"List<StakingRecord>",method:"getHistory",items:[{label:"Default",params:"new HistoryParams(ProductType.STAKING, TransactionType.INTEREST, asset)"},{label:"Paginated",params:"new HistoryParams(ProductType.STAKING, TransactionType.INTEREST, asset), FramedPaging(startTime, endTime, page, limit)"}],mdxType:"Examples"}),(0,o.kt)("h3",{id:"get-personal-left-quota-of-staking-product"},"Get personal left quota of Staking product"),(0,o.kt)(d.ZP,{payload:"LeftQuota",method:"getLeftQuota",items:[{label:"Default",params:"new LeftQuotaParams(ProductType.STAKING, productId)"}],mdxType:"Examples"}),(0,o.kt)("h3",{id:"get-staking-product-position"},"Get Staking product position."),(0,o.kt)(d.ZP,{payload:"List<ProductPosition>",method:"getPosition",items:[{label:"Staking",params:"new PositionParams(ProductType.STAKING)"},{label:"Flexible DeFi",params:"new PositionParams(ProductType.F_DEFI)"},{label:"Locked DeFi",params:"new PositionParams(ProductType.L_DEFI)"}],mdxType:"Examples"}),(0,o.kt)("h3",{id:"purchase-staking-product"},"Purchase Staking product"),(0,o.kt)(d.ZP,{payload:"PurchaseResponse",method:"purchase",items:[{label:"Staking product",params:"new PurchaseParams(ProductType.STAKING, productId, amount)"},{label:"Flexible DeFi product",params:"new PurchaseParams(ProductType.F_DEFI, productId, amount)"},{label:"Locked DeFi product",params:"new PurchaseParams(ProductType.L_DEFI, productId, amount)"}],mdxType:"Examples"}),(0,o.kt)("h3",{id:"redeem-staking-product"},"Redeem Staking product"),(0,o.kt)(d.ZP,{payload:"RedeemResponse",method:"redeem",items:[{label:"Staking product",params:"new RedeemParams(ProductType.STAKING, productId)"},{label:"Flexible DeFi product",params:"new RedeemParams(ProductType.F_DEFI, productId)"},{label:"Locked DeFi product",params:"new RedeemParams(ProductType.L_DEFI, productId)"}],mdxType:"Examples"}),(0,o.kt)("h3",{id:"set-auto-staking-on-locked-staking-or-locked-defi-staking"},"Set auto staking on Locked Staking or Locked DeFi Staking"),(0,o.kt)(d.ZP,{payload:"AutoStakingResponse",method:"setAutoStaking",items:[{params:"new AutoStakingParams(ProductType.STAKING, productId, true/false)"}],mdxType:"Examples"}))}m.isMDXComponent=!0}}]);