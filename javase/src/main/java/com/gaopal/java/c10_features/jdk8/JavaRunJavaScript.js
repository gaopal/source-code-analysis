const BigDecimal = Java.type('java.math.BigDecimal');

function calculate(amount, percentage) {

    const result = new BigDecimal(amount).multiply(
        new BigDecimal(percentage)).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);

    return result.toPlainString();
}

const result = calculate(568000000000000000023, 13.9);
print(result);