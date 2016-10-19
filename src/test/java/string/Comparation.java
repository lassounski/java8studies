package string;

import org.junit.Test;
import utils.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Comparation {

    final List<Person> people = Arrays.asList(
            new Person("Kirill Lassounski", 28, "22988238222"),
            new Person("Michele Tavares", 25, "22984564331"),
            new Person("Elena Lassounskaia", 52, "229992171210"),
            new Person("Kirill Lassounski", 35, "+155498766641")
    );

    @Test
    public void shouldOrderPeopleByAge() {

        printPeople("People sorted by ascending age using lambda:",
                people.stream()
                        .sorted((o1, o2) -> o1.ageDifference(o2))
                        .collect(Collectors.toList())
        );

        printPeople("People sorted by ascending age using method reference:",
                people.stream()
                        .sorted(Person::ageDifference)
                        .collect(Collectors.toList())
        );

        printPeople("Youngest person:",
                people.stream()
                        .min(Person::ageDifference)
                        .orElseThrow(() -> new RuntimeException("Youngest person not found"))
        );
    }

    @Test
    public void shouldUseComparatorAuxiliaryFunctions() {
        Function<Person, String> byName = person -> person.getName();

        printPeople("Comparing by name reversed using function:",
                people.stream()
                        .sorted(Comparator.comparing(byName)
                                .reversed())
                        .collect(Collectors.toList())
        );

        printPeople("Comparing by name and age using function:",
                people.stream()
                        .sorted(Comparator.comparing(byName)
                                .thenComparing(Person::ageDifference)
                                .reversed())
                        .collect(Collectors.toList())
        );
    }

    private void printPeople(String title, List people) {
        System.out.println(title);
        people.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    private void printPeople(String title, Person person) {
        System.out.printf("%s\n%s\n", title, person);
    }
}
