package com.mo.export.service;

import com.mo.export.common.ExportDataSection;
import com.mo.export.common.ExportKeySection;
import com.mo.export.common.ExportResultDTO;
import com.mo.export.controller.ExportDTO;
import com.mo.export.controller.ExportParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@Service
public class TestService {

    int totalSection = 10;
    int sectionLength = 20;

    public ExportResultDTO export(ExportParam exportParam) {

        ExportResultDTO exportResultDTO = new ExportResultDTO();

        List<ExportDataSection> data = new ArrayList<>();
        List<ExportKeySection> keySections = new ArrayList<>();

        if (exportParam.getOrder() == 1 || exportParam.getOrder() == 0) {
            for (int i = 1; i <= totalSection; i++) {
                ExportKeySection exportKeySection = new ExportKeySection();
                exportKeySection.setKeyBegin((i * sectionLength + 1) + "");
                exportKeySection.setKeyEnd(((i + 1) * sectionLength) + "");
                exportKeySection.setOrder(i + 1);
                keySections.add(exportKeySection);
            }

            ExportDataSection exportDataSectionBegin = new ExportDataSection();
            exportDataSectionBegin.setOrder(1);
            exportDataSectionBegin.setDataList(getList(1, sectionLength / 2));

            ExportDataSection exportDataSectionBegEnd = new ExportDataSection();
            exportDataSectionBegEnd.setOrder(sectionLength + 2);
            exportDataSectionBegEnd.setDataList(getList(1, sectionLength / 2));

            data.add(exportDataSectionBegin);
            data.add(exportDataSectionBegEnd);
        } else {
            ExportDataSection exportDataSection = new ExportDataSection();
            exportDataSection.setOrder(exportParam.getOrder());
            exportDataSection.setDataList(getList(exportParam.getOrder() * sectionLength - sectionLength / 2
                    , exportParam.getOrder() * (sectionLength + 1) - sectionLength / 2));

            data.add(exportDataSection);
        }

        exportResultDTO.setData(data);
        exportResultDTO.setKeySections(keySections);
        return exportResultDTO;
    }

    private List<ExportDTO> getList(int start, int end) {
        List<ExportDTO> list = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            ExportDTO exportDTO = new ExportDTO();
            exportDTO.setId(Long.valueOf(i));
            exportDTO.setUserId("" + i);
            exportDTO.setUserName("测试名字" + i);
            list.add(exportDTO);
        }

        return list;
    }
}
