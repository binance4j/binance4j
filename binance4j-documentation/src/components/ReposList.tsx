import React from 'react'
import binance4j from '../../static/binance4j'
import { GithubLink } from './Link/GithubLink'

/** A list of all the available repos on binance4j linked to their GIthub repository */
export default function ReposList() {
  return (
    <ul>
      {
        Object.values(binance4j.repos).map((repo, i) => (
          <li key={i}><GithubLink repo={repo.name} />: {repo.description}</li>)
        )
      }
    </ul >
  )
}
