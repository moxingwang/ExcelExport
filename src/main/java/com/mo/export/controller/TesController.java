package com.mo.export.controller;

import com.mo.export.common.ExportResultDTO;
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

    @RequestMapping(method = RequestMethod.POST)
    public ExportResultDTO test(@RequestBody ExportParam exportParam) {

        return testService.export(exportParam);
    }
}
