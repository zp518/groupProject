package com.jk.test.mapper;

import com.jk.test.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeMapper {
    @Select("select id,text,url,pid"
            + " from tress where pid=#{id}")
    List<Tree> selectByPrimaryKey(Integer id);
}
