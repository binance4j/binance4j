import React from 'react';
import JavadocBadge from '../badge/JavadocBadge';

interface Props {
    artifact: string
    version: string
}

export default function RepoBadges(props: Props) {
    return (
        <>
            <JavadocBadge artifact={props.artifact} javadoc="index.html" version={props.version} />
            &nbsp;
            <img src={`https://img.shields.io/badge/License-MIT-yellow.svg`} alt="License: MIT" />
            &nbsp;
            <img src="https://img.shields.io/badge/JDK-17%2B-blue" />
        </>
    )
}
