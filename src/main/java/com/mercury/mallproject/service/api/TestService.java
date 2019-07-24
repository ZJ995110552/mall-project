package com.mercury.mallproject.service.api;

import com.mercury.mallproject.domain.Test;
import com.mercury.mallproject.domain.ext.ExtTest;

import java.util.List;

public interface TestService {
    int addObject(Test test);

    long queryToalTestObject();

    int batchInsert(List<ExtTest> extTestList);

    int batchUpdate(List<ExtTest> extTestList);

}
