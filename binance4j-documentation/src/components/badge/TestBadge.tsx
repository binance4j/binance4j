import React from 'react';

interface Props {
    artifact: string;
}

export default function TestBadge({ artifact }: Props) {
    const action = "deploy"

    return (
        <img
            src={`https://img.shields.io/github/workflow/status/binance4j/binance4j-${artifact}/${action.replaceAll(" ", "%20")}/deploy?label=Test`}
        />
    )
}
