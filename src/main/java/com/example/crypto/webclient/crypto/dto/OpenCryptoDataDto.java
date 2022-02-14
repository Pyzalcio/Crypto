package com.example.crypto.webclient.crypto.dto;

import lombok.Getter;

@Getter
public class OpenCryptoDataDto
{
    private OpenCryptoMarketDataDto market_data;
    private String symbol;
}
