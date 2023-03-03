package src.srccode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import src.srccode.model.CryptoCurrencyDto;
import src.srccode.service.BinanceService;

import java.util.List;


@RestController
@RequestMapping("/binance")
@RequiredArgsConstructor
public class BinanceController {
    private final BinanceService binanceService;

    @PostMapping
    public List<CryptoCurrencyDto> getCryptoCurrencyRate(@RequestBody List<CryptoCurrencyDto> cryptoCurrencyDtoList) {
        return binanceService.getCryptoCurrencyRate(cryptoCurrencyDtoList);
    }
}
