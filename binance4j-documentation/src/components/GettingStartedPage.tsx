import binance4j from "@site/static/data/binance4j.ts";
import React from 'react';
import RepoBadges from './badge/RepoBadges';
import InstallationInstructions from "./InstallationInstructions";



interface Props {
    artifact: string
    version: string
}

export default function GettingStartedPage(props: Props) {
    return (
        <>
            <RepoBadges artifact={props.artifact} version={props.version} />
            <h2>Description</h2>
            <div>{binance4j.repos[props.artifact].description}</div>
            <h2>Installation</h2>
            <InstallationInstructions repo={props.artifact} version={props.version} />
        </>
    )
}