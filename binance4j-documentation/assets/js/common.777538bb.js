(self.webpackChunkdocusaurus=self.webpackChunkdocusaurus||[]).push([[8592],{3905:(e,t,n)=>{"use strict";n.d(t,{Zo:()=>u,kt:()=>m});var a=n(7294);function o(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function r(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function c(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?r(Object(n),!0).forEach((function(t){o(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function i(e,t){if(null==e)return{};var n,a,o=function(e,t){if(null==e)return{};var n,a,o={},r=Object.keys(e);for(a=0;a<r.length;a++)n=r[a],t.indexOf(n)>=0||(o[n]=e[n]);return o}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(a=0;a<r.length;a++)n=r[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var s=a.createContext({}),l=function(e){var t=a.useContext(s),n=t;return e&&(n="function"==typeof e?e(t):c(c({},t),e)),n},u=function(e){var t=l(e.components);return a.createElement(s.Provider,{value:t},e.children)},d={inlineCode:"code",wrapper:function(e){var t=e.children;return a.createElement(a.Fragment,{},t)}},p=a.forwardRef((function(e,t){var n=e.components,o=e.mdxType,r=e.originalType,s=e.parentName,u=i(e,["components","mdxType","originalType","parentName"]),p=l(n),m=o,g=p["".concat(s,".").concat(m)]||p[m]||d[m]||r;return n?a.createElement(g,c(c({ref:t},u),{},{components:n})):a.createElement(g,c({ref:t},u))}));function m(e,t){var n=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var r=n.length,c=new Array(r);c[0]=p;var i={};for(var s in t)hasOwnProperty.call(t,s)&&(i[s]=t[s]);i.originalType=e,i.mdxType="string"==typeof e?e:o,c[1]=i;for(var l=2;l<r;l++)c[l]=n[l];return a.createElement.apply(null,c)}return a.createElement.apply(null,n)}p.displayName="MDXCreateElement"},814:(e,t,n)=>{"use strict";n.d(t,{Z:()=>q});var a=n(7462),o=n(7294),r=n(2389),c=n(6010),i=n(2949),s=n(6668);function l(){const{prism:e}=(0,s.L)(),{colorMode:t}=(0,i.I)(),n=e.theme,a=e.darkTheme||n;return"dark"===t?a:n}var u=n(5281),d=n(7594),p=n.n(d);const m=/title=(?<quote>["'])(?<title>.*?)\1/,g=/\{(?<range>[\d,-]+)\}/,b={js:{start:"\\/\\/",end:""},jsBlock:{start:"\\/\\*",end:"\\*\\/"},jsx:{start:"\\{\\s*\\/\\*",end:"\\*\\/\\s*\\}"},bash:{start:"#",end:""},html:{start:"\x3c!--",end:"--\x3e"}};function f(e,t){const n=e.map((e=>{const{start:n,end:a}=b[e];return"(?:"+n+"\\s*("+t.flatMap((e=>{var t,n;return[e.line,null==(t=e.block)?void 0:t.start,null==(n=e.block)?void 0:n.end].filter(Boolean)})).join("|")+")\\s*"+a+")"})).join("|");return new RegExp("^\\s*(?:"+n+")\\s*$")}function v(e,t){let n=e.replace(/\n$/,"");const{language:a,magicComments:o,metastring:r}=t;if(r&&g.test(r)){const e=r.match(g).groups.range;if(0===o.length)throw new Error("A highlight range has been given in code block's metastring (``` "+r+"), but no magic comment config is available. Docusaurus applies the first magic comment entry's className for metastring ranges.");const t=o[0].className,a=p()(e).filter((e=>e>0)).map((e=>[e-1,[t]]));return{lineClassNames:Object.fromEntries(a),code:n}}if(void 0===a)return{lineClassNames:{},code:n};const c=function(e,t){switch(e){case"js":case"javascript":case"ts":case"typescript":return f(["js","jsBlock"],t);case"jsx":case"tsx":return f(["js","jsBlock","jsx"],t);case"html":return f(["js","jsBlock","html"],t);case"python":case"py":case"bash":return f(["bash"],t);case"markdown":case"md":return f(["html","jsx","bash"],t);default:return f(Object.keys(b),t)}}(a,o),i=n.split("\n"),s=Object.fromEntries(o.map((e=>[e.className,{start:0,range:""}]))),l=Object.fromEntries(o.filter((e=>e.line)).map((e=>{let{className:t,line:n}=e;return[n,t]}))),u=Object.fromEntries(o.filter((e=>e.block)).map((e=>{let{className:t,block:n}=e;return[n.start,t]}))),d=Object.fromEntries(o.filter((e=>e.block)).map((e=>{let{className:t,block:n}=e;return[n.end,t]})));for(let p=0;p<i.length;){const e=i[p].match(c);if(!e){p+=1;continue}const t=e.slice(1).find((e=>void 0!==e));l[t]?s[l[t]].range+=p+",":u[t]?s[u[t]].start=p:d[t]&&(s[d[t]].range+=s[d[t]].start+"-"+(p-1)+","),i.splice(p,1)}n=i.join("\n");const m={};return Object.entries(s).forEach((e=>{let[t,{range:n}]=e;p()(n).forEach((e=>{null!=m[e]||(m[e]=[]),m[e].push(t)}))})),{lineClassNames:m,code:n}}const y="codeBlockContainer_Ckt0";function h(e){let{as:t,...n}=e;const r=function(e){const t={color:"--prism-color",backgroundColor:"--prism-background-color"},n={};return Object.entries(e.plain).forEach((e=>{let[a,o]=e;const r=t[a];r&&"string"==typeof o&&(n[r]=o)})),n}(l());return o.createElement(t,(0,a.Z)({},n,{style:r,className:(0,c.Z)(n.className,y,u.k.common.codeBlock)}))}const k={codeBlockContent:"codeBlockContent_biex",codeBlockTitle:"codeBlockTitle_Ktv7",codeBlock:"codeBlock_bY9V",codeBlockStandalone:"codeBlockStandalone_MEMb",codeBlockLines:"codeBlockLines_e6Vv",codeBlockLinesWithNumbering:"codeBlockLinesWithNumbering_o6Pm",buttonGroup:"buttonGroup__atx"};function j(e){let{children:t,className:n}=e;return o.createElement(h,{as:"pre",tabIndex:0,className:(0,c.Z)(k.codeBlockStandalone,"thin-scrollbar",n)},o.createElement("code",{className:k.codeBlockLines},t))}var E=n(902);const w={attributes:!0,characterData:!0,childList:!0,subtree:!0};function N(e,t){const[n,a]=(0,o.useState)(),r=(0,o.useCallback)((()=>{var t;a(null==(t=e.current)?void 0:t.closest("[role=tabpanel][hidden]"))}),[e,a]);(0,o.useEffect)((()=>{r()}),[r]),function(e,t,n){void 0===n&&(n=w);const a=(0,E.zX)(t),r=(0,E.Ql)(n);(0,o.useEffect)((()=>{const t=new MutationObserver(a);return e&&t.observe(e,r),()=>t.disconnect()}),[e,a,r])}(n,(e=>{e.forEach((e=>{"attributes"===e.type&&"hidden"===e.attributeName&&(t(),r())}))}),{attributes:!0,characterData:!1,childList:!1,subtree:!1})}const I={plain:{backgroundColor:"#2a2734",color:"#9a86fd"},styles:[{types:["comment","prolog","doctype","cdata","punctuation"],style:{color:"#6c6783"}},{types:["namespace"],style:{opacity:.7}},{types:["tag","operator","number"],style:{color:"#e09142"}},{types:["property","function"],style:{color:"#9a86fd"}},{types:["tag-id","selector","atrule-id"],style:{color:"#eeebff"}},{types:["attr-name"],style:{color:"#c4b9fe"}},{types:["boolean","string","entity","url","attr-value","keyword","control","directive","unit","statement","regex","atrule","placeholder","variable"],style:{color:"#ffcc99"}},{types:["deleted"],style:{textDecorationLine:"line-through"}},{types:["inserted"],style:{textDecorationLine:"underline"}},{types:["italic"],style:{fontStyle:"italic"}},{types:["important","bold"],style:{fontWeight:"bold"}},{types:["important"],style:{color:"#c4b9fe"}}]};var B={Prism:n(7410).Z,theme:I};function C(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function T(){return T=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var a in n)Object.prototype.hasOwnProperty.call(n,a)&&(e[a]=n[a])}return e},T.apply(this,arguments)}var O=/\r\n|\r|\n/,L=function(e){0===e.length?e.push({types:["plain"],content:"\n",empty:!0}):1===e.length&&""===e[0].content&&(e[0].content="\n",e[0].empty=!0)},S=function(e,t){var n=e.length;return n>0&&e[n-1]===t?e:e.concat(t)},Z=function(e,t){var n=e.plain,a=Object.create(null),o=e.styles.reduce((function(e,n){var a=n.languages,o=n.style;return a&&!a.includes(t)||n.types.forEach((function(t){var n=T({},e[t],o);e[t]=n})),e}),a);return o.root=n,o.plain=T({},n,{backgroundColor:null}),o};function x(e,t){var n={};for(var a in e)Object.prototype.hasOwnProperty.call(e,a)&&-1===t.indexOf(a)&&(n[a]=e[a]);return n}const P=function(e){function t(){for(var t=this,n=[],a=arguments.length;a--;)n[a]=arguments[a];e.apply(this,n),C(this,"getThemeDict",(function(e){if(void 0!==t.themeDict&&e.theme===t.prevTheme&&e.language===t.prevLanguage)return t.themeDict;t.prevTheme=e.theme,t.prevLanguage=e.language;var n=e.theme?Z(e.theme,e.language):void 0;return t.themeDict=n})),C(this,"getLineProps",(function(e){var n=e.key,a=e.className,o=e.style,r=T({},x(e,["key","className","style","line"]),{className:"token-line",style:void 0,key:void 0}),c=t.getThemeDict(t.props);return void 0!==c&&(r.style=c.plain),void 0!==o&&(r.style=void 0!==r.style?T({},r.style,o):o),void 0!==n&&(r.key=n),a&&(r.className+=" "+a),r})),C(this,"getStyleForToken",(function(e){var n=e.types,a=e.empty,o=n.length,r=t.getThemeDict(t.props);if(void 0!==r){if(1===o&&"plain"===n[0])return a?{display:"inline-block"}:void 0;if(1===o&&!a)return r[n[0]];var c=a?{display:"inline-block"}:{},i=n.map((function(e){return r[e]}));return Object.assign.apply(Object,[c].concat(i))}})),C(this,"getTokenProps",(function(e){var n=e.key,a=e.className,o=e.style,r=e.token,c=T({},x(e,["key","className","style","token"]),{className:"token "+r.types.join(" "),children:r.content,style:t.getStyleForToken(r),key:void 0});return void 0!==o&&(c.style=void 0!==c.style?T({},c.style,o):o),void 0!==n&&(c.key=n),a&&(c.className+=" "+a),c})),C(this,"tokenize",(function(e,t,n,a){var o={code:t,grammar:n,language:a,tokens:[]};e.hooks.run("before-tokenize",o);var r=o.tokens=e.tokenize(o.code,o.grammar,o.language);return e.hooks.run("after-tokenize",o),r}))}return e&&(t.__proto__=e),t.prototype=Object.create(e&&e.prototype),t.prototype.constructor=t,t.prototype.render=function(){var e=this.props,t=e.Prism,n=e.language,a=e.code,o=e.children,r=this.getThemeDict(this.props),c=t.languages[n];return o({tokens:function(e){for(var t=[[]],n=[e],a=[0],o=[e.length],r=0,c=0,i=[],s=[i];c>-1;){for(;(r=a[c]++)<o[c];){var l=void 0,u=t[c],d=n[c][r];if("string"==typeof d?(u=c>0?u:["plain"],l=d):(u=S(u,d.type),d.alias&&(u=S(u,d.alias)),l=d.content),"string"==typeof l){var p=l.split(O),m=p.length;i.push({types:u,content:p[0]});for(var g=1;g<m;g++)L(i),s.push(i=[]),i.push({types:u,content:p[g]})}else c++,t.push(u),n.push(l),a.push(0),o.push(l.length)}c--,t.pop(),n.pop(),a.pop(),o.pop()}return L(i),s}(void 0!==c?this.tokenize(t,a,c,n):[a]),className:"prism-code language-"+n,style:void 0!==r?r.root:{},getLineProps:this.getLineProps,getTokenProps:this.getTokenProps})},t}(o.Component),_="codeLine_lJS_",A="codeLineNumber_Tfdd",D="codeLineContent_feaV";function M(e){let{line:t,classNames:n,showLineNumbers:r,getLineProps:i,getTokenProps:s}=e;1===t.length&&"\n"===t[0].content&&(t[0].content="");const l=i({line:t,className:(0,c.Z)(n,r&&_)}),u=t.map(((e,t)=>o.createElement("span",(0,a.Z)({key:t},s({token:e,key:t})))));return o.createElement("span",l,r?o.createElement(o.Fragment,null,o.createElement("span",{className:A}),o.createElement("span",{className:D},u)):o.createElement(o.Fragment,null,u,o.createElement("br",null)))}var V=n(5999);const F={copyButtonCopied:"copyButtonCopied_obH4",copyButtonIcons:"copyButtonIcons_eSgA",copyButtonIcon:"copyButtonIcon_y97N",copyButtonSuccessIcon:"copyButtonSuccessIcon_LjdS"};function R(e){let{code:t,className:n}=e;const[a,r]=(0,o.useState)(!1),i=(0,o.useRef)(void 0),s=(0,o.useCallback)((()=>{!function(e,t){let{target:n=document.body}=void 0===t?{}:t;const a=document.createElement("textarea"),o=document.activeElement;a.value=e,a.setAttribute("readonly",""),a.style.contain="strict",a.style.position="absolute",a.style.left="-9999px",a.style.fontSize="12pt";const r=document.getSelection();let c=!1;r.rangeCount>0&&(c=r.getRangeAt(0)),n.append(a),a.select(),a.selectionStart=0,a.selectionEnd=e.length;let i=!1;try{i=document.execCommand("copy")}catch{}a.remove(),c&&(r.removeAllRanges(),r.addRange(c)),o&&o.focus()}(t),r(!0),i.current=window.setTimeout((()=>{r(!1)}),1e3)}),[t]);return(0,o.useEffect)((()=>()=>window.clearTimeout(i.current)),[]),o.createElement("button",{type:"button","aria-label":a?(0,V.I)({id:"theme.CodeBlock.copied",message:"Copied",description:"The copied button label on code blocks"}):(0,V.I)({id:"theme.CodeBlock.copyButtonAriaLabel",message:"Copy code to clipboard",description:"The ARIA label for copy code blocks button"}),title:(0,V.I)({id:"theme.CodeBlock.copy",message:"Copy",description:"The copy button label on code blocks"}),className:(0,c.Z)("clean-btn",n,F.copyButton,a&&F.copyButtonCopied),onClick:s},o.createElement("span",{className:F.copyButtonIcons,"aria-hidden":"true"},o.createElement("svg",{className:F.copyButtonIcon,viewBox:"0 0 24 24"},o.createElement("path",{d:"M19,21H8V7H19M19,5H8A2,2 0 0,0 6,7V21A2,2 0 0,0 8,23H19A2,2 0 0,0 21,21V7A2,2 0 0,0 19,5M16,1H4A2,2 0 0,0 2,3V17H4V3H16V1Z"})),o.createElement("svg",{className:F.copyButtonSuccessIcon,viewBox:"0 0 24 24"},o.createElement("path",{d:"M21,7L9,19L3.5,13.5L4.91,12.09L9,16.17L19.59,5.59L21,7Z"}))))}const W="wordWrapButtonIcon_Bwma",G="wordWrapButtonEnabled_EoeP";function z(e){let{className:t,onClick:n,isEnabled:a}=e;const r=(0,V.I)({id:"theme.CodeBlock.wordWrapToggle",message:"Toggle word wrap",description:"The title attribute for toggle word wrapping button of code block lines"});return o.createElement("button",{type:"button",onClick:n,className:(0,c.Z)("clean-btn",t,a&&G),"aria-label":r,title:r},o.createElement("svg",{className:W,viewBox:"0 0 24 24","aria-hidden":"true"},o.createElement("path",{fill:"currentColor",d:"M4 19h6v-2H4v2zM20 5H4v2h16V5zm-3 6H4v2h13.25c1.1 0 2 .9 2 2s-.9 2-2 2H15v-2l-3 3l3 3v-2h2c2.21 0 4-1.79 4-4s-1.79-4-4-4z"})))}function H(e){var t;let{children:n,className:r="",metastring:i,title:u,showLineNumbers:d,language:p}=e;const{prism:{defaultLanguage:g,magicComments:b}}=(0,s.L)(),f=null!=(t=null!=p?p:function(e){const t=e.split(" ").find((e=>e.startsWith("language-")));return null==t?void 0:t.replace(/language-/,"")}(r))?t:g,y=l(),j=function(){const[e,t]=(0,o.useState)(!1),[n,a]=(0,o.useState)(!1),r=(0,o.useRef)(null),c=(0,o.useCallback)((()=>{const n=r.current.querySelector("code");e?n.removeAttribute("style"):(n.style.whiteSpace="pre-wrap",n.style.overflowWrap="anywhere"),t((e=>!e))}),[r,e]),i=(0,o.useCallback)((()=>{const{scrollWidth:e,clientWidth:t}=r.current,n=e>t||r.current.querySelector("code").hasAttribute("style");a(n)}),[r]);return N(r,i),(0,o.useEffect)((()=>{i()}),[e,i]),(0,o.useEffect)((()=>(window.addEventListener("resize",i,{passive:!0}),()=>{window.removeEventListener("resize",i)})),[i]),{codeBlockRef:r,isEnabled:e,isCodeScrollable:n,toggle:c}}(),E=function(e){var t,n;return null!=(t=null==e||null==(n=e.match(m))?void 0:n.groups.title)?t:""}(i)||u,{lineClassNames:w,code:I}=v(n,{metastring:i,language:f,magicComments:b}),C=null!=d?d:function(e){return Boolean(null==e?void 0:e.includes("showLineNumbers"))}(i);return o.createElement(h,{as:"div",className:(0,c.Z)(r,f&&!r.includes("language-"+f)&&"language-"+f)},E&&o.createElement("div",{className:k.codeBlockTitle},E),o.createElement("div",{className:k.codeBlockContent},o.createElement(P,(0,a.Z)({},B,{theme:y,code:I,language:null!=f?f:"text"}),(e=>{let{className:t,tokens:n,getLineProps:a,getTokenProps:r}=e;return o.createElement("pre",{tabIndex:0,ref:j.codeBlockRef,className:(0,c.Z)(t,k.codeBlock,"thin-scrollbar")},o.createElement("code",{className:(0,c.Z)(k.codeBlockLines,C&&k.codeBlockLinesWithNumbering)},n.map(((e,t)=>o.createElement(M,{key:t,line:e,getLineProps:a,getTokenProps:r,classNames:w[t],showLineNumbers:C})))))})),o.createElement("div",{className:k.buttonGroup},(j.isEnabled||j.isCodeScrollable)&&o.createElement(z,{className:k.codeButton,onClick:()=>j.toggle(),isEnabled:j.isEnabled}),o.createElement(R,{className:k.codeButton,code:I}))))}function q(e){let{children:t,...n}=e;const c=(0,r.Z)(),i=function(e){return o.Children.toArray(e).some((e=>(0,o.isValidElement)(e)))?e:Array.isArray(e)?e.join(""):e}(t),s="string"==typeof i?H:j;return o.createElement(s,(0,a.Z)({key:String(c)},n),i)}},5162:(e,t,n)=>{"use strict";n.d(t,{Z:()=>c});var a=n(7294),o=n(6010);const r="tabItem_Ymn6";function c(e){let{children:t,hidden:n,className:c}=e;return a.createElement("div",{role:"tabpanel",className:(0,o.Z)(r,c),hidden:n},t)}},5488:(e,t,n)=>{"use strict";n.d(t,{Z:()=>m});var a=n(7462),o=n(7294),r=n(6010),c=n(2389),i=n(7392),s=n(7094),l=n(2466);const u="tabList__CuJ",d="tabItem_LNqP";function p(e){var t,n;const{lazy:c,block:p,defaultValue:m,values:g,groupId:b,className:f}=e,v=o.Children.map(e.children,(e=>{if((0,o.isValidElement)(e)&&"value"in e.props)return e;throw new Error("Docusaurus error: Bad <Tabs> child <"+("string"==typeof e.type?e.type:e.type.name)+'>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.')})),y=null!=g?g:v.map((e=>{let{props:{value:t,label:n,attributes:a}}=e;return{value:t,label:n,attributes:a}})),h=(0,i.l)(y,((e,t)=>e.value===t.value));if(h.length>0)throw new Error('Docusaurus error: Duplicate values "'+h.map((e=>e.value)).join(", ")+'" found in <Tabs>. Every value needs to be unique.');const k=null===m?m:null!=(t=null!=m?m:null==(n=v.find((e=>e.props.default)))?void 0:n.props.value)?t:v[0].props.value;if(null!==k&&!y.some((e=>e.value===k)))throw new Error('Docusaurus error: The <Tabs> has a defaultValue "'+k+'" but none of its children has the corresponding value. Available values are: '+y.map((e=>e.value)).join(", ")+". If you intend to show no default tab, use defaultValue={null} instead.");const{tabGroupChoices:j,setTabGroupChoices:E}=(0,s.U)(),[w,N]=(0,o.useState)(k),I=[],{blockElementScrollPositionUntilNextRender:B}=(0,l.o5)();if(null!=b){const e=j[b];null!=e&&e!==w&&y.some((t=>t.value===e))&&N(e)}const C=e=>{const t=e.currentTarget,n=I.indexOf(t),a=y[n].value;a!==w&&(B(t),N(a),null!=b&&E(b,String(a)))},T=e=>{var t;let n=null;switch(e.key){case"ArrowRight":{var a;const t=I.indexOf(e.currentTarget)+1;n=null!=(a=I[t])?a:I[0];break}case"ArrowLeft":{var o;const t=I.indexOf(e.currentTarget)-1;n=null!=(o=I[t])?o:I[I.length-1];break}}null==(t=n)||t.focus()};return o.createElement("div",{className:(0,r.Z)("tabs-container",u)},o.createElement("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,r.Z)("tabs",{"tabs--block":p},f)},y.map((e=>{let{value:t,label:n,attributes:c}=e;return o.createElement("li",(0,a.Z)({role:"tab",tabIndex:w===t?0:-1,"aria-selected":w===t,key:t,ref:e=>I.push(e),onKeyDown:T,onFocus:C,onClick:C},c,{className:(0,r.Z)("tabs__item",d,null==c?void 0:c.className,{"tabs__item--active":w===t})}),null!=n?n:t)}))),c?(0,o.cloneElement)(v.filter((e=>e.props.value===w))[0],{className:"margin-top--md"}):o.createElement("div",{className:"margin-top--md"},v.map(((e,t)=>(0,o.cloneElement)(e,{key:t,hidden:e.props.value!==w})))))}function m(e){const t=(0,c.Z)();return o.createElement(p,(0,a.Z)({key:String(t)},e))}},5884:(e,t,n)=>{"use strict";n.d(t,{Z:()=>l});var a=n(7294),o=n(2671),r=n(814);const c=e=>{const[t,n]=(0,a.useState)(e.manager.instruction);return(0,a.useEffect)((()=>{let t="";t=e.manager.instruction.replace("{{version}}",e.version),t=t.replace("{{groupId}}",e.data.groupId),t=t.replace("{{artifactId}}",e.data.repos[e.repo].artifactId),n(t)})),a.createElement(a.Fragment,null,a.createElement(r.Z,{language:e.manager.language,title:e.manager.fileName},t))};var i=n(5488),s=n(5162);const l=e=>{let{repo:t,version:n}=e;const[r,l]=(0,a.useState)(t);return(0,a.useEffect)((()=>l(t)),[t]),a.createElement(i.Z,null,Object.values(o.Z.managersList).map((e=>a.createElement(s.Z,{value:e.text},a.createElement(c,{data:o.Z,repo:r,manager:e,version:n})))))}},4645:(e,t,n)=>{"use strict";n.d(t,{Z:()=>o});var a=n(7294);const o=e=>{let{label:t,message:n,color:o}=e;return a.createElement("img",{src:"https://img.shields.io/badge/"+t+"-"+n+"-"+o})}},3738:(e,t,n)=>{"use strict";n.d(t,{Z:()=>r});var a=n(7294),o=n(4645);function r(e){let{artifact:t,javadoc:n,version:r,label:c}=e;const i="https://s01.oss.sonatype.org/service/local/repositories/releases/archive/com/binance4j/binance4j-"+t+"/"+r+"/binance4j-"+t+"-"+r+"-javadoc.jar/!/"+n;return a.createElement("a",{target:"_blank",href:i},a.createElement(o.Z,{label:""+(c||"javadoc"),message:r,color:"gold"}))}},3389:(e,t,n)=>{"use strict";n.d(t,{ZP:()=>u});var a=n(814),o=n(5162),r=n(5488),c=n(7294);function i(e){return c.createElement(a.Z,{language:"java"},"try{\n    "+("Void"!=e.payload?e.payload+" res = ":"")+" client."+e.method+".sync();\n}catch(ApiException e){ \n//...\n}")}function s(e){return c.createElement(a.Z,{language:"java"},"client."+e.method+".async((response, exception) -> {\n    if(exception == null){\n        //...\n    }else{\n        //...\n    }\n});")}function l(e){return c.createElement(c.Fragment,null,c.createElement(r.Z,null,c.createElement(o.Z,{label:"Sync",value:"sync",default:!0},c.createElement(i,e)),c.createElement(o.Z,{label:"Async",value:"async-lambda"},c.createElement(s,e))))}function u(e){return c.createElement(c.Fragment,null,1==e.items.length?c.createElement(l,{method:e.method+"("+(e.items[0].params?e.items[0].params:"")+")",payload:e.payload}):c.createElement(r.Z,null,e.items.map(((t,n)=>c.createElement(o.Z,{key:n,value:n.toString(),label:t.label||"Default"},c.createElement(l,{method:e.method+"("+(t.params?t.params:"")+")",payload:e.payload}))))))}},8267:(e,t,n)=>{"use strict";n.d(t,{Z:()=>r});var a=n(7294),o=n(3738);function r(e){return a.createElement(a.Fragment,null,a.createElement(o.Z,{artifact:e.artifact,javadoc:"index.html",version:e.version}),"\xa0",a.createElement("img",{src:"https://img.shields.io/badge/License-MIT-yellow.svg",alt:"License: MIT"}),"\xa0",a.createElement("img",{src:"https://img.shields.io/badge/JDK-17%2B-blue"}))}},2671:(e,t,n)=>{"use strict";n.d(t,{Z:()=>r});const a="https://binance4j.github.io/",o="/img/svg/",r={baseUrl:"https://github.com/binance4j/",groupId:"com.binance4j",repos:{strategy:{name:"strategy",artifactId:"binance4j-strategy",title:"Strategy",link:"Strategy",javadoc:a+"binance4j-strategy/",description:"Technical analysis for the Binance4j ecosystem",icon:o+"strategy.svg"},websocket:{name:"websocket",artifactId:"binance4j-websocket",title:"Websocket",link:"endpoints/Websocket",javadoc:a+"binance4j-websocket/",description:"Get real-time data about the market",icon:o+"websocket.svg"},wallet:{name:"wallet",artifactId:"binance4j-wallet",title:"Wallet",link:"endpoints/Wallet",javadoc:a+"binance4j-wallet/",description:"Retrieve your assets balance and transaction records",icon:o+"wallet.svg"},market:{name:"market",artifactId:"binance4j-market",title:"Market",link:"endpoints/Market",javadoc:a+"binance4j-market/",description:"Get infos about the crypto Market",icon:o+"market.svg"},spot:{name:"spot",artifactId:"binance4j-spot",title:"Spot",link:"endpoints/Spot",javadoc:a+"binance4j-spot/",description:"Trade on the SPOT market",icon:o+"dollar.svg"},margin:{name:"margin",artifactId:"binance4j-margin",title:"Margin",link:"endpoints/Margin",javadoc:a+"binance4j-margin/",description:"Borrow tokens and multiply your investment thanks to leverage effect",icon:o+"margin.svg"},mining:{name:"mining",artifactId:"binance4j-mining",title:"Mining",link:"endpoints/Mining",javadoc:a+"binance4j-mining/",description:"Get workers/earnings data and manage hashrate resales",icon:o+"mining.svg"},blvt:{name:"blvt",artifactId:"binance4j-blvt",title:"BLVT",link:"endpoints/BLVT",javadoc:a+"binance4j-blvt/",description:"Manage Binance Leveraged Tokens",icon:o+"blvt.svg"},c2c:{name:"c2c",artifactId:"binance4j-c2c",title:"C2C",link:"endpoints/C2C",javadoc:a+"binance4j-c2c/",description:"Get c2c trade history",icon:o+"c2c.svg"},convert:{name:"convert",artifactId:"binance4j-convert",title:"Convert",link:"endpoints/Convert",javadoc:a+"binance4j-convert/",description:"Connect to the convert endpoints",icon:o+"convert.svg"},fiat:{name:"fiat",artifactId:"binance4j-fiat",title:"Fiat",link:"endpoints/Fiat",javadoc:a+"binance4j-fiat/",description:"Retrieve fiat transactions",icon:o+"fiat.svg"},loan:{name:"loan",artifactId:"binance4j-loan",title:"Loan",link:"endpoints/Loan",javadoc:a+"binance4j-loan/",description:"Get crypto loans income history",icon:o+"loan.svg"},pay:{name:"pay",artifactId:"binance4j-pay",title:"Pay",link:"endpoints/Pay",javadoc:a+"binance4j-pay/",description:"Get pay trade history",icon:o+"pay.svg"},portFolio:{name:"portfolio-margin",artifactId:"binance4j-portfolio-margin",title:"Portfolio margin",link:"endpoints/portfolio",javadoc:a+"binance4j-portfolio-margin/",description:"Manage your portfolio margin account",icon:o+"portfolio-margin.svg"},rebate:{name:"rebate",artifactId:"binance4j-rebate",title:"Rebate",link:"endpoints/Rebate",javadoc:a+"binance4j-rebate/",description:"Get Spot rebate history records",icon:o+"rebate.svg"},staking:{name:"staking",artifactId:"binance4j-staking",title:"Staking",link:"endpoints/Staking",javadoc:a+"binance4j-staking/",description:"Interact with staking products",icon:o+"staking.svg"},nft:{name:"nft",artifactId:"binance4j-nft",title:"NFT",link:"endpoints/NFT",javadoc:a+"binance4j-nft/",description:"Get NFT transaction records",icon:o+"nft.svg"},vision:{name:"vision",artifactId:"binance4j-vision",title:"Vision",link:"endpoints/Vision",javadoc:a+"binance4j-vision/",description:"Get historical market data",icon:o+"eye.svg"},savings:{name:"savings",artifactId:"binance4j-savings",title:"Savings",link:"endpoints/Savings",javadoc:a+"binance4j-savings/",description:"Interact with Binance savings products",icon:o+"savings.svg"},connectors:{name:"connectors",artifactId:"binance4j-connectors",title:"Connectors",link:"Connectors",javadoc:a+"binance4j-connectors/",description:"All REST and Websocket connectors in one place.",icon:o+"connectors.svg"}},managersList:{maven:{text:"Maven",language:"xml",fileName:"pom.xml",instruction:"<dependency>\n\t<groupId>{{groupId}}</groupId>\n\t<artifactId>{{artifactId}}</artifactId>\n\t<version>{{version}}</version>\n</dependency>"},gradle:{text:"Gradle",language:"bash",fileName:"build.gradle",instruction:"implementation '{{groupId}}:{{artifactId}}:{{version}}'"}}}},7594:(e,t)=>{function n(e){let t,n=[];for(let a of e.split(",").map((e=>e.trim())))if(/^-?\d+$/.test(a))n.push(parseInt(a,10));else if(t=a.match(/^(-?\d+)(-|\.\.\.?|\u2025|\u2026|\u22EF)(-?\d+)$/)){let[e,a,o,r]=t;if(a&&r){a=parseInt(a),r=parseInt(r);const e=a<r?1:-1;"-"!==o&&".."!==o&&"\u2025"!==o||(r+=e);for(let t=a;t!==r;t+=e)n.push(t)}}return n}t.default=n,e.exports=n}}]);