package com.mo.export.controller;

import com.mo.export.common.ExportQueryParam;
import com.mo.export.common.ExportResultDTO;
import com.mo.export.service.ExportService;
import com.mo.export.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@RestController
@RequestMapping(value = "export")
public class TesController {

    @Autowired
    private TestService testService;
    @Autowired

    private ExportService exportService;

    @RequestMapping(value = "/1", method = RequestMethod.POST)
    public ExportResultDTO test1(@RequestBody ExportTestParam exportQueryParam) {
        return testService.export(exportQueryParam);
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST)
    public ExportResultDTO test2(@RequestBody ExportQueryParam exportQueryParam) {
        return exportService.exportData(exportQueryParam);
    }

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public String test2() {
        return "ok";
    }
}
