package com.jacob.learn.device;

import io.vavr.collection.Stream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Stream.range(1, 10).forEach(value -> {
            es.submit(() -> System.out.println(value));
        });

        es.shutdown();
    }
}
