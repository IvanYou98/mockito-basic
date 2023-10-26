package com.example.mockitobasic.service;

import com.example.mockitobasic.repo.DataRepo;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final DataRepo dataRepo;

    public CalculatorServiceImpl(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @Override
    public int calculateSum() {
        return Arrays.stream(dataRepo.fetchData()).sum();
    }

    @Override
    public void addNumbers(int[] num) {
        dataRepo.addData(num);
    }
}
