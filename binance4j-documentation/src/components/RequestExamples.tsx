import CodeBlock from '@theme/CodeBlock';
import TabItem from '@theme/TabItem';
import Tabs from '@theme/Tabs';
import React from 'react';

/**
 * A set of components generating example code blocks for sync and async API call methods
 */

/** The request examples components's props */
interface Props {
    /** The method name */
    method: string,
    /** The method return type */
    responseType?: string,
    /** The method request type */
    requestType?: string,
    /** The method request parameters */
    requestParameters?: string[]
    /** The client class */
    client: string,
    /** The constructor params */
    constructorParams: string[]
}

/**
 * Generates the request for the API call or nothing
 * @param props The components props
 */
const generateClient = (props: Props) => `${props.client} client = new ${props.client}(${props.constructorParams.join(", ")});\n\n`

/**
 * Generates the request for the API call or nothing
 * @param props The components props
 */
const generateRequest = (props: Props) => props.requestType ? props.requestType + " request = new " + props.requestType + `(${props.requestParameters ? props.requestParameters.join(", ") : ""});\n\n` : "";

/**
 * Returns an example code block for a sync API call
 * @param props The components props
 */
export function SyncRequest(props: Props) {
    const callback = props.responseType ? `${props.responseType} response = ` : "";

    return (
        <CodeBlock language="java">
            {`${generateClient(props)}${generateRequest(props)}try{
    ${callback}client.${props.method}(${props.requestType ? "request" : ""}).execute();
}catch(ApiException e){ 
//...
}
`}
        </CodeBlock>
    )
}

/**
 * Returns an example code block for an async API call with lambda
 * @param props The components props
 */
export function AsyncRequestLambda(props: Props) {
    return (
        <CodeBlock language="java">
            {`${generateClient(props)}${generateRequest(props)}client.${props.method}(${props.requestType ? "request" : ""}).then(response->{
  //...
});
`}
        </CodeBlock>
    )
}

/**
 * Returns an example code block for an async API call with ApiCallback
 * @param props The components props
 */
export function AsyncRequestApiCallback(props: Props) {
    const callback = props.responseType ? `${props.responseType} response` : "";

    return (
        <CodeBlock language="java">
            {`${generateClient(props)}${generateRequest(props)}client.${props.method}().then(new ApiCallback<${props.responseType ? props.responseType : "Void"}>() {
    @Override
    public void onResponse(${callback}) {
        //...
    }

    @Override
    public void onFailure(ApiException exception) {
        //...
    }
});
`}
        </CodeBlock>
    )
}

/**
 * Returns all the examples in a Tabs item
 * @param props The components props
 */
export default function RequestExamples(props: Props) {
    return (
        <>
            <Tabs>
                <TabItem label="Sync" value="sync" default>
                    <SyncRequest {...props} />
                </TabItem>
                <TabItem label="Async (lambda)" value="async-lambda">
                    <AsyncRequestLambda {...props} />
                </TabItem>
                <TabItem label="Async (ApiCallback)" value="async-api-callback">
                    <AsyncRequestApiCallback {...props} />
                </TabItem>
            </Tabs>
        </>
    )
}