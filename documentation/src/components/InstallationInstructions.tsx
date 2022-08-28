import React, { useEffect, useState } from "react";
import data from "../../static/data/binance4j";
import InstallationInstruction from "./InstallationInstruction";
import Tabs from "@theme/Tabs";
import TabItem from "@theme/TabItem";

export interface InstallationInstructionsProps {
    repo: string;
    version: string;
}

const InstallationInstructions: React.FunctionComponent<InstallationInstructionsProps> = ({ repo, version }: InstallationInstructionsProps) => {
    const [rep, setRep] = useState(repo);

    useEffect(() => setRep(repo), [repo]);

    return (
        <Tabs>
            {Object.values(data.managersList).map(manager => (
                <TabItem value={manager.text}>
                    <InstallationInstruction data={data} repo={rep} manager={manager} version={version} />
                </TabItem>
            ))}
        </Tabs>
    )
}

export default InstallationInstructions;