package com.mercury.mallproject.service.impl;

import com.mercury.mallproject.domain.Test;
import com.mercury.mallproject.domain.ext.ExtTest;
import com.mercury.mallproject.service.api.TestService;

import java.util.List;

public class TestServiceRedisImpl  implements TestService {
    @Override
    public int addObject(Test test) {
        return 0;
    }

    @Override
    public long queryToalTestObject() {
        return 0;
    }

    @Override
    public int batchInsert(List<ExtTest> extTestList) {
        return 0;
    }

    @Override
    public int batchUpdate(List<ExtTest> extTestList) {
        return 0;
    }
}
