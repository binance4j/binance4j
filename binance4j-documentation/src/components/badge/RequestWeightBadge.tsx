import React from 'react'
import Badge from './Badge'

interface Props {
    weight: string
}

/**
 * A shields.io badge displaying the request weight
 * @param param0 The badge props
 */
export default function RequestWeightBadge({ weight }: Props) {
    return (
        <Badge label='weight' message={weight} color="blue" />
    )
}
