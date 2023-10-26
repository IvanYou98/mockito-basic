package com.example.mockitobasic;

import com.example.mockitobasic.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
public class Test06StaticMethod {


    @Test
    public void testStaticMethod() {
        try (MockedStatic<CalculatorService> service = mockStatic(CalculatorService.class)){
            service.when(() -> CalculatorService.add(anyInt(), anyInt()))
                    .thenReturn(1);

            System.out.println(CalculatorService.add(2, 3));
            System.out.println(CalculatorService.add(1, 3));
        }
    }
}
