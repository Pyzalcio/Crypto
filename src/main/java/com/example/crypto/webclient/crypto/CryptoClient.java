package com.example.crypto.webclient.crypto;

import com.example.crypto.model.CryptoDto;
import com.example.crypto.webclient.crypto.dto.OpenCryptoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CryptoClient
{
    private static final String CRYPTO_URL = "https://data.messari.io/api/v1/assets";
    private RestTemplate restTemplate = new RestTemplate();
    double coinPrice;

    public CryptoDto getExchangeForCoins(String coin)
    {
        OpenCryptoDto openCryptoDto = callGetMethod("/{coin}/metrics",
                OpenCryptoDto.class, coin);
        return CryptoDto.builder()
                .coinSymbol(openCryptoDto.getData().getSymbol())
                .coinPriceInUSD(openCryptoDto.getData().getMarket_data().getPrice_usd())
                .coinPriceInBTC(openCryptoDto.getData().getMarket_data().getPrice_btc())
                .coinPriceInETH(openCryptoDto.getData().getMarket_data().getPrice_eth())
                .build();
        //return response;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects)
    {
        return restTemplate.getForObject(CRYPTO_URL + url, responseType, objects);
    }
}
