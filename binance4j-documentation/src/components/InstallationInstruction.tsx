import CodeBlock from '@theme/CodeBlock';
import React, { useEffect, useState } from 'react';
import { Binance4JData, ProjectManager } from '../../static/data/binance4j';
import InstallationTitle from './InstallationTitle';
export interface InstallationInstructionProps {
    data: Binance4JData
    repo: string;
    manager: ProjectManager
    version: string;
}

const InstallationInstruction: React.FunctionComponent<InstallationInstructionProps> = (props: InstallationInstructionProps) => {
    const [instruction, setInstruction] = useState(props.manager.instruction);

    useEffect(() => {
        let newInstruction = "";

        newInstruction = props.manager.instruction.replace("{{version}}", props.version);
        newInstruction = newInstruction.replace("{{groupId}}", props.data.groupId);
        newInstruction = newInstruction.replace("{{artifactId}}", props.data.repos[props.repo].artifactId);

        setInstruction(newInstruction)

    });

    return (
        <>
            <InstallationTitle src={props.manager.img} href={props.manager.href}>{props.manager.text}</InstallationTitle>

            <CodeBlock language={props.manager.language} title={props.manager.fileName}>
                {instruction}
            </CodeBlock>
        </>
    )
}

export default InstallationInstruction