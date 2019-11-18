package leetcode.common;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTest {
    public static void main(String[] args) {
        testFunction();
        testSupplier();
        testConsumer();
        testPredicate();
    }

    public static void testFunction() {
        Function<Integer, String> function1 = (x) -> "test function1 x:" + x;
        Function<Integer, String> function2 = (x) -> "test function2 x:" + x;
        System.out.println(function1.apply(6));
        System.out.println(function2.apply(6));
    }

    public static void testSupplier() {
        Supplier<String> supplier = () -> "Test supplier";
        System.out.println(supplier.get());
    }

    public static void testConsumer() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello World");
    }

    public static void testPredicate() {
        Predicate<Integer> predicate = (x) -> new Integer(9).equals(x);
        System.out.println(predicate.test(9));
    }


}
