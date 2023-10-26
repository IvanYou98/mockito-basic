package com.example.mockitobasic;

import com.example.mockitobasic.repo.DataRepo;
import com.example.mockitobasic.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Test02MockSpringTest {

    @MockBean
    DataRepo dataRepo;

    @Autowired
    CalculatorService service;

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
