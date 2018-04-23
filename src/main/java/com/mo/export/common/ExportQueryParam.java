package com.mo.export.common;

import java.io.Serializable;

/**
 * @author MoXingwang on 2018/4/23.
 */
public class ExportQueryParam implements Serializable {
    private String keyBegin;
    private String keyEnd;
    private int order;

    public String getKeyBegin() {
        return keyBegin;
    }

    public void setKeyBegin(String keyBegin) {
        this.keyBegin = keyBegin;
    }

    public String getKeyEnd() {
        return keyEnd;
    }

    public void setKeyEnd(String keyEnd) {
        this.keyEnd = keyEnd;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
