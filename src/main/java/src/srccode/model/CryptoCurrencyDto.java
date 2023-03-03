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
public class CryptoCurrencyDto {
    private String price;
    private String exchangeName;
    private String cryptoCurrency;
}
