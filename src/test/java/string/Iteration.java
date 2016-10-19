package string;

import org.junit.Test;

public class Iteration {

    private final String name = "Kirill";

    @Test
    public void shouldPrintOneCharacterPerLine(){
        //prints integers
        name.chars()
                .forEach(System.out::println);
        //prints characters
        name.chars()
                .mapToObj(charInt -> (char)charInt)
                .forEach(System.out::println);
    }

    @Test
    public void shouldPrintTheStringCharactersInUpperCaseInEachLine(){
        name.chars()
                .mapToObj(charInteger -> (char)charInteger)
                .map(Character::toUpperCase)
                .forEach(System.out::println);

    }
}
