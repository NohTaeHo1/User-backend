package com.von.user.common.proxy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    
    public static Function<Integer, Integer> absInt = Math::abs;
    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Double, Double, Double> maxDouble = Math::max;
    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
    public static BiFunction<Double, Double, Double> minDouble = Math::min;
    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer, Integer, Integer> rangeRandomInt = (a, b)->(int)(Math.random()*(b-a));
    public static BiFunction<Double, Double, Double> rangeRandomDouble = (a, b)->(Double)(Math.random()*(b-a));
    public static Function<Double, Double> ceilDouble = Math::ceil;
    public static Function<Double, Integer> ceilInt = (a) -> (int) Math.ceil(a);
    public static Function<Double, Double> floorDouble = Math::floor;
    public static Function<Double, Integer> floorInt = (a) -> (int) Math.floor(a);
    public static Function<Float, Integer> roundInt = Math::round;
    public static Supplier<LocalDate> nowDate = LocalDate::now;
    public static Supplier<LocalTime> nowTime = LocalTime::now;
    
}
