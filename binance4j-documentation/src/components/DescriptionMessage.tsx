import React from "react";
import { RepoList } from "../../static/data/binance4j";
import JavadocLink from "./Link/JavadocLink";

export interface DescriptionMessageProps {
    repo?: string;
    repos: RepoList;
}

export default function DescriptionMessage({ repos, repo }: DescriptionMessageProps) {
    return (
        <div>
            <span style={{ textTransform: "capitalize" }}><JavadocLink repo={repo} repos={repos} /></span> is available for every popular project manager
        </div>
    )
}