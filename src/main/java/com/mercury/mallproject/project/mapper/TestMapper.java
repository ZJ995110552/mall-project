package com.mercury.mallproject.project.mapper;

import com.mercury.mallproject.project.domain.Test;

import java.util.List;

import com.mercury.mallproject.project.domain.TestExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {
    int countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

}