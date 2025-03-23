package org.example.streams;

@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<T, E extends  Exception>{
    public void accept(T t) throws E;
}
