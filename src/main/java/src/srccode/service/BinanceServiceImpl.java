package src.srccode.service;

import com.binance.api.client.BinanceApiRestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import src.srccode.enums.CryptoCurrencyCode;
import src.srccode.integration.service.CryptoCurrencyCommunicationService;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.util.BinanceUtil;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BinanceServiceImpl implements BinanceService {
    private final String PRICE_CODE = "USDT";
    private final BinanceApiRestClient binanceApiRestClient;
    private final CryptoCurrencyCommunicationService cryptoCurrencyCommunicationService;

    @Override
    public List<CryptoCurrencyDto> getCryptoCurrencyRate(CryptoCurrencyDto cryptoCurrencyDto) {
        List<String> cryptoCurrencyList = BinanceUtil.convertStringToList(cryptoCurrencyDto.getCryptoCurrency());

        List<CryptoCurrencyDto> cryptoCurrencyDtoList = cryptoCurrencyList.stream().map(cryptoCurrency -> {
            String cryptoCurrencyCode = CryptoCurrencyCode.valueOf(cryptoCurrency.toUpperCase())
                    .getCryptoCurrencyCode();
            String cryptoCurrencyTicket = String.format("%s%s", cryptoCurrencyCode, PRICE_CODE);

            String price = binanceApiRestClient.getPrice(cryptoCurrencyTicket).getPrice();

            return buildCryptoCurrency(price, cryptoCurrencyDto.getExchangeName(), cryptoCurrency);
        }).toList();

        cryptoCurrencyCommunicationService.sendCryptoCurrencyRate(cryptoCurrencyDtoList);

        return cryptoCurrencyDtoList;
    }

    private CryptoCurrencyDto buildCryptoCurrency(String price, String exchangeName, String key) {
        String cryptoCurrency = String.format("%s_%s", exchangeName, key);
        return CryptoCurrencyDto.builder()
                .price(price)
                .exchangeName(exchangeName)
                .cryptoCurrency(cryptoCurrency)
                .build();
    }
}
