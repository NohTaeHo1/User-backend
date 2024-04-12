package com.von.user.common.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {

    @Test
    public void testSame() {
        int[] arr = {1, 2, 3, 4, 5};

        Arrays.stream(arr).forEach(System.out::println);
        Stream.of(arr).forEach(System.out::println);
        Stream.of(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);

        // 1 2 3 4 5
        // [I@4c1d9d4b :.of()는 레퍼런스 고정 -> 요소를 보는게 아니라 레퍼런스 값 자체를 봄
        // 1 2 3 4 5

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.stream().forEach(System.out::println);
        Stream.of(list).forEach(System.out::println);

        // 1 2 3 4 5
        // [1, 2, 3, 4, 5]

    }

    @Test
    public void testDifferent() {

    }
}
