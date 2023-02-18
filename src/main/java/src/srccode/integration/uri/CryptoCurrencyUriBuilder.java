package src.srccode.integration.uri;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import src.srccode.integration.properties.UriProperties;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class CryptoCurrencyUriBuilder {
    private final UriProperties uriProperties;

    public URI saveOrUpdateCryptoCurrency() {
        return UriComponentsBuilder.fromUriString(uriProperties.getUri())
                .path(uriProperties.getPath())
                .build()
                .encode()
                .toUri();
    }
}
