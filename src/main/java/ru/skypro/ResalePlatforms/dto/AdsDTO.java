package ru.skypro.ResalePlatforms.dto;

import java.util.List;

public class AdsDTO {
    //общее количество объявлений
    private int count;
    //лист всех объявления
    private List<AdDTO> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AdDTO> getResults() {
        return results;
    }

    public void setResults(List<AdDTO> results) {
        this.results = results;
    }
}
