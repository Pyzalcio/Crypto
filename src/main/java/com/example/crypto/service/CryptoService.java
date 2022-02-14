package com.example.crypto.service;

import com.example.crypto.model.CryptoDto;
import com.example.crypto.webclient.crypto.CryptoClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CryptoService
{
    private final CryptoClient cryptoClient;

    public CryptoDto getCrypto(String coin)
    {
        return cryptoClient.getExchangeForCoins(coin);
    }
    public CryptoDto getCrypto(String coin, String filter)
    {
        return cryptoClient.getExchangeForCoins(coin);
    }

}
