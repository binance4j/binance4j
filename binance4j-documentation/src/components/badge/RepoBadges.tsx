import React from 'react';
import JavadocBadge from './JavadocBadge';
import JDKBadge from './JDKBadge';
import MavenBadge from './MavenBadge';
import MITBadge from './MITBadge';
import SonatypeBadge from './SonatypeBadge';

interface Props {
    artifact: string
    version: string
}

export default function RepoBadges(props: Props) {
    return (
        <>
            <JavadocBadge artifact={props.artifact} javadoc="index.html" version={props.version} />
            &nbsp;
            <MavenBadge artifact={props.artifact} />
            &nbsp;
            <SonatypeBadge artifact={props.artifact} />
            &nbsp;
            <MITBadge />
            &nbsp;
            <JDKBadge />
        </>
    )
}
