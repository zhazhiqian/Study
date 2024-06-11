package com.example.summerpublicapi.bigclassify.controller;

import com.example.summerpublicapi.Enum.BigClassifyStatusEnum;
import com.example.summerpublicapi.bigclassify.dao.param.BigClassifyQueryRequest;
import com.example.summerpublicapi.bigclassify.dao.result.BigClassifyQueryResponse;
import com.example.summerpublicapi.bigclassify.service.BigClassifyService;
import com.example.summerpublicapi.returndto.ReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bigClassifyController")
public class BigClassifyController {

    @Resource
    BigClassifyService bigClassifyService;
    /**
     * 大分类功能查询
     * @return
     */
    @PostMapping("/queryBigClassify")
    public ReturnDto queryBigClassify(@RequestBody BigClassifyQueryRequest param){
        List<BigClassifyQueryResponse> result = new ArrayList<>();
        // arrayList、linkedList/HashSet、HashMap
        List<String> selectStatus = new ArrayList<>();
        selectStatus.add(BigClassifyStatusEnum.drafter.getCode());
        selectStatus.add(BigClassifyStatusEnum.normal.getCode());
        selectStatus.add(BigClassifyStatusEnum.abort.getCode());
        result = bigClassifyService.queryBigClassify(param,selectStatus);
        return ReturnDto.success("请求成功",result);
    }
}
