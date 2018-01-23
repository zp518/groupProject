package com.jk.test.service;

import com.jk.test.mapper.TreeMapper;
import com.jk.test.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    TreeMapper treeMapper;

    @Override
    public List<Tree> selTreeList1(Integer id) {
        return treeMapper.selectByPrimaryKey(id);
    }
}
