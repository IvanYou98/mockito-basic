package com.example.mockitobasic;

import com.example.mockitobasic.repo.DataRepo;
import com.example.mockitobasic.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class Test03VerifyMethodCall {

    @MockBean
    DataRepo dataRepo;

    @Autowired
    CalculatorService calculatorService;

    @Test
    public void verifyMethodCall() {
        //given
        calculatorService.addNumbers(new int[]{2, 3, 4});
        // no side effect
        // System.out.println(Arrays.toString(dataRepo.fetchData()));
        verify(dataRepo, atLeastOnce()).addData(any());
    }

}
