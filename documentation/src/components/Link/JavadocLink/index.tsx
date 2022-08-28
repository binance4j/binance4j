import { RepoList } from '@site/../../../static/data/binance4j';
import React from 'react';
import Link from "../index";


export interface JavadocLinkProps {
    repo: string;
    repos: RepoList;
}


/**
 * A link to a repo javadoc
 * @param repo The repo name
 */
const JavadocLink: React.FunctionComponent<JavadocLinkProps> = ({ repo, repos }: JavadocLinkProps, props) => <Link to={repos[repo].javadoc}>{props.children || repos[repo].artifactId}</Link>

export default JavadocLink;
