package src.srccode.util;

import java.util.Arrays;
import java.util.List;

public class BinanceUtil {
        public static List<String> convertStringToList(String cryptoCurrencys){
            return Arrays.asList(cryptoCurrencys.split(","));
        }
}
