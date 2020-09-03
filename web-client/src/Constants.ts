interface ConfigInterface {
    url: {
        API_URL: string;
    };
}

const prod: ConfigInterface = {
    url: {
        API_URL: "http://wodfeeder-api.gabrielpf.com",
    },
};

const dev: ConfigInterface = {
    url: {
        API_URL: "http://localhost:8080",
    },
};

export default process.env.NODE_ENV === "development" ? dev : prod;
