package com.mercury.mallproject.service.impl;

import com.mercury.mallproject.domain.Test;
import com.mercury.mallproject.domain.ext.ExtTest;
import com.mercury.mallproject.repository.mapper.TestMapper;
import com.mercury.mallproject.domain.TestExample;
import com.mercury.mallproject.repository.mapper.ext.ExtTestMapper;
import com.mercury.mallproject.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private ExtTestMapper extTestMapper;

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

    @Override
    public int batchInsert(List<ExtTest> extTestList) {
        return extTestMapper.batchInsert(extTestList);
    }

    @Override
    public int batchUpdate(List<ExtTest> extTestList) {
        return extTestMapper.batchUpdateById(extTestList);
    }


}
