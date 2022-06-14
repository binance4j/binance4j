import React from 'react';
import Badge from './Badge';

interface Props {
    /** The endpoint path */
    path: string;
}

/**
 * A shields.io badge showing the Binance API endpoint of a client method
 * @param param0 The props 
 */
export default function ApiEndpointBadge({ path }: Props) {
    return (
        <Badge label='endpoint' message={path} color='blueviolet' />
    )
}
