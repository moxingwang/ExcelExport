package com.mo.export.service;

import com.mo.export.common.ExportDataSection;
import com.mo.export.common.ExportKeySection;
import com.mo.export.common.ExportResultDTO;
import com.mo.export.controller.ExportDTO;
import com.mo.export.controller.ExportTestParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@Service
public class TestService {

    int totalSection = 5;
    int sectionLength = 2000;

    public ExportResultDTO export(ExportTestParam exportParam) {


        List<ExportDataSection> data = new ArrayList<>();
        List<ExportKeySection> keySections = new ArrayList<>();
        ExportResultDTO exportResultDTO = new ExportResultDTO(data,keySections);


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
            exportDataSectionBegEnd.setDataList(getList(totalSection * sectionLength + 1, totalSection * sectionLength + totalSection * sectionLength / 2));

            data.add(exportDataSectionBegin);
            data.add(exportDataSectionBegEnd);
        } else {
            ExportDataSection exportDataSection = new ExportDataSection();
            exportDataSection.setOrder(exportParam.getOrder());
            exportDataSection.setDataList(getList(exportParam.getKeyBegin(), exportParam.getKeyEnd()));

            data.add(exportDataSection);
        }

        exportResultDTO.setData(data);
        exportResultDTO.setKeySections(keySections);
        return exportResultDTO;
    }

    private List<ExportDTO> getList(long start, long end) {
        List<ExportDTO> list = new ArrayList<>();

        for (long i = start; i <= end; i++) {
            ExportDTO exportDTO = new ExportDTO();
            exportDTO.setId(Long.valueOf(i));
            exportDTO.setUserId("" + i);
            exportDTO.setUserName("测试名字" + i);
            exportDTO.setRemark("11111");
            list.add(exportDTO);
        }

        return list;
    }
}
