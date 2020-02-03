package com.xianyu.pojo;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private Long total;
    private List<T> results;

    public PageResult(Long total, List<T> results) {
        this.total = total;
        this.results = results;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
