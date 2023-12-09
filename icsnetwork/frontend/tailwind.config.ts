import type { Config } from 'tailwindcss'

const config: Config = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/routes/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      // backgroundImage: {
      //   'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
      //   'gradient-conic':
      //     'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
      // },
      colors: {
        footer: "var(--footer)",
        headerimage: "var(--headerimage)",
        primary: "var(--primary)",
        secondarya: "var(--secondarya)",
        secondaryb: "var(--secondaryb)",
        "variable-collection-cardbackground": "var(--variable-collection-cardbackground)",
        "variable-collection-cardbg": "var(--variable-collection-cardbg)",
        "variable-collection-menu-font": "var(--variable-collection-menu-font)",
        "variable-collection-strokecolor": "var(--variable-collection-strokecolor)",
      },
      fontFamily: {
        1: "var(--1-font-family)",
        2: "var(--2-font-family)",
        menu: "var(--menu-font-family)",
        "regular-text": "var(--regular-text-font-family)",
      },
    },
  },
  plugins: [],
}
export default config
