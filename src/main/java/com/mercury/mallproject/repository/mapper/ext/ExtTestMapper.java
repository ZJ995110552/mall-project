package com.mercury.mallproject.repository.mapper.ext;

import com.mercury.mallproject.domain.ext.ExtTest;
import com.mercury.mallproject.repository.mapper.TestMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtTestMapper extends TestMapper {

    List<ExtTest> selectExistByObject(@Param("list") List<ExtTest> listExtTest);

    int batchInsert(@Param("list") List<ExtTest> listExtTest);

    int batchUpdateById(@Param("list") List<ExtTest> listExtTest);
}
