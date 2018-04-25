package com.mo.export.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MoXingwang on 2018-04-25.
 * 数据库有id主键，并且导出的数据不重复
 * 强制数据排序字段和id的方向一致
 */
public class ExportStrategy {

    private static final int DEFAULT_SECTION_LENGTH = 1000;
    private static final int MAX_LENGTH = 5000;

    private ExportQueryParam queryParam;
    private int sectionLength = 2000;
    private String sort;

    private ExportStrategy() {
    }

    public ExportStrategy(ExportQueryParam exportQueryParam, int sectionLength, String sort) {
        this.queryParam = exportQueryParam;
        this.sectionLength = sectionLength;
        this.sort = sort.toUpperCase();
    }

    private String revertSort() {
        return "ASC".equals(sort) ? "DESC" : "ASC";
    }

    public ExportResultDTO exportData(IExportInterface exportInterface) {
        List<ExportDataSection> exportDataSections = new ArrayList<>();
        List<ExportKeySection> exportKeySections = new ArrayList<>();
        ExportResultDTO exportResultDTO = new ExportResultDTO(exportDataSections, exportKeySections);

        ExportQueryDBParam exportQueryDBParam = new ExportQueryDBParam(queryParam.getKeyBegin(), queryParam.getKeyEnd(), sort, sectionLength);

        //如果是第一次导出
        if (queryParam.getOrder() <= 0) {
            ExportDataSection exportDataSectionHeader = new ExportDataSection();
            ExportDataSection exportDataSectionTail = new ExportDataSection();

            exportQueryDBParam.setKeyBegin(0);
            exportQueryDBParam.setKeyEnd(0);

            List<ExportData> exportDataListHeader = exportInterface.getData(exportQueryDBParam);
            if (null == exportDataListHeader || exportDataListHeader.isEmpty()) {
                return exportResultDTO;
            }

            exportDataSectionHeader.setOrder(0);

            if (exportDataListHeader.size() < sectionLength) {
                exportDataSectionHeader.setDataList(exportDataListHeader);
                exportDataSections.add(exportDataSectionHeader);
                return exportResultDTO;
            }

            //去除最后一个id的数据，防止mybatis查询一对多的情况,如果数据不重复就去掉这个步骤
            final Long headerLastId = exportDataListHeader.get(exportDataListHeader.size() - 1).getId();
            exportDataListHeader = exportDataListHeader.stream().filter(p -> !p.getId().equals(headerLastId)).collect(Collectors.toList());
            exportDataSectionHeader.setDataList(exportDataListHeader);
            exportDataSections.add(exportDataSectionHeader);

            exportQueryDBParam.setSort(revertSort());
            List<ExportData> exportDataListTail = exportInterface.getData(exportQueryDBParam);
            //反转顺序
            Collections.reverse(exportDataListTail);
            //去掉第一个id的数据
            final Long tailFirstId = exportDataListTail.get(0).getId();
            exportDataListTail = exportDataListTail.stream().filter(p -> !p.getId().equals(tailFirstId)).collect(Collectors.toList());
            //排查书是否重复
            if ("DESC".equals(sort) && tailFirstId > headerLastId) {
                exportDataListTail = exportDataListTail.stream().filter(p -> p.getId() <= headerLastId).collect(Collectors.toList());
                exportDataSectionTail.setOrder(1);
            } else if ("ASC".equals(sort) && tailFirstId < headerLastId) {
                exportDataListTail = exportDataListTail.stream().filter(p -> p.getId() >= headerLastId).collect(Collectors.toList());
                exportDataSectionTail.setOrder(1);
            } else {
                //计算区间
                long maxId = tailFirstId > headerLastId ? tailFirstId : headerLastId;
                long minId = tailFirstId > headerLastId ? headerLastId : tailFirstId;

                long dif = maxId - minId;
                if (dif <= sectionLength) {
                    ExportKeySection keySection = new ExportKeySection(minId, maxId, 1);
                    exportKeySections.add(keySection);

                    exportDataSectionTail.setOrder(2);
                } else {
                    long sectionCount = (long) Math.ceil(dif / sectionLength);
                    for (long i = 1; i < sectionCount - 1; i++) {
                        ExportKeySection keySection = new ExportKeySection(i * sectionLength + minId, maxId, i);
                        exportKeySections.add(keySection);
                    }

                    ExportKeySection keySection = new ExportKeySection(sectionCount * sectionLength + minId, maxId + 1, sectionCount);
                    exportKeySections.add(keySection);

                    exportDataSectionTail.setOrder(sectionCount + 1);
                }
            }

            exportDataSectionTail.setDataList(exportDataListTail);
            exportDataSections.add(exportDataSectionTail);
        } else {
            //防止参数错误查询数据过大
            exportQueryDBParam.setLimit(MAX_LENGTH);
            List<ExportData> exportDataList = exportInterface.getData(exportQueryDBParam);

            ExportDataSection exportDataSection = new ExportDataSection(exportDataList, queryParam.getOrder());
            exportDataSections.add(exportDataSection);
        }

        return exportResultDTO;
    }
}
