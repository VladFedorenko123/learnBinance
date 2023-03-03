package src.srccode.service;

import com.binance.api.client.BinanceApiRestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import src.srccode.integration.service.CryptoCurrencyCommunicationService;
import src.srccode.model.CryptoCurrencyDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BinanceServiceImpl implements BinanceService {
    private final String PRICE_CODE = "USDT";
    private final String EXCHANGE_NAME = "Binance";
    private final BinanceApiRestClient binanceApiRestClient;
    private final CryptoCurrencyCommunicationService cryptoCurrencyCommunicationService;

    @Override
    public List<CryptoCurrencyDto> getCryptoCurrencyRate(List<CryptoCurrencyDto> cryptoCurrencyDtoList) {
        List<CryptoCurrencyDto> cryptoCurrencyDtos = cryptoCurrencyDtoList.stream().map(cryptoCurrencyDto -> {
            String cryptoCurrencyTicket = String.format("%s%s", cryptoCurrencyDto.getExchangeName(), PRICE_CODE);
            String price = binanceApiRestClient.getPrice(cryptoCurrencyTicket).getPrice();

            return buildCryptoCurrency(price, EXCHANGE_NAME, cryptoCurrencyDto.getCryptoCurrency());
        }).toList();

        cryptoCurrencyCommunicationService.sendCryptoCurrencyRate(cryptoCurrencyDtos);

        return cryptoCurrencyDtos;
    }

    private CryptoCurrencyDto buildCryptoCurrency(String price, String exchangeName, String cryptoCurrency) {
        return CryptoCurrencyDto.builder()
                .price(price)
                .exchangeName(exchangeName)
                .cryptoCurrency(cryptoCurrency)
                .build();
    }
}
