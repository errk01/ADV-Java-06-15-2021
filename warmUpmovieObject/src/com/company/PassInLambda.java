package com.company;

public class PassInLambda {
    public void getExponent(int x, IntegerMath integerMath){
        int result = integerMath.run(x);
        System.out.println(result);
    }

}
