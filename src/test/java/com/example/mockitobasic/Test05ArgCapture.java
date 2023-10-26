package com.example.mockitobasic;

import com.example.mockitobasic.repo.DataRepo;
import com.example.mockitobasic.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class Test05ArgCapture {
    @MockBean
    DataRepo dataRepo;

    @Autowired
    CalculatorService service;

    @Captor
    ArgumentCaptor<int[]> intArrayCaptor;

    @Test
    public void testArgCaptorForOnceMethodCall() {
        int[] expected = {3, 7, 2};
        service.addNumbers(expected);
        verify(dataRepo).addData(intArrayCaptor.capture());
        assertEquals(expected, intArrayCaptor.getValue());
    }

    @Test
    public void testArgCaptorForMultipleMethodCall() {
        int[][] inputArrays = {{1, 2, 3}, {4, 5, 6}};
        for (int[] inputArray : inputArrays) {
            service.addNumbers(inputArray);
        }
        verify(dataRepo, times(2)).addData(intArrayCaptor.capture());

        for (int i = 0; i < intArrayCaptor.getAllValues().size(); i++) {
            assertEquals(inputArrays[i], intArrayCaptor.getAllValues().get(i));
        }
    }

}
