package com.mo.export.common;

import java.io.Serializable;

/**
 * @author MoXingwang on 2018/4/23.
 */
public class ExportQueryDBParam implements Serializable {
    private long keyBegin;
    private long keyEnd;
    private String sort;
    private int limit;

    private ExportQueryDBParam() {
    }

    protected ExportQueryDBParam(long keyBegin, long keyEnd, String sort, int limit) {
        this.keyBegin = keyBegin;
        this.keyEnd = keyEnd;
        this.sort = sort;
        this.limit = limit;
    }

    public long getKeyBegin() {
        return keyBegin;
    }

    public void setKeyBegin(long keyBegin) {
        this.keyBegin = keyBegin;
    }

    public long getKeyEnd() {
        return keyEnd;
    }

    public void setKeyEnd(long keyEnd) {
        this.keyEnd = keyEnd;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
