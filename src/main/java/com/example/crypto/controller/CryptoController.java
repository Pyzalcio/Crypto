package com.example.crypto.controller;

import com.example.crypto.model.CryptoDto;
import com.example.crypto.model.Exchange;
import com.example.crypto.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CryptoController
{
    private final CryptoService cryptoService;

    @GetMapping("/currencies/{coin}")
    public CryptoDto getCrypto(@PathVariable String coin)
    {
        return cryptoService.getCrypto(coin);
    }
    public CryptoDto getCrypto(@PathVariable String coin, @RequestParam String filter)
    {
        return cryptoService.getCrypto(coin, filter);
    }

    @PostMapping("/exchange")
    Exchange createExchange(@RequestBody Exchange toCreate)
    {
        String fromCoin = cryptoService.getCrypto(toCreate.getFromCoin()).getCoinSymbol();
        String toCoin = cryptoService.getCrypto(toCreate.getToCoin()).getCoinSymbol();
        double fromCoinValue = cryptoService.getCrypto(toCreate.getFromCoin()).getCoinPriceInUSD();
        double toCoinValue = cryptoService.getCrypto(toCreate.getToCoin()).getCoinPriceInUSD();
        double result = exchangeCoin(toCreate.getAmount(), fromCoinValue, toCoinValue);
        toCreate.setResult(result);
        return toCreate;
    }

    private double exchangeCoin(double amount, double fromCoinValue, double toCoinValue)
    {
        return amount*(fromCoinValue/toCoinValue);
    }

}
