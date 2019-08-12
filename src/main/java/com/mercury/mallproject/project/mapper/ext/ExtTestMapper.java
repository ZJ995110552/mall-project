package com.mercury.mallproject.project.mapper.ext;

import com.mercury.mallproject.project.domain.ext.ExtTest;
import com.mercury.mallproject.project.mapper.TestMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtTestMapper extends TestMapper {

    List<ExtTest> selectExistByObject(@Param("list") List<ExtTest> listExtTest);

    int batchInsert(@Param("list") List<ExtTest> listExtTest);

    int batchUpdateById(@Param("list") List<ExtTest> listExtTest);
}
