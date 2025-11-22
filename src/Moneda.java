import java.math.BigDecimal;
import java.util.Map;

public record Moneda(String base_code,
                     Map<String, BigDecimal> conversion_rates) {
}
