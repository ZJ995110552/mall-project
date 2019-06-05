package com.mercury.mallproject.service.impl;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.domain.SysLogOperation;
import com.mercury.mallproject.repository.mapper.SysLogOperationMapper;
import com.mercury.mallproject.service.api.SysLogOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogOperationServiceImpl implements SysLogOperationService {

    private IdGenerator idGenerator = DefaultIdGenerator.getInstance();

    @Autowired
    private SysLogOperationMapper sysLogOperationMapper;

    @Override
    public int addObject(SysLogOperation sysLogOperation) {
        sysLogOperation.setId(idGenerator.generateId());
        return sysLogOperationMapper.insert(sysLogOperation);
    }
}
