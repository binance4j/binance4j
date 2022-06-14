import React from 'react'

interface Props {
    /** The binance4j artifact name */
    artifact: string
}

/**
 * A shields.io badge showing the artifact version on maven central 
 * @param param0 The props
 */
export default function MavenBadge({ artifact }: Props) {
    return (
        <a href={`https://search.maven.org/search?q=com.binance4j.binance4j-${artifact}`} target="_blank">
            <img alt="Maven Central"
                src={`https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-${artifact}/badge.svg`}
            />
        </a>
    )
}
