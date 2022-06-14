import React from 'react';
import ApiEndpointBadge from './ApiEndpointBadge';
import JavadocBadge from './JavadocBadge';
import RequestWeightBadge from './RequestWeightBadge';
import SignatureBadge from './SignatureBadge';

interface Props {
    artifact: string;
    javadoc: string;
    version: string;
    path: string;
    weight: string;
    signature: string;
    label: string;
}

export default function RequestBadges(props: Props) {
    return (
        <>
            <ApiEndpointBadge path={props.path} />
            &nbsp;
            <RequestWeightBadge weight={props.weight} />
            &nbsp;
            <SignatureBadge signature={props.signature} />
            &nbsp;
            <JavadocBadge label={props.label} artifact={props.artifact} javadoc={props.javadoc} version={props.version} />
        </>
    )
}
