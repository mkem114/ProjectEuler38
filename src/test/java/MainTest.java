import org.junit.jupiter.api.Test;

import java.time.Instant;

import static java.time.Duration.between;
import static java.time.Instant.now;

public class MainTest {
    @Test
    public void microbenchmark() {
        final Instant start = now();
        Main.main(new String[0]);
        final Instant end = now();
        System.out.println(between(start, end));
    }
}
