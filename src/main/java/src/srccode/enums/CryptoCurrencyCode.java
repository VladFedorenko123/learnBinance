package src.srccode.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CryptoCurrencyCode {
    BITCOIN("BTC"),
    ETHEREUM("ETH"),
    DOGECOIN("DOGE"),
    MONERO("XMR"),
    DASH("DASH");
    private String cryptoCurrencyCode;

    CryptoCurrencyCode(String cryptoCurrencyCode) {
        this.cryptoCurrencyCode = cryptoCurrencyCode;
    }
}
