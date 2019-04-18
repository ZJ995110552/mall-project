package com.mercury.mallproject.service.impl;

import com.mercury.mallproject.domain.Test;
import com.mercury.mallproject.repository.mapper.TestMapper;
import com.mercury.mallproject.repository.mapper.template.TestExample;
import com.mercury.mallproject.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public int addObject(Test test) {
        return testMapper.insert(test);
    }

    @Override
    public long queryToalTestObject() {
        TestExample testExample = new TestExample();
        TestExample.Criteria criteria = testExample.createCriteria();
        criteria.andUserIdIsNotNull();
        return testMapper.countByExample(testExample);
    }

}
