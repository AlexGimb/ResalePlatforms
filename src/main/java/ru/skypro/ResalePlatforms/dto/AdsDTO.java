package ru.skypro.ResalePlatforms.dto;


import ru.skypro.ResalePlatforms.entity.Ad;

import java.util.List;


public class AdsDTO {
    //общее количество объявлений
    private int count;
    //лист всех объявления
    private List<Ad> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Ad> getResults() {
        return results;
    }

    public void setResults(List<Ad> results) {
        this.results = results;
    }
}
