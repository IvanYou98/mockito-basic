package com.example.mockitobasic;

import com.example.mockitobasic.repo.DataRepoImpl;
import com.example.mockitobasic.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Test02MockNative {

    @Mock
    DataRepoImpl dataRepo;

    @InjectMocks
    CalculatorServiceImpl service;

    @Test
    public void testEmptyArray() {
        when(dataRepo.fetchData()).thenReturn(new int[0]);
        assertEquals(0, service.calculateSum());
    }

    @Test
    public void testNormalArray() {
        when(dataRepo.fetchData()).thenReturn(new int[] {1, 4, 9});
        assertEquals(14, service.calculateSum());
    }
}
