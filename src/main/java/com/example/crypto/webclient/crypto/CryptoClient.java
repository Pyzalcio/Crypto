package com.example.crypto.webclient.crypto;

import com.example.crypto.model.CryptoDto;
import com.example.crypto.webclient.crypto.dto.OpenCryptoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CryptoClient
{
    private static final String CRYPTO_URL = "https://api.coincap.io/v2/";
    private RestTemplate restTemplate = new RestTemplate();
    double coinPrice;

    public CryptoDto getExchangeForCoins(String coin)
    {
        OpenCryptoDto openCryptoDto = callGetMethod("rates/{coin}",
                OpenCryptoDto.class, coin);
        return CryptoDto.builder()
                .coinPrice(openCryptoDto.getData().getRateUsd())
                .build();
        //return response;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects)
    {
        return restTemplate.getForObject(CRYPTO_URL + url, responseType, objects);
    }
}
