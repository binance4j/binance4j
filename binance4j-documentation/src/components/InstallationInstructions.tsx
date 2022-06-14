import React, { useEffect, useState } from "react";
import data from "../../static/data/binance4j";
import InstallationInstruction from "./InstallationInstruction";

export interface InstallationInstructionsProps {
    repo: string;
    version: string;
}

const InstallationInstructions: React.FunctionComponent<InstallationInstructionsProps> = ({ repo, version }: InstallationInstructionsProps) => {
    const [rep, setRep] = useState(repo);

    useEffect(() => setRep(repo), [repo]);

    return (
        <>
            {Object.values(data.managersList).map(manager => <InstallationInstruction data={data} repo={rep} manager={manager} version={version} />)}
        </>
    )
}

export default InstallationInstructions;