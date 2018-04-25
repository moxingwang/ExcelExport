package com.mo.export.common;

import com.mo.export.model.ItemPayment;

import java.util.List;

/**
 * @author MoXingwang on 2018-04-25.
 */
public interface IExportInterface<T extends ExportData> {

    ExportResultDTO exportData(ExportQueryParam queryParam);

    List<T> getData(ExportQueryDBParam queryParam);

}
