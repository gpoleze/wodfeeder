module.exports = {
    extends: [
        "airbnb-typescript",
        "eslint:recommended",
        "plugin:@typescript-eslint/recommended",
        "plugin:react/recommended",
        "plugin:import/errors",
        "plugin:import/warnings",
        "plugin:import/typescript",
        "prettier"
    ],
    parser: "@typescript-eslint/parser",
    parserOptions: {
        ecmaFeatures: {
            jsx: true,
            tsx: true,
        },
        ecmaVersion: 2020,
        sourceType: "module",
        project: "./tsconfig.json"
    },
    plugins: [
        "@typescript-eslint",
        "react",
        "prettier",
        "react-hooks",
        "import",
    ],
    settings: {
        "import/resolver": {
            typescript: {}
        },
    },
    "rules": {
        // Default ESLint Rules
        "complexity": ["error", 10],
        "indent": ["warn", 4, { "SwitchCase": 1 }],
        "max-lines-per-function": ["error", {
            "max": 50,
            "skipBlankLines": true,
            "skipComments": true
        }],
        "max-nested-callbacks": ["error", 5],

        // Plugins - @typescript-eslint
        "@typescript-eslint/explicit-function-return-type": ["warn"],
        "@typescript-eslint/no-empty-interface": ["off"],
        "@typescript-eslint/indent": ["warn", 4],
        "@typescript-eslint/quotes": "off",

        // Plugins - eslint-plugin-import
        "import/no-unresolved": "error",
        "import/named": "error",
        "import/namespace": "error",
        "import/default": "error",
        "import/export": "off",
        "import/prefer-default-export": "warn",
        "import/order": ["error", {
            "groups": ["builtin", "external", "internal"],
            "pathGroups": [{
                "pattern": "react",
                "group": "external",
                "position": "before"
            }, {
                "pattern": "[components]/**",
                "group": "external",
                "position": "after"
            },
            ],
            "pathGroupsExcludedImportTypes": ["react"],
            "newlines-between": "always",
            "alphabetize": {
                "order": "asc",
                "caseInsensitive": true
            }
        }],

        // Plugins - Prettier
        "prettier/prettier": ["error"],

        // Plugins - React
        "react/jsx-filename-extension": [1, {
            "extensions": [".jsx", ".tsx"]
        }],
        "react/jsx-indent": ["warn", 4],
        "react/jsx-indent-props": ["warn", 4],
        "react-hooks/rules-of-hooks": "error",
        "react-hooks/exhaustive-deps": "warn",
        "react/button-has-type": ["off"],
        "react/prop-types": ["off"]
    }
}