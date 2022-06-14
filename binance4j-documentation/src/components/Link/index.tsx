import Link from "@docusaurus/Link";
import React from 'react';

/**
 * A custom link
 * @param to The destination
 */
const MyLink: React.FunctionComponent<{ to: string }> = ({ to, children }) => <Link to={to} style={{ fontWeight: "bold" }}>{children}</Link>;

export default MyLink;
