import React from "react";

import { render } from "@testing-library/react";

import ApplicationInfo from "./ApplicationInfo";

describe("ApplicationInfo Component", () => {
    const appVersionValue = "appVersion";
    process.env.REACT_APP_WEB_CLIENT_VERSION = appVersionValue;

    let container: HTMLElement;
    beforeEach(() => {
        const renderedComponent = render(<ApplicationInfo />);
        container = renderedComponent.container;
    });

    it("should render the node environment", () => {
        const nodeEnv = container.querySelector("#nodeEnv");
        expect(nodeEnv).not.toBeNull();
        expect(nodeEnv?.textContent).toBe("test");
    });

    it("should render the application version with the placeholder value", () => {
        const appVersion = container.querySelector("#appVersion");
        expect(appVersion).not.toBeNull();
        expect(appVersion?.textContent).toBe(appVersionValue);
    });

    it("should render the component with hidden visibility", () => {
        const element = container.querySelector("*[data-key='applicationInfo']");
        expect(element).toHaveStyle("visibility: hidden");
        expect(element).toHaveStyle("display: none");
    });
});
