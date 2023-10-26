package com.example.mockitobasic.repo;

import org.springframework.stereotype.Repository;

@Repository
public class DataRepoImpl implements DataRepo{
    private int[] data;

    @Override
    public int[] fetchData() {
        return data;
    }

    @Override
    public void addData(int[] newData) {
        this.data = newData;
    }
}
