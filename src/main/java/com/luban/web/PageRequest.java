package com.luban.web;

import org.springframework.util.StringUtils;

public class PageRequest {

    private int page;

    private int size;

    private String orderBy = "id";

    private boolean asc = false;

    public int getPage() {
        return page;
    }

    public PageRequest setPage(int page) {
        this.page = page;
        return this;
    }

    public int getSize() {
        return size;
    }

    public PageRequest setSize(int size) {
        this.size = size;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public PageRequest setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public boolean isAsc() {
        return asc;
    }

    public PageRequest setAsc(boolean asc) {
        this.asc = asc;
        return this;
    }

    public String toSqlString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!StringUtils.isEmpty(orderBy)) {
            stringBuilder.append(orderBy).append(" ").append((asc) ? "ASC" : "DESC");
        } else {
            stringBuilder.append("id ").append((asc) ? "ASC" : "DESC");
        }

        if (stringBuilder.length() > 0) {
            stringBuilder.append(" ");
        }

        stringBuilder.append("limit ").append(size).append(" offset ").append((page - 1) * size);

        return stringBuilder.toString();
    }
}
