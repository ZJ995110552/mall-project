package com.mercury.mallproject.project.service;

import com.mercury.mallproject.project.domain.Test;
import com.mercury.mallproject.project.domain.ext.ExtTest;

import java.util.List;

public interface TestService {
    int addObject(Test test);

    long queryToalTestObject();

    int batchInsert(List<ExtTest> extTestList);

    int batchUpdate(List<ExtTest> extTestList);

}
