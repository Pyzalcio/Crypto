package com.example.crypto.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CryptoDto
{
    private double coinPriceInUSD;
    private double coinPriceInBTC;
    private double coinPriceInETH;
    private String coinSymbol;
}
