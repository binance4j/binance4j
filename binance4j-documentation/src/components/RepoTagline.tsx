import React from 'react'
import github from "/binance4j.ts"

/** The repository description */
export default function Repodescription({ repo }) {
    return (
        <div>{github.repos[repo]}</div>
    )
}
