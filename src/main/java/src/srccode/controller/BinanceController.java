package src.srccode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import src.srccode.model.BinanceCryptoCurrencyDto;
import src.srccode.service.BinanceService;


@RestController
@RequestMapping("/binance")
@RequiredArgsConstructor
public class BinanceController {
    private final BinanceService binanceService;

    @PostMapping
    public BinanceCryptoCurrencyDto getCryptoCurrencyRate(@RequestBody BinanceCryptoCurrencyDto binanceCryptoCurrencyDto) {
        return binanceService.getCryptoCurrencyRate(binanceCryptoCurrencyDto);
    }
}
