package src.srccode.provider;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "binance.api")
public class BinanceSettingsProvider {
    private String apiKey;
    private String secretKey;
}
