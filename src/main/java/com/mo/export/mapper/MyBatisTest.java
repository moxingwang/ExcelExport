package com.mo.export.mapper;

import com.mxw.export.*;
import com.mo.export.model.ItemPayment;

import java.util.List;

/**
 * Created by MoXingwang on 2017/6/4.
 */
public interface MyBatisTest {

    List<ItemPayment> export(ExportQueryDBParam exportParam);

}
