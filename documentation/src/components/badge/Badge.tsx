import React, { FunctionComponent } from 'react'

export interface BadgeProps {
    label: string
    message: string
    color: string
}

/**
 * A shields.io badge
 * @param param0 The props
 */
const Badge: FunctionComponent<BadgeProps> = ({ label, message, color }) => {
    return (
        <img src={`https://img.shields.io/badge/${label}-${message}-${color}`} />
    )
}

export default Badge;