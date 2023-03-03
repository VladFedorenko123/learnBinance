package src.srccode.integration.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import src.srccode.integration.uri.CryptoCurrencyUriBuilder;
import src.srccode.model.CryptoCurrencyDto;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoCurrencyCommunicationServiceImpl implements CryptoCurrencyCommunicationService {
    private final CryptoCurrencyUriBuilder cryptoCurrencyUriBuilder;
    private final RestTemplate restTemplate;

    @Override
    public void sendCryptoCurrencyRate(List<CryptoCurrencyDto> binanceCryptoCurrencyDto) {
        URI uri = cryptoCurrencyUriBuilder.saveOrUpdateCryptoCurrency();
        HttpEntity<List<CryptoCurrencyDto>> httpEntity = new HttpEntity<>(binanceCryptoCurrencyDto);
        try {
            log.info("Sending data");
            restTemplate.exchange(uri, POST, httpEntity, String.class);
            log.info("Data send successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
