package src.srccode.integration.service;

import src.srccode.model.BinanceCryptoCurrencyDto;

public interface CryptoCurrencyCommunicationService {
    void sendCryptoCurrencyRate(BinanceCryptoCurrencyDto binanceCryptoCurrencyDto);
}
