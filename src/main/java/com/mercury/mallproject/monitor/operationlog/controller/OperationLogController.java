package com.mercury.mallproject.monitor.operationlog.controller;


import com.mercury.mallproject.domain.SysLogOperation;
import com.mercury.mallproject.framework.page.TableDataInfo;
import com.mercury.mallproject.framework.web.controller.BaseController;
import com.mercury.mallproject.service.api.SysLogOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oprlog")
public class OperationLogController extends BaseController {

    @Autowired
    private SysLogOperationService sysLogOperationService;

    @RequestMapping("/list")
    public TableDataInfo list(){
        startPage();
        List<SysLogOperation> sysLogOperations = sysLogOperationService.selectList();
        return getDataTable(sysLogOperations);
    }

}
