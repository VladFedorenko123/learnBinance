package src.srccode.service;

import com.binance.api.client.BinanceApiRestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import src.srccode.enums.CryptoCurrencyCode;
import src.srccode.integration.service.CryptoCurrencyCommunicationService;
import src.srccode.model.BinanceCryptoCurrencyDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class BinanceServiceImpl implements BinanceService {
    private final BinanceApiRestClient binanceApiRestClient;
    private final CryptoCurrencyCommunicationService cryptoCurrencyCommunicationService;

    @Override
    public BinanceCryptoCurrencyDto getCryptoCurrencyRate(BinanceCryptoCurrencyDto binanceCryptoCurrencyDto) {
        //This try-catch need if ticketCode not be correct microservice not stop!

        try {
            String currency = binanceCryptoCurrencyDto.getCurrency();
            String cryptoCurrency = binanceCryptoCurrencyDto.getCryptoCurrency();

            String cryptoCurrencyCode = CryptoCurrencyCode.valueOf(cryptoCurrency.toUpperCase())
                    .getCryptoCurrencyCode() + currency;

            String price = binanceApiRestClient.getPrice(cryptoCurrencyCode).getPrice();

            BinanceCryptoCurrencyDto builtCryptoCurrencyDto = buildCryptoCurrency(price, currency, cryptoCurrency);

            cryptoCurrencyCommunicationService.sendCryptoCurrencyRate(builtCryptoCurrencyDto);

            return builtCryptoCurrencyDto;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private BinanceCryptoCurrencyDto buildCryptoCurrency(String price, String currency, String cryptoCurrency) {
        return BinanceCryptoCurrencyDto.builder()
                .price(price)
                .currency(currency)
                .cryptoCurrency(cryptoCurrency)
                .build();
    }
}
