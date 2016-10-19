package streams;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by delaru on 13/10/16.
 */
public class LocateElements {
    @Test
    public void shouldFindFirstElement() {
        final List<String> people = Arrays.asList("Kirill Lassounski", "Michele", "Kirill Bodrov", "Elena");

        assertThat(
        people.stream()
                .filter(name -> name.startsWith("Kirill"))
                .findFirst()
                .orElse("Not Found")
        ).isEqualTo("Kirill Lassounski");
    }
}
