export type RepoList = { [key: string]: Repo };

export interface Binance4JData {
  baseUrl: string;
  groupId: string;
  repos: RepoList;
  managersList: ProjectManagerList;
}

export interface Repo {
    name: string;
    artifactId: string;
    title: string;
    javadoc: string;
    description: string;
    icon: string;
}

const core: Repo = {
    name: "core",
    artifactId: "binance4j-core",
    title: "Core",
    javadoc: "https://binance4j.github.io/binance4j-core/",
    description: "The core of every connector",
    icon: "/img/svg/gear.svg",
};

const wallet: Repo = {
    name: "wallet",
    artifactId: "binance4j-wallet",
    title: "Wallet",
    javadoc: "https://binance4j.github.io/binance4j-wallet/",
    description: "Connect to the Wallet endpoints",
    icon: "/img/svg/wallet.svg",
};

const market: Repo = {
    name: "market",
    artifactId: "binance4j-market",
    title: "Market",
    javadoc: "https://binance4j.github.io/binance4j-market/",
    description: "Connect to the Market endpoints",
    icon: "/img/svg/market.svg",
};

const spot: Repo = {
    name: "spot",
    artifactId: "binance4j-spot",
    title: "Spot",
    javadoc: "https://binance4j.github.io/binance4j-spot/",
    description: "Connect to the SPOT endpoints",
    icon: "/img/svg/dollar.svg",
};

const websocket: Repo = {
    name: "websocket",
    artifactId: "binance4j-websocket",
    title: "Websocket",
    javadoc: "https://binance4j.github.io/binance4j-websocket/",
    description: "Connect to the Websocket endpoints",
    icon: "/img/svg/websocket.svg",
};

const vision: Repo = {
    name: "vision",
    artifactId: "binance4j-vision",
    title: "Vision",
    javadoc: "https://binance4j.github.io/binance4j-vision/",
    description: "Connect to the Public Data endpoints",
    icon: "/img/svg/eye.svg",
};

const strategy: Repo = {
    name: "strategy",
    artifactId: "binance4j-strategy",
    title: "Strategy",
    javadoc: "https://binance4j.github.io/binance4j-strategy/",
    description: "Technical analysis for the Binance4j ecosystem",
    icon: "/img/svg/strategy.svg",
};

const nft: Repo = {
    name: "nft",
    artifactId: "binance4j-nft",
    title: "NFT",
    javadoc: "https://binance4j.github.io/binance4j-nft/",
    description: "Connect to the NFT endpoints",
    icon: "/img/svg/nft.svg",
};

export interface ProjectManager {
    img: string;
    href: string;
    text: string;
    language: string;
    fileName: string;
    instruction: string;
}

export type ProjectManagerList = { [key: string]: ProjectManager };

const maven: ProjectManager = {
    img: "https://search.maven.org/assets/images/mvn.png",
    href: "https://maven.apache.org/",
    text: "Apache Maven",
    language: "xml",
    fileName: "pom.xml",
    instruction:
        "<dependency>\n\t<groupId>{{groupId}}</groupId>\n\t<artifactId>{{artifactId}}</artifactId>\n\t<version>{{version}}</version>\n</dependency>",
};

const gradle: ProjectManager = {
    img: "https://search.maven.org/assets/images/gradle.png",
    href: "https://gradle.org/",
    text: "Gradle Groovy DSL",
    language: "bash",
    fileName: "build.gradle",
    instruction: "implementation '{{groupId}}:{{artifactId}}:{{version}}'",
};

const managersList: ProjectManagerList = {
    maven,
    gradle,
};

const binance4j: Binance4JData = {
    baseUrl: "https://github.com/binance4j/",
    groupId: "com.binance4j",
    repos: {
        core,
        wallet,
        market,
        spot,
        nft,
        websocket,
        vision,
        strategy,
        //strategies,
    },
    managersList,
};

export default binance4j;
