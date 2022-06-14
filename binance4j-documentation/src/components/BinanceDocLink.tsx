import React from 'react'

/**
 * Link to the corresponding Spot documentation
 * @param anchor The section anchor
 */
export function BinanceSpotDocLink({ anchor }: { anchor: string }) {
    return (
        <a href={`https://binance-docs.github.io/apidocs/spot/en/#${anchor}`}>
            Binance official documentation
        </a>
    )
}
