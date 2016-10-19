package string;

import org.junit.Test;
import utils.Person;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Collection {

    final List<Person> people = Arrays.asList(
            new Person("Kirill Lassounski", 28, "22988238222"),
            new Person("Michele Tavares", 25, "22984564331"),
            new Person("Elena Lassounskaia", 52, "229992171210"),
            new Person("Mascote", 28, "22995641356"),
            new Person("Kirill Lassounski", 35, "+155498766641")
    );

    @Test
    public void shouldCollectPeopleOlderThan30Years() {
        List<Person> olderThan30 = people.stream()
                .filter(person -> person.getAge() > 30)
                //telling the compiler how to collect the stream elements into an ArrayList
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertThat(olderThan30).hasSize(2);

        olderThan30 = people.stream()
                .filter(person -> person.getAge() > 30)
                //using an auxiliary method from Collectors that tells how to collect into an ArrayList
                .collect(toList());
        assertThat(olderThan30).hasSize(2);
    }

    @Test
    public void shouldGroupPeopleByAge() {
        Map<Integer, List<Person>> groupedByAge =
                people.stream()
                        //the groupingBy function recieves a classifier function that returns
                        //the value of the property on which we want to do the grouping
                        .collect(groupingBy(Person::getAge));
        assertThat(groupedByAge).hasSize(4);
        System.out.println(groupedByAge);

        Map<Integer, List<String>> namesGroupedByAge =
                people.stream()
                        .collect(
                                //collecting people by age and mapping the value of the map to a list of names
                                groupingBy(Person::getAge, mapping(Person::getName, toList()))
                        );
        System.out.println(namesGroupedByAge);
    }

    @Test
    public void shouldGroupPeopleByTheFirstCharacterOfTheirName() {
        Map<Character, List<String>> peopleGroupedByFirstNameLetter =
                people.stream()
                        .collect(
                                groupingBy(Person::getNameFirstChar, mapping(Person::getName, toList()))
                        );
        System.out.println(peopleGroupedByFirstNameLetter);
    }

    @Test
    public void shouldReduceToTheOldestPersonOfAGroupMappedByTheNameFirstCharacter() {
        Comparator<Person> age = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonForNameFirstChar =
                people.stream()
                        .collect(
                                groupingBy(Person::getNameFirstChar, reducing(BinaryOperator.maxBy(age)))
                        );
        System.out.println(oldestPersonForNameFirstChar);
    }
}
