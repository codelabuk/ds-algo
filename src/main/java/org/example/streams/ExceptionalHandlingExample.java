package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionalHandlingExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("21", "22", "234", "xyz");
        List<Integer> list2 = Arrays.asList(1, 0);
        // List<Integer> listInt = list.stream().map(Integer::parseInt).collect(Collectors.toList());

        //list.forEach(ExceptionalHandlingExample::printList);
        // list.forEach(handleException(s -> System.out.println(Integer.parseInt(s))));
        //list.forEach(handleException(s -> System.out.println(Integer.parseInt(s))));
//        list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)) , NumberFormatException.class));
//        list2.forEach(handleGenericException(s -> System.out.println(10/s), ArithmeticException.class));

        List<Integer> list3 = Arrays.asList(10, 15);

        list3.forEach(
                handleCheckedException(i -> {
                    Thread.sleep(i);
                    System.out.println(i);
                }));

    }


    public static void printList(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception exe) {
            System.out.println("Exception: " + exe.getMessage());
        }
    }

    public static Consumer<String> handleException(Consumer<String> payload) {
        return obj -> {
            try {
                payload.accept(obj);
            } catch (Exception ex) {
                System.out.println("Exception occured" + ex.getMessage());
            }
        };
    }

    public static <T, E extends Exception> Consumer<T> handleGenericException(Consumer<T> targetConsumer,
                                                                              Class<E> exceptionObj) {
        return obj -> {
            try {
                targetConsumer.accept(obj);
            } catch (Exception ex) {
                try {
                    E exObj = exceptionObj.cast(ex);
                    System.out.println("exception: " + exObj.getMessage());
                } catch (ClassCastException cce) {
                    throw cce;
                }
            }
        };
    }

    public static <T> Consumer<T> handleCheckedException(CheckedExceptionHandlerConsumer<T, Exception>
                                                                 handlerConsumer) {
        return obj -> {
            try {
                handlerConsumer.accept(obj);
            } catch (Exception ex) {
                System.out.println("Exception occured" + ex.getMessage());
            }
        };
    }
}
