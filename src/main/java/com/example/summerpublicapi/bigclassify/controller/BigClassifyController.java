package com.example.summerpublicapi.bigclassify.controller;

import com.example.summerpublicapi.bigclassify.dao.result.BigClassifyQueryResult;
import com.example.summerpublicapi.returndto.ReturnDto;

public class BigClassifyController {


    public ReturnDto queryBigClassify(){
        BigClassifyQueryResult result = new BigClassifyQueryResult();
        return ReturnDto.success("请求成功",result);
    }
}
