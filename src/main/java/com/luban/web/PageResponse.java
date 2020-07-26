package com.luban.web;

public class PageResponse {

    private long total;

    private PageRequest pageRequest;

    private Object data;

    public long getTotal() {
        return total;
    }

    public PageResponse setTotal(long total) {
        this.total = total;
        return this;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public PageResponse setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
        return this;
    }

    public Object getData() {
        return data;
    }

    public PageResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
