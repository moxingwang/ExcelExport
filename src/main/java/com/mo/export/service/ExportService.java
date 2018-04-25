package com.mo.export.service;

import com.mo.export.common.*;
import com.mo.export.mapper.MyBatisTest;
import com.mo.export.model.ItemPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MoXingwang on 2018-04-24.
 */
@Service
public class ExportService implements IExportInterface {
    @Autowired
    private MyBatisTest myBatisTest;

    @Override
    public ExportResultDTO exportData(ExportQueryParam queryParam) {
        ExportStrategy exportStrategy = new ExportStrategy(queryParam, 1000);
        return exportStrategy.exportData(this);
    }

    @Override
    public List<ItemPayment> getData(ExportQueryDBParam queryParam) {
        return myBatisTest.export(queryParam);
    }
}
