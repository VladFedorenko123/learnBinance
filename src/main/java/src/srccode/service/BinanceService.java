package src.srccode.service;

import src.srccode.model.CryptoCurrencyDto;

import java.util.List;

public interface BinanceService {
    List<CryptoCurrencyDto> getCryptoCurrencyRate(CryptoCurrencyDto cryptoCurrencyDto);
}
