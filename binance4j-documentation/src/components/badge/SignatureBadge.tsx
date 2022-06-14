import React from 'react'
import Badge from './Badge'

interface Props {
    signature: string
}

/**
 * A shields.io showing the request signature
 * @param param0 The badge props
 */
export default function SignatureBadge({ signature }: Props) {
    return (
        <Badge label='signature' message={signature} color='red' />
    )
}
