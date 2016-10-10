package streams;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by delaru on 10/10/16.
 */
public class LexicalScope {

    @Test
    public void shouldCountCorrectlyUsingFunctionWithClosure() {
        final List<String> people = Arrays.asList("Kirill", "Michele", "Elena");

        //The letter variable inside the second lambda is a closure to the first
        Function<String, Predicate<String>> startsWithLetter = (letter) -> {
            return (name) -> {
                return name.startsWith(letter);
            };
        };

        assertThat(
                people.stream()
                        .filter(startsWithLetter.apply("K"))
                        .count()
        ).isEqualTo(1);

        // simplest form
        startsWithLetter = (letter) ->  (name) -> name.startsWith(letter);

        assertThat(
                people.stream()
                        .filter(startsWithLetter.apply("K"))
                        .count()
        ).isEqualTo(1);
    }
}
