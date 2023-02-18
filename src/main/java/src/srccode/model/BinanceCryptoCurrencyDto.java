package src.srccode.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BinanceCryptoCurrencyDto {
    private String price;
    private String currency;
    private String cryptoCurrency;
}
