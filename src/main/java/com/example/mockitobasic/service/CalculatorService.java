package com.example.mockitobasic.service;

public interface CalculatorService {
    int calculateSum();

    void addNumbers(int[] num);

    static int add(int a, int b) {
        return a + b;
    }
}
