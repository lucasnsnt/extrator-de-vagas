package io.github.lucasnsnt.unemployment_killer.scraper.gupy;

import java.util.ArrayList;
import java.util.List;

public class GupyApiResponse {

    List<GupyJobResponse> data = new ArrayList<>();

    Pagination pagination = new Pagination();

    public List<GupyJobResponse> getData() {
        return data;
    }

    public void setData(List<GupyJobResponse> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
