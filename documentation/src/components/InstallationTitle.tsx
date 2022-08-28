import React from "react";

export interface TitleProps {
    src: string
    href: string
    children: string
}

const h3Style: React.CSSProperties = {
    position: "relative",
    display: "flex",
    alignItems: "center"
};

const imageContainerStyle: React.CSSProperties = {
    width: "3rem",
    height: "3rem",
    borderRadius: 50,
    border: "1px solid #aaa",
    margin: "0 .5rem",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
    backgroundPosition: "top",
}

export default function InstallationTitle({ src, href, children }: TitleProps) {
    const newImagaContainer: React.CSSProperties = { ...imageContainerStyle, backgroundImage: `url(${src})` };

    return (
        <h3 style={h3Style}>
            <div style={newImagaContainer} />
            <a href={href}>{children}</a>
        </h3>
    )
}
