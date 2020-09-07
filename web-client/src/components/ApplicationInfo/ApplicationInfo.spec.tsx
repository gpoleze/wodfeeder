import React from "react";

import { render } from "@testing-library/react";

import ApplicationInfo from "./ApplicationInfo";

const getStyle = (element: HTMLElement, selector: string): CSSStyleDeclaration => {
    const node = element.querySelector(selector) || element;
    return window.getComputedStyle(node);
};

describe("ApplicationInfo Component", () => {
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

    it("shoud render the application version with the placeholder value", () => {
        const appVersion = container.querySelector("#appVersion");
        expect(appVersion).not.toBeNull();
        expect(appVersion?.textContent).toBe("%WEB_CLIENT_VERSION%");
    });

    it("should render the component with hidden visibility", () => {
        const style = getStyle(container, "div[data-key='applicationInfo']");
        expect(style.display).toBe("hidden");
    });
});
