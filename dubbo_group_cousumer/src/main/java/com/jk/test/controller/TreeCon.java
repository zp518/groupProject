package com.jk.test.controller;

import com.jk.test.model.Tree;
import com.jk.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("tree")
public class TreeCon {
    @Autowired
    TestService testService;
    @RequestMapping("selTreeList")
    @ResponseBody
    public List<Tree> selTreeList(){
        //查询父节点
        List<Tree> list=testService.selTreeList1(0);
        //将查询出来的父节点 当作条件 再查询子节点
        List<Tree> listSel =selChild(list);
        return listSel;

    }


    //查询子节点
    public List<Tree> selChild(List<Tree> list) {
        //定义一个新的集合 用来装查询出来的数据
        List<Tree> childList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Tree trees = list.get(i);

            //将父节点的id当作条件查询 因为子节点的pid等于父节点的id
            List<Tree> listQ=testService.selTreeList1(trees.getId());
            //判断子节点下是否还有子节点
            if(listQ.size()>0){
                List<Tree> selChild = selChild(listQ);
                trees.setNodes(selChild);
                childList.add(trees);
            }else{
                childList.add(trees);
            }
        }
        return childList;
    }
}
