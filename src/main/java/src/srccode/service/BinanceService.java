package src.srccode.service;

import src.srccode.model.BinanceCryptoCurrencyDto;

public interface BinanceService {
    BinanceCryptoCurrencyDto getCryptoCurrencyRate(BinanceCryptoCurrencyDto binanceCryptoCurrencyDto);
}
