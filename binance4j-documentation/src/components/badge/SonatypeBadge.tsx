import React from 'react'

interface Props {
    /** The binance4j artifact name */
    artifact: string
}

/**
 * A shields.io badge showing the artifact version on sonatype
 * @param param0 The props
 */
export default function SonatypeBadge({ artifact }: Props) {
    return (
        <a href={`https://s01.oss.sonatype.org/#nexus-search;quick~com.binance4j.${artifact}`}>
            <img alt="Sonatype Nexus"
                src={`https://img.shields.io/nexus/r/com.binance4j/binance4j-${artifact}?server=https%3A%2F%2Fs01.oss.sonatype.org%2F`}
            />
        </a>
    )
}
