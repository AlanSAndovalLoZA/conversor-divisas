package conversor;

import java.util.Map;

public record ConversionDolares(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {}
