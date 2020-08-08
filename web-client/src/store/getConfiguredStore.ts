import { configureStore, EnhancedStore } from "@reduxjs/toolkit";
import { Middleware, StoreEnhancer } from "redux";
import thunkMiddleware from "redux-thunk";

import monitorReducersEnhancer from "store/enhancers/monitorReducers";
import loggerMiddleware from "store/middleware/logger";
import rootReducer from "store/rootReducer";

const getConfiguredStore = (): EnhancedStore => {
    const middleware: Middleware[] = [thunkMiddleware];
    const enhancers: StoreEnhancer[] = [];

    if (process.env.NODE_ENV !== "production") {
        middleware.push(loggerMiddleware);
        enhancers.push(monitorReducersEnhancer);
    }

    return configureStore({
        reducer: rootReducer,
        middleware,
        enhancers,
        preloadedState: {},
    });
};

export default getConfiguredStore;
