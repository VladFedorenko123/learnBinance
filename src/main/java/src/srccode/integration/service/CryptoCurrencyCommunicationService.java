package src.srccode.integration.service;

import src.srccode.model.CryptoCurrencyDto;

import java.util.List;

public interface CryptoCurrencyCommunicationService {
    void sendCryptoCurrencyRate(List<CryptoCurrencyDto> binanceCryptoCurrencyDto);
}
