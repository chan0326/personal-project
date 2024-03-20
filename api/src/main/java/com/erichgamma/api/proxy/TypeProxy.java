package com.erichgamma.api.proxy;

import java.util.Objects;
import java.util.function.Function;

public class TypeProxy {
//    public static Function<Integer,String> string1 = String::valueOf;
//    public static Function<Character,String> string2 = String::valueOf;
//    public static Function<Long,String> string3 = String::valueOf;
    public static Function<Objects,String> string = String::valueOf;
    public static Function<?,String> string1 = String::valueOf;
//    public static Function<T,String> string2 = String::valueOf; 파라미터라 사용불가능 T자리는 리턴을 받아야함

    public static Function<String,Integer> integer = Integer::valueOf;
    public static Function<String,Double> doubleof = Double::valueOf;
    public static Function<String,Float> floatof = Float::valueOf;
    public static Function<String,Long> longof = Long::valueOf;



}
