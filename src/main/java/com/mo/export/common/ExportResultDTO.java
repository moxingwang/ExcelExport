package com.mo.export.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author MoXingwang on 2018/4/23.
 */
public class ExportResultDTO implements Serializable {
    private List<ExportDataSection> data;
    private List<ExportKeySection> keySections;

    public List<ExportDataSection> getData() {
        return data;
    }

    public void setData(List<ExportDataSection> data) {
        this.data = data;
    }

    public List<ExportKeySection> getKeySections() {
        return keySections;
    }

    public void setKeySections(List<ExportKeySection> keySections) {
        this.keySections = keySections;
    }
}