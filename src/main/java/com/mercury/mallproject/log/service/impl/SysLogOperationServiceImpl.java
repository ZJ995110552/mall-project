package com.mercury.mallproject.log.service.impl;

import com.mercury.mallproject.common.id.DefaultIdGenerator;
import com.mercury.mallproject.common.id.IdGenerator;
import com.mercury.mallproject.log.domain.SysLogOperation;
import com.mercury.mallproject.log.domain.SysLogOperationExample;
import com.mercury.mallproject.log.mapper.SysLogOperationMapper;
import com.mercury.mallproject.log.service.SysLogOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SysLogOperation> selectList() {
        SysLogOperationExample sysLogOperationExample = new SysLogOperationExample();
        return sysLogOperationMapper.selectByExample(sysLogOperationExample);
    }
}
