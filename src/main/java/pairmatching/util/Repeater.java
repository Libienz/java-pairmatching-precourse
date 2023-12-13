package pairmatching.util;

import java.util.function.Supplier;

public class Repeater {
    public static <T> T doRepeat(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
