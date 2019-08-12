package com.mercury.mallproject.log.service;

import com.mercury.mallproject.log.domain.SysLogOperation;

import java.util.List;

public interface SysLogOperationService {

    int addObject(SysLogOperation sysLogOperation);

    List<SysLogOperation> selectList();
}
