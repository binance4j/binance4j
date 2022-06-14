import React from 'react';
import Badge, { BadgeProps } from './Badge';


interface Props extends BadgeProps {
    to: string
}

export default function LinkBadge(props: Props) {
    return (
        <a href={props.to} target="_blank"><Badge color={props.color} label={props.label} message={props.message} /></a>
    )
}
