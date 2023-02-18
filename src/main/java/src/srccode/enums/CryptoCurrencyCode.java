package src.srccode.enums;

public enum CryptoCurrencyCode {
    BITCOIN("BTC"), ETHEREUM("ETH");
    private String cryptoCurrencyCode;

    CryptoCurrencyCode(String cryptoCurrencyCode) {
        this.cryptoCurrencyCode = cryptoCurrencyCode;
    }

    public String getCryptoCurrencyCode() {
        return cryptoCurrencyCode;
    }

}
