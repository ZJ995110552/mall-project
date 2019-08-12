package com.mercury.mallproject.service.api;

import com.mercury.mallproject.domain.SysLogOperation;

import java.util.List;

public interface SysLogOperationService {

    int addObject(SysLogOperation sysLogOperation);

    List<SysLogOperation> selectList();
}
