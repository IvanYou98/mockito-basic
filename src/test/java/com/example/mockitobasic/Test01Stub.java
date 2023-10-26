package com.example.mockitobasic;

import com.example.mockitobasic.repo.DataRepo;
import com.example.mockitobasic.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01Stub {
    static class DateRepoEmptyArray implements DataRepo {

        @Override
        public int[] fetchData() {
            return new int[0];
        }

        @Override
        public void addData(int[] numToAdd) {
        }
    }

    @Test
    public void testEmptyArray() {
        CalculatorServiceImpl service = new CalculatorServiceImpl(new DateRepoEmptyArray());
        assertEquals(0, service.calculateSum());
    }

    static class DateRepoNormalArray implements DataRepo {

        @Override
        public int[] fetchData() {
            return new  int[] {1, 3, 5};
        }

        @Override
        public void addData(int[] numToAdd) {
        }
    }

    @Test
    public void testNormalArray() {
        CalculatorServiceImpl service = new CalculatorServiceImpl(new DateRepoNormalArray());
        assertEquals(9, service.calculateSum());
    }

}
