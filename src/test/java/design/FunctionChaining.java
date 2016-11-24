package design;

import java.util.function.Function;

public class FunctionChaining {

    private static final Function<Integer,Integer> incrementIn1 = integer -> integer + 1;
    private static final Function<Integer,Integer> incrementIn2 = integer -> integer + 2;
    private static final Function<Integer,Integer> incrementIn3 = integer -> integer + 3;

    public static void main(String[] args) {
        Function<Integer,Integer> incrementAll = incrementIn1.compose(incrementIn2).compose(incrementIn3);

        System.out.println(incrementAll.apply(1));
    }
}
