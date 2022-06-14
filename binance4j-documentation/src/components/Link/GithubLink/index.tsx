import React from 'react';
import Link from "../index";
import binance4j from './../../../../static/binance4j';

/**
 * A link to a repo javadoc
 * @param repo The repo name
 */
const GithubLink: React.FunctionComponent<{ repo: string }> = ({ repo, children }) => <Link to={binance4j.baseUrl + binance4j.repos[repo].artifactId}>{children || binance4j.repos[repo].artifactId}</Link>

/** A link to the binance4j-core javadoc */
const GithubCoreLink: React.FunctionComponent<{}> = ({ children }) => <GithubLink repo="core">{children}</GithubLink>

export { GithubLink, GithubCoreLink };
