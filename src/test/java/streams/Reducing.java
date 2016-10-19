package streams;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by delaru on 13/10/16.
 */
public class Reducing {
    @Test
    public void shouldCountTheElementsOfACollection() {
        final List<String> people = Arrays.asList("Michele", "Elena");

        assertThat(
                people.stream()
                        .mapToInt(name -> name.length())
                        //sum is a reduce operation
                        .sum()
        ).isEqualTo(12);
    }

    @Test
    public void shouldJoinAllNameOfACollection() {
        final List<String> people = Arrays.asList("Kirill Lassounski", "Michele", "Kirill Bodrov", "Elena");

        assertThat(
                people.stream()
                        .reduce((name1, name2) -> name1.concat(";").concat(name2))
                        .orElse("Not Found")
        ).isEqualTo("Kirill Lassounski;Michele;Kirill Bodrov;Elena");
    }
}