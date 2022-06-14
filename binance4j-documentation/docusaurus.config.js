// @ts-check
// Note: type annotations allow type checking and IDEs autocompletion

const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'Binance4j',
  tagline: 'Java connectors and technical analysis for the Binance API',
  url: 'https://binance4j.github.io',
  baseUrl: '/binance4j/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',
  organizationName: 'binance4j', // Usually your GitHub org/user name.
  projectName: 'binance4J', // Usually your repo name.
  deploymentBranch: 'gh-pages',
  presets: [
    [
      'classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          editUrl: 'https://github.com/binance4j',
        },
        blog: {
          showReadingTime: true,
          editUrl:
            'https://github.com/binance4j',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.scss'),
        },
      }),
    ],
  ],
  staticDirectories: ['static'],

  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      navbar: {
        title: 'Binance4J',
        logo: {
          alt: 'Binance4j logo',
          src: '/img/logo/logo2.png',
        },
        items: [
          {
            type: 'docsVersionDropdown',
            position: 'left'
          },
          {
            type: 'doc',
            docId: 'Core',
            position: 'left',
            label: 'Documentation'
          },
          {
            to: 'changelog',
            label: 'Changelog',
            position: 'left',
          },
          {
            href: 'https://github.com/binance4j',
            label: 'GitHub',
            position: 'right',
          },
        ],
      },
      footer: {
        style: 'dark',
        links: [
        ],
        copyright: `Copyright © ${new Date().getFullYear()} Binance4J by Vivien Le Duc`,
      },
      prism: {
        theme: require('prism-react-renderer/themes/dracula'),
        darkTheme: darkCodeTheme,
        additionalLanguages: ['java'],
      },
    }),
  plugins: ['docusaurus-plugin-sass', 'docusaurus-lunr-search'],
};

module.exports = config;
