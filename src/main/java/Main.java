import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int FIRST_10_DIGIT_NUMBER = 1_000_000_000;
    private static final int MINIMUM_SERIES_LENGTH = 2;
    public static final int BASE_10 = 10;

    public static void main(String[] args) {
        final List<String> pandigitalConcatenatedProducts = new ArrayList<>();
        for (int baseFactor = 1; baseFactor < FIRST_10_DIGIT_NUMBER / MINIMUM_SERIES_LENGTH; baseFactor++) {
            final int[] digitCountsInConcatenatedProducts = new int[BASE_10];
            int numDigitsInConcatenatedProducts = 0;
            for (int seriesFactor = 1; numDigitsInConcatenatedProducts < BASE_10; seriesFactor++) {
                int product = baseFactor * seriesFactor;

                while (product > 0) {
                    final int digit = product % 10;
                    digitCountsInConcatenatedProducts[digit]++;
                    numDigitsInConcatenatedProducts++;
                    product /= 10;
                }

                if (numDigitsInConcatenatedProducts == 9) {
                    boolean isPandigital = true;
                    for (int digitIndex = 1; digitIndex < BASE_10; digitIndex++) {
                        if (digitCountsInConcatenatedProducts[digitIndex] != 1) {
                            isPandigital = false;
                            break;
                        }
                    }

                    if (isPandigital) {
                        final StringBuilder concatenatedProducts = new StringBuilder();
                        for (int i = 1; i <= seriesFactor; i++) {
                            concatenatedProducts.append(baseFactor*i);
                        }
                        pandigitalConcatenatedProducts.add(concatenatedProducts.toString());
                    }
                    break;
                }
            }
        }

        System.out.println(pandigitalConcatenatedProducts.stream().max(String::compareTo).get());
    }
}
