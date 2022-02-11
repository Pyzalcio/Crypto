package com.example.crypto.controller;

import com.example.crypto.model.CryptoDto;
import com.example.crypto.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CryptoController
{
    private final CryptoService cryptoService;

    @GetMapping("/crypto")
    public CryptoDto getCrypto()
    {
        return cryptoService.getCrypto();
    }
}
