package com.mo.export.common;

import java.io.Serializable;

/**
 * @author MoXingwang on 2018/4/23.
 */
public class ExportQueryParam implements Serializable {
    private String keyBegin;
    private String keyEnd;
    private int order;
    private int strategy;//0 默认策略并行，1 串行

    public int getStrategy() {
        return strategy;
    }

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }

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
