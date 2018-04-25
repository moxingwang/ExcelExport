package com.mo.export.common;

import com.mo.export.model.ItemPayment;

import java.util.List;

/**
 * @author MoXingwang on 2018-04-25.
 */
public interface IExportInterface {

    ExportResultDTO exportData(ExportQueryParam queryParam);

    List<ExportData> getData(ExportQueryDBParam queryParam);

}
