package src.srccode.configuration;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import src.srccode.provider.BinanceSettingsProvider;

@Configuration
@RequiredArgsConstructor
public class BinanceClientConfiguration {
    private final BinanceSettingsProvider binanceSettingsProvider;

    @Bean
    public BinanceApiRestClient binanceApiRestClient() {
        return BinanceApiClientFactory.newInstance(binanceSettingsProvider.getApiKey(), binanceSettingsProvider.getSecretKey()).newRestClient();
    }
}
