import Link from '@docusaurus/Link';
import useBaseUrl from '@docusaurus/useBaseUrl';
import { Card, Typography } from '@mui/material';
import React from 'react';
import styles from './styles.module.scss';
import binance4j from '/data/binance4j.ts';

function FeatureCard({ repo }) {
    return (
        <Link to={`/docs/${repo.title.toLowerCase()}`} className={styles.link}>
            <Card sx={{ minWidth: 275 }} className={styles.card}>
                <div style={{ backgroundImage: `url(${useBaseUrl(repo.icon)})` }} className={styles.imgContainer} />
                <h2 color="text.primary" className={styles.title}>
                    {repo.title}
                </h2>

                <Typography variant="body2" className={styles.description}>
                    {repo.description}
                </Typography>
            </Card>
        </Link>
    )
}

export default function HomepageFeatures() {
    return (
        <section className={styles.features}>
            <div className={styles.container}>
                {Object.values(binance4j.repos).map((repo, i) => (
                    <FeatureCard repo={repo} key={i} />
                ))}
            </div>
        </section>
    );
}
