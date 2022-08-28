import React from 'react';
import Badge from './Badge';

export interface JavadocBadgeProps {
    /** The binance4j artifact */
    artifact: string;
    /** The binance4j javadoc path */
    javadoc: string;
    /** The javadoc version */
    version: string;
    /** The class name to add to the badge */
    label?: string;
}

/**
 * A shields.io badge linked to the given Binance4j javadoc
 * @param param0 The badge props
 */
export default function JavadocBadge({ artifact, javadoc, version, label }: JavadocBadgeProps) {
    const defaultBase = "https://s01.oss.sonatype.org/service/local/repositories/releases/archive/com/binance4j/";
    const link = `${defaultBase}binance4j-${artifact}/${version}/binance4j-${artifact}-${version}-javadoc.jar/!/${javadoc}`;

    return (
        <a target="_blank" href={link}>
            <Badge label={`${label || "javadoc"}`} message={version} color='gold' />
        </a>
    )
}
